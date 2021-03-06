/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import models.User;

import java.sql.SQLException;

/**
 *
 * @author Mahmoud Ahmed
 */
public class UserDAO 
{
    public DBUtil db;
    
    public UserDAO() throws SQLException
    {
        
        db = DBUtil.getInstance();
        
    }
    public void addUser(User _user)
    {
        try
        {
            db.executeCommand("INSERT INTO `users`(`email`, `password`, `gender`, `country`, `birthday`) "
                               + "VALUES ('" + _user.email + "', '" + _user.password + "', '" + _user.gender + "', '" + _user.country + "', '" + _user.birthday + "')");
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
    }
    
    public void addFriendById(int _by, int _to)
    {
        try
        {
            db.executeCommand("INSERT INTO `friendships`(`by`, `to`) VALUES ('" + _by + "', '" + _to + "')");
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
    }
    
    public void updateFriendStatus(int _by, int _to)
    {
        try
        {
            db.executeCommand("UPDATE `friendships` SET `status`= '" + 1 + "' WHERE `by`='" + _by + "' AND `to`='" + _to + "' ");
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
    }
    
    public void updateUser(User _user)
    {
        try
        {
            db.executeCommand("UPDATE `users` SET " + 
                                "`email`='" + _user.email + 
                                "',`password`='" + _user.password + 
                                "',`gender`='" + _user.gender + 
                                "',`country`='" + _user.country + 
                                "',`account_type`='" + _user.accountType + 
                                "',`birthday`='" + _user.birthday + 
                                "' WHERE `user_id`='" + _user.userId + "'");
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
    }
    
    public User getUserByEmailAndPass(String _email, String _password)
    {
        User user = new User();
        
        try
        {
            db.resultSet = db.selectData("SELECT * FROM `users` WHERE `email` = '" + _email + "' AND `password` = '" + _password + "' LIMIT 1");
            
            if(db.resultSet.next()) 
            {
                user.userId = db.resultSet.getInt(1);
                user.email = db.resultSet.getString(2);
                user.password = db.resultSet.getString(3);
                user.gender = db.resultSet.getString(4);
                user.country = db.resultSet.getString(5);
                user.accountType = db.resultSet.getString(6);
                user.birthday = db.resultSet.getString(7);
            }
            else
            {
                user = null;
            }
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
        
        return user;
    }
    
    public User getUserById(int _userId)
    {
        User user = new User();
        
        try
        {
            db.resultSet = db.selectData("SELECT * FROM `users` WHERE `user_id` = '" + _userId + "' LIMIT 1");
            
            if(db.resultSet.next()) 
            {
                user.userId = db.resultSet.getInt(1);
                user.email = db.resultSet.getString(2);
                user.password = db.resultSet.getString(3);
                user.gender = db.resultSet.getString(4);
                user.country = db.resultSet.getString(5);
                user.accountType = db.resultSet.getString(6);
                user.birthday = db.resultSet.getString(7);
            }
            else
            {
                user = null;
            }
        } 
        catch(Exception _ex) 
        {
            System.err.println(_ex);
        }
        
        return user;
    }
    
    
}
