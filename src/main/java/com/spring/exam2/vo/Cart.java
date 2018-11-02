package com.spring.exam2.vo;

public class Cart {
	
	int cart_id;
	String user_id;	
	String prod_id;
	int amount;
	
	public Cart() {}

	public Cart(int cart_id, String user_id, String prod_id, int amount) {
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.prod_id = prod_id;
		this.amount = amount;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user_id=" + user_id + ", prod_id=" + prod_id + ", amount=" + amount
				+ "]";
	}	
	

}
