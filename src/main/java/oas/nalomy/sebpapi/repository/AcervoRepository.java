package oas.nalomy.sebpapi.repository;

import java.util.Optional;

import oas.nalomy.sebpapi.domain.Acervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcervoRepository extends JpaRepository<Acervo, Long> {
	@Query("SELECT e FROM Acervo e WHERE e.biblioteca.id = ?1")
	Optional<Acervo> findByBiblioteca(Long id);
}