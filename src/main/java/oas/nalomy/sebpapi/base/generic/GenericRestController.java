package oas.nalomy.sebpapi.base.generic;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import oas.nalomy.sebpapi.base.domain.base.BaseDomain;
import oas.nalomy.sebpapi.base.domain.base.BaseService;
import oas.nalomy.sebpapi.base.exception.SebpNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public class GenericRestController<T extends BaseDomain, S extends BaseService<T>> {

	@Autowired
	public S service;

	@Operation(summary = "Get pelo {id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto encontrado pelo {id}", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
			@ApiResponse(responseCode = "404", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
	@GetMapping("/{id}")
	public T read(@PathVariable(value = "id") long id) {
		return this.service.findById(id).orElseThrow(() -> new SebpNotFoundException());
	}

	@Operation(summary = "Get todos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "todos os objetos", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
			@ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nenhum recurso encontrado", content = @Content)})
	@GetMapping("/all")
	public List<T> all() {
		return this.service.all();
	}

	@Operation(summary = "Get todos com paginação")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "todos os objetos paginados", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))) }),
			@ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nenhum recurso encontrado", content = @Content)})
	@GetMapping
	public Page<T> all(Pageable page) {
		return this.service.all(page);
	}

	@Operation(summary = "Inserindo um objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "objeto criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		T created;
		try {
			created = this.service.createOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@Operation(summary = "Atualizando um objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Objeto atualizado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Nenhum objeto encontrado com este {id}", content = @Content) })
	@PutMapping(value = "/{id}")
	public T update(@PathVariable(value = "id") long id, @Valid @RequestBody T entity) {
		return this.service.findById(id).map(o -> {
			entity.setId(o.getId());
			entity.setUpdateIn(new Date());
			return this.service.createOrUpdate(entity);
		}).orElseThrow(() -> new SebpNotFoundException());
	}

	@Operation(summary = "Deleta o objeto")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "objeto deletado"),
			@ApiResponse(responseCode = "204", description = "Nenhum objeto encontrado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nenhum recurso encontrado", content = @Content)})
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") long id) {
		try {
			this.service.delete(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.noContent().build();
	}
}
