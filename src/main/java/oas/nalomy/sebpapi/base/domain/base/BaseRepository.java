package oas.nalomy.sebpapi.base.domain.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain>
		extends JpaRepository<T, Serializable>, JpaSpecificationExecutor<T> {
	@Modifying
	@Query("update T o set o.enabled = :enabledOrDisabled where o.id = :id")
	void enabledOrDisabled(@Param(value = "id") Long id, @Param(value = "enabledOrDisabled") boolean enabledOrDisabled);
}
