using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class token
    {
        public int id { get; set; }
        public int auther_id { get; set; }
        public string token1 { get; set; }
        public Nullable<System.DateTime> expire { get; set; }
    }
}
