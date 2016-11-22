package fia.ues.edu.sv.repository;

import fia.ues.edu.sv.domain.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ivan on 11-12-16.
 */
public interface PeriodoRepository extends JpaRepository<Periodo,Integer>{

    List<Periodo> findByidperiodo(int idperiodo);

}
