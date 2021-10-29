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

	@GetMapping("escolaridades")
	public ResponseEntity<?> getEscolaridades() {
		return ResponseEntity.ok(Escolaridade.values());
	}

	@GetMapping("intervalos/livros")
	public ResponseEntity<?> getIntervalosLivro() {
		return ResponseEntity.ok(IntervaloLivro.values());
	}

	@GetMapping("motivos/frequencias")
	public ResponseEntity<?> getMotivosFrequencia() {
		return ResponseEntity.ok(MotivoFrequencia.values());
	}

	@GetMapping("periodicos")
	public ResponseEntity<?> getPeriodicos() {
		return ResponseEntity.ok(Periodico.values());
	}

	@GetMapping("tipos/biliotecas")
	public ResponseEntity<?> getTiposBilioteca() {
		return ResponseEntity.ok(TipoBiblioteca.values());
	}

	@GetMapping("municipios")
	public ResponseEntity<?> getMunicipios() {
		return ResponseEntity.ok(municipioRepository.getMunicipios());
	}

	@GetMapping("mesorregioes")
	public ResponseEntity<?> getMesorregioes() {
		return ResponseEntity.ok(municipioRepository.getMesorregioes());
	}

	@GetMapping("microrregioes")
	public ResponseEntity<?> getMicrorregioes() {
		return ResponseEntity.ok(municipioRepository.getMicrorregioes());
	}

}