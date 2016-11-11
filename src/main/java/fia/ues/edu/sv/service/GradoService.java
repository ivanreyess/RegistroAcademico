package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.domain.Grado;
import fia.ues.edu.sv.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */
@Service
public class GradoService {
    @Autowired
    GradoRepository gradoRepository;

    @Transactional
    public List<Grado> listarTodos(){
        return gradoRepository.findAll();
    }

    @Transactional
    public List<Grado> listarPorDocente1(Docente docente){
        return gradoRepository.findBydocentes(docente);
    }

    @Transactional
    public List<Grado> listarporDocente(int idDocente){
        return gradoRepository.queryByDocente(idDocente);
    }
}
