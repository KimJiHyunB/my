package com.spring.exam2.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import com.spring.exam2.vo.Product;


public interface ProductMapper {
	
	// 상품 등록
	public int insertProd(Product prod);
	
	// 총 글 개수
	public int getTotal(String typeText);
	
	//검색 후의 현재 페이지 목록
	public ArrayList<Product> listBoard(String typeText,RowBounds rb);
	
	// 상품 1개 읽기
	public Product getProd(int prod_id);

}
