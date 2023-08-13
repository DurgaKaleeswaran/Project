package org.log.in.runner;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pom.Log;

public class my extends Log {
	Log j;

	@BeforeClass
	public static void before() {
		lanuchChrome();
		time(20);
	}
	@Before
	public void be() {
		System.out.println("Start");
	}
	//Automation
	@Test
	public void testbylogin0() throws IOException {
		j=new Log();
        launchUrl("http://demo.myschoolgo.com/");
        sendKey(j.getUser(),"tsdemo");
        sendKey(j.getPasswd(),"welcome");
        click(j.getLoging());
	}
	@Test
	public void testbylogin2() throws IOException {
		j=new Log();
        launchUrl("http://demo.myschoolgo.com/");
        sendKey(j.getUser(),"ts");
        sendKey(j.getPasswd(),"welcome@123");
        click(j.getLoging());
	}
	@Test
	public void testbylogin3() throws IOException {
		j=new Log();
        launchUrl("http://demo.myschoolgo.com/");
        sendKey(j.getUser(),"tsdemo23");
        sendKey(j.getPasswd(),"welcome@12345");
        click(j.getLoging());

	}
	@Test
	public void testbylogin() throws IOException {
		j=new Log();
        launchUrl("http://demo.myschoolgo.com/");
        sendKey(j.getUser(),"tsdemo");
        sendKey(j.getPasswd(),"welcome@123");
        click(j.getLoging());
	}
	//Manual Excel
	
		@Test
	public void testbylogin1() throws IOException {
		j=new Log();
        launchUrl("http://demo.myschoolgo.com/");
        sendKey(j.getUser(),readExcel("Login", "Myschool", 1, 7));
        sendKey(j.getPasswd(),readExcel("Login", "Myschool", 1, 7));
        click(j.getLoging());
	}
	  @AfterClass
      public static void aft() {
      	driver.close();
      }
      @After
      public void afno() {
      	Date d=new Date();
      	System.out.println(d);
      }
}