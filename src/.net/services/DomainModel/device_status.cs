using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class device_status
    {
        public int id { get; set; }
        public Nullable<System.DateTime> date { get; set; }
        public Nullable<int> status { get; set; }
        public Nullable<int> merchant_id { get; set; }
        public int device_id { get; set; }
    }
}
