package oas.nalomy.sebpapi.domain.help;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Entity
@Table(schema = "help", name = "municipio")
@JsonIgnoreProperties(value = { "microrregiao", "regiao-imediata", "regiaoImediata" })
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Transient
	private Microrregiao microrregiao;

	@Transient
	@JsonAlias(value = "regiao-imediata")
	private Object regiaoImediata;

	public Municipio(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
