package oas.nalomy.sebpapi.domain.help;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Escolaridade {
	ENSINO_FUNDAMENTAL(1, "Ensino Fundamental"), 
	ENSINO_MEDIO(2, "Ensino Médio"),
	GRADUACAO(3, "Ensino Superior (Graduação)"), 
	POS_GRADUACAO(4, "Ensino Superior (Pós-Graduação)"),
	MESTRADO(5, "Ensino Superior (Mestrado)"), 
	DOUTORADO(6, "Ensino Superior (Doutorado)"),
	POS_DOUTORADO(7, "Ensino Superior (Pós-Doutorado)"),
	TREINAMENTO_EM_SBP(8, "Treinamento em Serviços de Biblioteca");

	Integer id;
	String descricao;

	private Escolaridade(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Optional<Escolaridade> findByOrdinal(Integer escolaridade) {
		if (Objects.isNull(escolaridade)) {
			return Optional.empty();
		}
		return Arrays.stream(Escolaridade.values()).filter(n -> n.getId() == Integer.valueOf(escolaridade)).findFirst();
	}

	@JsonCreator
	public static Escolaridade fromObject(final Map<String, Object> obj) {
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

	public static Escolaridade fromId(final Integer id) {
		if (id != null) {
			for (Escolaridade e : Escolaridade.values()) {
				if (id.equals(e.getId()))
					return e;
			}
		}
		return null;
	}

}