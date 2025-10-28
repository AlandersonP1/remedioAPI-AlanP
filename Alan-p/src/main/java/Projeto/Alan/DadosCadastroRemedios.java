package Projeto.Alan;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRemedios(
		
		 
		@NotBlank
		String nome,
		@Enumerated
        Via via,
        @NotBlank
        String lote,
        
        
        int quantidade,
        
        @Future
        LocalDate validade,
		@Enumerated
        Laboratorio laboratorio) {

}
