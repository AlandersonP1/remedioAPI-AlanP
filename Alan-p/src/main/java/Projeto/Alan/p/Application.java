package Projeto.Alan.p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Projeto.Alan", "Projeto.Alan.p"})
@EntityScan(basePackages = {"Projeto.Alan"}) // Isso resolve seu erro
@EnableJpaRepositories(basePackages = {"Projeto.Alan.p"}) // Caso seus repositórios estejam aí
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
