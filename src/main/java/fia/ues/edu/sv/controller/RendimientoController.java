package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.service.GradoService;
import fia.ues.edu.sv.service.MateriaService;
import fia.ues.edu.sv.service.PeriodoService;
import fia.ues.edu.sv.service.ReporteRendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ivan on 11-21-16.
 */
@Controller
public class RendimientoController {
    @Autowired
    ReporteRendimientoService reporteRendimientoService;

    @Autowired
    PeriodoService periodoService;

    @Autowired
    GradoService gradoService;

    @RequestMapping("/listaRendimientoMateria")
    public String listarGradoYPeriodo(Model model){
        model.addAttribute("periodos",periodoService.listarTodos());
        model.addAttribute("grados",gradoService.listarTodos());
        return "/coordinador/listaRendimientoMateria";
    }

    @RequestMapping("/rendimientoReporte")
    public String reporteRendimiento(@RequestParam Integer periodo,
                                     @RequestParam Integer grado,
                                     Model model){
        model.addAttribute("rendimiento",reporteRendimientoService.listarPorGradoYPeriodo(grado,periodo));
        return "/coordinador/rendimientoReporte";
    }
}
