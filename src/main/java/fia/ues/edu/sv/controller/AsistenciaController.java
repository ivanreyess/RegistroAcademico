package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.EstudianteService;
import fia.ues.edu.sv.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 11-10-16.
 */
@Controller
public class AsistenciaController {

    @Autowired
    GradoService gradoService;

    @Autowired
    EstudianteService estudianteService;

    @RequestMapping("/listaGradoAsistencia")
    public String listarGrado(Model model){

        model.addAttribute("grados",gradoService.listarTodos());

        return "/docente/listaGradoAsistencia";
    }

    @RequestMapping("/asistenciaReporte")
    public String asistenciaReporte(Model model){
        model.addAttribute("estudiantes",estudianteService.listarTodos());
        return "/docente/asistenciaReporte";
    }
}
