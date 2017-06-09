using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    public class thongbao
    {
        public int id { get; set; }
        public string tieude { get; set; }
        public string noidung { get; set; }
        public DateTime ngaytao { get; set; }
        public int nguoitao { get; set; }
        public int nguoinhan { get; set; }
    }
}
