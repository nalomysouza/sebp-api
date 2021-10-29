package oas.nalomy.sebpapi.base.domain.repository;

import java.util.Optional;
import oas.nalomy.sebpapi.base.domain.ERole;
import oas.nalomy.sebpapi.base.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
