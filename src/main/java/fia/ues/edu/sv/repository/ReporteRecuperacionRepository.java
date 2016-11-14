package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.ReporteRecuperacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-13-16.
 */
public interface ReporteRecuperacionRepository extends JpaRepository<ReporteRecuperacion,Integer>{

    List<ReporteRecuperacion> findBygrado(String grado);
}
