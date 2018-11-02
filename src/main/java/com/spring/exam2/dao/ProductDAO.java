package com.spring.exam2.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam2.vo.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	/**
	* ����
	* @param prod ������ �Խñ� ����
	*/
	public int insertProd(Product prod) {
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);
		
		int result = 0;
		try {
			result = mapper.insertProd(prod);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * �˻� ��� ���ڵ� ��
	 * @return �۰���
	 */
	public int getTotal(String typeText) {
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);
		int total = mapper.getTotal(typeText);
		return total;
	}
	
	/**
	 * �� �������� �Խñ� ��� �б�
	 */
	public ArrayList<Product> listBoard(String typeText, int startRecord, int countPerPage) {
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		

		ArrayList<Product> boardlist = mapper.listBoard(typeText, rb);
		return boardlist;
	}
	
	// ��ǰ 1�� �б�
	public Product getProd(int prod_id) {
		ProductMapper mapper = sqlsession.getMapper(ProductMapper.class);
		Product result = null;
		
		try {
			result = mapper.getProd(prod_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}

}
