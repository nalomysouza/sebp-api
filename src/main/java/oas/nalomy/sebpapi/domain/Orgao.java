package oas.nalomy.sebpapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oas.nalomy.sebpapi.base.domain.base.BaseDomain;
import oas.nalomy.sebpapi.domain.help.Municipio;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(schema = "public", name = "orgao")
public class Orgao extends BaseDomain {
	private static final long serialVersionUID = 5626089605126180294L;

	private @NotEmpty String nome;

	private @Email String email;

	private String telefone, fax;

	private @NotNull String logradouro;

	private String complemento, bairro, numero, cep;

	@ManyToOne
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;

	public Orgao(Long id, @NotEmpty String nome) {
		this.setId(id);
		this.nome = nome;
	}
}
