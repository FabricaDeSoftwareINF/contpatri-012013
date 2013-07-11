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
 * Ativo fixo sobre o qual se deseja ou se necessita manter controle patrimonial
 * 
 * @author Emerson Jose Porfirio
 */
public class BemPatrimonial implements Serializable, Cloneable {

	private static final long serialVersionUID = -4633199957240608028L;
	private Long id;
	private String descricao;
	private Date dataAquisicao;
	private Origem origem;
	private Gestor gestor;
	private Agente agente;
	private Tombamento tombamento;
	private SubLocal subLocal;

	public BemPatrimonial(String descricao, Origem origem, SubLocal subLocal) {
		setDescricao(descricao);
		setOrigem(origem);
		setSubLocal(subLocal);
	}

	public void setSubLocal(SubLocal subLocal) {
		if (subLocal == null) {
			throw new IllegalArgumentException("O Sub Local não pode ser nulo.");
		}
		this.subLocal = subLocal;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Tombamento getTombamento() {
		return tombamento;
	}

	public void setTombamento(Tombamento tombamento) {
		this.tombamento = tombamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricaoBreve)
			throws IllegalArgumentException {
		if (descricaoBreve == null || descricaoBreve.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"A descrição não pode ser nula ou vazia");
		}
		this.descricao = descricaoBreve;
	}

	public Origem getOrigem() throws CloneNotSupportedException {
		return origem.clone();
	}

	public void setOrigem(Origem origem) throws IllegalArgumentException {
		if (origem == null) {
			throw new IllegalArgumentException("A origem não pode ser nula");
		}
		this.origem = origem;
	}

	public Gestor getGestor() throws CloneNotSupportedException {
		return gestor.clone();
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public SubLocal getSubLocal() throws CloneNotSupportedException {
		return subLocal.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BemPatrimonial)) {
			return false;
		}
		BemPatrimonial outroBem = (BemPatrimonial) obj;
		if (this.descricao.equals(outroBem.descricao)
				&& this.origem.equals(outroBem.origem)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 15 * hash + (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public final BemPatrimonial clone() throws CloneNotSupportedException {
		BemPatrimonial clone = (BemPatrimonial) super.clone();
		clone.setGestor(this.gestor == null ? null : this.gestor.clone());
		clone.setTombamento(this.tombamento == null ? null : this.tombamento
				.clone());
		clone.setSubLocal(this.subLocal == null ? null : this.subLocal.clone());
		return clone;
	}
}
