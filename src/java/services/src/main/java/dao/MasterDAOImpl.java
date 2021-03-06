package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.MasterDTO;

//@Transactional
@Repository
public class MasterDAOImpl implements MasterDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<MasterDTO> getAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("select e from masters e");
			List<MasterDTO> li = q.list();

			session.getTransaction().commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}

	}
	@Override
	public List<MasterDTO> getbyid(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("select e from masters e where e.auther_id = ?").setInteger(0, id);
			List<MasterDTO> li = q.list();

			session.getTransaction().commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
