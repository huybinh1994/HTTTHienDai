package dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import service.Sha256;
import util.UtilComponent;
import model.AgentSubAgent;
import model.MerchantsDTO;
import model.UserDTO;


@Repository
public class AgentDAOImpl implements AgentDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Boolean insert(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(MerchantsDTO m) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String old_merchant_code = m.getMerchant_code();
			if(m.getStatus() != null && m.getStatus() == 1)
			{
				String first_active_date = m.getFirst_active_date();
				if(first_active_date != null)
				{
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date();
					m.setLast_active_Date(dateFormat.format(date));
				}
			}
			
			Query queryUpdateActive = session.createQuery("update users  set active = ? ");
			queryUpdateActive.setInteger(0, m.getStatus());
			
			queryUpdateActive.executeUpdate();
			
			String first_active_date = m.getFirst_active_date();
			
			int id = m.getId();
			int master_id = m.getMaster_id();
			int agent_id = m.getAgent_id();
			int sub_agent_id = m.getSub_agent_id();
			int level = m.getLevel_id();
			String merchant_code = UtilComponent.generateFullCode(master_id, agent_id, sub_agent_id, id, level);
			
			m.setMerchant_code(merchant_code);
			session.update(m);
			
			Query queryUpdate = session.createQuery("update transactions  set merchant_code = ? where merchant_code = ? ");
			queryUpdate.setString(0, merchant_code);
			queryUpdate.setString(1, old_merchant_code);
			
			queryUpdate.executeUpdate();
			
			session.getTransaction().commit();
			
			
			return true;
			
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public MerchantsDTO insertAgentAndUser(MerchantsDTO m, UserDTO u) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(u);
			Integer auther_id = u.getId();
			m.setAuther_id(auther_id);
			MerchantDAOImpl merchantDAOImpl = new MerchantDAOImpl();
			int nextId = merchantDAOImpl.getNextIdentity();
			
			int master_id = m.getMaster_id();
			int agent_id = m.getAgent_id();
			int sub_agent_id = m.getSub_agent_id();
			int level = m.getLevel_id();
			String merchant_code = UtilComponent.generateFullCode(master_id, agent_id, sub_agent_id, nextId, level);
			m.setMerchant_code(merchant_code);
			m.setStatus(u.getActive());
			session.save(m);
			session.getTransaction().commit();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
