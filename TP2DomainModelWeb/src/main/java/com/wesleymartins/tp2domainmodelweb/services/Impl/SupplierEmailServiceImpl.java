/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services.Impl;

import com.wesleymartins.tp2domainmodelweb.domain.other.Supplier;
import com.wesleymartins.tp2domainmodelweb.repository.SupplierRepository;
import com.wesleymartins.tp2domainmodelweb.services.SupplierEmailService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Wesley
*/
@Service
public class SupplierEmailServiceImpl implements SupplierEmailService{

    @Autowired
    private SupplierRepository accessoryRepository;
    
    
    public List<Supplier> getSupplierEmail(String i) {
       List<Supplier> supplier = new ArrayList<>();
        List<Supplier> allSuppliers =accessoryRepository.findAll();

        for (Supplier person : allSuppliers) {
            if (i.equals(person.getEmail())) {
                supplier.add(person);
            }
        }
        return supplier;
    
        
    }
    
}