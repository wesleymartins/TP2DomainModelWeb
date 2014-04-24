/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.domain;

import com.wesleymartins.tp2domainmodelweb.domain.customer.Credit;
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
public class testCredit {
    
    public static Credit service;
    public static Credit newService;
    
    public testCredit() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void creditCreation() {
        
    service = new Credit.Builder("00012").type("check").build();
     Assert.assertEquals(service.getId(),"00012",service.getType());
            
    }
    
    @Test
    public void creditUpdate() {
        
    newService = new Credit.Builder("00012").type("savings").build();
     Assert.assertEquals(newService.getId(),"00012",newService.getType());
            
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

   