package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Materia;
import fia.ues.edu.sv.domain.IngresoNota;
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
    MateriaRepository materiaRepository;


    @Transactional

    public List<Materia> listarTodas(){
        return materiaRepository.findAll();
    }

    @Transactional
    public List<Materia> listarPorDocente(int idDocente){return materiaRepository.queryByDocente(idDocente);
    }
    @Transactional
    public Materia guardarMateria(Materia materia){ return materiaRepository.save(materia);}

}
