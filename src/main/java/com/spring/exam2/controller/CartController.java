package com.spring.exam2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.exam2.dao.CartDAO;
import com.spring.exam2.dao.ProductDAO;
import com.spring.exam2.vo.Cart;
import com.spring.exam2.vo.User;

@Controller
@RequestMapping("cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartDAO dao;
	
	/**
	 * cart insert
	 */
	@ResponseBody
	@RequestMapping (value="insertCart", method=RequestMethod.POST)
	public String updateForm(HttpSession session, Model model, Cart cart, int amount, User user) {
		logger.info("insertCart 1");
		String user_id = (String) session.getAttribute("loginId");
		
		String obj = null;
		cart.setUser_id(user_id);
		cart.setAmount(amount);

        int count = dao.countCart(cart);

        if (count == 0) {
        	dao.insertCart(cart);
        	obj = "add to cart!";
		} else {
			dao.updateCart(cart);
		}
        
		logger.info("insertCart 2");
		return obj;
	}
	
	/**
	 * cart list
	 */
	@RequestMapping (value="myCart", method=RequestMethod.GET)
	public String listCart(HttpSession session, Model model, Cart cart) {
		logger.info("myCart 1");
		String user_id = (String) session.getAttribute("loginId");
		int fee = 0;
		int total = 0;

		List<HashMap<String, Object>> myCartList = dao.listCart(user_id);

		int sumMoney = dao.sumMoney(user_id);

		
		if(sumMoney < 50000) {
			System.out.println("fee1 : " + fee);
			fee = 2500;
		} else {
			System.out.println("fee2 : " + fee);
			fee = 0;
		}
		total = sumMoney + fee;
		
		model.addAttribute("myCartList",myCartList);
		model.addAttribute("sumMoney", sumMoney);
		model.addAttribute("fee", fee);
		model.addAttribute("total", total);
		
		logger.info("myCart 2");
		return "cart/myCartList";
	}
	
	/**
	 * cart delete
	 */
    @RequestMapping(value="deleteCart", method=RequestMethod.GET)
    public String deleteCart(int cart_id){
    	logger.info("deleteCart 1");
    	
        int result = dao.deleteCart(cart_id);
        
        logger.info("deleteCart 2");
        return "redirect:myCart";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
