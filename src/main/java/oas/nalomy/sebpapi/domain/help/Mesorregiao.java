package oas.nalomy.sebpapi.domain.help;

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
public class Mesorregiao {
	private Integer id;
	private String nome;
	private Object uf;

	public Mesorregiao(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
}
