/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.ldap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;


@Entry(objectClasses = {"contact","organizationalPerson","person","top"}, base = "OU=sudy, OU=_phonebook")
public class ContactEntry {
    @Id
    @JsonIgnore
    private Name dn;
    
    @Attribute(name = "cn")
    @DnAttribute(value = "cn", index = 2)
    private String cn;
    
    @Attribute(name = "sn")
    private String sn;
    
    @Attribute(name = "givenName")
    private String givenName;

    @Attribute(name = "company")
    private String company;
    
    @Attribute(name = "description")
    private String description;
    
    @Attribute(name = "displayName")
    private String displayName;
    
    @Attribute(name = "mail")
    private String mail;
   
    @Attribute(name = "telephoneNumber")
    private String telephoneNumber;
    
    @Attribute(name = "title")
    private String post;
    

    public ContactEntry() {
    }

    public ContactEntry(String cn, String sn, String givenName, String company, String description, String displayName, String mail, String telephoneNumber, String post) {
        this.cn = cn;
        this.sn = sn;
        this.givenName = givenName;
        this.company = company;
        this.description = description;
        this.displayName = displayName;
        this.mail = mail;
        this.telephoneNumber = telephoneNumber;
        this.post = post;
    }

   

    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "ContactEntry{" + "dn=" + dn + ", cn=" + cn + ", sn=" + sn + ", givenName=" + givenName + ", company=" + company + ", description=" + description + ", displayName=" + displayName + ", mail=" + mail + ", telephoneNumber=" + telephoneNumber + ", post=" + post + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.dn);
        hash = 41 * hash + Objects.hashCode(this.cn);
        hash = 41 * hash + Objects.hashCode(this.sn);
        hash = 41 * hash + Objects.hashCode(this.givenName);
        hash = 41 * hash + Objects.hashCode(this.company);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.displayName);
        hash = 41 * hash + Objects.hashCode(this.mail);
        hash = 41 * hash + Objects.hashCode(this.telephoneNumber);
        hash = 41 * hash + Objects.hashCode(this.post);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactEntry other = (ContactEntry) obj;
        if (!Objects.equals(this.cn, other.cn)) {
            return false;
        }
        if (!Objects.equals(this.sn, other.sn)) {
            return false;
        }
        if (!Objects.equals(this.givenName, other.givenName)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.displayName, other.displayName)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.telephoneNumber, other.telephoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.dn, other.dn)) {
            return false;
        }
        return true;
    }

    
}