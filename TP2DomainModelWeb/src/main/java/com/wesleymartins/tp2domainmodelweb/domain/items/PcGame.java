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
public class PcGame implements Serializable, Console {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
 private String consoleType;
    private String name;
    

    public String determineType() {
        return "PC";
    }
    
    public String getId() {
        return id;
    }

    public String getConsoleType() {
        return consoleType;
    }

    public String getName() {
        return name;
    }
    
     private PcGame(){}
    
        
 private PcGame(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private String id;
            private String name;
            
            public Builder(String id)
            {
                this.id = id;
            }
                        
        
        
        public Builder name(String value)
        {
            name = value;
            return this;
        }
        
        public PcGame build()
        {
        return new PcGame(this);
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
        if (!(object instanceof PcGame)) {
            return false;
        }
        PcGame other = (PcGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Items.PcGame[ id=" + id + " ]";
    }
    
}
