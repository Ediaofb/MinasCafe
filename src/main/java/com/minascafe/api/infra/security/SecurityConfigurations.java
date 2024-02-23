
package com.minascafe.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // "Habilite a configuração do WebSecurity e eu vou configurar dentro dessa
                   // classe"
public class SecurityConfigurations {
    // Corrente de filtro de segurança - métodos para fazer validações no usuário e
    // validar se ele está apto a fazer as requisições

    @Autowired
    SecurityFilter securityFilter;

    @Bean // para que o Spring consiga instanciar a classe
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // desliga a configuração padrão do Spring Security
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // autenticação
                                                                                                              // via
                                                                                                              // token.Ñ
                                                                                                              // armazena
                                                                                                              // infs.
                                                                                                              // da
                                                                                                              // sessão
                                                                                                              // no
                                                                                                              // servidor
                .authorizeHttpRequests(authorize -> authorize // Quais são as requisições http que serão autorizadas
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // permite q/ qualquer pessoa
                                                                                     // faça requisições para tela de
                                                                                     // login
                        .requestMatchers(HttpMethod.OPTIONS, "/auth/login/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll() //.hasRole("ADMIN")//.permitAll() // ** Só para testar. Deve ser bloqueado. Permissão só para Admins **
                        .requestMatchers(HttpMethod.OPTIONS, "/auth/register").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.OPTIONS, "/cafecoco/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/cafemaquina/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/cafebeneficiado/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/produtor/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cafecoco/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cafemaquina/**").permitAll() //hasRole("ADMIN" 
                        .requestMatchers(HttpMethod.POST, "/cafebeneficiado/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/produtor/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cafecoco/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cafemaquina/**").permitAll()//.authenticated() //.permitAll()
                        .requestMatchers(HttpMethod.GET, "/cafebeneficiado/**").permitAll() //.authenticated() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/produtor/**").permitAll() //.authenticated()
                        .requestMatchers(HttpMethod.PUT, "/cafecoco/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cafemaquina/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cafebeneficiado/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/produtor/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cafecoco/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cafemaquina/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cafebeneficiado/**").permitAll() //.hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/produtor/**").permitAll() //.hasRole("ADMIN")
                        .anyRequest().authenticated() // para todas as outras requisições o usuário deve estar
                                                      // autenticado apenas
                )
                // Fará um filtro em todas as reqs. com base nas regras q estaremos
                // implementando. Fará antes dos filtros acima
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //1° o securityFilter, depois UserNamePasswordAuthenticationFilter
                .build(); // Cria o objeto SecurityFilterChain
    }

    @Bean // Para q o Spring identifique essa classe e consiga fazer a injeção de
          // dependência
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Para pegar a instância de um
                                                                       // authenticationManager do SpringSecurity

    }

    @Bean // P/ que o Spring faça a injeção correta deste método quando for necessário
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// Classe q o Spring Security fornece para fazer criptografia das nossas
                                           // senhas
        // Faz o hash dos dados e faz decode também - com a mesma entrada ao 'hashear'
        // sempre gera a mesma saída
    }
}