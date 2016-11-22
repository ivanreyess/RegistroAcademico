package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.domain.Estudiante;
import fia.ues.edu.sv.domain.Grado;
import fia.ues.edu.sv.repository.IngresoNotaRepository;
import fia.ues.edu.sv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MariaJose on 18/11/2016.
 */
@Controller
public class IngresoNotasController {
    @Autowired
    GradoService gradoService;

    @Autowired
    PeriodoService periodoService;

    @Autowired
    MateriaService materiaService;

    @Autowired
    EstudianteService  estudianteService;

    @Autowired
    IngresoNotaService ingresoNotaService;

    @RequestMapping("/registroNotas")
    public String listarGrado(Model model){
        Grado grado= new Grado();
        model.addAttribute("grados",gradoService.listarporDocente(1));
        model.addAttribute("periodos",periodoService.listarTodos());
        model.addAttribute("materias",materiaService.listarPorDocente(1));
        return "/docente/registroNotas";
    }


    @RequestMapping("/calificacionesTabla")
    public String calificacionesTabla(Model model, @RequestParam Integer idgrado,@RequestParam Integer periodo,@RequestParam Integer idmateria){
        model.addAttribute("alumnos",estudianteService.existenciaNotas(idmateria,periodo,idmateria,idgrado));
        model.addAttribute("actividades",ingresoNotaService.listarPorMateria(idmateria));
        model.addAttribute("nombremateria",ingresoNotaService.listarPorMateria(idmateria).get(0).getNombremateria());
        model.addAttribute("periodo",periodoService.listarPorId(periodo));
        return "/docente/calificacionesTabla";
    }

    @RequestMapping("/ingresarNota")
    public String ingresarNota(@RequestParam Integer idestudiante, BigDecimal idactividades)
    {

        return "/docente/calificacionesTabla";
    }
}
