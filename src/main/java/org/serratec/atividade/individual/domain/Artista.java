package org.serratec.atividade.individual.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nome do Artista")
    @NotBlank(message = "O nome do artista deve ser informado")@Size(max = 100, min = 2)
    private String nome;

    @Schema(description = "Nacionalidade do Artista")
    @NotBlank( message = "A nacionalidade do Artista deve ser informada!") @Size(max = 50, min = 2)
    private String nacionalidade;

    public Artista() {
    }

    public Artista(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
