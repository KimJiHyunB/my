package com.spring.exam2.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.exam2.vo.Cart;

public interface CartMapper {
	
	// 買物籠
	public int insertCart(Cart cart); 
	
	// 買い物かごの一覧
	public List<HashMap<String, Object>> listCart(String user_id);
	
	// 買い物かごの金額合計
    public int sumMoney(String user_id); 
	
	// 買い物かごの同一の商品レコードを確認
	public int countCart(Cart cart);
	
	// 買い物かごに同一の商品が存在すれば,修正 
	public int updateCart(Cart cart);
	
	// 買い物かごの削除
    public int deleteCart(int cart_id);
	

}
