package dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.MoviesGenres;
import pojo.MoviesGenresId;

/**
 * A data access object (DAO) providing persistence and search support for
 * MoviesGenres entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see pojo.MoviesGenres
 * @author MyEclipse Persistence Tools
 */
public class MoviesGenresDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MoviesGenresDAO.class);
	// property constants

	public void save(MoviesGenres transientInstance) {
		log.debug("saving MoviesGenres instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MoviesGenres persistentInstance) {
		log.debug("deleting MoviesGenres instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MoviesGenres findById(MoviesGenresId id) {
		log.debug("getting MoviesGenres instance with id: " + id);
		try {
			MoviesGenres instance = (MoviesGenres) getSession().get("pojo.MoviesGenres", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MoviesGenres> findByExample(MoviesGenres instance) {
		log.debug("finding MoviesGenres instance by example");
		try {
			List<MoviesGenres> results = (List<MoviesGenres>) getSession()
					.createCriteria("pojo.MoviesGenres").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding MoviesGenres instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from MoviesGenres as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all MoviesGenres instances");
		try {
			String queryString = "from MoviesGenres";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MoviesGenres merge(MoviesGenres detachedInstance) {
		log.debug("merging MoviesGenres instance");
		try {
			MoviesGenres result = (MoviesGenres) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MoviesGenres instance) {
		log.debug("attaching dirty MoviesGenres instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MoviesGenres instance) {
		log.debug("attaching clean MoviesGenres instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}