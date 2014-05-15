/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.other;

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
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    private Supplier(){}
    
        
 private Supplier(Builder builder){
     id = builder.id;
     name = builder.name;
     email = builder.email;
 }
 
 
        public static class Builder
        {
            private Long id;
            private String name;
            private String email;
            
            public Builder(String name)
            {
                this.name = name;
            }
                        
        
        
        public Builder name(String value)
        {
            name = value;
            return this;
        }
        
        public Builder e(String value)
        {
            email = value;
            return this;
        }
        
        public Supplier build()
        {
        return new Supplier(this);
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.other.Supplier[ id=" + id + " ]";
    }
    
}
