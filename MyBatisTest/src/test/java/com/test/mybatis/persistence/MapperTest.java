package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testQuery() {
		assertNotNull(sqlSessionFactory);
		
		//SqlSessionTemplate > SQL실행(Statement 역할)
		SqlSession session = sqlSessionFactory.openSession();
		
		//session.executeQuery("select")
		//[test.xml] namespace="test", select id="time" -> String(타입)은 알아서 찾아서 적용 
		String time = session.selectOne("test.time");
		log.info(time);
	}
}
