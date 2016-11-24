package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.ReporteAprobadosDir;
import fia.ues.edu.sv.repository.ReporteAprobadosDirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Monica on 22/11/2016.
 */
@Service
public class ReporteAprobadoDirService {
    @Autowired
    ReporteAprobadosDirRepository reporteAprobadosDirRepository;
    @Transactional
    public List<ReporteAprobadosDir> listarPorPeriodo(int numeroperiodo){
        return reporteAprobadosDirRepository.findBynumeroperiodo(numeroperiodo);
    }
}
