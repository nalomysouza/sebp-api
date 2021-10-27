package oas.nalomy.sebpapi.base.generic;

import java.util.List;
import java.util.Optional;

import oas.nalomy.sebpapi.base.domain.base.BaseDomain;
import oas.nalomy.sebpapi.base.domain.base.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public class GenericServiceCrudImpl<T extends BaseDomain, D extends BaseRepository<T>>
		implements GenericServiceCrud<T, D> {

	@Autowired
	public D repository;

	public GenericServiceCrudImpl() {
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<T> findById(Long id) {
		return this.repository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> all() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<T> all(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Transactional
	@Override
	public T createOrUpdate(T entity) {
		return this.repository.save(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public long count() {
		return this.repository.count();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
