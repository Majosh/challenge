package com.majosh.challenge;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.opencsv.CSVReader;

public class TechnicalTest {
	private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
       
    private static SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
         
        Properties properties = configuration.getProperties();
         
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
         
        return sessionFactory;  
    }
    
	public static void main(String[] args) {
		
		CSVReader reader = null;
		
		configureSessionFactory();
        
        Session session = null;
        Transaction tx=null;
        
		try {
			session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
			reader = new CSVReader(
					new FileReader(
							new File(
									TechnicalTest.class.getResource("csvfiles/sampleCSVData.csv").toURI())));
//			FileWriter fw = new FileWriter(new File(
//					TechnicalTest.class.getResource("csvfiles/bad-data-"+new Date(System.currentTimeMillis()).toString() +".csv").toURI()));
//			PrintWriter out = new PrintWriter(fw);

			String [] line;
			
			while((line = reader.readNext()) != null && line.length > 1) {
				
				if(line.length < 10 || line.length> 10) {
					System.err.print("\nLine: ");
					for(String l: line)
					{
						System.err.print(" " + l);
					}
				}
				else {
					Xtable row = new Xtable(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9]);
					row.cleanComma();
					
					if(row.isAllFieldsValid()) {
						session.save(row);
						System.out.println("Row saved : " + row);
					}else {
						System.err.println("Row not saved " + row);
					}
				}
			}

			session.flush();
			tx.commit();
//			 Fetching saved data
            List<Xtable> xList = (List<Xtable>) session.createQuery("from Xtable").list();
             
            for (Xtable x: xList) {
                System.out.println( " | columnA:"  + x.getColumnA());
            }
		} catch(IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if(session != null ) {
				//session.close();
			}
		}
		
		
	}

	public static void createNewDatabase(String fileName) {
		
    }
}
