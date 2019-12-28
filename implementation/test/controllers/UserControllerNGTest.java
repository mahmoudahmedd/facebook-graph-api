/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashMap;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Mahmoud Ahmed
 */
public class UserControllerNGTest {
    
    public UserControllerNGTest() {
    }

    /**
     * Test of register method, of class UserController.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        HashMap<String, String> _parameters = null;
        UserController instance = new UserController();
        instance.register(_parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserController.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        HashMap<String, String> _parameters = null;
        UserController instance = new UserController();
        instance.login(_parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendFirendRequest method, of class UserController.
     */
    @Test
    public void testSendFirendRequest() throws Exception {
        System.out.println("sendFirendRequest");
        HashMap<String, String> _parameters = null;
        UserController instance = new UserController();
        instance.sendFirendRequest(_parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptFirendRequest method, of class UserController.
     */
    @Test
    public void testAcceptFirendRequest() throws Exception {
        System.out.println("acceptFirendRequest");
        HashMap<String, String> _parameters = null;
        UserController instance = new UserController();
        instance.acceptFirendRequest(_parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of upgradeToPremium method, of class UserController.
     */
    @Test
    public void testUpgradeToPremium() throws Exception {
        System.out.println("upgradeToPremium");
        HashMap<String, String> _parameters = null;
        UserController instance = new UserController();
        instance.upgradeToPremium(_parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
