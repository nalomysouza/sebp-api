package oas.nalomy.sebpapi.base.generic;

import java.util.List;
import java.util.Optional;

import oas.nalomy.sebpapi.base.domain.base.BaseDomain;
import oas.nalomy.sebpapi.base.domain.base.BaseRepository;
import oas.nalomy.sebpapi.base.domain.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericServiceCrud<T extends BaseDomain, D extends BaseRepository<T>> extends BaseService<T> {

	Optional<T> findById(Long id);

	List<T> all();

	Page<T> all(Pageable pageable);

	T createOrUpdate(T entity);

	void delete(Long id);

	void enabledOrDisabled(Long id, boolean enabledOrDisabled);

	long count();
}
