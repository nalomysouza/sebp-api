package oas.nalomy.sebpapi.repository;

import java.util.Optional;

import oas.nalomy.sebpapi.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
	@Query("SELECT e FROM Responsavel e WHERE e.biblioteca.id = ?1")
	Optional<Responsavel> findByBiblioteca(Long id);
}