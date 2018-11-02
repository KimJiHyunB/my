package com.spring.exam2.dao;

import com.spring.exam2.vo.User;

public interface UserMapper {
	
	public int insertUser(User user);
	
	//ID�� �ش� ȸ�� ���� �˻�
	public User getUser(String user_id);
	
	// ���� ����
	public int updateUser(User user);
	
	public int createAuthKey(User user);
	
	// ���� ������ Ȱ��ȭ
	public int userAuth(String user_id);
}
