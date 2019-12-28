/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.sql.SQLException;
import java.util.HashMap;
import models.*;
import views.*;
import utilities.*;

/**
 *
 * @author Mahmoud Ahmed
 */
public class UserController extends Controller
{
    public User user;
    public UserView userView;
    public UserDAO userDAO;

    public UserController() throws SQLException 
    {
        this.user = new User();
        this.userView = new UserView();
        this.userDAO = new UserDAO();
    }
    
    public void register(HashMap<String, String> _parameters) throws Exception
    {
        if(!_parameters.containsKey("full_name"))
        {
            userView.exception();
            throw new Exception("full_name key cannot be null");
        }
        
        if(!_parameters.containsKey("password"))
        {
            userView.exception();
            throw new Exception("password key cannot be null");
        }
        
        if(!_parameters.containsKey("email"))
        {
            userView.exception();
            throw new Exception("email key cannot be null");
        }
        
        if(!_parameters.containsKey("gender"))
        {
            userView.exception();
            throw new Exception("gender key cannot be null");
        }
        
        if(!_parameters.containsKey("country"))
        {
            userView.exception();
            throw new Exception("country key cannot be null");
        }
        
        if(!_parameters.containsKey("birthday"))
        {
            userView.exception();
            throw new Exception("birthday key cannot be null");
        }

        if(_parameters.get("password").length() < 7)
        {
            userView.exception();
            throw new Exception("password length cannot be less than 7 chars");
        }
        
        user.fullName = _parameters.get("full_name");
        user.email = _parameters.get("email");
        user.password = _parameters.get("password");
        user.gender = _parameters.get("gender");
        user.country = _parameters.get("country");
        user.birthday = _parameters.get("birthday");
        
        // User DAO
        userDAO.addUser(user);
        
        // User View
        userView.render(user);
    }
    
    public void login(HashMap<String, String> _parameters) throws Exception
    {
        if(_parameters == null)
        {
            throw new Exception("_parameters cannot be null");
        }
        
        if(!_parameters.containsKey("email"))
        {
            userView.exception();
            throw new Exception("email key cannot be null");
        }
        
        if(!_parameters.containsKey("password"))
        {
            userView.exception();
            throw new Exception("password key cannot be null");
        }
        
        user.email = _parameters.get("email");
        user.password = _parameters.get("password");

        User temp = userDAO.getUserByEmailAndPass(user.email, user.password);
        
        if(temp != null)
        {
            // User View
            userView.render(temp);
        }
        else
        {
            // User View
            userView.fail();
        }
    }
    
    public void sendFirendRequest(HashMap<String, String> _parameters) throws Exception
    {      
        User by = new User();
        User to = new User();
        
        if(!_parameters.containsKey("by"))
        {
            userView.exception();
            throw new Exception("by key cannot be null");
        }
        
        if(!_parameters.containsKey("to"))
        {
            userView.exception();
            throw new Exception("to key cannot be null");
        }
        
        by.userId = Integer.parseInt(_parameters.get("by"));
        to.userId = Integer.parseInt(_parameters.get("to"));
        
        by = userDAO.getUserById(by.userId);
        to = userDAO.getUserById(to.userId);
        
        if(by == null || to == null)
        {
            userView.fail();
            throw new Exception("user not found");
        }

        userDAO.addFriendById(by.userId, to.userId);
        userView.success();
    }
    
    public void acceptFirendRequest(HashMap<String, String> _parameters) throws Exception
    {      
        User by = new User();
        User to = new User();
        
        if(!_parameters.containsKey("by"))
        {
            userView.exception();
            throw new Exception("by key cannot be null");
        }
        
        if(!_parameters.containsKey("to"))
        {
            userView.exception();
            throw new Exception("to key cannot be null");
        }
        
        by.userId = Integer.parseInt(_parameters.get("by"));
        to.userId = Integer.parseInt(_parameters.get("to"));
        
        by = userDAO.getUserById(by.userId);
        to = userDAO.getUserById(to.userId);
        
        if(by == null || to == null)
        {
            userView.exception();
            throw new Exception("user not found");
        }
        
        // userDAO
        userDAO.updateFriendStatus(by.userId, to.userId);
        
        // userView
        userView.success();
    }
    
    public void upgradeToPremium(HashMap<String, String> _parameters) throws Exception
    {
        if(!_parameters.containsKey("user_id"))
        {
            userView.exception();
            throw new Exception("user_id key cannot be null");
        }
        
        user.userId = Integer.parseInt(_parameters.get("user_id"));
        
        User temp = userDAO.getUserById(user.userId);
        
        if(temp != null)
        {
            // User View
            userView.render(temp);
        }
        else
        {
            userView.exception();
            throw new Exception("user not found");
        }
        
        // Paid
        if(true)
        {
            temp.accountType = "premium";
        }

        userDAO.updateUser(temp);
    }
}
