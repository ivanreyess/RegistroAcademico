package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.IngresoNota;
import fia.ues.edu.sv.domain.Materia;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Maria Jose on 15/11/2016.
 */
public interface IngresoNotaRepository extends JpaRepository <IngresoNota,Integer> {

    List<IngresoNota> findByidmateria(int idmateria);
}
