package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.ReporteExcelencia;
import fia.ues.edu.sv.repository.ReporteExcelenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Monica on 18/11/2016.
 */
@Service
public class ReporteExcelenciaService {
    @Autowired
    ReporteExcelenciaRepository reporteExcelenciaRepository;
    @Transactional
    public List<ReporteExcelencia> listarTodos(){
        return reporteExcelenciaRepository.findAll();
    }

    @Transactional
    public List<ReporteExcelencia> listarPorMateriayGrado(String materia, int idgrado){
        return reporteExcelenciaRepository.findBymateriaAndIdgrado(materia,idgrado);
    }
}
