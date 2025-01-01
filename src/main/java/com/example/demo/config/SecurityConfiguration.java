package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
 @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // Toate cererile trebuie să fie autentificate
            )
            .formLogin(form -> form
                .loginPage("/login") // Specifică URL-ul paginii de login
                .permitAll() // Permite accesul tuturor la pagina de login
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // URL-ul pentru logout
                .logoutSuccessUrl("/login?logout") // Redirecționare după logout
                .permitAll()
            );
        return http.build();
    }

}
