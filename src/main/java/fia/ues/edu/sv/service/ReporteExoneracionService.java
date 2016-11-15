package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.MateriaEstudiante;
import fia.ues.edu.sv.domain.ReporteExoneracion;
import fia.ues.edu.sv.repository.ReporteExoneracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-14-16.
 */
@Service
public class ReporteExoneracionService {
    @Autowired
    ReporteExoneracionRepository reporteExoneracionRepository;

    @Transactional
    public List<ReporteExoneracion> listarTodos(){
        return reporteExoneracionRepository.findAll();
    }

    @Transactional
    public List<ReporteExoneracion> listarPorMateriayGrado(String  materia, int idgrado){
        return reporteExoneracionRepository.findBymateriaAndIdgrado(materia,idgrado);
    }
    }
