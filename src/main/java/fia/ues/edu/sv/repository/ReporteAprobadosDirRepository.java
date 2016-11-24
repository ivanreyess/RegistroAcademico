package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.ReporteAprobadosDir;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Monica on 22/11/2016.
 */
public interface ReporteAprobadosDirRepository extends JpaRepository<ReporteAprobadosDir,Integer> {
    List<ReporteAprobadosDir> findBynumeroperiodo(int numeroperiodo);
}
