package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.EstudianteService;
import fia.ues.edu.sv.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

       // model.addAttribute("grados",gradoService.listarTodos());
        model.addAttribute("grados",gradoService.listarporDocente(1));
        return "/docente/listaGradoAsistencia";
    }

    @RequestMapping("/asistenciaReporte")
    public String asistenciaReporte(@RequestParam Integer id, Model model){
        model.addAttribute("estudiantes",estudianteService.listarTodos(id));
        return "/docente/asistenciaReporte";
    }
}
