package cn.hjycjc.spring.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import cn.hjycjc.spring.hibernate.helloworld.n21.both.Customer;
import cn.hjycjc.spring.hibernate.helloworld.n21.both.Order;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Blob;

import cn.hjycjc.spring.hibernate.helloworld.News;
import cn.hjycjc.spring.hibernate.helloworld.News2;
import cn.hjycjc.spring.hibernate.helloworld.News3;
import cn.hjycjc.spring.hibernate.helloworld.Pay;
import cn.hjycjc.spring.hibernate.helloworld.Worker;


public class TestApp {
	
//	@Test
//	public void test() throws IOException{
////		1.新建SessionFactory
//		SessionFactory sessionFactory=null;
////		1.1创建Configuration对象：对应hibernate的基本配置信息和对象关系映射信息
//		
///*		public Configuration configure() throws HibernateException {
//			configure( "/hibernate.cfg.xml" );
//			return this;
//		}*/
//		Configuration configuration = new Configuration().configure();
////		1.2hibernate4.0之前可以直接用
////		configuration.buildSessionFactory();
////		现在要注册serviceRegistry
//		
//		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																						   .buildServiceRegistry();
//		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
////		2.打开Session
//		Session session=sessionFactory.openSession();
//	
////		3.开启事务
//		Transaction transaction =session.beginTransaction();
//		
////		4.执行操作
////		SQL或业务逻辑
//		News news =new News();
//		news.setAuthor("cc");
//		news.setTitle("CC");
//		Date date =new Date(new java.util.Date().getTime());
//		news.setDate(date);
//	
//		
//		InputStream stream = new FileInputStream("Navicat.png");
//		Blob img =(Blob) Hibernate.getLobCreator(session).createBlob(stream, stream.available());
//		
//		news.setImg(img);
//		
//		session.save(news);
//		
////		5.提交事务
//		transaction.commit();
////		6.关闭session
//		session.close();
////		7.关闭sessionFactory
//		sessionFactory.close();
//	}
//	
//	//@Test
//	public void test2(){
//
//		SessionFactory sessionFactory=null;
///*		public Configuration configure() throws HibernateException {
//			configure( "/hibernate.cfg.xml" );
//			return this;
//		}*/
//		Configuration configuration = new Configuration().configure();	
//		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																						   .buildServiceRegistry();
//		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//		Session session=sessionFactory.openSession();
//	
//		Transaction transaction =session.beginTransaction();
//		
////		4.执行操作
////		SQL或业务逻辑
//		String title ="hadoop";
//		String author="hadoop";
//		Date date =new Date(new java.util.Date().getTime());
//		News2 news2 =new News2(title, author, date);
//		
//		session.save(news2);
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//	}
//	
//	//@Test
//	public void testfindObject(){
//
//		SessionFactory sessionFactory=null;
///*		public Configuration configure() throws HibernateException {
//			configure( "/hibernate.cfg.xml" );
//			return this;
//		}*/
//		Configuration configuration = new Configuration().configure();	
//		org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																						   .buildServiceRegistry();
//		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//		Session session=sessionFactory.openSession();
//	
//		Transaction transaction =session.beginTransaction();
//		
////		4.执行操作
////		SQL或业务逻辑
//		Integer id=1;
//		Class<News> clazz =News.class;
//		News news=(News) session.get(clazz, id);
//		
//		System.out.println(news);
//		
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//	}
//	
//	@After
//	public void destroy(){
//		System.out.println("destroy:...");
//	}
//	@Before
//	public void init(){
//		System.out.println("init:...");
//	}
//
//	@Test
//	public void test3(){
//		SessionFactory sessionFactory=null;
//		/*		public Configuration configure() throws HibernateException {
//					configure( "/hibernate.cfg.xml" );
//					return this;
//				}*/
//				Configuration configuration = new Configuration().configure();	
//				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																								   .buildServiceRegistry();
//				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//				Session session=sessionFactory.openSession();
//			
//				Transaction transaction =session.beginTransaction();
//				
////				4.执行操作
////				SQL或业务逻辑
//				
//				News3 news3 =(News3) session.get(News3.class, 1);
//				System.out.println(news3);
//				//只执行了一次SQL语句，由于Hibernate的缓存机制
//				News3 news32 = (News3) session.get(News3.class, 1);
//				System.out.println(news32);
//				
//				transaction.commit();
//				session.close();
//				sessionFactory.close();
//	}
//	@Test
//	public void test4(){
//		SessionFactory sessionFactory=null;
//		/*		public Configuration configure() throws HibernateException {
//					configure( "/hibernate.cfg.xml" );
//					return this;
//				}*/
//				Configuration configuration = new Configuration().configure();	
//				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																								   .buildServiceRegistry();
//				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//				Session session=sessionFactory.openSession();
//			
//				Transaction transaction =session.beginTransaction();
//				
////				4.执行操作
////				SQL或业务逻辑
//				
//				News3 news3 =(News3) session.get(News3.class, 1);
//				System.out.println(news3);
//				news3.setAuthor("man");
//				//缓存中和数据库中的对象(记录)不相同，Hibernate在提交事务前会执行flush()方法；为了实现ORM框架：
//				//操作对象相当于操作数据库记录。
//				/*
//				 * 也可以显示执行flush();
//				 */
//				//flush()是为了让记录和对象保持一致，可能会执行SQL update
//				session.flush();
//				//flush()方法会被隐式调用，在执行 HQL及QBC查询时，因为是保证在事务范围内是最新的。
//				//由于OID是数据库自己自增生成的所以在事务提交之前会插入数据库。
//				
//				transaction.commit();
//				session.close();
//				sessionFactory.close();
//	}
//	
//	@Test
//	public void testDoWork(){
//		SessionFactory sessionFactory=null;
//		/*		public Configuration configure() throws HibernateException {
//					configure( "/hibernate.cfg.xml" );
//					return this;
//				}*/
//				Configuration configuration = new Configuration().configure();	
//				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																								   .buildServiceRegistry();
//				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//				Session session=sessionFactory.openSession();
//			
//				Transaction transaction =session.beginTransaction();
//				
////				4.执行操作
////				SQL或业务逻辑
//				session.doWork(new Work() {
//					
//					@Override
//					public void execute(Connection connection) throws SQLException {
//						System.out.println(connection);
//						
//					}
//				});
//				
//				transaction.commit();
//				session.close();
//				sessionFactory.close();
//	}
//	
//	@Test
//	public void test6(){
//		SessionFactory sessionFactory=null;
//		/*		public Configuration configure() throws HibernateException {
//					configure( "/hibernate.cfg.xml" );
//					return this;
//				}*/
//				Configuration configuration = new Configuration().configure();	
//				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																								   .buildServiceRegistry();
//				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//				Session session=sessionFactory.openSession();
//			
//				Transaction transaction =session.beginTransaction();
//				
////				4.执行操作
////				SQL或业务逻辑
//				Worker worker =new Worker();
//				worker.setName("张三");
//				Pay pay =new Pay();
//				pay.setmPay(1000);
//				pay.setyPay(90000);
//				pay.setVocationWithPay(5);
//				worker.setPay(pay);
//				
//				session.save(worker);
//				
//				transaction.commit();
//				session.close();
//				sessionFactory.close();
//	}
//	
//	@Test
//	public void testN21(){
//		SessionFactory sessionFactory=null;
//		/*		public Configuration configure() throws HibernateException {
//					configure( "/hibernate.cfg.xml" );
//					return this;
//				}*/
//				Configuration configuration = new Configuration().configure();	
//				org.hibernate.service.ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//																								   .buildServiceRegistry();
//				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//				Session session=sessionFactory.openSession();
//			
//				Transaction transaction =session.beginTransaction();
				
//				4.执行操作
//				SQL或业务逻辑
				
//				两种方法：				
				
//				Customer customer=new Customer();
//				customer.setCustomerName("AA");
//				
//				Order order=new Order();
//				
//				order.setOrderName("Order-1");
//				order.setCustomer(customer);
//				
//				Order order2 =new Order();
//				order2.setOrderName("Order-2");
//				order2.setCustomer(customer);
//				方法1
//				session.save(customer);
//				session.save(order);
//				session.save(order2);
////				方法2可以但是先去查询
//				session.save(order);
//				session.save(order2);
//				session.save(customer);
				
//				//get()方法
//				Order order=(Order) session.get(Order.class, 163841);
//				System.out.println(order);
				
//				Customer customer =order.getCustomer();
//				System.out.println(customer);
//
//					
//				transaction.commit();
//				session.close();
//				sessionFactory.close();
//	}
	
	@Test
	public void test12N(){
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
				Customer customer=new Customer();
				customer.setCustomerName("BB");
				
				Order order =new Order();
				order.setOrderName("Order--01");
				
				Order order2 =new Order();
				order2.setOrderName("Order--02");
				
				session.save(customer);
				session.save(order);
				session.save(order2);

					
				transaction.commit();
				session.close();
				sessionFactory.close();
	}
	
}
