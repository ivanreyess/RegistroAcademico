package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.ReporteRendimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-21-16.
 */
public interface ReporteRendimientoRepository extends JpaRepository<ReporteRendimiento, Integer> {

    List<ReporteRendimiento> findByNumeroperiodoAndIdgrado(int numeroperiodo, int idgrado);
}
