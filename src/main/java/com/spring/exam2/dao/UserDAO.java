package com.spring.exam2.dao;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.spring.exam2.controller.MailHandler;
import com.spring.exam2.controller.TempKey;
import com.spring.exam2.vo.User;

@Repository
public class UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	@Autowired
	SqlSession sqlsession;
	
	
	// ȸ�� ����
	public int insertUser(User user) {
		logger.info("DAO_insertUser ����");
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertUser(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_insertUser ����");
		return result;
	}
	
	/**
	 * ID�� ȸ������ �˻�
	 */
	public User getUser(String user_id) {
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		User u = mapper.getUser(user_id);
		return u;
	}
	
	/**
	 * ȸ�� ���� ���� ó��
	 */
	public int updateUser(User user) {
		logger.info("DAO_update ����");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
		
		int result = 0;
		try {
			result = mapper.updateUser(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_update ����");	
		return result;
	}
	
	//�ش� email�� ���� Ű ������Ʈ
    public int createAuthKey(User user) throws Exception {
    	logger.info("DAO_createAuthKey ����");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);

        
        int result = 0;
		try {
			result = mapper.createAuthKey(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_createAuthKey ����");
		return result;
       
    }
    
    // ���� ������ Ȱ��ȭ
 	public int userAuth(String user_id) {
 		logger.info("DAO_userAuth ����");	
		UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        
        int result = 0;
		try {
			result = mapper.userAuth(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_userAuth ����");
		
		return result;
 	}
}
