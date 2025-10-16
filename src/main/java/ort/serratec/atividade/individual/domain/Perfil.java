package ort.serratec.atividade.individual.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Telefone vinculado ao perfil")
    @NotBlank(message = "O telefone deve ser informado!")@Size(min=11, max = 11)
    private String telefone;

    @Schema(description = "Data de nascimento vinculado ao perfil")
    @NotNull(message = "Data de nascimento deve ser informada")
    @Past(message = "Data de nascimento deve ser inferior a data atual")
    private LocalDate dataNascimento;

    @Schema(description = "Perfil do usuario")
    @JsonIgnore
    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(Long id, String telefone, LocalDate dataNascimento, Usuario usuario) {
        this.id = id;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
