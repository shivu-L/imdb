package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Movies;

/**
 * A data access object (DAO) providing persistence and search support for
 * Movies entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Movies
 * @author MyEclipse Persistence Tools
 */
public class MoviesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MoviesDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String YEAR = "year";
	public static final String RANK = "rank";

	public void save(Movies transientInstance) {
		log.debug("saving Movies instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movies persistentInstance) {
		log.debug("deleting Movies instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movies findById(java.lang.Long id) {
		log.debug("getting Movies instance with id: " + id);
		try {
			Movies instance = (Movies) getSession().get("pojo.Movies", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Movies> findByExample(Movies instance) {
		log.debug("finding Movies instance by example");
		try {
			List<Movies> results = (List<Movies>) getSession().createCriteria("pojo.Movies")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Movies instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Movies as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Movies> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Movies> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List<Movies> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List findAll() {
		log.debug("finding all Movies instances");
		try {
			String queryString = "from Movies";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public List findLimitedMovies(Integer max_result) {
		log.debug("finding all Movies instances");
		try {
			String queryString = "from Movies";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(max_result);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public Movies merge(Movies detachedInstance) {
		log.debug("merging Movies instance");
		try {
			Movies result = (Movies) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movies instance) {
		log.debug("attaching dirty Movies instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movies instance) {
		log.debug("attaching clean Movies instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}