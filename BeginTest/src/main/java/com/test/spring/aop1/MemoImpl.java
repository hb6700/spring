package com.test.spring.aop1;

import java.util.Calendar;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		System.out.println("추가" + memo);
		
		//로그기록
		//Calendar now = Calendar.getInstance();
		//System.out.println("[log][%tF %tT]로그를 기록합니다");
		
		//Logger logger = new Logger();
		//logger.log();
	}

	@Override
	public String read(int seq) throws Exception{
		
		if(seq > 10) {
			System.out.println("메모 읽기");
		}else {
			throw new Exception("존재하지 않는 메모");
		}
		
		return "메모입니다";
	}

	@Override
	public boolean edit(int seq, String memo) {
		System.out.println("메모 수정" + memo);
		return false;
	}

	@Override
	public boolean del(int seq) {
		System.out.println("메모삭제" + seq);
		return false;
	}
	
	
	
}
