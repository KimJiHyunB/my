package com.spring.exam2.dao;

import com.spring.exam2.vo.User;

public interface UserMapper {
	
	// 会員加入
	public int insertUser(User user);
	
	// IDで該当会員情報検索
	public User getUser(String user_id);
	
	// 会員情報修正処理
	public int updateUser(User user);
	
	// 該当のemailに認証キーアップデート
	public int createAuthKey(User user);
	
	// メール認証時活性化
	public int userAuth(String user_id);
}
