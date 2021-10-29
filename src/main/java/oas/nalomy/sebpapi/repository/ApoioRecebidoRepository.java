package oas.nalomy.sebpapi.repository;

import java.util.Optional;

import oas.nalomy.sebpapi.domain.ApoioRecebido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoioRecebidoRepository extends JpaRepository<ApoioRecebido, Long> {
	@Query("SELECT e FROM ApoioRecebido e WHERE e.biblioteca.id = ?1")
	Optional<ApoioRecebido> findByBiblioteca(Long id);
}