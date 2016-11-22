package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.IngresoNota;
import fia.ues.edu.sv.domain.Materia;
import fia.ues.edu.sv.repository.IngresoNotaRepository;
import fia.ues.edu.sv.repository.MateriaRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MariaJose on 20/11/2016.
 */
@Service
public class IngresoNotaService {
    @Autowired
    IngresoNotaRepository ingresoNotaRepository;

    @Transactional
    public List<IngresoNota> listarPorMateria(int idmateria){
      return ingresoNotaRepository.findByidmateria(idmateria);

    }
}
