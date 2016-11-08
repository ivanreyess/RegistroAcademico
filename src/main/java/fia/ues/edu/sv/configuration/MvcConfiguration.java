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
        registry.addViewController("/listaGrado").setViewName("listaGrado");
        registry.addViewController("/asistenciaReporte").setViewName("asistenciaReporte");
        registry.addViewController("/recuperacion").setViewName("recuperacionReporte");
        registry.addViewController("/docente").setViewName("docente");
    }
}
