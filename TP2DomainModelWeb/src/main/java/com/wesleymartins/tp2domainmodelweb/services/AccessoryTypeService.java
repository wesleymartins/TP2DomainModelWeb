/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services;

import com.wesleymartins.tp2domainmodelweb.domain.items.Accessory;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface AccessoryTypeService {
    
     public List<Accessory> getAccessoryType(String i);
}
