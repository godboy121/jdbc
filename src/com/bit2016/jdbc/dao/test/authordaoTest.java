package com.bit2016.jdbc.dao.test;

import com.bit2016.jdbc.dao.AuthorDao;
import com.bit2016.jdbc.vo.authorNoVo;

public class authordaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insert test
		insert();

	}
	public static void insert(){
		authorNoVo vo=new authorNoVo();
		vo.setNo(1255);
		vo.setName("해리포터");
		
		
		AuthorDao dao=new AuthorDao();
		dao.insert(vo);
		
	}

}
