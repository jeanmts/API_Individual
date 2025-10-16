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
import ort.serratec.atividade.individual.domain.PlayList;
import ort.serratec.atividade.individual.repository.PlayListRepository;

import java.util.List;
import java.util.Optional;

@Tag(name = "Playlist", description = "Cadastro de playlist")
@RestController
@RequestMapping("/playlists")
public class PlayListController {
    @Autowired
    private PlayListRepository playListRepository;

    @Operation(summary = "Lista todas as playLists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando todos os playLists com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao lista todos os playLists"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<PlayList>> listar () {
        return ResponseEntity.ok(playListRepository.findAll());
    }
    @Operation(summary = "Lista uma playList pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listando o playList com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao listar a playList"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlayList> buscar (@PathVariable Long id) {
        Optional<PlayList> optionalplayList = playListRepository.findById(id);
        if (optionalplayList.isPresent()) {
            return ResponseEntity.ok(optionalplayList.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @Operation(summary = "Cadastrar uma playList")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "playList cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar a playList"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayList> cadastrar(@Valid @RequestBody PlayList playList) {
        return  ResponseEntity.ok(playListRepository.save(playList));
    }

    @Operation(summary = "Atualiza um playList pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "playList atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Playlist informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PlayList> atualizar(@Valid @RequestBody PlayList playList,@PathVariable Long id) {
        if (playListRepository.existsById(id)) {
            playList.setId(id);
            return ResponseEntity.ok(playListRepository.save(playList));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar  uma playList pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "playList deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Playlist informado não foi encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        if (playListRepository.existsById(id)) {
            playListRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
