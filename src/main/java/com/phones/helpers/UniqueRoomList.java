/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.helpers;

import com.phones.entity.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author trunov_as
 */
public class UniqueRoomList {
    private String name;
        
    private List<String> list = new ArrayList<>();
   
    
    public UniqueRoomList(List<Contact> cList){
        for(Contact c :cList){
            list.add(c.getRoom());
        }
        
        Set<String> s = new HashSet<>(list);
        list = new ArrayList<>(s);
        
        
    }
        
    
    
    
    public UniqueRoomList(){}
    
    public List<String> getUniqueRoomList(){
        return list; 
    }
        
    

    public String getName() {
        return name;
    }

    
    
    
    
    
}
