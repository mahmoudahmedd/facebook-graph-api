/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import java.util.ArrayList;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 


public abstract class View 
{
    public JSONObject success()
    {
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 

        // putting data to JSONObject 
        jo.put("status", "ok"); 
        jo.put("message", "the request has succeeded."); 

        System.out.println(jo);
        return jo;
    }
    
    public JSONObject fail()
    {
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 

        // putting data to JSONObject 
        jo.put("status", "fail"); 
        jo.put("message", "the request has failed. Please review the data sent."); 

        System.out.println(jo);
        return jo;
    }
    
    public JSONObject exception()
    {
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 

        // putting data to JSONObject 
        jo.put("status", "exception"); 
        jo.put("message", "unsupported get request. Please read the API documentation."); 

        System.out.println(jo);
        return jo;
    }
    
    public JSONObject render()
    {
        return null;
    }
    
    public JSONObject renderAll()
    {
        return null;
    }
}
