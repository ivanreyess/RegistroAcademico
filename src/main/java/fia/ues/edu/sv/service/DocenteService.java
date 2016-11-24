package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
<<<<<<< HEAD
 * Created by ivan on 11-22-16.
=======
 * Created by Monica on 23/11/2016.
>>>>>>> 2a335c9548e4da06f65cde4bc1f6accb549da45b
 */
@Service
public class DocenteService {
    @Autowired
    DocenteRepository docenteRepository;

    @Transactional

    public Docente obtenerPorUsuario(String usuario) {
        return docenteRepository.queryByUsuario(usuario);
    }
    public Docente guardarDocente(Docente docente){
        return docenteRepository.save(docente);
    }
    @Transactional
    public int ultimoDocente(){
        return docenteRepository.queryLastDocente();

    }
}
