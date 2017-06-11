using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DomainModel;
using System.Data.SqlClient;

namespace DataAccessLayer
{
    public interface IDeviceRepository : IGenericDataRepository<device> { }
    public interface IDevice_StatusRepository : IGenericDataRepository<device_status> { }
    public interface IMasterRepository : IGenericDataRepository<master> { }
    public interface IMerchantRepository : IGenericDataRepository<merchant>
    {
        merchant getMerchantByID(int id);
        List<merchant> searchMerchant(string Nanme, int Type, int Provice, int District, int Ward);
    }
    public interface IParameterRepository : IGenericDataRepository<parameter> { }
    public interface ITransactionRepository : IGenericDataRepository<transaction> { }
    public interface ITokenRepository : IGenericDataRepository<token>
    {
    }
    public interface IUserRepository : IGenericDataRepository<user>
    {
        //user getUserByKey(int p_iKey);
      

    }    
    public interface IMerchant_TypeRepository: IGenericDataRepository<merchant_type> { }
    public interface IThongBaoRepository : IGenericDataRepository<thongbao> { }
    public class DeviceRepositoryy : GenericDataRepository<device>, IDeviceRepository { }
    public class Device_StatusRepository : GenericDataRepository<device_status>, IDevice_StatusRepository { }
    public class MasterRepository : GenericDataRepository<master>, IMasterRepository { }
    public class MerchantRepository : GenericDataRepository<merchant>, IMerchantRepository
    {
        public merchant getMerchantByID(int id)
        {
            merchant v_obj = null;
            using (var context = new card_processingEntities())
            {
                v_obj = context.merchants.Where(x => x.id == id).FirstOrDefault();
            }
            return v_obj;
        }
       
       public List<merchant> searchMerchant(string Name, int Type, int Provice, int District, int Ward)
        {

            List<merchant> v_listMerchant = null;
            using (var context = new card_processingEntities())
            {
                v_listMerchant = context.Database.SqlQuery<merchant>("sp_sel_list_searMerchant @Name, @Type, @Provice, @District, @Ward",
                   new SqlParameter("@Name", Name), new SqlParameter("@Type", Type), new SqlParameter("@Provice", Provice),
                   new SqlParameter("@District", District), new SqlParameter("@Ward",Ward)).ToList();
            }

            return v_listMerchant;
        }

    }
    public class ParameterRepository : GenericDataRepository<parameter>, IParameterRepository { }
    public class TransactionRepository : GenericDataRepository<transaction>, ITransactionRepository { }
    public class TokenRepository : GenericDataRepository<token>, ITokenRepository
    {
        

    }
    public class UserRepository : GenericDataRepository<user>, IUserRepository
    {


    }
    public class Merchant_TypeRepository : GenericDataRepository<merchant_type>, IMerchant_TypeRepository
    {


    }
    public class ThongBaoRepository : GenericDataRepository<thongbao>, IThongBaoRepository
    {


    }
}
