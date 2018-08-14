package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Directors;

/**
 * A data access object (DAO) providing persistence and search support for
 * Directors entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Directors
 * @author MyEclipse Persistence Tools
 */
public class DirectorsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DirectorsDAO.class);
	// property constants
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";

	public void save(Directors transientInstance) {
		log.debug("saving Directors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Directors persistentInstance) {
		log.debug("deleting Directors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Directors findById(java.lang.Long id) {
		log.debug("getting Directors instance with id: " + id);
		try {
			Directors instance = (Directors) getSession().get("pojo.Directors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Directors> findByExample(Directors instance) {
		log.debug("finding Directors instance by example");
		try {
			List<Directors> results = (List<Directors>) getSession().createCriteria("pojo.Directors")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Directors instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Directors as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Directors> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List<Directors> findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findAll() {
		log.debug("finding all Directors instances");
		try {
			String queryString = "from Directors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Directors merge(Directors detachedInstance) {
		log.debug("merging Directors instance");
		try {
			Directors result = (Directors) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Directors instance) {
		log.debug("attaching dirty Directors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Directors instance) {
		log.debug("attaching clean Directors instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}