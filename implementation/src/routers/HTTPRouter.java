/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routers;

import java.util.HashMap;
import controllers.*;
import java.lang.reflect.Method;


public class HTTPRouter 
{
    public HTTPRequest request;
    public Controller controller;

    public HTTPRouter(HTTPRequest _request)
    {
        this.request = _request;
    }
    
    public void mapHTTPRoute() throws Exception
    {
        try 
        {
            Class<?> classController = Class.forName("controllers." + this.request.object);

            // Invoke empty constructor
            Object obj = classController.newInstance();

            // Class[] parameterTypes = new Class[]{HashMap.class};
            Method method = classController.getDeclaredMethod(this.request.method, HashMap.class);
            
            // Pass parameters
            method.invoke(obj, this.request.parameters); 
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex.getCause());
        }
    }  
}
