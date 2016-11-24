package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.PeriodoService;
import fia.ues.edu.sv.service.ReporteAprobadoDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Monica on 22/11/2016.
 */
@Controller
public class AprobadosPeriodoController {
    @Autowired
    PeriodoService periodoService;
    @Autowired
    ReporteAprobadoDirService reporteAprobadoDirService;
/*
    @RequestMapping("/listaAprobadosPorPeriodo")
    public String listarGrado(Model model, Authentication authentication){
        //System.out.println(authentication.getName());

        model.addAttribute("periodos",periodoService.listarTodos());
        return "/director/listaAprobadosPorPeriodo";
    }*/

    @RequestMapping("/aprobadosPorPeriodoReporte")
    public String reporteAprobadosDir(@RequestParam Integer periodo,Model model){
        model.addAttribute("aprobados",reporteAprobadoDirService.listarPorPeriodo(periodo));
        return "/director/aprobadosPorPeriodoReporte";
    }
}
