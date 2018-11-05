package com.spring.exam2.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam2.vo.User;

@Repository
public class UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	@Autowired
	SqlSession sqlsession;
	
	
	/**
	 * 会員加入
	 */
	public int insertUser(User user) {
		logger.info("DAO_insertUser 1");
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertUser(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_insertUser 2");
		return result;
	}
	
	/**
	 * IDで会員情報検索
	 */
	public User getUser(String user_id) {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		User u = mapper.getUser(user_id);
		return u;
	}
	
	/**
	 * 会員情報修正処理
	 */
	public int updateUser(User user) {
		logger.info("DAO_update 1");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		
		int result = 0;
		try {
			result = mapper.updateUser(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_update 2");	
		return result;
	}
	
	/**
	 * 該当のemailに認証キーアップデート
	 */
    public int createAuthKey(User user) throws Exception {
    	logger.info("DAO_createAuthKey 1");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        
        int result = 0;
		try {
			result = mapper.createAuthKey(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_createAuthKey 2");
		return result;
       
    }
    
    /**
	 * メール認証時活性化
	 */
 	public int userAuth(String user_id) {
 		logger.info("DAO_userAuth 1");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        
        int result = 0;
		try {
			result = mapper.userAuth(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_userAuth 2");
		
		return result;
 	}
}
