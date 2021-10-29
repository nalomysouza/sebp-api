package oas.nalomy.sebpapi.domain.help;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Periodico {

	ATE10(1, "ATÉ 10 TÍTULOS"), DE11A30(2, "DE 11 A 30 TÍTULOS"), DE31A50(3, "DE 31 A 50 TÍTULOS"),
	DE51A100(4, "DE 51 A 100 TÍTULOS"), ACIMADE100(5, "ACIMA DE 100 TÍTULOS");

	Integer id;
	String descricao;

	private Periodico(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Optional<Periodico> findByOrdinal(Integer id) {
		if (Objects.isNull(id)) {
			return Optional.empty();
		}
		return Arrays.stream(Periodico.values()).filter(n -> n.getId() == Integer.valueOf(id)).findFirst();
	}

	@JsonCreator
	public static Periodico fromObject(final Map<String, Object> obj) {
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

	public static Periodico fromId(final Integer id) {
		if (id != null) {
			for (Periodico e : Periodico.values()) {
				if (id.equals(e.getId()))
					return e;
			}
		}
		return null;
	}

}