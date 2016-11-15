package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.domain.MateriaEstudiante;
import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.MateriaService;
import fia.ues.edu.sv.service.ReporteExoneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ivan on 11-14-16.
 */
@Controller
public class ReporteExoneracionController {

    @Autowired
    ReporteExoneracionService reporteExoneracionService;
    @Autowired
    GradoService gradoService;
    @Autowired
    MateriaService materiaService;

    @RequestMapping("/exoneracionReporte")
    public String reporteRecuperacion(@RequestParam Integer id, @RequestParam String materia, Model model){
        MateriaEstudiante materiaEstudiante= new MateriaEstudiante();
        materiaEstudiante.setIdmateria(1);
        // model.addAttribute("exoneracion",reporteExoneracionService.listarPorMateriayGrado("Ingles",1));
        model.addAttribute("exoneracion",reporteExoneracionService.
                listarPorMateriayGrado(materia,id));
        return "/coordinador/exoneracionReporte";
    }
    @RequestMapping("/listaAlumnoExonerado")
    public String listarGrado(Model model){
        model.addAttribute("lgrados",gradoService.listarTodos());
        model.addAttribute("materia",materiaService.listarTodas());

        return "/coordinador/listaAlumnoExonerado";
    }
}
