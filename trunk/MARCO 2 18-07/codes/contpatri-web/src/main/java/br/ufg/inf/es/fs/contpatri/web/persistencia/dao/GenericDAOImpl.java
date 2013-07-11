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
package br.ufg.inf.es.fs.contpatri.web.persistencia.dao;

import br.ufg.inf.es.fs.contpatri.web.persistencia.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Implementação genérica de operações de persistência no Hibernate.
 * 
 * @author Guilherme de Paula <guilherme.p.pereira at gmail.com>
 */
abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	protected Session getSession() {
		return HibernateUtil.getSession();
	}

	@Override
	public void create(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.save(entity);
	}

	@Override
	public void update(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.update(entity);
	}

	@Override
	public void merge(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.merge(entity);
	}

	@Override
	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
	}

	@Override
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	@Override
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	public int rowCount(Class clazz) {
		Session hibernateSession = this.getSession();
		Query query = hibernateSession.createQuery("select count (*) from "
				+ clazz.getName());
		return ((Long) query.list().get(0)).intValue();
	}

	@Override
	public T findByID(Class clazz, int id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	@Override
	public List findAll(Class clazz) {
		Session hibernateSession = this.getSession();
		List t = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		t = query.list();
		return T;
	}
}