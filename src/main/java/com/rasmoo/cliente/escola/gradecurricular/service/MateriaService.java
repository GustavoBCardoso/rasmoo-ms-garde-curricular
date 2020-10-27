package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public Boolean atualizar(MateriaEntity materia) {
        try {
            // buscamos pela materia que gostariamos de atualizar
            MateriaEntity materiaEntityAtualiza = this.materiaRepository.findById(materia.getId()).get();

            // atualizamos todos os valores
            materiaEntityAtualiza.setNome(materia.getNome());
            materiaEntityAtualiza.setCodigo(materia.getCodigo());
            materiaEntityAtualiza.setHoras(materia.getHoras());
            materiaEntityAtualiza.setFrequencia(materia.getFrequencia());

            // salvamos as alterações
            this.materiaRepository.save(materiaEntityAtualiza);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean excluir(Long id) {
        try {
            this.materiaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
