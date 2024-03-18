package br.com.alura.spring.data;

import br.com.alura.spring.data.principal.Principal;
import br.com.alura.spring.data.repository.FabricanteRepository;
import br.com.alura.spring.data.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    @Autowired
    private ProdutoRepository proRepository;
    @Autowired
    private FabricanteRepository fabRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    // Chamar aqui tudo que for usar na aplicação
    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(proRepository, fabRepository);
        principal.inicial();
    }
}
