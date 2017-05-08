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
    public class DeviceRepositoryy : GenericDataRepository<device>, IDeviceRepository { }
    public class Device_StatusRepository : GenericDataRepository<device_status>, IDevice_StatusRepository { }
    public class MasterRepository : GenericDataRepository<master>, IMasterRepository { }
    public class MerchantRepository : GenericDataRepository<merchant>, IMerchantRepository { }
    public class ParameterRepository : GenericDataRepository<parameter>, IParameterRepository { }
    public class TransactionRepository : GenericDataRepository<transaction>, ITransactionRepository { }
}
