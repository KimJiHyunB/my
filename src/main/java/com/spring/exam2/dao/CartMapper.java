package com.spring.exam2.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.exam2.vo.Cart;

public interface CartMapper {
	
	// 1. 장바구니 만들기
	public int insertCart(Cart cart); 
	
	// 2. 장바구니 목록
	public List<HashMap<String, Object>> listCart(String user_id);
	
	// 5. 장바구니 금액 합계

    public int sumMoney(String user_id); 
	
	// 6. 장바구니 동일한 상품 레코드 확인
	public int countCart(Cart cart);
	
	// 7. 장바구니에 동일한 상품이 존재하면 수정 
	public int updateCart(Cart cart);
	
	// 3. 장바구니 삭제
    public int deleteCart(int cart_id);
	

}
