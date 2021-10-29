package oas.nalomy.sebpapi.domain.help;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IntervaloLivro {

	ATE2000(1, "ATÉ 2.000 LIVROS"), DE2001A5000(2, "DE 2.001 A 5.000 LIVROS"),
	DE5001A10000(3, "DE 5.001 A 10.000 LIVROS"), DE10001A15000(4, "DE 10.001 A 15.000 LIVROS"),
	DE15001A20000(5, "DE 15.001 A 20.000 LIVROS"), DE20001A15000(6, "DE 20.001 A 50.000 LIVROS"),
	ACIMADE50000(7, "ACIMA DE 50.000 LIVROS");

	Integer id;
	String descricao;

	private IntervaloLivro(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Optional<IntervaloLivro> findByOrdinal(Integer id) {
		if (Objects.isNull(id)) {
			return Optional.empty();
		}
		return Arrays.stream(IntervaloLivro.values()).filter(n -> n.getId() == Integer.valueOf(id)).findFirst();
	}

	@JsonCreator
	public static IntervaloLivro fromObject(final Map<String, Object> obj) {
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

	public static IntervaloLivro fromId(final Integer id) {
		if (id != null) {
			for (IntervaloLivro e : IntervaloLivro.values()) {
				if (id.equals(e.getId()))
					return e;
			}
		}
		return null;
	}

}