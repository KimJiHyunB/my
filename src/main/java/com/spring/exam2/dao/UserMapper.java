package com.spring.exam2.dao;

import com.spring.exam2.vo.User;

public interface UserMapper {
	
	public int insertUser(User user);
	
	//ID로 해당 회원 정보 검색
	public User getUser(String user_id);
	
	// 정보 수정
	public int updateUser(User user);
	
	public int createAuthKey(User user);
	
	// 메일 인증시 활성화
	public int userAuth(String user_id);
}
