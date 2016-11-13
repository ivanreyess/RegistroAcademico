package fia.ues.edu.sv.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by ivan on 11-11-16.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/coordinador/**","/docente/**","/director/**").permitAll()
                    .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll().successHandler(customSuccessHandler)
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login?logut")
                    .permitAll();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("docente").password("password").roles("Docente");
        auth.inMemoryAuthentication().withUser("director").password("password").roles("Director");
        auth.inMemoryAuthentication().withUser("coordinador").password("password").roles("Coordinador");

    }
}
