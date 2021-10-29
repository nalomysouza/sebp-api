package oas.nalomy.sebpapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(schema = "public", name = "apoio_recebido")
public class ApoioRecebido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean proares;

	@Column(name = "proares_descricao")
	private String proaresDescricao;

	private boolean ubecm;

	@Column(name = "ubecm_descricao")
	private String ubecmDescricao;

	private boolean minc;

	@Column(name = "minc_descricao")
	private String mincDescricao;

	@ManyToOne(optional = false)
	@JoinColumn(name = "biblioteca_id")
	private Biblioteca biblioteca;
}
