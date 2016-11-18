package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.ReporteCondicionado;
import fia.ues.edu.sv.repository.ReporteCondicionadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-17-16.
 */
@Service
public class ReporteCondicionadoService {
    @Autowired
    ReporteCondicionadoRepository reporteCondicionadoRepository;

    @Transactional
    public List<ReporteCondicionado> listarTodos(){
        return reporteCondicionadoRepository.findAll();
    }

    @Transactional
    public List<ReporteCondicionado> listarPorGrado(int idgrado){
        return reporteCondicionadoRepository.findByidgrado(idgrado);
    }
}
