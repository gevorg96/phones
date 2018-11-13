/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.ldap.domain.dao;

import com.phones.ldap.domain.Person;
import java.util.List;
import javax.naming.Name;
import javax.naming.ldap.LdapName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.query.LdapQuery;
import static org.springframework.ldap.query.LdapQueryBuilder.query;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class PersonLdapDAOImpl implements PersonLdapDAO{

    @Autowired
    private LdapTemplate ldapTemplate;
    
    @Override
    public void update(Person person) {
        Name dn = buildDn(person);
        DirContextOperations context  = ldapTemplate.lookupContext(dn);
        context.setAttributeValue("telephonenumber", person.getTelephone());
        ldapTemplate.modifyAttributes(context);
    }

    @Override
    public List<Person> getAll() {
        LdapQuery lq = query().base(LdapUtils.emptyLdapName()).where("objectclass").is("person");
        return ldapTemplate.search(lq, PERSON_CONTEXT_MAPPER);
    }
    
    private LdapName buildDn(Person person){
        return buildDn(person.getOu(), person.getCn());
    }
    
    private LdapName buildDn(String ou, String cn){
        return LdapNameBuilder.newInstance().add("ou", ou).add("cn",cn).build();
    }
    
    
    @Override
    public Person findBy(String ou, String cn){
        LdapName dn = buildDn(ou, cn);
        return ldapTemplate.lookup(dn, PERSON_CONTEXT_MAPPER);
    }
    
    
    
    
    
    private final static ContextMapper<Person> PERSON_CONTEXT_MAPPER = new AbstractContextMapper<Person>() {
        @Override
        protected Person doMapFromContext(DirContextOperations dco) {
            Person person = new Person();
            LdapName dn = LdapUtils.newLdapName(dco.getDn());
            person.setCn(dco.getStringAttribute("cn"));
            person.setOu(LdapUtils.getStringValue(dn, 0));
            person.setTelephone(dco.getStringAttribute("telephonenumber"));
            person.setName(dco.getStringAttribute("displayname"));
            return person;
        }
    };
    
}
