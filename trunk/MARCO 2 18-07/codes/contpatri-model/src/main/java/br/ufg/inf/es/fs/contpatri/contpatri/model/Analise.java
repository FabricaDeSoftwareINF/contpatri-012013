/**
 * Esse documento é parte do código fonte e artefatos relacionados ao projeto
 * CONTPATRI, em desenvolvimento pela Fábrica de Software da UFG.
 *
 * Links relevantes: Fábrica de Software: http://fs.inf.ufg.br/ Instituto de
 * Informática UFG: http://www.inf.ufg.br Projeto CONTPATRI DROPBOX:
 * https://www.dropbox.com/home/CONTPATRI%20-%20012013 Projeto CONTPATRI
 * REDMINE:
 *
 * Copyleft © UFG.
 *
 * Licenciado sobre a licença GNU-GPL v3
 *
 * Você pode obter uma cópia da licença em http://www.gnu.org/licenses/gpl.html
 *
 * A menos que especificado ou exigido por legislação local, o software é
 * fornecido "da maneira que está", sem garantias ou condições de qualquer tipo,
 * nem expressas nem implícitas. Em caso de dúvidas referir a licença GNU-GPL.
 */
package br.ufg.inf.es.fs.contpatri.contpatri.model;

import java.io.Serializable;

/**
 * Resultado da analise de um determinado bem patrimonial realizado dentro de um
 * inventario.
 *
 * @author Emerson Jose Porfirio
 */
public class Analise implements Serializable {

	private static final long serialVersionUID = -8538872437513272042L;

	public enum TipoSituacaoAnalise {

		LOCALIZADO("Localizado"),
		REALOCADO("Realocado"),
		EXTRAVIADO("Extraviado");
		private String descricao;

		TipoSituacaoAnalise(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
	private Long id;
	private BemPatrimonial bemPatrimonial;
	private Inventario inventario;
	private TipoSituacaoAnalise situacao;

	public Analise() {
	}

	public Analise(BemPatrimonial bemPatrimonial, Inventario inventario, TipoSituacaoAnalise situacao) {
		setBemPatrimonial(bemPatrimonial);
		setInventario(inventario);
		setSituacao(situacao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BemPatrimonial getBemPatrimonial() {
		return bemPatrimonial;
	}

	private void setBemPatrimonial(BemPatrimonial bemPatrimonial) {
		if (bemPatrimonial == null) {
			throw new IllegalArgumentException("O bem não pode ser nulo");
		}
		this.bemPatrimonial = bemPatrimonial;
	}

	public Inventario getInventario() {
		return inventario;
	}

	private void setInventario(Inventario inventario) {
		if (inventario == null) {
			throw new IllegalArgumentException("O inventário não pode ser nulo");
		}
		this.inventario = inventario;
	}

	public TipoSituacaoAnalise getSituacao() {
		return situacao;
	}

	private void setSituacao(TipoSituacaoAnalise situacao) {
		this.situacao = situacao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Analise analisa = (Analise) o;
		if (!bemPatrimonial.equals(analisa.bemPatrimonial)) {
			return false;
		}
		if (!inventario.equals(analisa.inventario)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int valorIncremental = 31;
		int result = bemPatrimonial != null ? bemPatrimonial.hashCode() : 0;
		result = valorIncremental * result + (inventario != null ? inventario.hashCode() : 0);
		return result;
	}
}
