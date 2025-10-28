package Projeto.Alan;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name = "Remedio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;

    private int quantidade;

    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    private boolean ativo;

    public Remedio(DadosCadastroRemedios dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    // Setter manual para o id, garantindo que o Hibernate encontre
    public void setId(Long id) {
        this.id = id;
    }

    public void atualizarInformacoes(@Valid DadosatualizarRemedios dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.via() != null) {
            this.via = dados.via();
        }
        if (dados.laboratorio() != null) {
            this.laboratorio = dados.laboratorio();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
    
    public void reativar() {
    	this.ativo = true;    
    }

	public Boolean getAtivo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

