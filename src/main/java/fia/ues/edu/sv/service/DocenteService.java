package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Monica on 23/11/2016.
 */
@Service
public class DocenteService {
    @Autowired
    DocenteRepository docenteRepository;

    @Transactional
    public Docente guardarDocente(Docente docente){
        return docenteRepository.save(docente);
    }
    @Transactional
    public int ultimoDocente(){
        return docenteRepository.queryLastDocente();
    }
}
