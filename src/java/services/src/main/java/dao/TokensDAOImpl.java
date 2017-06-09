package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MasterDTO;
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

	@Override
	public Boolean findByTK(TokensDTO tk) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("select e from tokens e where e.token = ?");
			q.setString(0, tk.getToken());
			List<TokensDTO> li = q.list();
			session.getTransaction().commit();
			if(li != null )
			{
				return true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return false;
	}

	@Override
	public Boolean deleteTK(TokensDTO tk) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("delete e from tokens e where e.token = ?");
			q.setString(0, tk.getToken());
			q.executeUpdate();
			session.getTransaction().commit();
			
				return true;			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

}
