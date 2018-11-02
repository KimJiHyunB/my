package com.spring.exam2.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import com.spring.exam2.vo.Product;


public interface ProductMapper {
	
	// ��ǰ ���
	public int insertProd(Product prod);
	
	// �� �� ����
	public int getTotal(String typeText);
	
	//�˻� ���� ���� ������ ���
	public ArrayList<Product> listBoard(String typeText,RowBounds rb);
	
	// ��ǰ 1�� �б�
	public Product getProd(int prod_id);

}
