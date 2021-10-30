package oas.nalomy.sebpapi.controller;

import oas.nalomy.sebpapi.base.generic.GenericRestController;
import oas.nalomy.sebpapi.domain.Biblioteca;
import oas.nalomy.sebpapi.service.BibliotecaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/biblioteca")
public class BibliotecaController extends GenericRestController<Biblioteca, BibliotecaService> {

}
