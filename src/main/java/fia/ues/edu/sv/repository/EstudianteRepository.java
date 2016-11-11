package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Estudiante;
import fia.ues.edu.sv.domain.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {

    List<Estudiante> findByGrado(Grado grado);

    @Query(value ="SELECT e.idestudiante,e.idgrado,e.nie, e.nombreestudiante , e.apelllidosestudiante FROM estudiante e" +
          " JOIN grado G ON G.idgrado = e.idgrado AND G.idgrado =?1", nativeQuery =true)
    List<Estudiante> queryByGrado(int idGrado);
}
