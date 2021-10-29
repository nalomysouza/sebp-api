package oas.nalomy.sebpapi.service;

import oas.nalomy.sebpapi.base.generic.GenericServiceCrudImpl;
import oas.nalomy.sebpapi.domain.Biblioteca;
import oas.nalomy.sebpapi.repository.BibliotecaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService extends GenericServiceCrudImpl<Biblioteca, BibliotecaRepository> {
	
	public ResponseEntity<?> updateEnabled(long id, boolean enabled) {
		return repository.findById(id).map(record -> {
			record.setEnabled(enabled);
			repository.save(record);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
