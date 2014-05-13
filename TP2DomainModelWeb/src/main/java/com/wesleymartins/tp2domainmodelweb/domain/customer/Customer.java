/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.customer;

import java.io.Serializable;
import java.util.Locale.Builder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 212022261
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String surname;
    private int age;

    
    public Customer() {
    }
    
    
        
 private Customer(Builder builder){
     id = builder.id;
     fName = builder.fName;
     surname = builder.surname;
     age = builder.age;
     
 }
 
 
        public static class Builder
        {
            private Long id;
            private String fName;
            private String surname;
            private int age;
            
            public Builder(String firstName)
            {
                this.fName = firstName;
            }
            
             public Builder surname(String sur)
            {
                surname = sur;
                return this;
            }
             
              public Builder age(int a)
            {
                age = a;
                return this;
            }
              
              
                        
        
        
        public Builder id(Long value)
        {
            id = value;
            return this;
        }
        
        public Customer build()
        {
        return new Customer(this);
        }
        
        
}

    public String getfName() {
        return fName;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Customer.Customer[ id=" + id + " ]";
    }
    
}
