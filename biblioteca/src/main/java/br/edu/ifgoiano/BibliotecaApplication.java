package br.edu.ifgoiano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifgoiano.entidade.Livro;
import br.edu.ifgoiano.repository.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar registros de livros
		
		Livro livro1 = new Livro();
		livro1.setNome("Java para Leigos");
		livro1.setAutor("Acsa");
		livro1.setIsbn("12233");
		
		Livro livro2 = new Livro();
		livro2.setNome("Todas suas imperfeições");
		livro2.setAutor("Coller Hover");
		livro2.setIsbn("12233");
		
		livroRepository.save(livro1);
		livroRepository.save(livro2);
		
	}


}
