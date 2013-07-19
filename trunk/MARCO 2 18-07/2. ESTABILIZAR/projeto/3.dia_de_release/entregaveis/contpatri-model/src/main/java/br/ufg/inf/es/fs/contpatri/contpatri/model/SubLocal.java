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
 * Espaço físico onde um ou mais bens permanentes são usualmente dispostos, seja
 * para uso ou para estocagem. Exemplo: Laboratório, Sala de Aulas, etc.
 *
 * @author Emerson Jose Porfirio
 */
public class SubLocal implements Serializable, Cloneable {

	private Long id;
	private String nome;

	public SubLocal() {
	}

	public SubLocal(String nome) {
		setNome(nome);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private void setNome(String nome) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Campo nome não pode ser nulo ou vazio.");
		}
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public SubLocal clone() {
		try {
			return (SubLocal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("CloneNotSupported");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof SubLocal)) {
			return false;
		}
		SubLocal outro = (SubLocal) obj;
		return this.nome.equals(outro.nome);
	}
}
