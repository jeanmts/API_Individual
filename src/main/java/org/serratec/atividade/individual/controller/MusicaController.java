package org.serratec.atividade.individual.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.serratec.atividade.individual.domain.Musica;
import org.serratec.atividade.individual.repository.MusicaRepository;

import java.util.List;
import java.util.Optional;

@Tag(name = "Musicas", description = "Cadastro de musicas")
@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @Operation(description = "Lista todas as musicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando todas as Musicas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao lista Musicas"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<Musica>> listar () {
        return ResponseEntity.ok().body(musicaRepository.findAll());
    }


    @Operation(summary = "Lista uma musica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando Musica com sucesso"),
            @ApiResponse(responseCode = "404", description = "Musica informada não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscar (@PathVariable Long id) {
        Optional<Musica> optionalMusica = musicaRepository.findById(id);

        if (optionalMusica.isPresent()) {
            return ResponseEntity.ok(optionalMusica.get());
        }
        return ResponseEntity.notFound().build();
    }


    @Operation(summary = "Cadastrar musica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Musica cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar musica"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Musica cadastrar (@Valid @RequestBody Musica musica) {
        return musicaRepository.save(musica);
    }

    @Operation(summary = "Atualiza uma musica pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musica atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Musica informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@Valid @RequestBody Musica musica, @PathVariable Long id){
        Optional<Musica> optionalMusica = musicaRepository.findById(id);

        if(optionalMusica.isPresent()) {
            musica.setId(id);
            musicaRepository.save(musica);
            return ResponseEntity.ok(optionalMusica.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta uma musica pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musica deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Musica informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (musicaRepository.existsById(id)) {
            musicaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
