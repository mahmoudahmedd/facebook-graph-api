/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Mahmoud Ahmed
 */
public class DBUtil 
{
    // Connection is the session between java application and database
    public static Connection connection;
    
    // The Statement interface provides methods to execute queries with the database
    public static Statement statement;
    
    // The query string value to the database
    public static String query;
    
    // The object of ResultSet maintains a cursor pointing to a row of a table
    public static ResultSet resultSet;
    
    private DBUtil() {}
    
    public static Connection getConnection() 
    {
        if(DBUtil.connection != null)
        {
            return DBUtil.connection;
        }
        else
        {
            // Database URL
            final String DB_URL = "jdbc:mysql://localhost:3306/graph_api?useSSL=false";

            // Database credentials
            final String USERNAME = "root";
            final String PASSWORD = "";;
            
            try
            {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");  
            
                // Open a connection
                DBUtil.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  
            }
            catch(Exception _ex)
            {
                System.out.println(_ex.getMessage());
            }

            return DBUtil.connection;
        }
    }
    
    public static ResultSet selectData(String _query) throws Exception
    {
        DBUtil.getConnection();
        
        DBUtil.query = _query;
        
        // Creating statement
        DBUtil.statement = DBUtil.connection.createStatement();
        
        // Execute query
        DBUtil.resultSet = DBUtil.statement.executeQuery(_query);
        
        return DBUtil.resultSet;
    }
    
    public static void executeCommand(String _query) throws Exception
    {
        DBUtil.getConnection();
        
        DBUtil.query = _query;
        
        // Creating statement
        DBUtil.statement = DBUtil.connection.createStatement();
        
        // Execute query
        DBUtil.statement.executeUpdate(_query);
    }
    
    @Override
    public void finalize() throws Throwable
    {
        try 
        {
            // Clean-up environment
            this.resultSet.close();
            this.statement.close();
            this.connection.close();
        } 
        finally 
        {
            super.finalize();
        }
    }
    
}
