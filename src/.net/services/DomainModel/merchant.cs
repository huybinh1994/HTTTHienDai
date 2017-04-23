//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DomainModel
{
    using System;
    using System.Collections.Generic;
    
    public partial class merchant
    {
        public merchant()
        {
            this.transactions = new HashSet<transaction>();
            this.device_status = new HashSet<device_status>();
        }
    
        public Nullable<int> merchant_name { get; set; }
        public Nullable<int> merchant_phone_call { get; set; }
        public Nullable<int> tax_code { get; set; }
        public Nullable<int> agent_id { get; set; }
        public Nullable<int> sub_agent_id { get; set; }
        public string address_1 { get; set; }
        public string address_2 { get; set; }
        public string address_3 { get; set; }
        public Nullable<int> city { get; set; }
        public Nullable<int> province { get; set; }
        public Nullable<int> zip_code { get; set; }
        public Nullable<int> country { get; set; }
        public Nullable<System.DateTime> first_active_date { get; set; }
        public Nullable<System.DateTime> last_active_date { get; set; }
        public int id { get; set; }
        public Nullable<int> master_id { get; set; }
    
        public virtual master master { get; set; }
        public virtual ICollection<transaction> transactions { get; set; }
        public virtual ICollection<device_status> device_status { get; set; }
    }
}