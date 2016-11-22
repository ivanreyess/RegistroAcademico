package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Periodo;
import fia.ues.edu.sv.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-12-16.
 */
@Service
public class PeriodoService {
    @Autowired
    PeriodoRepository periodoRepository;

    @Transactional
    public List<Periodo> listarTodos(){
        return periodoRepository.findAll();
    }

    @Transactional
    public List<Periodo> listarPorId(int idperiodo){ return periodoRepository.findByidperiodo(idperiodo);}
}
