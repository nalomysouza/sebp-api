package oas.nalomy.sebpapi.repository;

import oas.nalomy.sebpapi.domain.Acervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcervoRepository extends JpaRepository<Acervo, Long> {
}