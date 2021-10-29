package oas.nalomy.sebpapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(schema = "public", name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "qtd_total")
	private Integer qtdTotal;

	@Column(name = "qtd_com_ensino_superior")
	private Integer qtdComEnsinoSuperior;

	@Column(name = "formacao")
	private String formacao;

	@Column(name = "qtd_com_1grau")
	private Integer qtdCom1Grau;

	@Column(name = "qtd_com_2grau")
	private Integer qtdCom2Grau;

	@Column(name = "qtd_treinado_em_sbp")
	private Integer qtdTreinadoEmSBP;

	@Column(name = "ultimo_treinamento_em_sbp")
	private Date ultimoTreinamentoEmSBP;

	@ManyToOne(optional = false)
	@JoinColumn(name = "biblioteca_id")
	private Biblioteca biblioteca;
}
