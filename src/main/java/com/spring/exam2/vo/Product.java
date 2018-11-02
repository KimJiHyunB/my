package com.spring.exam2.vo;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	String prod_id;	
	String prod_type;	
	String prod_name;
	String prod_price;	
	int prod_inv;
	String prod_exp;
	String prod_img;
	String prod_saveimg;
	
	public Product() {
	}

	
	public Product(String prod_id, String prod_type, String prod_name, String prod_price, int prod_inv, String prod_exp,
			String prod_img, String prod_saveimg) {
		super();
		this.prod_id = prod_id;
		this.prod_type = prod_type;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_inv = prod_inv;
		this.prod_exp = prod_exp;
		this.prod_img = prod_img;
		this.prod_saveimg = prod_saveimg;
	}


	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_type() {
		return prod_type;
	}

	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_price() {
		return prod_price;
	}

	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_inv() {
		return prod_inv;
	}

	public void setProd_inv(int prod_inv) {
		this.prod_inv = prod_inv;
	}

	public String getProd_exp() {
		return prod_exp;
	}

	public void setProd_exp(String prod_exp) {
		this.prod_exp = prod_exp;
	}


	public String getProd_img() {
		return prod_img;
	}


	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}


	public String getProd_saveimg() {
		return prod_saveimg;
	}


	public void setProd_saveimg(String prod_saveimg) {
		this.prod_saveimg = prod_saveimg;
	}


	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_type=" + prod_type + ", prod_name=" + prod_name + ", prod_price="
				+ prod_price + ", prod_inv=" + prod_inv + ", prod_exp=" + prod_exp + ", prod_img=" + prod_img
				+ ", prod_saveimg=" + prod_saveimg + "]";
	}

	
	

}
