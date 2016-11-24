package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.DocenteMateria;
import fia.ues.edu.sv.domain.docentes_dan_materias;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Monica on 23/11/2016.
 */
public interface DocenteMateriaRepository extends JpaRepository <docentes_dan_materias,DocenteMateria>{
}
