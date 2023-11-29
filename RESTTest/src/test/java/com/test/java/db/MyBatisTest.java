package com.test.java.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	@Autowired
	private SqlSessionTemplate template; 

	@Test
	public void testQuery() {
		int count = template.selectOne("rest.test");
		assertNotNull(template);
		assertEquals(11, count);
	}
	
}
