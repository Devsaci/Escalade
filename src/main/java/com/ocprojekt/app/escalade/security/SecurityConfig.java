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
        http.authorizeRequests().antMatchers("/").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Accueil").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/ListeSites").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Site").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/NewSpot").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Topo").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/Profil").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveSite").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveSecteur").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveVoie").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers("/saveTopo").hasAnyRole("USER","ADMIN");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
