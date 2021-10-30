package oas.nalomy.sebpapi.controller;

import oas.nalomy.sebpapi.domain.help.*;
import oas.nalomy.sebpapi.repository.help.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/help")
public class HelpController {

	@Autowired
	private MunicipioRepository municipioRepository;

	@GetMapping("escolaridade")
	public ResponseEntity<?> getEscolaridades() {
		return ResponseEntity.ok(Escolaridade.values());
	}

	@GetMapping("intervalo-livro")
	public ResponseEntity<?> getIntervalosLivro() {
		return ResponseEntity.ok(IntervaloLivro.values());
	}

	@GetMapping("motivo-frequencia")
	public ResponseEntity<?> getMotivosFrequencia() {
		return ResponseEntity.ok(MotivoFrequencia.values());
	}

	@GetMapping("periodico")
	public ResponseEntity<?> getPeriodicos() {
		return ResponseEntity.ok(Periodico.values());
	}

	@GetMapping("tipo-bilioteca")
	public ResponseEntity<?> getTiposBilioteca() {
		return ResponseEntity.ok(TipoBiblioteca.values());
	}

	@GetMapping("municipio")
	public ResponseEntity<?> getMunicipios() {
		return ResponseEntity.ok(municipioRepository.getMunicipios());
	}

	@GetMapping("mesorregiao")
	public ResponseEntity<?> getMesorregioes() {
		return ResponseEntity.ok(municipioRepository.getMesorregioes());
	}

	@GetMapping("microrregiao")
	public ResponseEntity<?> getMicrorregioes() {
		return ResponseEntity.ok(municipioRepository.getMicrorregioes());
	}

}