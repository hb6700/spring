package com.test.spring.di01;

public class Hong {

	public void run() {

		//의존관계 
		//Main > hong > (의존) > Pen
		//펜을 사용하는 업무 > 펜 객체를 생성 > 사용(Pen에 위임)
		
		//hong의 의존객체이다 
		//Pen을 직접 생성한다.(기존방식) 
		Pen p = new Pen();
		p.write();
		
	}

}
