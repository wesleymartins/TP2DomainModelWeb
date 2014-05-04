/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services.Impl;

import com.wesleymartins.tp2domainmodelweb.domain.staff.Manager;
import com.wesleymartins.tp2domainmodelweb.repository.ManagerRepository;
import com.wesleymartins.tp2domainmodelweb.services.ManagerSalaryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Wesley
*/
@Service
public class ManagerSalaryServiceImpl implements ManagerSalaryService{

    @Autowired
    private ManagerRepository accessoryRepository;
    
    
    public List<Manager> getManagerSalary(double i) {
       List<Manager> manager = new ArrayList<>();
        List<Manager> allManagers =accessoryRepository.findAll();

        for (Manager person : allManagers) {
            if (person.getSalary() == i) {
                manager.add(person);
            }
        }
        return manager;
    
        
    }
    
}