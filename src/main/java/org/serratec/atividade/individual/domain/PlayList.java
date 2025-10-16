package org.serratec.atividade.individual.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Schema(description = "Nome da playlist")
    @NotBlank(message = "O nome da playlist deve ser informado!")@Size(min = 1, max = 50)
    private String nome;

    @Schema(description = "Descrição da playlist")
    @Size(min = 1, max = 50)
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    @ManyToMany
    @JoinTable(name = "playlist_musica",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_musica"))
    private List<Musica> musica;

    public PlayList() {
    }

    public PlayList(Long id, String nome, String descricao, List<Musica> musica) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.musica = musica;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Musica> getMusica() {
        return musica;
    }

    public void setMusica(List<Musica> musica) {
        this.musica = musica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
