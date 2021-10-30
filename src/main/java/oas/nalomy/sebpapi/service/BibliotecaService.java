package oas.nalomy.sebpapi.service;

import oas.nalomy.sebpapi.base.generic.GenericServiceCrudImpl;
import oas.nalomy.sebpapi.domain.Biblioteca;
import oas.nalomy.sebpapi.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService extends GenericServiceCrudImpl<Biblioteca, BibliotecaRepository> {

}
