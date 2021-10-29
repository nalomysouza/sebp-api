package oas.nalomy.sebpapi.domain.help;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoBiblioteca {

	MUNICIPAL(1, "MUNICIPAL"), ESTADUAL(2, "ESTADUAL"), COMUNITARIO(3, "COMUNITÁRIO(A)");

	Integer id;
	String descricao;

	private TipoBiblioteca(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Optional<TipoBiblioteca> findByOrdinal(Integer id) {
		if (Objects.isNull(id)) {
			return Optional.empty();
		}
		return Arrays.stream(TipoBiblioteca.values()).filter(n -> n.getId() == Integer.valueOf(id)).findFirst();
	}

	@JsonCreator
	public static TipoBiblioteca fromObject(final Map<String, Object> obj) {
		if (obj != null && obj.containsKey("id")) {
			Integer id = null;
			if (obj.get("id") instanceof Integer) {
				id = (Integer) obj.get("id");
			} else {
				id = Integer.parseInt((String) obj.get("id"));
			}
			return fromId(id);
		}
		return null;
	}

	public static TipoBiblioteca fromId(final Integer id) {
		if (id != null) {
			for (TipoBiblioteca e : TipoBiblioteca.values()) {
				if (id.equals(e.getId()))
					return e;
			}
		}
		return null;
	}

}