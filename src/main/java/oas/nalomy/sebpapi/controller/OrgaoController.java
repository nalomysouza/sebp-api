package oas.nalomy.sebpapi.controller;

import javax.validation.Valid;

import oas.nalomy.sebpapi.base.generic.GenericRestController;
import oas.nalomy.sebpapi.base.payload.request.EnabledRequest;
import oas.nalomy.sebpapi.domain.Orgao;
import oas.nalomy.sebpapi.service.OrgaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/orgaos")
public class OrgaoController extends GenericRestController<Orgao, OrgaoService> {

	@PutMapping("/enabled")
	public ResponseEntity<?> enabledOrDisabled(@Valid @RequestBody EnabledRequest request) {
		return this.service.enabledOrDisabled(request.getId(), request.isEnabled());
	}
}
