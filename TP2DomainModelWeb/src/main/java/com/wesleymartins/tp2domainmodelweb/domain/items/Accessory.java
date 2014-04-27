/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.items;

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
public class Accessory implements Serializable, Console {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 private String name;
    private String type;
    
    public String determineType() {
         if(type=="1")
        type = "Xbox 360";
        else if(type=="2")
            type = "XboxOne";
        else if(type=="3")
            type = "PC";
        return type;
       
    }
    
     public Long getId() {
        return id;
    }

    public String getConsoleType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
     private Accessory(){}
    
        
 private Accessory(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private Long id;
            private String name;
            
            public Builder(String name)
            {
                this.name = name;
            }
                        
        
        
        public Builder name(String value)
        {
            name = value;
            return this;
        }
        
        public Accessory build()
        {
        return new Accessory(this);
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
        if (!(object instanceof Accessory)) {
            return false;
        }
        Accessory other = (Accessory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Items.Accessory[ id=" + id + " ]";
    }
   
   }
}
