package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.ReporteCondicionado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-17-16.
 */
public interface ReporteCondicionadoRepository extends JpaRepository<ReporteCondicionado,Integer>{

    List<ReporteCondicionado> findByidgrado(int grado);
}
