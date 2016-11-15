package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.ReporteRecuperacionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/recuperacionReporte")
    public String reporteRecuperacion(Model model){
        model.addAttribute("recuperacion",reporteRecuperacionService.listarPorGrado(3));
        return "/docente/recuperacionReporte";
    }
}
