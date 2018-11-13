/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trunov_as
 */
@Entity
@Table(name = "Organizations")
public class Organization implements Serializable{
    private Long id;
    private String name;
    private Long parentId;
    private Regions region;
    private OrganizationType type;
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }
    
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    public OrganizationType getType() {
        return type;
    }

    
    public void setType(OrganizationType type) {
        this.type = type;
    }
    
    
}
