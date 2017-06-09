package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.MerchantsDTO;;

//@Transactional
@Repository
public class MerchantDAOImpl implements MerchantDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<MerchantsDTO> getAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			

			Query q = session.createQuery("select m from merchants m");
			List<MerchantsDTO> li = q.list();

			session.getTransaction().commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}

	}

	@Override
	public Boolean insert(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean findByMerchant(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTK(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MerchantsDTO> getMerchantByMasterId(int master_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("select m from merchants m where master_id = ?");
			q.setInteger(0, master_id);
			List<MerchantsDTO> li = q.list();

			session.getTransaction().commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
