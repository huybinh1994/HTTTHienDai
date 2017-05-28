package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.UserDTO;
@Repository
public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public UserDTO loGin(String user, String pass) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
		
			Query q = session.createQuery("from users  where username = ? and password = ? ");
			q.setString(0, user);
			q.setString(1, pass);
			UserDTO a = (UserDTO) q.list().get(0);
			session.getTransaction().commit();
			return a;
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
