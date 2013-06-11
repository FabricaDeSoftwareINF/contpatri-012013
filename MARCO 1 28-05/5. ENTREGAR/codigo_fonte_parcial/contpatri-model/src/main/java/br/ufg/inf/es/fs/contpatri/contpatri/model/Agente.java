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
 * Identifica o Agente Patrimonial responsável pelas coletas de bens patrimoniais
 * da Unidade da UFG.
 * 
 *
 * @author Emerson Jose Porfirio
 */

public class Agente implements Serializable, Cloneable {

	private static final long serialVersionUID = -3415217048887883532L;
	private Long id;
	private String nome;
	private String matricula;
	private String email;

	public Agente() {
	}

	public Agente(String nome, String matricula, String email) {
		setNome(nome);
		setMatricula(matricula);
		setEmail(email);
	}

	private void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Campo email deve ser preenchido");
		}
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Identificador interno para a aplicação
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Nome do Agente responsável pela coleta dos bens patrimoniais da Unidade da UFG
	 *
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		if (nome == null || nome.trim().length() == 0 || nome.length() > 60)
			throw new IllegalArgumentException(String.format("Valor inválido para o atributo nome: '%s'", nome));
		this.nome = nome;
	}

	/**
	 * Identificação funcional do Agente; número de registro junto ao
	 * sistema de recursos humanos da UFG.
	 *
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		if (matricula == null || matricula.trim().equals(""))
			throw new IllegalArgumentException("Matricula nao pode ser nula ou vazia");
		Long.parseLong(matricula);
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object outro) {
		if (outro == null) return false;
		if (!(outro instanceof Agente)) return false;
		if (this == outro) return true;
		Agente outroAgente = (Agente) outro;
		return !((this.matricula.compareTo(outroAgente.matricula) != 0)
				|| (this.nome.compareTo(outroAgente.nome) != 0));
	}

	public int hashCode() {
		int hash = 1;
		hash = hash * 31 + (nome.isEmpty() ? 0 : nome.hashCode());
		hash = hash * 31 + (matricula.isEmpty() ? 0 : matricula.hashCode());
		return hash;
	}

	public Agente clone() {
		try {
			Agente clone = (Agente) super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new Error("Assertion failure");
		}
	}
   
}
