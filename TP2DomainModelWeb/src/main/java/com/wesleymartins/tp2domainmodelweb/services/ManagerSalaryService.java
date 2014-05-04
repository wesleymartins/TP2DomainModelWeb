/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services;

import com.wesleymartins.tp2domainmodelweb.domain.staff.Manager;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface ManagerSalaryService {
    
      public List<Manager> getManagerSalary(double i);
      
}
