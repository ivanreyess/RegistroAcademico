package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Estudiante;
import fia.ues.edu.sv.domain.Grado;
import fia.ues.edu.sv.dto.EstudianteAsistenciaDTO;
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

    @Query(value = "SELECT  e.idestudiante,e.idgrado,e.nie, e.nombreestudiante , e.apelllidosestudiante" +
            " FROM ESTUDIANTE E  WHERE  IDESTUDIANTE NOT IN \n" +
            "(\n" +
            "SELECT IDESTUDIANTE FROM NOTA N WHERE IDMATERIA=?1 AND IDPERIODO=?2 " +
            "GROUP BY  IDESTUDIANTE HAVING COUNT(IDACTIVIDADES)=\n" +
            "(SELECT  DISTINCT CASE WHEN IDMATERIA>=1 THEN 1 \n" +
            "ELSE 5 END CONTADOR FROM NOTA WHERE IDMATERIA=?3)\n" +
            " ) \n" +
            "AND IDGRADO=?4",nativeQuery = true)
    List<Estudiante> queryByExistenciaNota(int idmateria,int idperiodo, int idmateria2,int idgrado);

}
