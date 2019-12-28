/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mahmoud Ahmed
 */
public class DBUtil 
{
    public static DBUtil instance;
    
    // Database URL
    public final String DB_URL = "jdbc:mysql://localhost:3306/graph_api?useSSL=false";

    // Database credentials
    public final String USERNAME = "root";
    public final String PASSWORD = "";
    
    // Connection is the session between java application and database
    private Connection connection;
    
    // The Statement interface provides methods to execute queries with the database
    public Statement statement;
    
    // The query string value to the database
    public String query;
    
    // The object of ResultSet maintains a cursor pointing to a row of a table
    public ResultSet resultSet;
    
    private DBUtil() throws SQLException 
    {
        try
        {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");  

            // Open a connection
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  
        }
        catch(Exception _ex)
        {
            System.out.println(_ex.getMessage());
        }
        
    }
    
    public Connection getConnection() 
    {
        return this.connection;
    }
    
    public static DBUtil getInstance() throws SQLException 
    {
        if(instance == null)
        {
            instance = new DBUtil();
        }
        else if(instance.getConnection().isClosed())
        {
            instance = new DBUtil();
        }
        
        return instance;
    }
    
    public ResultSet selectData(String _query) throws Exception
    {
        this.query = _query;
        
        // Creating statement
        this.statement = this.connection.createStatement();
        
        // Execute query
        this.resultSet = this.statement.executeQuery(_query);
        
        return this.resultSet;
    }
    
    public void executeCommand(String _query) throws Exception
    {
        this.query = _query;
        
        // Creating statement
        this.statement = this.connection.createStatement();
        
        // Execute query
        this.statement.executeUpdate(_query);
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
