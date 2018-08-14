package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Actors;

/**
 * A data access object (DAO) providing persistence and search support for
 * Actors entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Actors
 * @author MyEclipse Persistence Tools
 */
public class ActorsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ActorsDAO.class);
	// property constants
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String GENDER = "gender";

	public void save(Actors transientInstance) {
		log.debug("saving Actors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Actors persistentInstance) {
		log.debug("deleting Actors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Actors findById(java.lang.Long id) {
		log.debug("getting Actors instance with id: " + id);
		try {
			Actors instance = (Actors) getSession().get("pojo.Actors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Actors> findByExample(Actors instance) {
		log.debug("finding Actors instance by example");
		try {
			List<Actors> results = (List<Actors>) getSession().createCriteria("pojo.Actors")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Actors instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Actors as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Actors> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<Actors> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List<Actors> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findAll() {
		log.debug("finding all Actors instances");
		try {
			String queryString = "from Actors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Actors merge(Actors detachedInstance) {
		log.debug("merging Actors instance");
		try {
			Actors result = (Actors) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Actors instance) {
		log.debug("attaching dirty Actors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Actors instance) {
		log.debug("attaching clean Actors instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}