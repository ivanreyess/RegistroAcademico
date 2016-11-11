package fia.ues.edu.sv.repository;


import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.domain.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */
public interface GradoRepository extends JpaRepository<Grado,Integer> {
    List<Grado> findByidgrado(int idGrado);

    List<Grado> findBydocentes(Docente docente);

    @Query(value = "SELECT G.idgrado,G.grado,G.seccion,G.descripciongrado FROM grado G" +
            " JOIN docentes_imparten_a_grados dg ON G.idgrado = dg.idgrado " +
            "JOIN docente d ON d.iddocente = dg.iddocente AND dg.iddocente=?1", nativeQuery = true)
    List<Grado> queryByDocente(int idDocente);
}
