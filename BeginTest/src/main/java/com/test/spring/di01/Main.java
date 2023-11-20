package com.test.spring.di01;

public class Main {
	
	public static void main(String[] args) {
		
		//Main > (의존) > Hong > Pen
		//Main.main() 실행 > Hong에게 업무 위임 
		
		//의존관계를 만드는 방법
		//1, 기존 방법
		//2. DI 패턴 방법
		
		//Main의 의존객체(Dependency Object) > 기존 방법
		Hong hong = new Hong();
		hong.run();
		
		//DI방식 
		//Lee lee = new Lee();
		//lee.run();
		
		
		Brush brush = new Brush();		//Main객체가 필요홀 하는 객체가 아니다. 
		Lee lee = new Lee(brush);		//DI발생, 의존주입 발생 
		lee.run();
		
		
		
	}
	
}
