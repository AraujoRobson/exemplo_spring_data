package br.edu.unoesc.exemplo_H2;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.exemplo_H2.model.Livro;
import br.edu.unoesc.exemplo_H2.repository.LivroRepository;

@SpringBootApplication
public class ExemploH2Application {

  public static void main(String[] args) {
    SpringApplication.run(ExemploH2Application.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(LivroRepository repositorio) {
    return args -> {
      Livro l = new Livro(null, "O Senhor dos pastéis", 666, "Tolkien");
      l = repositorio.save(l);

      repositorio.save(new Livro(null, "O hobbit", 42, "J.R.R.Tolkien"));

      Optional<Livro> p = repositorio.findById(2);
    };
  }
}
