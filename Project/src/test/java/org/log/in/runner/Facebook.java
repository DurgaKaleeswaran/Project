package org.log.in.runner;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.pom.Log;

public class Facebook extends Log {
	Log k;
	@BeforeClass
	public static void before() {
		lanuchChrome();
		time(20);
	}
	@Before
	public void be() {
		System.out.println("Start");
	}
	@Test
	public void testbylogin() {
		k=new Log();
        launchUrl("https://www.facebook.com/login");
        sendKey(k.getUser(), "Durga");
        sendKey(k.getPasswd(), "Som123");
        click(k.getLoging());
		
	}
	@Test
	public void testby() {
		k=new Log();
        launchUrl("https://www.facebook.com/login");
        sendKey(k.getUser(), "dd123");
        sendKey(k.getPasswd(), "  ");
        click(k.getLoging());
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


