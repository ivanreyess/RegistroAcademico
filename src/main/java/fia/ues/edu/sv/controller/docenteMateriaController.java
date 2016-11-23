package fia.ues.edu.sv.controller;

import fia.ues.edu.sv.domain.Docente;
import fia.ues.edu.sv.domain.DocenteMateria;
import fia.ues.edu.sv.domain.docentes_dan_materias;
import fia.ues.edu.sv.service.DocenteService;
import fia.ues.edu.sv.service.DocentesDanMateriaService;
import fia.ues.edu.sv.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Monica on 23/11/2016.
 */
@Controller
public class docenteMateriaController {
    @Autowired
    MateriaService materiaService;
    @Autowired
    DocenteService docenteService;
    @Autowired
    DocentesDanMateriaService docentesDanMateriaService;

    @RequestMapping("/docenteMateria")
    public String listaMateria (Model model){
        model.addAttribute("materia",materiaService.listarTodas());
        return "/coordinador/docenteMateria";
    }
    @RequestMapping("/guardarDocente")
    public String guardarDocente(@RequestParam String nombredocente, @RequestParam String apellidodocente,@RequestParam Integer materia,Model model){

        Docente docente = new Docente() ;
        docente.setNombredocente(nombredocente);
        docente.setApellidodocente(apellidodocente);
        docenteService.guardarDocente(docente);
        docentes_dan_materias docentemateria = new docentes_dan_materias();
        DocenteMateria dm = new DocenteMateria();
        dm.setIdmateria(materia);
        dm.setIddocente(docenteService.ultimoDocente());
        docentemateria.setDocenteMateria(dm);
        docentesDanMateriaService.guardarMateriaAsignada(docentemateria);

        System.out.println("se guardooo");
        return "redirect:/docenteMateria";
    }
}
