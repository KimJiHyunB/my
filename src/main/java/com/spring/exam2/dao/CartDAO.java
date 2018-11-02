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
		logger.info("DAO_insertCart 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_insertCart 종료");
		return result; 
	}
	
	// 장바구니 목록
	public List<HashMap<String, Object>> listCart(String user_id) {
		logger.info("DAO_listCart 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		List<HashMap<String, Object>> result = null;

		try {			
			result = mapper.listCart(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_listCart 시작");
		return result; 
	}
	
	// 6. 장바구니 동일한 상품 레코드 확인
	public int countCart(Cart cart) {
		logger.info("DAO_countCart 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);
		int result = 0;
		
		try {
			result = mapper.countCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_countCart 종료");
		return result; 
	}
	
	// 7. 장바구니에 동일한 상품이 존재하면 수정 
	public int updateCart(Cart cart) {
		logger.info("DAO_updateCart 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.updateCart(cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_updateCart 종료");
		return result; 
	}
	
	// 3. 장바구니 삭제
    public int deleteCart(int cart_id) {
    	logger.info("DAO_deleteCart 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.deleteCart(cart_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_deleteCart 종료");
		return result; 
    }
    
    // 5. 장바구니 금액 합계
    public int sumMoney(String user_id) {
    	logger.info("DAO_sumMoney 시작");
		CartMapper mapper = sqlsession.getMapper(CartMapper.class);

		int result = 0;
		
		try {
			result = mapper.sumMoney(user_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DAO_sumMoney 종료");
		return result; 
		
    }

}
