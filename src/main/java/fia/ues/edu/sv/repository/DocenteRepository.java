package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Monica on 23/11/2016.
 */
public interface DocenteRepository extends JpaRepository <Docente,Integer> {
    @Query(value = "SELECT" +
            " MAX(IDDOCENTE)" +
            " FROM DOCENTE",nativeQuery = true)
    int queryLastDocente();
}

