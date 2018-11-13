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
@Table(name="NUMBERPOOLS")
public class Pool implements Serializable {
    private Long id;
    private String lowbound;
    private String highbound;
    private String poolname;
    private String commentaries;
    private ContactType phonetype;
    private static final long serialVersionUID = -1798070786993154676L; 
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLowbound() {
        return lowbound;
    }

    public void setLowbound(String lowbound) {
        this.lowbound = lowbound;
    }

    public String getHighbound() {
        return highbound;
    }

    public void setHighbound(String highbound) {
        this.highbound = highbound;
    }

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    public String getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(String commentaries) {
        this.commentaries = commentaries;
    }
    
    @ManyToOne
    @JoinColumn(name = "phonetype")
    public ContactType getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(ContactType phonetype) {
        this.phonetype = phonetype;
    }
  
    
}
