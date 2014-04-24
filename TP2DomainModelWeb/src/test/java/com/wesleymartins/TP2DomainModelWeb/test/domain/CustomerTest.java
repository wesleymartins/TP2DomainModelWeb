/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.domain;

import com.wesleymartins.tp2domainmodelweb.domain.Customer.Customer;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Wesley
 */
public class CustomerTest {
    
    public static Customer service;
    public static Customer newService;
    
    
    public CustomerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void CustomerCreationTest()
     {
         service = new Customer.Builder("00012").fName("Wesley").build();
         Assert.assertEquals(service.getId(),"00012");
     }
     
     @Test
     public void CustomerUpdateTest()
     {
         newService = new Customer.Builder("00012").fName("John").build();
         Assert.assertEquals(newService.getId(),"00012",newService.getfName());
     }
     
     
     
     
     

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
        
        
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }
}