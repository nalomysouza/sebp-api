package oas.nalomy.sebpapi.controller;

import java.util.Optional;

import javax.validation.Valid;

import oas.nalomy.sebpapi.base.exception.SebpNotFoundException;
import oas.nalomy.sebpapi.domain.ApoioRecebido;
import oas.nalomy.sebpapi.repository.ApoioRecebidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/apoios-recebidos")
public class ApoioRecebidoController {

	@Autowired
	private ApoioRecebidoRepository repository;

	@Operation(summary = "Get apoio recebido pelo {id} biblioteca")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto encontrado pelo {id}", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
			@ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
	@GetMapping("")
	public ResponseEntity<?> findByBiblioteca(@RequestParam Long biblioteca) {
		Optional<ApoioRecebido> response = this.repository.findByBiblioteca(biblioteca);
		return response.isPresent() ? ResponseEntity.ok(response.get()) : ResponseEntity.noContent().build();
	}

	@Operation(summary = "Inserindo um objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "objeto criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<ApoioRecebido> create(@Valid @RequestBody ApoioRecebido entity) {
		ApoioRecebido created;
		try {
			created = this.repository.save(entity);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@Operation(summary = "Atualizando um objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto atualizado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
	@PutMapping(value = "/{id}")
	public ApoioRecebido update(@PathVariable(value = "id") Long id, @Valid @RequestBody ApoioRecebido entity) {
		return this.repository.findById(id).map(o -> {
			o.setMinc(entity.isMinc());
			o.setMincDescricao(entity.getMincDescricao());
			o.setProares(entity.isProares());
			o.setProaresDescricao(entity.getProaresDescricao());
			o.setUbecm(entity.isUbecm());
			o.setUbecmDescricao(entity.getUbecmDescricao());
			return this.repository.save(o);
		}).orElseThrow(() -> new SebpNotFoundException());
	}
}
