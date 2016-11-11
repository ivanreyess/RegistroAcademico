package fia.ues.edu.sv.repository;


import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.domain.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */
public interface GradoRepository extends JpaRepository<Grado,Integer> {
    List<Grado> findByidgrado(int idGrado);
    List<Grado> findBydocentes(Docente docente);
}
