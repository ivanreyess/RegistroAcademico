package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.ReporteRecuperacion;
import fia.ues.edu.sv.repository.ReporteRecuperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-13-16.
 */
@Service
public class ReporteRecuperacionService {

    @Autowired
    ReporteRecuperacionRepository reporteRecuperacionRepository;

    @Transactional
    public List<ReporteRecuperacion> listarPorGrado(int idgrado){
        return reporteRecuperacionRepository.findBygrado(idgrado);
    }

    @Transactional
    public List<ReporteRecuperacion> listarTodos(){
        return reporteRecuperacionRepository.findAll();
    }
}
