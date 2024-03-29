package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.Estudiante;
import fia.ues.edu.sv.domain.Grado;
import fia.ues.edu.sv.dto.EstudianteAsistenciaDTO;
import fia.ues.edu.sv.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 11-10-16.
 */
@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Transactional
    public List<Estudiante> listarPorGrado(Grado grado){
        return estudianteRepository.findByGrado(grado);
    }


    @Transactional
    public List<Estudiante> listarTodos1(){
        return estudianteRepository.findAll();
    }

    @Transactional
    public void guardar(Estudiante estudiante){
        estudianteRepository.saveAndFlush(estudiante);
    }

    @Transactional
    public List<Estudiante> listarTodos(int idGrado){
        return estudianteRepository.queryByGrado(idGrado);
    }

    @Transactional
    public  List<Estudiante>  existenciaNotas(int idmateria,int idperiodo, int idmateria2,int idgrado){
        return estudianteRepository.queryByExistenciaNota(idmateria,idperiodo,idmateria2,idgrado);
    }
}
