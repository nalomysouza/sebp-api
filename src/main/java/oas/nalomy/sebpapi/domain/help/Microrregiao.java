package oas.nalomy.sebpapi.domain.help;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Microrregiao {
	private Integer id;
	private String nome;
	@Transient
	private Mesorregiao mesorregiao;

	public Microrregiao(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
