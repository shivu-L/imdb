package dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Roles;
import pojo.RolesId;

/**
 * A data access object (DAO) providing persistence and search support for Roles
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see pojo.Roles
 * @author MyEclipse Persistence Tools
 */
public class RolesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RolesDAO.class);
	// property constants

	public void save(Roles transientInstance) {
		log.debug("saving Roles instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Roles persistentInstance) {
		log.debug("deleting Roles instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Roles findById(RolesId id) {
		log.debug("getting Roles instance with id: " + id);
		try {
			Roles instance = (Roles) getSession().get("pojo.Roles", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Roles> findByExample(Roles instance) {
		log.debug("finding Roles instance by example");
		try {
			List<Roles> results = (List<Roles>) getSession().createCriteria("pojo.Roles")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Roles instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Roles as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Roles instances");
		try {
			String queryString = "from Roles";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Roles merge(Roles detachedInstance) {
		log.debug("merging Roles instance");
		try {
			Roles result = (Roles) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Roles instance) {
		log.debug("attaching dirty Roles instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Roles instance) {
		log.debug("attaching clean Roles instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}