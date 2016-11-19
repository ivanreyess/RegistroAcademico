package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.EstudianteService;
import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.NotaService;
import fia.ues.edu.sv.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by ivan on 11-10-16.
 */
@Controller
public class AsistenciaController {

    @Autowired
    GradoService gradoService;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    PeriodoService periodoService;

    @Autowired
    NotaService notaService;



    @RequestMapping("/listaGradoAsistencia")
    public String listarGrado(Model model, Authentication authentication){
        //System.out.println(authentication.getName());
        model.addAttribute("grados",gradoService.listarporDocente(1));
        model.addAttribute("periodos",periodoService.listarTodos());
        return "/docente/listaGradoAsistencia";
    }

    @RequestMapping("/asistenciaReporte")
    public String asistenciaReporte(@RequestParam Integer grado, @RequestParam Integer periodo, Model model){
       model.addAttribute("estudiantes",notaService.listaAsistencia(grado,periodo));
        return "/docente/asistenciaReporte";
    }

    @RequestMapping("/listaGradoAsistenciaCor")
    public String listarGradoCor(Model model, Authentication authentication){
        //System.out.println(authentication.getName());
        model.addAttribute("grados",gradoService.listarporDocente(1));
        model.addAttribute("periodos",periodoService.listarTodos());
        return "/coordinador/listaGradoAsistenciaCor";
    }
}
