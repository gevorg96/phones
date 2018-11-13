/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phones.DAO.implementation;

import com.phones.DAO.PoolDAO;
import com.phones.entity.Contact;
import com.phones.entity.ContactType;
import com.phones.entity.Person;
import com.phones.entity.Pool;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import oracle.jdbc.rowset.OracleJDBCRowSet;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trunov_as
 */
@Repository
public class PoolDAOImpl implements PoolDAO{
   
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Pool> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Pool p").list();
    }

    
    @Override
    public Pool getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Pool pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pool pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getContactList(final Long id) {
       
      return sessionFactory.getCurrentSession().doReturningWork(new ReturningWork<List<Contact>>() {
          @Override
          public List<Contact> execute(Connection cnctn) throws SQLException {
              
              List<Contact> list = new ArrayList<>();
              
              String sql = "SELECT ID, CONTACT FROM table (phonepac.GetNumberList(?))";
              PreparedStatement statement = cnctn.prepareStatement(sql);
              statement.setLong(1, id);
              
              ResultSet rs = statement.executeQuery();
              
              while (rs.next()) {                  
                  Contact cn = new Contact();
                  cn.setId(rs.getLong("ID"));
                  cn.setContact(rs.getString("CONTACT"));
                  list.add(cn);
              }
              
              return list;
          }
      });
    }
    
    @Override
    public List<Contact> getFreeContactByPool(final Long id) {
       
      return sessionFactory.getCurrentSession().doReturningWork(new ReturningWork<List<Contact>>() {
          @Override
          public List<Contact> execute(Connection cnctn) throws SQLException {
              
              List<Contact> list = new ArrayList<>();
              
              String sql = "SELECT ID, CONTACT FROM table (phonepac.GetNumberList(?)) a WHERE a.person_id is null or a.id is null";
              PreparedStatement statement = cnctn.prepareStatement(sql);
              statement.setLong(1, id);
              
              ResultSet rs = statement.executeQuery();
              
              while (rs.next()) {                  
                  Contact cn = new Contact();
                  cn.setId(rs.getLong("ID"));
                  cn.setContact(rs.getString("CONTACT"));
                  list.add(cn);
              }
              return list;
          }
      });
    }
}
