package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ivan on 11-12-16.
 */
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    @Query(value = "SELECT\n" +
            "\t * \n" +
            "FROM\n" +
            "\tESTUDIANTE E\n" +
            "JOIN NOTA N ON E.IDESTUDIANTE = N.IDESTUDIANTE\n" +
            "JOIN PERIODO P ON P .IDPERIODO = N.IDPERIODO\n" +
            "JOIN GRADO G ON E.IDGRADO = G .IDGRADO\n" +
            "WHERE\n" +
            "\tIDMATERIA = 13 \n" +
            "AND E.IDGRADO = ?1 \n" +
            "AND P .IDPERIODO = ?2 ",nativeQuery = true)
    List<Nota> queryByEstudianteAsistencia(int idgrado, int idperiodo);


    @Query(value = "SELECT  \n" +
            "*\n" +
            "FROM NOTA N\n" +
            "JOIN ESTUDIANTE E ON N.IDESTUDIANTE=E.IDESTUDIANTE\n" +
            "JOIN PERIODO P ON P.IDPERIODO=N.IDPERIODO\n" +
            "WHERE IDGRADO=?1 AND P.IDPERIODO=?2 \n" +
            "AND IDMATERIA=14 \n" +
            "ORDER BY NOMBREESTUDIANTE||' '||APELLLIDOSESTUDIANTE ASC",nativeQuery = true)
    List<Nota> queryByEstudianteConducta(int idgrado, int idperiodo);

}
