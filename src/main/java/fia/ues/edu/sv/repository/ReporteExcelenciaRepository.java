package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.MateriaEstudiante;
import fia.ues.edu.sv.domain.ReporteExcelencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Monica on 18/11/2016.
 */
public interface ReporteExcelenciaRepository extends JpaRepository<ReporteExcelencia,MateriaEstudiante> {
    List<ReporteExcelencia> findBymateriaAndIdgrado(String materia,int idgrado);

}
