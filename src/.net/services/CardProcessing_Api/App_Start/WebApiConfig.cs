using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web.Http;
using Microsoft.Owin.Security.OAuth;
using Newtonsoft.Json.Serialization;

namespace CardProcessing_Api
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            
            config.SuppressDefaultHostAuthentication();
            config.Filters.Add(new HostAuthenticationFilter(OAuthDefaults.AuthenticationType));
          
          

           
            config.MapHttpAttributeRoutes();

     
        }
    }
}
