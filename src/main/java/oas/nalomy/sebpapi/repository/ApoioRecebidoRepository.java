package oas.nalomy.sebpapi.repository;

import oas.nalomy.sebpapi.domain.ApoioRecebido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoioRecebidoRepository extends JpaRepository<ApoioRecebido, Long> {

}