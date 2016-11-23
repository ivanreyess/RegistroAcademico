package fia.ues.edu.sv.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ivan on 10-09-16.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/blank").setViewName("blank_page");
        registry.addViewController("/table").setViewName("table_datatables_colreorder");
        registry.addViewController("/listaGradoAsistencia").setViewName("/docente/listaGradoAsistencia");
        registry.addViewController("/asistenciaReporte").setViewName("/docente/asistenciaReporte");
        registry.addViewController("/recuperacionReporte").setViewName("/docente/recuperacionReporte");
        registry.addViewController("/docente").setViewName("/docente/docente");
        registry.addViewController("/coordinador").setViewName("/coordinador/coordinador");
        registry.addViewController("/director").setViewName("/director/director");
        //registry.addViewController("/condicionadosReporte").setViewName("/docente/condicionadosReportes");
        registry.addViewController("/listaAlumnoGrado").setViewName("/docente/listaAlumnoGrado");
        registry.addViewController("/listaAlumnoConducta").setViewName("/docente/listaAlumnoConducta");
        registry.addViewController("/listaAlumnoRecuperacion").setViewName("/docente/listaAlumnoRecuperacion");
        registry.addViewController("/listaAlumnoExonerado").setViewName("/coordinador/listaAlumnoExonerado");
        registry.addViewController("/listaRendimientoMateria").setViewName("/coordinador/listaRendimientoMateria");
        registry.addViewController("/listaAlumnoExcelencia").setViewName("/coordinador/listaAlumnoExcelencia");
        registry.addViewController("/listaAlumnoGradoCor").setViewName("/coordinador/listaAlumnoGradoCor");
        registry.addViewController("/listaAlumnoConductaCor").setViewName("/coordinador/listaAlumnoConductaCor");
        registry.addViewController("/listaAlumnoRecuperacionCor").setViewName("/coordinador/listaAlumnoRecuperacionCor");
        registry.addViewController("/listaAlumnoCondicionadoCor").setViewName("/coordinador/listaAlumnoCondicionadoCor");
        registry.addViewController("/listaGradoAsistenciaCor").setViewName("/coordinador/listaGradoAsistenciaCor");

        registry.addViewController("/listaAlumnoExoneradoDir").setViewName("/director/listaAlumnoExoneradoDir");
        registry.addViewController("/listaRendimientoMateriaDir").setViewName("/director/listaRendimientoMateriaDir");
        registry.addViewController("/listaAlumnoExcelenciaDir").setViewName("/director/listaAlumnoExcelenciaDir");
        registry.addViewController("/listaAlumnoGradoDir").setViewName("/director/listaAlumnoGradoDir");
        registry.addViewController("/listaAlumnoConductaDir").setViewName("/director/listaAlumnoConductaDir");
        registry.addViewController("/listaAlumnoRecuperacionDir").setViewName("/director/listaAlumnoRecuperacionDir");
        registry.addViewController("/listaAlumnoCondicionadoDir").setViewName("/director/listaAlumnoCondicionadoDir");
        registry.addViewController("/listaGradoAsistenciaDir").setViewName("/director/listaGradoAsistenciaDir");
        registry.addViewController("/listaAprobadosPorPeriodo").setViewName("/director/listaAprobadosPorPeriodo");


        registry.addViewController("/registroNotas").setViewName("/docente/registroNotas");
        registry.addViewController("/calificacionesTabla").setViewName("/docente/calificacionesTabla");

        registry.addViewController("/docenteMateria").setViewName("/coordinador/docenteMateria");

    }
}
