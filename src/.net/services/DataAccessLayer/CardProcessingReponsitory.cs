using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DomainModel;

namespace DataAccessLayer
{
    public interface IDeviceRepository : IGenericDataRepository<device> { }
    public interface IDevice_StatusRepository : IGenericDataRepository<device_status> { }
    public interface IMasterRepository : IGenericDataRepository<master> { }
    public interface IMerchantRepository : IGenericDataRepository<merchant> { }
    public interface IParameterRepository : IGenericDataRepository<parameter> { }
    public interface ITransactionRepository : IGenericDataRepository<transaction> { }
    public interface ITokenRepository : IGenericDataRepository<token>
    {
    }
        

        public interface IUserRepository : IGenericDataRepository<user>
    {
        user getUserByKey(int p_iKey);
    }
        
    public class DeviceRepositoryy : GenericDataRepository<device>, IDeviceRepository { }
    public class Device_StatusRepository : GenericDataRepository<device_status>, IDevice_StatusRepository { }
    public class MasterRepository : GenericDataRepository<master>, IMasterRepository { }
    public class MerchantRepository : GenericDataRepository<merchant>, IMerchantRepository
    {

    }
    public class ParameterRepository : GenericDataRepository<parameter>, IParameterRepository { }
    public class TransactionRepository : GenericDataRepository<transaction>, ITransactionRepository { }
    public class TokenRepository : GenericDataRepository<token>, ITokenRepository
    {
        //public token getTokenByToKenValue(string p_strValue)
        //{
        //    //token v_obj;
        //    //using (var context = new card_processingEntities())
        //    //{
        //    //     v_obj = context.tokens.Where(x => x.value_token == p_strValue).FirstOrDefault();
        //    //}
        //    //return v_obj;

        //}

    }
    public class UserRepository : GenericDataRepository<user>, IUserRepository
    {
        
        public user getUserByKey(int p_iKey)
        {
            user v_obj;
            using (var context = new card_processingEntities())
            {
                v_obj = context.users.First(x => x.id == p_iKey);
            }
            return v_obj;

        }
       
    }
}
