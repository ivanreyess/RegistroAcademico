package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ivan on 11-22-16.
 */
@Service
public class DocenteService {
    @Autowired
    DocenteRepository docenteRepository;

    @Transactional
    public Docente obtenerPorUsuario(String usuario){
        return docenteRepository.queryByUsuario(usuario);
    }
}
