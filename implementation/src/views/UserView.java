/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

import models.User;

/**
 *
 * @author Mahmoud Ahmed
 */
public class UserView extends View
{
    public User user;
    public ArrayList<User> users;
    
    @Override
    public JSONObject render()
    {
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 
        HashMap<String, String> userM = new HashMap<String, String>();

        userM.put("full_name", user.fullName); 
        userM.put("password", user.password); 
        userM.put("email", user.email); 
        userM.put("gender", user.gender); 
        userM.put("country", user.country); 
        userM.put("birthday", user.birthday); 
        
        // putting data to JSONObject 
        jo.put("status", "ok"); 
        jo.put("data", userM); 

        
        System.out.println(jo);
        return jo;
    }
    
    @Override
    public JSONObject renderAll()
    {
        return null;
    }
}
