package com.example.appalumnos.config.security;

import com.example.appalumnos.config.APIConfig;
import com.example.appalumnos.config.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// Activamos la seguridad a nivel de método, por si queremos trabajar a nivel de controlador
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    /*
    Mecanismos de autentificación
    Expone nuestro mecanismos de autentificación como un bean para que luego lo podamos usar en un filtro
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    /*
   Configuración de autorización según verbos y rutas
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                // Para el establecimiento de sesiones son estado, no usamos sesiones
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Autorizamos con roles y acceso
                .authorizeRequests()

                // Registrarse todos y loguearse todos. De esta manera podemos permitir las consultas a todas las rutas
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/usuarios/**").permitAll()
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/usuarios/**").hasAnyRole("USER", "ADMIN")

                // Permitimos el acceso a todas las rutas de /rest/files
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/files/**").permitAll()
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/files/**").permitAll()

                // Loguearse, si estyuviese en otra ruta
                //.antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/auth/login").permitAll()

                // Permitimos el acceso a todas las rutas de /rest/productos
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/cursos/**").permitAll()
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/cursos/**").permitAll()
                .antMatchers(HttpMethod.PUT, APIConfig.API_PATH + "/cursos/**").permitAll()
                .antMatchers(HttpMethod.DELETE, APIConfig.API_PATH + "/cursos/**").permitAll()
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/modulos/**").permitAll()
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/modulos/**").permitAll()
                .antMatchers(HttpMethod.PUT, APIConfig.API_PATH + "/modulos/**").permitAll()
                .antMatchers(HttpMethod.DELETE, APIConfig.API_PATH + "/modulos/**").permitAll()
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/alumnos/**").permitAll()
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/alumnos/**").permitAll()
                .antMatchers(HttpMethod.PUT, APIConfig.API_PATH + "/alumnos/**").permitAll()
                .antMatchers(HttpMethod.DELETE, APIConfig.API_PATH + "/alumnos/**").permitAll()
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/calificaciones/**").permitAll()
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/calificaciones/**").permitAll()
                .antMatchers(HttpMethod.PUT, APIConfig.API_PATH + "/calificaciones/**").permitAll()
                .antMatchers(HttpMethod.DELETE, APIConfig.API_PATH + "/calificaciones/**").permitAll()

                // Jugamos ahora con /auth/productos

                // Consultar productos solo los usuarios registrados pueden hacerlo
                .antMatchers(HttpMethod.GET, APIConfig.API_PATH + "/auth/**").hasAnyRole("USER", "ADMIN")
                // Añadir productos solo los administradores
                .antMatchers(HttpMethod.POST, APIConfig.API_PATH + "/auth/**").hasRole("ADMIN")
                // Actualizar productos solo los administradores
                .antMatchers(HttpMethod.PUT, APIConfig.API_PATH + "/auth/**").hasRole("ADMIN")
                // Eliminar productos solo el administradores
                .antMatchers(HttpMethod.DELETE, APIConfig.API_PATH + "/auth/**").hasRole("ADMIN")

                // Cuidado que la ruta a la consola de H2 está capada, debemos darle acceso a todos temporalmente
                //.antMatchers("/h2-console").permitAll()
                // De la misma manera a swagger
                //.antMatchers("/swagger-ui.html").permitAll()

                // Resto de rutas, auteticadas o no, tu decides, cuidado con la consola
                // de H2
                // y la documentación de Swagger
                // que debes darle acceso si la necesitas.
                //.anyRequest().authenticated();
                // O no, depende de nuestra política de seguridad
                .anyRequest().not().authenticated();

                // De nuevo para la consola de H2 estas dos lineas
                //                .and().csrf().ignoringAntMatchers("/h2-console/**")
                //                .and().headers().frameOptions().sameOrigin();


        // Será el encargado de coger el token y si es válido lo dejaremos pasar...
        // Añadimos el filtro (jwtAuthorizationFilter).
        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
