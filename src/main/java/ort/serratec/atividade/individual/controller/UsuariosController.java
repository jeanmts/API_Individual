package ort.serratec.atividade.individual.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ort.serratec.atividade.individual.domain.Usuario;
import ort.serratec.atividade.individual.repository.PerfilRepository;
import ort.serratec.atividade.individual.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Tag(name = "Usuarios", description = "Cadastro de Usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    @Operation(summary = "Lista todos os Usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando todos os Usuarios com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao lista todos os usuarios"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<Usuario>> listar () {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @Operation(summary = "Lista um Usuario pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando o Usuario com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar (@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @Operation(summary = "Cadastrar um Usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar  usuario"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        usuario.setPerfil(usuario.getPerfil());
        return  ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @Operation(summary = "Atualiza um Usuario pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario,@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return ResponseEntity.ok(usuarioRepository.save(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar  um Usuario pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
