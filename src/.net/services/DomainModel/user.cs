using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class user
    {
        public string username { get; set; }
        public string password { get; set; }
        public string fullname { get; set; }
        public Nullable<int> flag { get; set; }
        public int id { get; set; }
    }
}
