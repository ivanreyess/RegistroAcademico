package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.EstudianteService;
import fia.ues.edu.sv.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 11-11-16.
 */
@Controller
public class CondicionadoController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    GradoService gradoService;

    @RequestMapping("/condicionadoReporte")
    public String listarCondicionados(Model model){
        model.addAttribute("listaCondicionados",estudianteService.listarTodos1());
        return "/docente/condicionadosReportes";
    }


    @RequestMapping("/listaAlumnoCondicionado")
    public String listarGrado(Model model){
        model.addAttribute("grados",gradoService.listarporDocente(1));
        return "/docente/listaAlumnoCondicionado";
    }

}
