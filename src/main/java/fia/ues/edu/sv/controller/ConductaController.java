package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.NotaService;
import fia.ues.edu.sv.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ivan on 11-17-16.
 */
@Controller
public class ConductaController {

    @Autowired
    GradoService gradoService;

    @Autowired
    NotaService notaService;

    @Autowired
    PeriodoService periodoService;

    @RequestMapping("/listaAlumnoConducta")
    public String listarGrado(Model model, Authentication authentication){
        //System.out.println(authentication.getName());
        model.addAttribute("grados",gradoService.listarporDocente(1));
        model.addAttribute("periodos",periodoService.listarTodos());
        return "/docente/listaAlumnoConducta";
    }

    @RequestMapping("/conductaReporte")
    public String conductaReporte(Model model, @RequestParam Integer grado,@RequestParam Integer periodo){
        model.addAttribute("estudiantes",notaService.listaConducta(grado,periodo));
        return "/docente/conductaReporte";
    }


}
