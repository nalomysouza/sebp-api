package oas.nalomy.sebpapi.base.domain.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain>
		extends JpaRepository<T, Serializable>, JpaSpecificationExecutor<T> {
}
