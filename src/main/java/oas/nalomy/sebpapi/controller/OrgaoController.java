package oas.nalomy.sebpapi.controller;

import oas.nalomy.sebpapi.base.generic.GenericRestController;
import oas.nalomy.sebpapi.domain.Orgao;
import oas.nalomy.sebpapi.service.OrgaoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/orgao")
public class OrgaoController extends GenericRestController<Orgao, OrgaoService> {

}
