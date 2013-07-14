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
package br.ufg.inf.es.fs.contpatri.model;

import java.io.Serializable;
import java.util.*;

/**
 * Representa um processo de tomada de contas dos bens patrimoniais da Unidade
 * da UFG.
 * 
 * @author Emerson Jose Porfirio
 */
public class Inventario implements Serializable {

	private static final long serialVersionUID = 7539830852103276098L;
	private Long id;
	private Date dataEmissao;
	private Date dataFechamento;
	private Gestor gestor;
	private Set<Analise> analisados = new HashSet<Analise>();

	public Inventario() {
	}

	public Inventario(Date dataEmissao, Gestor gestor,
			List<BemPatrimonial> bensPatrimoniais) {
		setDataEmissao(dataEmissao);
		setGestor(gestor);
		adicionarAnalisados(bensPatrimoniais);
	}

	private void adicionarAnalisados(List<BemPatrimonial> bensPatrimoniais) {
		if (bensPatrimoniais == null || bensPatrimoniais.isEmpty()) {
			throw new IllegalArgumentException(
					"A lista de bens analisados deve ter ao menos um elemento.");
		}
		for (BemPatrimonial bem : bensPatrimoniais) {
			this.adicionarAnalisado(bem);
		}
	}

	public void adicionarAnalisado(BemPatrimonial bem) {
		this.analisados.add(new Analise(bem, this, null));
	}

	public boolean removerAnalisado(BemPatrimonial bem) {
		for (Analise analisado : this.analisados) {
			if (analisado.getBemPatrimonial().equals(bem)) {
				this.analisados.remove(analisado);
				return true;
			}
		}
		return false;
	}

	private void setGestor(Gestor gestor) {
		if (gestor == null) {
			throw new IllegalArgumentException("Gestor não pode ser nulo.");
		}
		this.gestor = gestor;
	}

	private void setDataEmissao(Date dataEmissao) {
		if (dataEmissao == null) {
			throw new IllegalArgumentException("A data de "
					+ "emissão não pode ser nula");
		}
		this.dataEmissao = dataEmissao;
	}

	public void setDataFechamento(Date dataFechamento) {
		if (dataFechamento != null && dataFechamento.before(dataEmissao)) {
			throw new IllegalArgumentException(
					"A data fechamento não pode ser "
							+ "nula ou anterior à data inicial");
		}
		this.dataFechamento = dataFechamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmissao() {
		return (Date) this.dataEmissao.clone();
	}

	public Date getDataFechamento() {
		if (this.dataFechamento != null) {
			return (Date) this.dataFechamento.clone();
		}
		return this.dataFechamento;
	}

	public Gestor getGestor() throws CloneNotSupportedException {
		return gestor.clone();
	}

	public Set<Analise> getAnalisados() {
		return Collections.unmodifiableSet(analisados);
	}

	public boolean podeSerEncerrado() {
		return todasAnalisesFeitas() && !getEncerrado();
	}

	public boolean todasAnalisesFeitas() {
		for (Analise c : analisados) {
			if (c.getSituacao() == null) {
				return false;
			}
		}
		return true;
	}

	public boolean getEncerrado() {
		return dataFechamento != null;
	}
}
