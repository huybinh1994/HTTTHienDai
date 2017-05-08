using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessLayer
{
   public interface IGenericDataRepository<T> where T : class
    {
        IList<T> GetAll(params Expression<Func<T, object>>[] navigationproperties);
        IList<T> GetList(Func<T, bool> where, params Expression<Func<T, object>>[] navigationproperties);
        T GetSingle(Func<T, bool> where, params Expression<Func<T, object>>[] navigationproperties);
        void add(params T[] items);
        void update(params T[] items);
        void remove(params T[] items);
    }
}
