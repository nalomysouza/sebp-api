package oas.nalomy.sebpapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import oas.nalomy.sebpapi.base.exception.SebpNotFoundException;
import oas.nalomy.sebpapi.domain.Acervo;
import oas.nalomy.sebpapi.repository.AcervoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/cervo")
public class AcervoController {

	@Autowired
	private AcervoRepository repository;

	@Operation(summary = "Inserindo um objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "objeto criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<Acervo> create(@Valid @RequestBody Acervo entity) {
		Acervo created;
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
	public Acervo update(@PathVariable(value = "id") Long id, @Valid @RequestBody Acervo entity) {
		return this.repository.findById(id).map(o -> {
			entity.setId(id);
			return this.repository.save(entity);
		}).orElseThrow(() -> new SebpNotFoundException());
	}
}
