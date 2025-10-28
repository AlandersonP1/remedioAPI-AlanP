package Projeto.Alan;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(
    Long id,
    String nome,
    Via via,
    String lote,
    int quantidade,
    LocalDate validade,
    Laboratorio laboratorio,
    Boolean ativo) {  // nome do campo com letra minúscula

    public DadosDetalhamentoRemedio(Remedio remedio) {
        this(
            remedio.getId(),
            remedio.getNome(),
            remedio.getVia(),
            remedio.getLote(),
            remedio.getQuantidade(),
            remedio.getValidade(),
            remedio.getLaboratorio(),
            remedio.getAtivo()
        );
    }
}
