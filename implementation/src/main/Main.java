package main;

import routers.*;


/**
 *
 * @author Mahmoud Ahmed
 */     
public class Main 
{
    public static void main(String[] args)
    {
        /*
        1- Register into the system 
        
        GET /UserController/register/full_name=Mahmoud Ahmed&password=1234567... HTTP/1.1
        
        
        request.parameters.put("full_name", "Mahmoud Ahmed");
        request.parameters.put("password", "1234567");
        request.parameters.put("email", "mahmoud@gmail.com");
        request.parameters.put("gender", "male");
        request.parameters.put("country", "Egypt");
        request.parameters.put("birthday", "1997-12-08");
        ------------------------------------------------------------------------
        2- Login
        
        GET /UserController/login/email=mahmoud@gmail.com&password=1234567 HTTP/1.1
        
        request.parameters.put("email", "mahmoud@gmail.com");
        request.parameters.put("password", "1234567");
        ------------------------------------------------------------------------
        3- Send a friend request
        GET /UserController/sendFirendRequest/by=1&to=2 HTTP/1.1
        
        request.parameters.put("by", "1");
        request.parameters.put("to", "2");
        ------------------------------------------------------------------------
        4- Accept any friend request
        
        GET /UserController/acceptFirendRequest/by=1&to=2 HTTP/1.1
        
        request.parameters.put("by", "1");
        request.parameters.put("to", "2");
        ------------------------------------------------------------------------
        5- Upgrade registration subscription to be a premium
        
        GET /UserController/upgradeToPremium/user_id=2 HTTP/1.1
        
        request.parameters.put("user_id", "2");
        ------------------------------------------------------------------------
        */
        
        // HTTPRequest
        // GET /object/method/parameters
        HTTPRequest request = new HTTPRequest();
        
        request.object = "UserController";
        request.method = "login";
        
        request.parameters.put("full_name", "Mahmoud Ahmed");
        request.parameters.put("password", "124567");
        request.parameters.put("email", "mahmoud@gmail.com");
        request.parameters.put("gender", "male");
        request.parameters.put("country", "Egypt");
        request.parameters.put("birthday", "1997-12-08");
        
        // HTTPRouter
        HTTPRouter router = new HTTPRouter(request);
        
        try 
        {
            router.mapHTTPRoute();
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex.toString());
        }
    }
}

