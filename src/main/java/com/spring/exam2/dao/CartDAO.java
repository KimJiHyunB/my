package com.spring.exam2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam2.controller.CartController;
import com.spring.exam2.vo.Cart;


@Repository
public class CartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDAO.class);
	
	@Autowired
	SqlSession sqlsession;
	
	public int insertCart(Cart cart) {
		logger.info("DAO_insertCart ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_insertCart ����");
		return result; 
	}
	
	// ��ٱ��� ���
	public List<HashMap<String, Object>> listCart(String user_id) {
		logger.info("DAO_listCart ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		List<HashMap<String, Object>> result = null;

		try {			
			result = mapper.listCart(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_listCart ����");
		return result; 
	}
	
	// 6. ��ٱ��� ������ ��ǰ ���ڵ� Ȯ��
	public int countCart(Cart cart) {
		logger.info("DAO_countCart ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		int result = 0;
		
		try {
			result = mapper.countCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_countCart ����");
		return result; 
	}
	
	// 7. ��ٱ��Ͽ� ������ ��ǰ�� �����ϸ� ���� 
	public int updateCart(Cart cart) {
		logger.info("DAO_updateCart ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.updateCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_updateCart ����");
		return result; 
	}
	
	// 3. ��ٱ��� ����
    public int deleteCart(int cart_id) {
    	logger.info("DAO_deleteCart ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.deleteCart(cart_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_deleteCart ����");
		return result; 
    }
    
    // 5. ��ٱ��� �ݾ� �հ�
    public int sumMoney(String user_id) {
    	logger.info("DAO_sumMoney ����");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.sumMoney(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_sumMoney ����");
		return result; 
		
    }

}
