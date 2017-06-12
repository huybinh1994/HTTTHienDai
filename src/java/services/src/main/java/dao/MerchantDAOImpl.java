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

	@Override
	public List<AgentSubAgent> getAngentSubAgent() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String str = "exec get_agent_and_sub_agent";
			Query q = session.createSQLQuery(str).setResultTransformer(Transformers.aliasToBean(AgentSubAgent.class));
			session.getTransaction().commit();
			return q.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public int getNextIdentity() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createSQLQuery("SELECT IDENT_CURRENT('merchants')+1 as id");
			BigDecimal result = (BigDecimal) q.list().get(0);

			session.getTransaction().commit();

			return Integer.parseInt(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
	}

	@Override
	public MerchantsDTO insertMerchantAndUser(MerchantsDTO merchant, UserDTO user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			Integer auther_id = user.getId();
			merchant.setAuther_id(auther_id);
			
			int nextId = getNextIdentity();
			
			int master_id = merchant.getMaster_id();
			int agent_id = merchant.getAgent_id();
			int sub_agent_id = merchant.getSub_agent_id();
			int level = merchant.getLevel_id();
			String merchant_code = UtilComponent.generateFullCode(master_id, agent_id, sub_agent_id, nextId, level);
			merchant.setMerchant_code(merchant_code);
			merchant.setStatus(user.getActive());
			session.save(merchant);
			session.getTransaction().commit();
			return merchant;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

			
	public List<MerchantsDTO> Find_Agent(int masterId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Query q = session.createQuery("select m from merchants m where m.master_id=? and m.level_id=2");
			q.setInteger(0, masterId);
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
	public List<MerchantsDTO> Find_subAgent(int masterId, int agentId) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {

			if (agentId == 0) {
				Query q = session.createQuery("select m from merchants m where m.master_id=? and m.level_id=3");
				q.setInteger(0, masterId);
				List<MerchantsDTO> li = q.list();

				session.getTransaction().commit();
				return li;
			} else {
				Query q = session
						.createQuery("select m from merchants m where m.master_id=? and m.level_id=3 and m.agent_id=?");
				q.setInteger(0, masterId);
				q.setInteger(1, agentId);
				List<MerchantsDTO> li = q.list();

				session.getTransaction().commit();
				return li;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}


	@Override
	public List<MerchantsDTO> Find_Merchant(int masterId, int agentId, int subAgentId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {

			if (agentId == 0) {
				Query q = session.createQuery(
						"select m from merchants m where m.master_id=? and m.level_id=4 and m.sub_agent_id=?");
				q.setInteger(0, masterId);
				q.setInteger(1, subAgentId);
				List<MerchantsDTO> li = q.list();

				session.getTransaction().commit();
				return li;
			}
			else if (subAgentId == 0) {
				Query q = session.createQuery(
						"select m from merchants m where m.master_id=? and m.level_id=4 and m.agent_id=?");
				q.setInteger(0, masterId);
				q.setInteger(1, agentId);
				List<MerchantsDTO> li = q.list();

				session.getTransaction().commit();
				return li;
			} else {
				Query q = session
						.createQuery("select m from merchants m where m.master_id=? and m.level_id=4");
				q.setInteger(0, masterId);
				

				List<MerchantsDTO> li = q.list();

				session.getTransaction().commit();
				return li;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public Boolean update(MerchantsDTO merchant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String old_merchant_code = merchant.getMerchant_code();
			if(merchant.getStatus() != null && merchant.getStatus() == 1)
			{
				String first_active_date = merchant.getFirst_active_date();
				if(first_active_date != null)
				{
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date();
					merchant.setLast_active_Date(dateFormat.format(date));
				}
			}
			//update active in table user
			Query queryUpdateActive = session.createQuery("update users  set active = ? ");
			queryUpdateActive.setInteger(0, merchant.getStatus());
			
			queryUpdateActive.executeUpdate();
			
			String first_active_date = merchant.getFirst_active_date();
			
			int id = merchant.getId();
			int master_id = merchant.getMaster_id();
			int agent_id = merchant.getAgent_id();
			int sub_agent_id = merchant.getSub_agent_id();
			int level = merchant.getLevel_id();
			String merchant_code = UtilComponent.generateFullCode(master_id, agent_id, sub_agent_id, id, level);
			
			merchant.setMerchant_code(merchant_code);
			session.update(merchant);
			
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
	public List<MerchantsDTO> getbyid(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("select m from merchants m where m.auther_id = ?");
			q.setInteger(0, id);
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
	public MerchantsDTO getMerchantByIdAndLevel(int id, int level) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("select m from merchants m where m.id = ? and m.level_id = ?");
			q.setInteger(0, id);
			q.setInteger(1, level);
			MerchantsDTO m = (MerchantsDTO) q.list().get(0);

			session.getTransaction().commit();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
}
