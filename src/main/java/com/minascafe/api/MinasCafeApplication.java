package com.minascafe.api;
// @author Edson Ferreira Barbosa

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

 @SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //Desabilitando a segurança do SpringBoot

 public class MinasCafeApplication {
    
   public static void main(String[] args) {
	    SpringApplication.run(MinasCafeApplication.class, args);
		
	}	
	

   //gera um componente do Spring

   /*@Bean
	 public CommandLineRunner commandLineRunner() { //Executa automaticamente junto com o Spring
		
        return args ->{

            System.out.println("Executando o primeiro teste do projeto perfeitamente!");

       };		
	    }*/

}