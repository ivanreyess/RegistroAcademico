package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Estudiante;
import fia.ues.edu.sv.domain.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
    List<Estudiante> findByGrado(Grado grado);
}
