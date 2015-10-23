/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Membership;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.*;


/**
 *
 * @author HP
 */
@Default
@Stateless
public class MembershipJPABean implements MembershipBeanRemote{
    
    @PersistenceContext
    private EntityManager em;
    
    
    public void loadData(){
        Membership free = new Membership();
        free.setSubsId("free");
        free.setSubsType("free");
        free.setPricePerMonth(0);
        em.persist(free);
        
        Membership standard = new Membership();
        standard.setSubsId("standerd");
        standard.setSubsType("standerd");
        standard.setPricePerMonth(10);
        em.persist(standard);
        
        Membership premium = new Membership();
        premium.setSubsId("premium");
        premium.setSubsType("premium");
        premium.setPricePerMonth(20);
        em.persist(premium);
        
        Membership admin = new Membership();
        admin.setSubsId("admin");
        admin.setSubsType("admin");
        admin.setPricePerMonth(100);
        
        em.persist(admin);
        
        em.flush();
    }

    @Override
    public Membership get(String id) {
        return em.find(Membership.class, id);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Membership subscription) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
