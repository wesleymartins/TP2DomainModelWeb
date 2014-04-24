/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.domain;

import com.wesleymartins.tp2domainmodelweb.domain.customer.StorePurchase;
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
public class testStorePurchase {
    
    public static StorePurchase service;
    public static StorePurchase newService;
    
    public testStorePurchase() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void StorePurchaseCreation()
    {
        service = new StorePurchase.Builder("0012").time("13:46").build();
        Assert.assertEquals(service.getId(),"00012",service.getTime());
    }
    
    @Test
    public void StorePurchaseUpdate() {
        
    newService = new StorePurchase.Builder("00012").time("14:56").build();
     Assert.assertEquals(newService.getId(),"00012",newService.getTime());
            
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