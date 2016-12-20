package cn.hjycjc.spring.hibernate;

import java.sql.Date;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.hjycjc.spring.hibernate.helloworld.News;
import cn.hjycjc.spring.hibernate.helloworld.News2;


public class TestApp {
	
	//@Test
	public void test(){
//		1.新建SessionFactory
		SessionFactory sessionFactory=null;
//		1.1创建Configuration对象：对应hibernate的基本配置信息和对象关系映射信息
		
/*		public Configuration configure() throws HibernateException {
			configure( "/hibernate.cfg.xml" );
			return this;
		}*/
		Configuration configuration = new Configuration().configure();
//		1.2hibernate4.0之前可以直接用
//		configuration.buildSessionFactory();
//		现在要注册serviceRegistry
		
		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																						   .buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//		2.打开Session
		Session session=sessionFactory.openSession();
	
//		3.开启事务
		Transaction transaction =session.beginTransaction();
		
//		4.执行操作
//		SQL或业务逻辑
		String title ="hadoop";
		String author="hadoop";
		Date date =new Date(new java.util.Date().getTime());
		News news =new News(title, author, date);
		
		session.save(news);
//		5.提交事务
		transaction.commit();
//		6.关闭session
		session.close();
//		7.关闭sessionFactory
		sessionFactory.close();
	}
	
	//@Test
	public void test2(){

		SessionFactory sessionFactory=null;
/*		public Configuration configure() throws HibernateException {
			configure( "/hibernate.cfg.xml" );
			return this;
		}*/
		Configuration configuration = new Configuration().configure();	
		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																						   .buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
	
		Transaction transaction =session.beginTransaction();
		
//		4.执行操作
//		SQL或业务逻辑
		String title ="hadoop";
		String author="hadoop";
		Date date =new Date(new java.util.Date().getTime());
		News2 news2 =new News2(title, author, date);
		
		session.save(news2);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//@Test
	public void testfindObject(){

		SessionFactory sessionFactory=null;
/*		public Configuration configure() throws HibernateException {
			configure( "/hibernate.cfg.xml" );
			return this;
		}*/
		Configuration configuration = new Configuration().configure();	
		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																						   .buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
	
		Transaction transaction =session.beginTransaction();
		
//		4.执行操作
//		SQL或业务逻辑
		Integer id=1;
		Class<News> clazz =News.class;
		News news=(News) session.get(clazz, id);
		
		System.out.println(news);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@After
	public void destroy(){
		System.out.println("destroy:...");
	}
	@Before
	public void init(){
		System.out.println("init:...");
	}

	@Test
	public void test3(){
		SessionFactory sessionFactory=null;
		/*		public Configuration configure() throws HibernateException {
					configure( "/hibernate.cfg.xml" );
					return this;
				}*/
				Configuration configuration = new Configuration().configure();	
				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
																								   .buildServiceRegistry();
				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
				Session session=sessionFactory.openSession();
			
				Transaction transaction =session.beginTransaction();
				
//				4.执行操作
//				SQL或业务逻辑

				
				transaction.commit();
				session.close();
				sessionFactory.close();
	}

}
