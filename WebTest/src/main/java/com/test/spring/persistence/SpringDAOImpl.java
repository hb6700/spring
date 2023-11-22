package com.test.spring.persistence;

import com.test.spring.domain.SpringDTO;

public class SpringDAOImpl implements SpringDAO{

	@Override
	public int getCount() {
		
		return 100;			//select...
	}

	@Override
	public int add(SpringDTO dto) {

		//DB작업  > insert
		System.out.println("insert finish");
		System.out.println(dto);
		return 0;
	}

}
