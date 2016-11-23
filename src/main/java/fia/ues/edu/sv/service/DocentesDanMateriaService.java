package fia.ues.edu.sv.service;

import fia.ues.edu.sv.domain.docentes_dan_materias;
import fia.ues.edu.sv.repository.DocenteMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Monica on 23/11/2016.
 */
@Service
public class DocentesDanMateriaService {
    @Autowired
    DocenteMateriaRepository docenteMateriaRepository;

    @Transactional
    public docentes_dan_materias guardarMateriaAsignada(docentes_dan_materias docenteMateria){

        return docenteMateriaRepository.save(docenteMateria);
    }
}
