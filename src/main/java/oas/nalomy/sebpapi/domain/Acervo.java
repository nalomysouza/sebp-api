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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oas.nalomy.sebpapi.domain.help.IntervaloLivro;
import oas.nalomy.sebpapi.domain.help.Periodico;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(schema = "public", name = "acervo")
public class Acervo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean livros, mapas, filmes, fotografias, discos, periodicos;

	@Column(name = "fitas_k7")
	private boolean fitasK7;

	@Column(name = "fitas_video")
	private boolean fitasVideo;

	@Column(name = "acervo_outros")
	private String acervoOutros;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "intervalo_livro_id")
	private IntervaloLivro intervaloLivro;

	@Column(name = "etr_livros_tombados")
	private boolean etrLivrosTombados;

	@Column(name = "etr_folhas_soltas")
	private boolean etrFolhasSoltas;

	@Column(name = "etr_cadernos")
	private boolean etrCadernos;

	@Column(name = "etr_fichas_soltas")
	private boolean etrFichasSoltas;

	@Column(name = "etr_nao_registrados")
	private boolean etrNaoRegistrados;

	@Column(name = "etr_outros")
	private String etrOutros;

	@Column(name = "eti_autor")
	private boolean etiAutor;

	@Column(name = "eti_titulo")
	private boolean etiTitulo;

	@Column(name = "eti_assunto")
	private boolean etiAssunto;

	@Column(name = "eti_outros")
	private String etiOutros;

	@Column(name = "etc_simplificada")
	private boolean etcSimplificada;

	@Column(name = "etc_dewey")
	private boolean etcDewey;

	@Column(name = "etc_universal")
	private boolean etcUniversal;

	@Column(name = "etc_outros")
	private String etcOutros;

	@Column(name = "etcat_simplificada")
	private boolean etcatSimplificada;

	@Column(name = "etcat_abnt")
	private boolean etcatAbnt;

	@Column(name = "etcat_outros")
	private String etcatOutros;

	@Column(name = "aquisicao_por_compra")
	private boolean aquisicaoPorCompra;

	@Column(name = "aquisicao_por_doacao")
	private boolean aquisicaoPorDoacao;

	@Column(name = "aquisicao_por_permuta")
	private boolean aquisicaoPorPermuta;

	@Column(name = "maioria_registrado")
	private boolean maioriaRegistrado;

	@Column(name = "maioria_identificado")
	private boolean maioriaIdentificado;

	@Column(name = "maioria_classificado")
	private boolean maioriaClassificado;

	@Column(name = "maioria_catalogado")
	private boolean maioriaCatalogado;

	@Column(name = "acervo_atende_leitor")
	private boolean acervoAtendeLeitor;

	@Column(name = "acervo_outras_necessidades")
	private String acervoOutrasNecessidades;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "periodico_id")
	private Periodico periodico;

	@Column(name = "periodico_maioria_registrado")
	private boolean periodicoMaioriaRegistrado;

	@Column(name = "periodico_outras_necessidades")
	private String periodicoOutrasNecessidades;

	@Column(name = "etreg_fichas_kardex")
	private boolean etregFichasKardex;

	@Column(name = "etreg_cadernos")
	private boolean etregCadernos;

	@Column(name = "etreg_nao_registrado")
	private boolean etregNaoRegistrado;

	@Column(name = "etreg_outros")
	private String etregOutros;

	@ManyToOne(optional = false)
	@JoinColumn(name = "biblioteca_id")
	private Biblioteca biblioteca;

}
