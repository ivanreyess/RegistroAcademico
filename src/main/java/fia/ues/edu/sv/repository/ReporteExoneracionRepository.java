package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.MateriaEstudiante;
import fia.ues.edu.sv.domain.ReporteExoneracion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-14-16.
 */
public interface ReporteExoneracionRepository extends JpaRepository<ReporteExoneracion,MateriaEstudiante> {

    List<ReporteExoneracion> findBymateriaAndIdgrado(String materia,int idgrado);
}
