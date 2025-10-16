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
import ort.serratec.atividade.individual.domain.Artista;
import ort.serratec.atividade.individual.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;

@Tag(name = "Artista Controller", description = "Cadastro Artista")
@RestController
@RequestMapping("/artistas")
public class ArtistasController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    @Operation(summary = "Lista todos os Artistas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando todos os artistas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao lista artistas"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<List<Artista>> listar () {
        return ResponseEntity.ok().body(artistaRepository.findAll());
    }
    @Operation(summary = "Busca um Artista pelo ID ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Artista informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscar(@PathVariable Long id) {
        Optional<Artista> optionalArtista = artistaRepository.findById(id);

        if (optionalArtista.isPresent()) {
            return ResponseEntity.ok(optionalArtista.get());
        }
        return null;
    }
    @Operation(summary = "Cadastra um novo Artista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Artista cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar Artista"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artista cadastrar (@Valid @RequestBody Artista artista) {
        return artistaRepository.save(artista);
    }

    @Operation(summary = "Atualiza um Artista pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Artista informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualizar(@Valid @RequestBody Artista artista, Long id) {
        if (artistaRepository.existsById(id)) {
            artista.setId(id);
            artistaRepository.save(artista);
            return ResponseEntity.ok(artista);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta um Artista pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Artista informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        if (artistaRepository.existsById(id)){
            artistaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
