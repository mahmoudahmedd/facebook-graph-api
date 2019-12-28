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
    public JSONObject render(User _user)
    {
        // creating JSONObject 
        JSONObject jo = new JSONObject(); 
        HashMap<String, String> userM = new HashMap<String, String>();

        userM.put("email", _user.email); 
        userM.put("password", _user.password); 
        userM.put("gender", _user.gender); 
        userM.put("country", _user.country); 
        userM.put("account_type", _user.accountType); 
        userM.put("birthday", _user.birthday); 
        
        // putting data to JSONObject 
        jo.put("status", "ok"); 
        jo.put("data", userM); 

        
        System.out.println(jo);
        return jo;
    }
    
}
