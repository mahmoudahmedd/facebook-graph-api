package routers;

import java.util.HashMap;
import controllers.*;
import java.lang.reflect.Method;
import java.sql.SQLException;


public class HTTPRouter 
{
    private HTTPRequest request;
    private Controller controller;

    public HTTPRouter(HTTPRequest _request)
    {
        this.request = _request;
    }
    
    public boolean checkRouting() throws SQLException
    {
        if(this.request.object == "UserController")
        {
            controller = new UserController();
            return true;
        }
            
        return false;
    }
    
    public void mapHTTPRoute() throws Exception
    {
            if(this.checkRouting())
            {
                try 
                {
                    // ===>>>> 1
                    
                    /*
                    Class<?> classController = Class.forName("controllers." + this.request.object);

                    // Invoke empty constructor
                    Object obj = classController.newInstance();

                    // Class[] parameterTypes = new Class[]{HashMap.class};
                    Method method = classController.getDeclaredMethod(this.request.method, HashMap.class);

                    // Pass parameters
                    method.invoke(obj, this.request.parameters); 
                    */
                    
                    // ===>>>> 2
                    
                    if(this.request.method.equals("register"))
                    {
                        ((UserController)controller).register(this.request.parameters);
                    }
                    else if(this.request.method.equals("login"))
                    {
                        ((UserController)controller).login(this.request.parameters);
                    }
                    else if(this.request.method.equals("sendFirendRequest"))
                    {
                        ((UserController)controller).sendFirendRequest(this.request.parameters);
                    }
                    else if(this.request.method.equals("acceptFirendRequest"))
                    {
                        ((UserController)controller).acceptFirendRequest(this.request.parameters);
                    }
                    else if(this.request.method.equals("upgradeToPremium"))
                    {
                        ((UserController)controller).upgradeToPremium(this.request.parameters);
                    }
                    else
                    {
                        throw new Exception("method not found");
                    }
                    
                } 
                catch(Exception _ex) 
                {
                    //System.err.println(_ex.getCause());
                    System.err.println(_ex.toString());
                }
            }
            else
            {
                throw new Exception("object not found");
            }
    }
}
