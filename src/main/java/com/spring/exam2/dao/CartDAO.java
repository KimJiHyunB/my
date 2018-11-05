package com.spring.exam2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam2.vo.Cart;


@Repository
public class CartDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDAO.class);
	
	@Autowired
	SqlSession sqlsession;
	
	/**
	 * 買物籠
	 */
	public int insertCart(Cart cart) {
		logger.info("DAO_insertCart 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_insertCart 2");
		return result; 
	}
	
	/**
	 * 買い物かごの一覧
	 */
	public List<HashMap<String, Object>> listCart(String user_id) {
		logger.info("DAO_listCart 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		List<HashMap<String, Object>> result = null;

		try {			
			result = mapper.listCart(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_listCart 2");
		return result; 
	}
	
	/**
	 * 買い物かごの同一の商品レコードを確認
	 */ 
	public int countCart(Cart cart) {
		logger.info("DAO_countCart 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		int result = 0;
		
		try {
			result = mapper.countCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_countCart 2");
		return result; 
	}
	
	/**
	 * 買い物かごに同一の商品が存在すれば,修正
	 */ 
	public int updateCart(Cart cart) {
		logger.info("DAO_updateCart 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.updateCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_updateCart 2");
		return result; 
	}
	
	/**
	 * 買い物かごの削除
	 */
    public int deleteCart(int cart_id) {
    	logger.info("DAO_deleteCart 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.deleteCart(cart_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_deleteCart 2");
		return result; 
    }
    
    /**
	 * 買い物かごの金額合計
	 */
    public int sumMoney(String user_id) {
    	logger.info("DAO_sumMoney 1");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.sumMoney(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_sumMoney 2");
		return result; 
		
    }

}
