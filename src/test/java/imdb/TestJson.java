package imdb;



import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pojo.CriteriaPojo;
import util.HibernateSessionFactory;

@Entity
public class TestJson {

	private static final Faker faker = new Faker();
	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();

		for (int i = 0; i < 50; i++) {

			CriteriaPojo criteriaPojo = new CriteriaPojo();

			criteriaPojo.setDraw(faker.number().randomDigitNotZero());
			criteriaPojo.setColumns(null);
			criteriaPojo.setOrder(null);
			criteriaPojo.setStart(faker.number().randomDigit() );
			criteriaPojo.setLength(faker.number().randomDigit());
			criteriaPojo.setSearch(null);
			session.save(criteriaPojo);
			Transaction transaction = null;
			{
				try {
					transaction = session.beginTransaction();

					transaction.commit();
				} catch (HibernateException e) {
					transaction.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}

			}

		}

	}

}
