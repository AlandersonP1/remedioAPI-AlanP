package Projeto.Alan;

import jakarta.validation.constraints.NotNull;

public record DadosatualizarRemedios(
		@NotNull
		Long id,
		String nome,
		Via via,
		Laboratorio laboratorio) {

}
