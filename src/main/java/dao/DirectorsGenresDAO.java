package dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.DirectorsGenres;
import pojo.DirectorsGenresId;

/**
 * A data access object (DAO) providing persistence and search support for
 * DirectorsGenres entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pojo.DirectorsGenres
 * @author MyEclipse Persistence Tools
 */
public class DirectorsGenresDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DirectorsGenresDAO.class);
	// property constants

	public void save(DirectorsGenres transientInstance) {
		log.debug("saving DirectorsGenres instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DirectorsGenres persistentInstance) {
		log.debug("deleting DirectorsGenres instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DirectorsGenres findById(DirectorsGenresId id) {
		log.debug("getting DirectorsGenres instance with id: " + id);
		try {
			DirectorsGenres instance = (DirectorsGenres) getSession().get("pojo.DirectorsGenres", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DirectorsGenres> findByExample(DirectorsGenres instance) {
		log.debug("finding DirectorsGenres instance by example");
		try {
			List<DirectorsGenres> results = (List<DirectorsGenres>) getSession()
					.createCriteria("pojo.DirectorsGenres").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DirectorsGenres instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from DirectorsGenres as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all DirectorsGenres instances");
		try {
			String queryString = "from DirectorsGenres";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DirectorsGenres merge(DirectorsGenres detachedInstance) {
		log.debug("merging DirectorsGenres instance");
		try {
			DirectorsGenres result = (DirectorsGenres) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DirectorsGenres instance) {
		log.debug("attaching dirty DirectorsGenres instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DirectorsGenres instance) {
		log.debug("attaching clean DirectorsGenres instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}