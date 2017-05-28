package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.TokensDTO;

@Repository
public class TokensDAOImpl implements TokensDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean insert(TokensDTO tk) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
		
				session.save(tk);
			
//			q.setString(0, tk.getToken());
//			q.executeUpdate();
			session.getTransaction().commit();
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

}
