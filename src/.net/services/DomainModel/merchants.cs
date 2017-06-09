using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    using System;
    using System.Collections.Generic;

    public partial class merchant
    {
        public int id { get; set; }
        public string merchant_code { get; set; }
        public string merchant_name { get; set; }
        public string merchant_phone_call { get; set; }
        public string tax_code { get; set; }
        public int master_id { get; set; }
        public Nullable<int> agent_id { get; set; }
        public Nullable<int> sub_agent_id { get; set; }
        public string address { get; set; }
        public Nullable<int> district { get; set; }
        public Nullable<int> province { get; set; }
        public Nullable<int> ward { get; set; }
        public Nullable<int> zip_code { get; set; }
        public Nullable<System.DateTime> first_active_date { get; set; }
        public Nullable<System.DateTime> last_active_date { get; set; }
        public Nullable<int> auther_id { get; set; }
        public Nullable<int> invite_id { get; set; }
        public Nullable<int> status { get; set; }
        public Nullable<int> type_id { get; set; }
    }
}
