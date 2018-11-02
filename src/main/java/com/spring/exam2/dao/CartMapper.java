package com.spring.exam2.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.exam2.vo.Cart;

public interface CartMapper {
	
	// 1. ��ٱ��� �����
	public int insertCart(Cart cart); 
	
	// 2. ��ٱ��� ���
	public List<HashMap<String, Object>> listCart(String user_id);
	
	// 5. ��ٱ��� �ݾ� �հ�

    public int sumMoney(String user_id); 
	
	// 6. ��ٱ��� ������ ��ǰ ���ڵ� Ȯ��
	public int countCart(Cart cart);
	
	// 7. ��ٱ��Ͽ� ������ ��ǰ�� �����ϸ� ���� 
	public int updateCart(Cart cart);
	
	// 3. ��ٱ��� ����
    public int deleteCart(int cart_id);
	

}
