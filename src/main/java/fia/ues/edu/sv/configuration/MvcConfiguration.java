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


    }
}
