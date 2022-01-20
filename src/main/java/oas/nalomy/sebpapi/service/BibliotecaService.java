package oas.nalomy.sebpapi.service;

import oas.nalomy.sebpapi.base.generic.GenericServiceCrudImpl;
import oas.nalomy.sebpapi.domain.ApoioRecebido;
import oas.nalomy.sebpapi.domain.Biblioteca;
import oas.nalomy.sebpapi.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BibliotecaService extends GenericServiceCrudImpl<Biblioteca, BibliotecaRepository> {

    @Transactional(readOnly = true)
    public Optional<ApoioRecebido> findApoioRecebidoByBiblioteca(Long id) {
        return this.repository.findApoioRecebidoByBiblioteca(id);
    }
}
