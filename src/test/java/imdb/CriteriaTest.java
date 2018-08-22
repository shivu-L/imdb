package imdb;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pojo.Movies;
import util.HibernateSessionFactory;

public class CriteriaTest {
	public static void main(String args[]) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;

		try {
			
 
			tx = session.beginTransaction();
			Criteria c = session.createCriteria(Movies.class);
//			c.setFirstResult(0);
//            c.setMaxResults(25);
			
			c.add(Restrictions.like("name", "%Life%")); 
			c.add(Restrictions.like("name", "%Dispos%")); 
			c.add(Restrictions.like("name", "%Dispos%")); 
			
//			Criterion name = Restrictions.like("name","%Life%");
//			Criterion year = Restrictions.like("year","%20%");
//
//			LogicalExpression orExpression =Restrictions.or(name, year);
//			c.add(orExpression);
//			
//		    c.add(Restrictions.ilike("lastName", "%F%"));
//			Criteria cr = session.createCriteria(Actors.class);
//			cr.setProjection(Projections.countDistinct("firstName"));
//		    Criterion firstName = Restrictions.like("firstName","zara%");
//			Criterion salary = Restrictions.like("lastName", "%F%");
//			LogicalExpression andExp = Restrictions.or(salary,name);
//			cr.add( andExp );
//		    c.addOrder(Order.asc("firstName"));
			
		    List<Movies> result = c.list();
			for (Movies movies : result) {
				System.out.println(" name " + movies.getName() );
			}

			System.out.println(result.size());
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		
		
	}

}
