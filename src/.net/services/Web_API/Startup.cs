using Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace DongABank_API
{
    public class Startup
    {
        // This code configures Web API. The Startup class is specified as a type
        // parameter in the WebApp.Start method.
        public void Configuration(IAppBuilder appBuilder)
        {
            appBuilder.UseCors(Microsoft.Owin.Cors.CorsOptions.AllowAll);  // cors for owin token pipeline
            // Configure Web API for self-host. 
            HttpConfiguration config = new HttpConfiguration();
            WebApiConfig.Register(config);  // registering web api configuration

            appBuilder.UseWebApi(config);
        }
    }
}
