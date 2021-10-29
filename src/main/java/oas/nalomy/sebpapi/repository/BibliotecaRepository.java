package oas.nalomy.sebpapi.repository;

import java.util.Optional;

import oas.nalomy.sebpapi.base.domain.base.BaseRepository;
import oas.nalomy.sebpapi.domain.Biblioteca;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends BaseRepository<Biblioteca> {

	@Modifying
	@Query("update Biblioteca o set o.enabled = :enabled where o.id = :id")
	void enabledOrDisabled(@Param(value = "id") Long id, @Param(value = "enabled") boolean enabled);

	Optional<Biblioteca> findByNome(String nome);

}