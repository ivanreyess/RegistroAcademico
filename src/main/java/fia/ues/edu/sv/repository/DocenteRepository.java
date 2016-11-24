package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

/**
 * Created by ivan on 11-22-16.
 */
public interface DocenteRepository extends JpaRepository<Docente,Integer> {

    @Query(value = "SELECT D.* FROM DOCENTE D \n" +
            "JOIN USUARIO U ON U.IDUSUARIO=D.IDUSUARIO\n" +
            "WHERE USUARIO= ?1",nativeQuery = true)
    Docente queryByUsuario(String usuario);
}
=======

/**
 * Created by Monica on 23/11/2016.
 */
public interface DocenteRepository extends JpaRepository <Docente,Integer> {
    @Query(value = "SELECT" +
            " MAX(IDDOCENTE)" +
            " FROM DOCENTE",nativeQuery = true)
    int queryLastDocente();
}

>>>>>>> 2a335c9548e4da06f65cde4bc1f6accb549da45b
