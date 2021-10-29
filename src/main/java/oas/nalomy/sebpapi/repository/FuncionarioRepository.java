package oas.nalomy.sebpapi.repository;

import java.util.Optional;
import oas.nalomy.sebpapi.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	@Query("SELECT e FROM Funcionario e WHERE e.biblioteca.id = ?1")
	Optional<Funcionario> findByBiblioteca(Long id);
}