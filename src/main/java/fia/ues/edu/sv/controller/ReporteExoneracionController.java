package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.domain.MateriaEstudiante;
import fia.ues.edu.sv.service.ReporteExoneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 11-14-16.
 */
@Controller
public class ReporteExoneracionController {

    @Autowired
    ReporteExoneracionService reporteExoneracionService;

    @RequestMapping("/exoneracionReporte")
    public String reporteRecuperacion(Model model){
        MateriaEstudiante materiaEstudiante= new MateriaEstudiante();
        materiaEstudiante.setIdmateria(1);
         model.addAttribute("exoneracion",reporteExoneracionService.
                 listarPorMateriayGrado("Matematicas",1));
        return "/coordinador/exoneracionReporte";
    }
}
