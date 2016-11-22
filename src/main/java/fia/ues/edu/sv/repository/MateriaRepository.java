package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Materia;
import fia.ues.edu.sv.domain.IngresoNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Monica on 15/11/2016.
 */
public interface MateriaRepository extends JpaRepository <Materia,Integer> {

     @Query(value = "SELECT NOMBREMATERIA,M2.IDMATERIA \n" +
             "FROM MATERIA M\n" +
             "JOIN DOCENTES_DAN_MATERIAS M2 ON M.IDMATERIA=M2.IDMATERIA\n" +
             "WHERE IDDOCENTE=?1",nativeQuery = true)
    List<Materia> queryByDocente(int idDocente);

    @Query(value = "SELECT MA.IDACTIVIDADES,MA.IDMATERIA,NOMBREACTIVIDAD FROM ACTIVIDADES A\n" +
            "JOIN MATERIA_TIENE_ACTIVIDADES MA ON A.IDACTIVIDADES=MA.IDACTIVIDADES\n" +
            "WHERE MA.IDMATERIA=?1",nativeQuery = true)
    List<IngresoNota> queryByMateria(int idmateria);
}
