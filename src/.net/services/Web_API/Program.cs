using Microsoft.Owin.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DongABank_API
{
    class Program
    {
        static void Main(string[] args)
        {
            string baseAddress = "http://localhost:4000/";

            // Start OWIN host 
            WebApp.Start<Startup>(url: baseAddress);
            Console.WriteLine("API is online at {0}. Press Enter to EXIT.", baseAddress);
            Console.ReadLine();
        }
    }
}
