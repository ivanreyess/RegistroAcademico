package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Materia;
import fia.ues.edu.sv.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Monica on 15/11/2016.
 */
@Service
public class MateriaService {
    @Autowired
    MateriaRepository notaRepository;


    @Transactional

    public List<Materia> listarTodas(){
        return notaRepository.findAll();
    }

}
