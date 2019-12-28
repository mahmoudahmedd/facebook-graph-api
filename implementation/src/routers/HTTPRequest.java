/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routers;

import java.util.HashMap;

/**
 *
 * @author Mahmoud Ahmed
 */
public class HTTPRequest
{
    public HashMap<String, String> parameters;
    public String object;
    public String method;
    
    public HTTPRequest()
    {
        this.parameters = new HashMap<String, String>();
        this.object = new String();
        this.method = new String();
    }
}
