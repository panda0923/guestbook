package com.bit2015.emaillist.dao.test;

import java.util.List;

import com.bit2015.emailist.dao.EmailLsitDao;
import com.bit2015.emaillist.vo.EmailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {

		//insert Test
		insert();
		
		//getList Test
		getListTest();
		
	}
	public static void getListTest(){
		EmailLsitDao dao = new EmailLsitDao();
		List<EmailListVo> list =  dao.getList();
		for(EmailListVo vo :list){
			System.out.println(vo);
		}
	}
	public static void insert(){
		EmailLsitDao dao = new EmailLsitDao();
		EmailListVo vo = new EmailListVo();
		
		vo.setFirstname("박");
		vo.setLastname("서준");
		vo.setEmail("sejun@naver.com");
		dao.insert(vo);
		
	}

}
//드라이브 로딩 실패:java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver-오라클 라이브러리가 없어서 오류