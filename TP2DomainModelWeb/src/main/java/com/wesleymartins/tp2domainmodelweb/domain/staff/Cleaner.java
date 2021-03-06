/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.staff;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Wesley
 */
@Entity
public class Cleaner implements Serializable, Employee {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private double salary;
    private final String jobType = "Cleaner";

    public double getSalary() {
        return salary;
    }
       
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJobType() {
        return jobType;
    }
    
     private Cleaner(){}
    
        
 private Cleaner(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private Long id;
            private String name;
            
            public Builder(Long id)
            {
                this.id = id;
            }
                        
        
        
        public Builder name(String value)
        {
            name = value;
            return this;
        }
        
        public Cleaner build()
        {
        return new Cleaner(this);
        }
    
}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cleaner)) {
            return false;
        }
        Cleaner other = (Cleaner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Staff.Cleaner[ id=" + id + " ]";
    }
    
}
