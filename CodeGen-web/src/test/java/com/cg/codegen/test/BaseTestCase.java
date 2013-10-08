package com.cg.codegen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/applicationContext-*.xml"})
public abstract class BaseTestCase {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("BasePath", "/codegen");
		System.setProperty("BaseRealPath", "D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\CodeGen-web\\src\\main\\webapp");
	}
	
	@Before
	public void init() {
		System.out.println("\n\nstart test --> ");
	}

	@After
	public void destory() {
		System.out.println("end test --> \n\n");
	}
	
}
