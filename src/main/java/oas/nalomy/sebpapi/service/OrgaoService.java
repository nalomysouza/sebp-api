package oas.nalomy.sebpapi.service;

import oas.nalomy.sebpapi.base.generic.GenericServiceCrudImpl;
import oas.nalomy.sebpapi.domain.Orgao;
import oas.nalomy.sebpapi.repository.OrgaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrgaoService extends GenericServiceCrudImpl<Orgao, OrgaoRepository> {

	public ResponseEntity<?> enabledOrDisabled(Long id, boolean enabled) {
		return repository.findById(id).map(record -> {
			record.setEnabled(enabled);
			this.createOrUpdate(record);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
