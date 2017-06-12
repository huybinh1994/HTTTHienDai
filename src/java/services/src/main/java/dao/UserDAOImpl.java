package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.Sha256;
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

	@Override
	public Boolean insert(UserDTO user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public Integer insertGetId(UserDTO user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
			return user.getId();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
	}

	@Override
	public Boolean isExistsEmail(String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Query q = session.createQuery("from users  where username = ? ");
			q.setString(0, email);
			session.getTransaction().commit();
			if(q.list().size() > 0)
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
	public int changePassword(int id, String oldPass, String newPass) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			oldPass = Sha256.convertSha256(oldPass);
			Query q = session.createQuery("from users  where id = ? and password = ? ");
			q.setInteger(0, id);
			q.setString(1, oldPass);
			System.out.print(q.list().size());
			if(q.list().size() != 0)
			{
				Query queryUpdate = session.createQuery("update users  set password = ? where id = ? ");
				queryUpdate.setString(0, Sha256.convertSha256(newPass));
				queryUpdate.setInteger(1, id);
				
				int result = queryUpdate.executeUpdate();
				session.getTransaction().commit();
				return result;
			}
			else
			{
				return -1;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
	}

}
