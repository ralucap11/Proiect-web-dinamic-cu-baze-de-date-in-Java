package com.example.demo.config;

import com.example.demo.entity.Utilizatori;
import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final UtilizatoriRepository utilizatoriRepository;

    public SecurityConfiguration(UtilizatoriRepository utilizatoriRepository) {
        this.utilizatoriRepository = utilizatoriRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/editor/**").hasRole("EDITOR") //pentru editori
                    .requestMatchers("/user/**").hasAnyRole("USER", "EDITOR") //pentru utilizatori si editori
                    .anyRequest().authenticated() //Orice altceva trebuie autentificat
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/utilizatori", true)
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Utilizatori utilizatori = utilizatoriRepository.findByUtilizator(username);
            if (utilizatori == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(
                    utilizatori.getUtilizator(),
                    utilizatori.getParola(),
                    List.of(new SimpleGrantedAuthority(utilizatori.getRolul()))
            );
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}