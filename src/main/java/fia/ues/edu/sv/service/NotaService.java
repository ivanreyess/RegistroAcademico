package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Nota;
import fia.ues.edu.sv.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-12-16.
 */
@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    @Transactional
    public List<Nota> listaAsistencia (int idgrado, int idperiodo){
        return notaRepository.queryByEstudianteAsistencia(idgrado,idperiodo);
    }

    @Transactional
    public List<Nota> listaConducta(int idgrado, int idperiodo){
        return notaRepository.queryByEstudianteConducta(idgrado,idperiodo);
    }
}
