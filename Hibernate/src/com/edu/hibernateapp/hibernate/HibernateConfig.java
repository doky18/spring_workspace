package com.edu.hibernateapp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryRegistry;

public class HibernateConfig {
	private static HibernateConfig instance;
	private SessionFactory sessionFactory;
	String resource="com/edu/hibernateapp/hibernate/hibernate.cfg.xml";		//설정파일 위치 알려주기
	
	private HibernateConfig() {
		//설정 xml을 읽기
		Configuration config = new Configuration().configure(resource);
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties()); 	//(설정맵)
		//이제 xml을 설정을 서비스레지스트리가 인식함
		
		StandardServiceRegistry registry = sb.build();
		sessionFactory = config.buildSessionFactory(registry);
		
	}
	
	public static HibernateConfig getInstance() {
		
		if(instance == null) {
			instance = new HibernateConfig();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//팩토리 반납
    public void release(SessionFactory sessionFactory) {
        sessionFactory.close();
    }
}
