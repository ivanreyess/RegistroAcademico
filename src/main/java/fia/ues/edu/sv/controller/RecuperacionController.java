package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.domain.Periodo;
import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.PeriodoService;
import fia.ues.edu.sv.service.ReporteRecuperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ivan on 11-13-16.
 */
@Controller
public class RecuperacionController {
    @Autowired
    ReporteRecuperacionService reporteRecuperacionService;

    @Autowired
    GradoService gradoService;

    @Autowired
    PeriodoService periodoService;

    @RequestMapping("/listaAlumnoRecuperacion")
    public String listarGrado(Model model, Authentication authentication){
        //System.out.println(authentication.getName());
        model.addAttribute("grados",gradoService.listarporDocente(1));
        return "/docente/listaAlumnoRecuperacion";
    }

    @RequestMapping("/recuperacionReporte")
    public String reporteRecuperacion(Model model, @RequestParam Integer grado){
        model.addAttribute("recuperacion",reporteRecuperacionService.listarPorGrado(grado));
        return "/docente/recuperacionReporte";
    }

    @RequestMapping("/listaAlumnoRecuperacionCor")
    public String listarGradoCor(Model model, Authentication authentication){
        //System.out.println(authentication.getName());
        model.addAttribute("grados",gradoService.listarTodos());
        return "/coordinador/listaAlumnoRecuperacionCor";
    }
}
