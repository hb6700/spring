package com.test.spring.di02;

public class Park {

	//Choi choi = new Choi();
	private Choi choi;
	
	public Park(Choi choi) {
		this.choi = choi;
	}
	
	public void run() {	
		System.out.println("Park 업무중...");
		choi.doSomething();
	}
	
}
