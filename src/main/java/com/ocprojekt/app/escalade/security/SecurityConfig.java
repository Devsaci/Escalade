package com.ocprojekt.app.escalade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("1234")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("1234")
//                .roles("USER", "ADMIN");
        
         auth.jdbcAuthentication().dataSource(dataSource)
                 .usersByUsernameQuery("SELECT username as principal, password as credentials," +
                         " enabled FROM user WHERE username=?")
                 .authoritiesByUsernameQuery("SELECT username as principal," +
                         " role as role FROM user WHERE username=?")
                 .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/").hasRole("USER");
        http.authorizeRequests().antMatchers("/Accueil").hasRole("USER");
        http.authorizeRequests().antMatchers("/ListeSites").hasRole("USER");
        http.authorizeRequests().antMatchers("/Site").hasRole("USER");
        http.authorizeRequests().antMatchers("/NewSpot").hasRole("USER");
        http.authorizeRequests().antMatchers("/Topo").hasRole("USER");
        http.authorizeRequests().antMatchers("/Profil").hasRole("USER");
        http.authorizeRequests().antMatchers("/saveSite").hasRole("USER");
        http.authorizeRequests().antMatchers("/saveSecteur").hasRole("USER");
        http.authorizeRequests().antMatchers("/saveVoie").hasRole("USER");
        http.authorizeRequests().antMatchers("/saveTopo").hasRole("USER");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
