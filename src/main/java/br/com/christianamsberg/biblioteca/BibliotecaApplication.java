package br.com.christianamsberg.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicação Principal - Sistema de Gestão de Livros
 * Spring Boot com Persistência em Memória (sem JPA ou Banco de Dados)
 */
@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
