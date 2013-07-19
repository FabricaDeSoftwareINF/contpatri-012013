/**
  * Esse documento é parte do código fonte e artefatos relacionados 
  * ao projeto CONTPATRI, em desenvolvimento pela Fábrica de Software
  * da UFG.
  * 
  *  Links relevantes:
  *  Fábrica de Software: http://fs.inf.ufg.br/
  *  Instituto de Informática UFG: http://www.inf.ufg.br
  *  Projeto CONTPATRI DROPBOX: https://www.dropbox.com/home/CONTPATRI%20-%20012013
  *  Projeto CONTPATRI REDMINE: http://fs.inf.ufg.br/redmine/projects/contpatri-012013-
  *
  * Copyleft © UFG.
  * 
  * Licenciado sobre a licença GNU-GPL v3
  *
  * Você pode obter uma cópia da licença em http://www.gnu.org/licenses/gpl.html
  * 
  * A menos que especificado ou exigido por legislação local, o software é 
  * fornecido "da maneira que está", sem garantias ou condições de qualquer 
  * tipo, nem expressas nem implícitas. Em caso de dúvidas referir a licença GNU-GPL.
  */ 

package com.contpatri.restful.inventario.jerseyspring.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "inventario")
@XmlRootElement
public class Inventario implements Serializable {

	// --------------------------------------------------------------------------
	private static final long serialVersionUID = -1058743390684974211L;
	// --------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(nullable = false, length = 250)
	private String name;

	@Column
	private String description;

	@Column(nullable = false, length = 250)
	private String url;

	// --------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// --------------------------------------------------------------------------

}
