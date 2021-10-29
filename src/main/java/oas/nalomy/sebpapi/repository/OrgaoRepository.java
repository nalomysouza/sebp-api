package oas.nalomy.sebpapi.repository;

import java.util.Optional;

import oas.nalomy.sebpapi.base.domain.base.BaseRepository;
import oas.nalomy.sebpapi.domain.Orgao;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepository extends BaseRepository<Orgao> {
	Optional<Orgao> findByNome(Orgao nome);
}