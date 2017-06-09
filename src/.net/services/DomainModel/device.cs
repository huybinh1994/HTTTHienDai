using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class device
    {
        public Nullable<int> device_type { get; set; }
        public string device_name { get; set; }
        public string device_no { get; set; }
        public int id { get; set; }
    }
}
