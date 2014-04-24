/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.domain;

import com.wesleymartins.tp2domainmodelweb.domain.customer.Cash;
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
public class testCash {
    
    public static Cash service;
    public static Cash newService;
    
    public testCash() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void CashCreation()
    {
     service = new Cash.Builder("00012").cashTendered(100.00).build();
     Assert.assertEquals(service.getId(),"00012");
    }
    
    @Test
    public void CashUpdate() {
        
     newService = new Cash.Builder("00012").cashTendered(150.00).build();
     Assert.assertEquals(newService.getId(),"00012");
     Assert.assertEquals(newService.getCashTendered(),150.00);
            
    }


    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}