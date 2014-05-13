/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services.Impl;

import com.wesleymartins.tp2domainmodelweb.domain.items.Accessory;
import com.wesleymartins.tp2domainmodelweb.repository.AccessoryRepository;
import com.wesleymartins.tp2domainmodelweb.services.AccessoryTypeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Wesley
*/
@Service
public class AccessoryTypeServiceImpl implements AccessoryTypeService{

    @Autowired
    private AccessoryRepository accessoryRepository;
    
    
    public List<Accessory> getAccessoryType(String i) {
       List<Accessory> cust = new ArrayList<>();
        List<Accessory> allAccessorys =accessoryRepository.findAll();

        for (Accessory person : allAccessorys) {
            if (i.equals(person.getType())) {
                cust.add(person);
            }
        }
        return cust;
    
        
    }
    
}