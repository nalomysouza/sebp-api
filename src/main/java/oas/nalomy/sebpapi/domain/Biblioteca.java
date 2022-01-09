package oas.nalomy.sebpapi.domain;

import java.util.Date;

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
import oas.nalomy.sebpapi.domain.help.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(schema = "public", name = "biblioteca")
public class Biblioteca extends BaseDomain {
	private static final long serialVersionUID = 9065249181584482593L;

	private @NotEmpty String nome;

	private @Email String email;

	@Column(name = "data_fundacao")
	private Date dataFundacao;

	@Column(name = "ato_criacao")
	private String atoCriacao;

	private String sigla;

	private String telefone, fax;

	private boolean polo;

	private boolean descredenciada;

	@Column(name = "implantada_pelo_pla")
	private boolean implantadaPeloPLA;

	@Column(name = "cadastro_snbp")
	private boolean cadastroSNBP;

	@Column(name = "ano_cadastro_snbp")
	private Integer anoCadastroSNBP;

	private @NotNull String logradouro;

	private String complemento, bairro, numero, cep;

	@ManyToOne
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "orgao_id")
	private Orgao orgao;

	@ManyToOne
	@JoinColumn(name = "tipo_biblioteca_id")
	private TipoBiblioteca tipoBiblioteca;

	private String observacoes;

}
