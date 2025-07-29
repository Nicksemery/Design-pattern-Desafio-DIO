package Padroes_de_projetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesDeProjetosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesDeProjetosApplication.class, args);
	}

}
