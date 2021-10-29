package oas.nalomy.sebpapi.base.domain.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T extends BaseDomain> {

	Optional<T> findById(Long id);

	List<T> all();

	Page<T> all(Pageable pageable);

	T createOrUpdate(T entity);

	void delete(Long id);

	long count();

}
