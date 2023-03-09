package ru.martynkin.security.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * In-Memory Authentication
 */

@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                //пароль password
                .password("{bcrypt}$2a$12$tHyc4gCrOkcQz5DLGLHz1.U3xV7YQDchnsoPwJ2n0TsT12mqiw/Bi")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                //пароль password
                .password("{bcrypt}$2a$12$tHyc4gCrOkcQz5DLGLHz1.U3xV7YQDchnsoPwJ2n0TsT12mqiw/Bi")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
