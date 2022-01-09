package oas.nalomy.sebpapi.repository.help;

import oas.nalomy.sebpapi.domain.help.TipoBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBibliotecaRepository extends JpaRepository<TipoBiblioteca, Long> { }