package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.ReporteRendimiento;
import fia.ues.edu.sv.repository.ReporteRendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-21-16.
 */
@Service
public class ReporteRendimientoService {

    @Autowired
    ReporteRendimientoRepository reporteRendimientoRepository;

    @Transactional
    public List<ReporteRendimiento> listarPorGradoYPeriodo(int grado, int periodo){
        return reporteRendimientoRepository.findByNumeroperiodoAndIdgrado(periodo,grado);
    }
}
