package oas.nalomy.sebpapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import oas.nalomy.sebpapi.base.generic.GenericRestController;
import oas.nalomy.sebpapi.domain.Acervo;
import oas.nalomy.sebpapi.domain.ApoioRecebido;
import oas.nalomy.sebpapi.domain.Biblioteca;
import oas.nalomy.sebpapi.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/biblioteca")
public class BibliotecaController extends GenericRestController<Biblioteca, BibliotecaService> {

    @Operation(summary = "Get apoio recebido pelo {id} biblioteca")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto encontrado pelo {id}", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
            @ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
    @GetMapping("/{id}/apoio-recebido")
    public ResponseEntity<ApoioRecebido> findApoioRecebidoByBiblioteca(@PathVariable(value = "id") Long id) {
        Optional<ApoioRecebido> response = service.findApoioRecebidoByBiblioteca(id);
        return response.isPresent() ? ResponseEntity.ok(response.get()) : ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get acervo pelo {id} biblioteca")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto encontrado pelo {id}", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
            @ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
    @GetMapping("/{id}/acervo")
    public ResponseEntity<Acervo> findAcervoByBiblioteca(@PathVariable(value = "id") Long id) {
        Optional<Acervo> response = service.findAcervoByBiblioteca(id);
        return response.isPresent() ? ResponseEntity.ok(response.get()) : ResponseEntity.noContent().build();
    }
}
