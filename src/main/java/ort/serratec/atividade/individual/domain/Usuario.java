package ort.serratec.atividade.individual.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nome do Usuario")
    @NotBlank(message = "O nome deve ser preenchido!") @Size( min = 2, max = 100)
    private String nome;

    @Schema(description = "E-mail do Usuario")
    @Email(message = "E-mail inválido!")
    @NotBlank(message = "O e-mail deve ser informado!")
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    @Schema(description = "Playlist do usuario")
    private List<PlayList> playLists;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, Perfil perfil, List<PlayList> playLists) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.playLists = playLists;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }

}
