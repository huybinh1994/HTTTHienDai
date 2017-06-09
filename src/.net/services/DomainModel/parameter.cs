using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class parameter
    {
        public int id { get; set; }
        public string param_name { get; set; }
        public string param_value { get; set; }
        public string param_type { get; set; }
        public Nullable<int> param_status { get; set; }
    }
}
