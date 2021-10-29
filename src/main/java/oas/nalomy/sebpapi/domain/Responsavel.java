package oas.nalomy.sebpapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import oas.nalomy.sebpapi.domain.help.Escolaridade;
import oas.nalomy.sebpapi.domain.help.Formacao;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(schema = "public", name = "responsavel")
public class Responsavel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "treinado_em_sbp")
	private boolean treinadoEmSBP;

	@Column(name = "escolaridade_id")
	@Enumerated(EnumType.ORDINAL)
	private Escolaridade escolaridade;

	@ManyToOne
	@JoinColumn(name = "formacao_id")
	private Formacao formacao;

	@ManyToOne(optional = false)
	@JoinColumn(name = "biblioteca_id")
	private Biblioteca biblioteca;
}
