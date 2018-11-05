package com.spring.exam2.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import com.spring.exam2.vo.Product;


public interface ProductMapper {
	
	// 商品情報保存
	public int insertProd(Product prod);
	
	// 検索結果レコード数
	public int getTotal(String typeText);
	
	// 1ページの書き込みリストを読むこと
	public ArrayList<Product> listBoard(String typeText,RowBounds rb);
	
	// 掲示文一読
	public Product getProd(int prod_id);

}
