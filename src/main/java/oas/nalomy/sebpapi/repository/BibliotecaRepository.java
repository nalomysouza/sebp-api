package oas.nalomy.sebpapi.repository;

import java.util.Optional;
import oas.nalomy.sebpapi.base.domain.base.BaseRepository;
import oas.nalomy.sebpapi.domain.Acervo;
import oas.nalomy.sebpapi.domain.ApoioRecebido;
import oas.nalomy.sebpapi.domain.Biblioteca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends BaseRepository<Biblioteca> {
	Optional<Biblioteca> findByNome(String nome);

	@Query("SELECT a FROM ApoioRecebido a WHERE a.biblioteca.id = ?1")
	Optional<ApoioRecebido> findApoioRecebidoByBiblioteca(Long id);

	@Query("SELECT a FROM Acervo a WHERE a.biblioteca.id = ?1")
	Optional<Acervo> findAcervoByBiblioteca(Long id);
}