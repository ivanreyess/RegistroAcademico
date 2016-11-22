package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.MateriaService;
import fia.ues.edu.sv.service.ReporteExcelenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Monica on 18/11/2016.
 */
@Controller
public class ReporteExcelenciaController {
    @Autowired
    ReporteExcelenciaService reporteExcelenciaService;
    @Autowired
    GradoService gradoService;
    @Autowired
    MateriaService materiaService;


    @RequestMapping("/listaAlumnoExcelencia")
    public String listarGradoMateria(Model model){
        model.addAttribute("lgrados",gradoService.listarTodos());
        model.addAttribute("materia",materiaService.listarTodas());

        return "/coordinador/listaAlumnoExcelencia";
    }
    @RequestMapping("/exelenciaReporte")
    public String reporteExcelencia( @RequestParam String materia,@RequestParam Integer id, Model model){
        model.addAttribute("excelencia",reporteExcelenciaService.listarPorMateriayGrado(materia,id));
        return "/coordinador/excelenciaReporte";
    }
}
