package oas.nalomy.sebpapi.repository.help;

import oas.nalomy.sebpapi.domain.help.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Long> { }