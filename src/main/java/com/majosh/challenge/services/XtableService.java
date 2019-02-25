package com.majosh.challenge.services;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.majosh.challenge.Xtable;

public class XtableService {
	private SessionFactory sessionFactory = null;  
    private ServiceRegistry serviceRegistry = null;  
    private Session session;
    private Transaction transaction;
    
    public SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
        
        Properties properties = configuration.getProperties();
         
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        

        session = null;
        transaction=null;
        
        return sessionFactory;  
    }
    
    public boolean startTransaction() {

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
        
    	return true;
    }
    
    public boolean saveRecord(Xtable xtable) {
    	try {
    		session.save(xtable);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean commitTransaction() {
    	try {
			session.flush();
			transaction.commit();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
}
