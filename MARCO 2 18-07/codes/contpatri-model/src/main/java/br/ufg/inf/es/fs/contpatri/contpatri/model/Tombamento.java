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
import java.util.Date;

/**
 * Código de tombamento de um bem patrimonial Imutável.
 * 
 * @author Emerson Jose Porfirio
 */
public class Tombamento implements Serializable, Cloneable {

	private static final long serialVersionUID = 2967724032422394187L;
	private Long id;
	private String codTombamento;
	private Date dataTombamento;
	private TipoTombamento tipoTombamento;

	public TipoTombamento getTipoTombamento() {
		return tipoTombamento;
	}

	public final void setTipoTombamento(TipoTombamento tipoTombamento) {
		this.tipoTombamento = tipoTombamento;
	}

	public Tombamento() {
	}

	public Tombamento(String codTombamento, Date dataTombamento,
			TipoTombamento tipoTombamento) {
		setCodTombamento(codTombamento);
		setDataTombamento(dataTombamento);
		setTipoTombamento(tipoTombamento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Número que identifica o tombamento.Esse código fica afixado ao bem seja
	 * por uma plaqueta metálica ou por uma etiqueta comum (código de barras,
	 * QR-code ou somente números).
	 * 
	 * @return String
	 */
	public String getCodTombamento() {
		return codTombamento;
	}

	private void setCodTombamento(String codTombamento) {
		if (codTombamento == null || codTombamento.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"O código de tombamento deve ser informado");
		}
		this.codTombamento = codTombamento;
	}

	/**
	 * Data em que o tombamento foi realizado
	 * 
	 * @return String
	 */
	public Date getDataTombamento() {
		return dataTombamento;
	}

	private void setDataTombamento(Date dataTombamento) {
		if (dataTombamento == null) {
			throw new IllegalArgumentException(
					"A data de tombamento deve ser informada");
		}
		this.dataTombamento = dataTombamento;
	}

	@Override
	public Tombamento clone() throws CloneNotSupportedException {
		Tombamento clone = (Tombamento) super.clone();
		clone.setDataTombamento((Date) this.dataTombamento.clone());
		return clone;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Tombamento)) {
			return false;
		}
		Tombamento outro = (Tombamento) obj;
		if (this.dataTombamento.equals(outro.dataTombamento)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int valorInicial = 7;
		final int valorIncremental = 89;

		int hash = valorInicial;
		hash = valorIncremental * hash
				+ (this.id != null ? this.id.hashCode() : 0);
		hash = valorIncremental
				* hash
				+ (this.codTombamento != null ? this.codTombamento.hashCode()
						: 0);
		hash = valorIncremental
				* hash
				+ (this.dataTombamento != null ? this.dataTombamento.hashCode()
						: 0);
		return hash;
	}
}
