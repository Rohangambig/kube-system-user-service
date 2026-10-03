package user_service.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration 
@EnableWebSecurity 
@EnableMethodSecurity 
public class SecurityConfig   {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(request -> request
                .requestMatchers("/login", "/register","/health").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable())
            .build();

    }

    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationProvider authProvider, UserDetailsService userDetailsService) throws Exception {
    //     DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider(userDetailsService);
    //     daoAuthProvider.setPasswordEncoder(passwordEncoder());

    //     return new ProviderManager(daoAuthProvider);
    // }

}
