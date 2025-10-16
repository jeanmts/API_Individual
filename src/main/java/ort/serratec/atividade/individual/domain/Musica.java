package ort.serratec.atividade.individual.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ort.serratec.atividade.individual.enums.GeneroMusical;


import java.util.List;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Schema(description = "Titulo da musica")
    @NotBlank(message = "O titulo da musica deve ser informado") @Size(min = 2, max = 50)
    private String titulo;

    @Schema(description = "Gênero Musical", name = "Gênero musical: ROCK,POP,SAMBA,FUNK,SERTANEJO")
    @NotBlank(message = "O gênero musical deve ser informado!")
    private GeneroMusical generoMusical;

    @ManyToMany
    @JoinTable(name = "musica_artista",
            joinColumns = @JoinColumn(name = "id_musica"),
            inverseJoinColumns = @JoinColumn(name = "id_artista"))
    private List<Artista> artistas;

    public Musica() {
    }

    public Musica(Long id, String titulo, GeneroMusical generoMusical, List<Artista> artistas) {
        this.id = id;
        this.titulo = titulo;
        this.generoMusical = generoMusical;
        this.artistas = artistas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGêneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
