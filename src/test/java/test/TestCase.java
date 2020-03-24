package test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdminDAO;
import dao.AdminDAOJdbcImpl;
import entity.Admin;
import service.LoginService;

public class TestCase {
	private ApplicationContext ac;
	@Before
	//@Before修饰的方法会在测试方法运行之前先执行
	public void init()
	{
		ac=new ClassPathXmlApplicationContext("springmvc.xml");
	}
	
	@Test
	public void test1() throws SQLException
	{
		
		DataSource ds=ac.getBean("ds",DataSource.class);
		
		System.out.println(ds.getConnection());
	}
	
	@Test
	public void test2() throws SQLException
	{
		AdminDAO dao=ac.getBean("adminDAO",AdminDAO.class);
		
		Admin admin=dao.findByAdminCode("lywme");
		System.out.println(admin);
	}
	
	@Test
	public void test3() throws SQLException
	{
		LoginService s=ac.getBean("loginService",LoginService.class);
		
		Admin admin=s.checkLogin("lywme", "123456");
		System.out.println(admin);
	}
	
	@Test
	public void test4() throws SQLException
	{
		AdminDAO dao=ac.getBean("adminDAOS",AdminDAO.class);
		
		Admin admin=dao.findByAdminCode("lywme");
		System.out.println(admin);
	}
}
