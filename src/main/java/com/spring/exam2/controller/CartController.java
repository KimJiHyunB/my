package com.spring.exam2.controller;

import java.util.HashMap;
import java.util.List;

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
import com.spring.exam2.vo.Cart;
import com.spring.exam2.vo.User;

/**
 * cart controller
 * 買い物かごに商品を入れること,削除
 */
@Controller
@RequestMapping("cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	// データオブジェクト処理
	@Autowired
	CartDAO dao;
	
	/**
	 * 買物籠
	 * @param amount 買い物籠入りの全商品
	 */
	@ResponseBody
	@RequestMapping (value="insertCart", method=RequestMethod.POST)
	public String updateForm(HttpSession session, Model model, Cart cart, int amount, User user) {
		logger.info("insertCart 1");
		String user_id = (String) session.getAttribute("loginId");
		
		String obj = null;
		cart.setUser_id(user_id);
		cart.setAmount(amount);

		// 選択した商品が買い物かごにあるか確認
        int count = dao.countCart(cart);

        if (count == 0) {
        	// 登録しなかった商品
        	dao.insertCart(cart);
        	obj = "add to cart!";
		} else {
			// 登録した商品
			dao.updateCart(cart);
			obj = "add to cart!";
		}
        
		logger.info("insertCart 2");
		return obj;
	}
	
	/**
	 * 買い物かごの一覧
	 */
	@RequestMapping (value="myCart", method=RequestMethod.GET)
	public String listCart(HttpSession session, Model model, Cart cart) {
		logger.info("myCart 1");
		String user_id = (String) session.getAttribute("loginId");
		int fee = 0;
		int total = 0;

		// 買い物かごの情報
		List<HashMap<String, Object>> myCartList = dao.listCart(user_id);
		
		// 商品の全体金額
		int sumMoney = dao.sumMoney(user_id);

		// 全体商品金額が500ウォン以下なら,配送料を追加
		if(sumMoney < 50000) {
			System.out.println("fee1 : " + fee);
			fee = 2500;
		} else {
			System.out.println("fee2 : " + fee);
			fee = 0;
		}
		// 全体金額
		total = sumMoney + fee;
		
		model.addAttribute("myCartList",myCartList);
		model.addAttribute("sumMoney", sumMoney);
		model.addAttribute("fee", fee);
		model.addAttribute("total", total);
		
		logger.info("myCart 2");
		return "cart/myCartList";
	}
	
	/**
	 * 買い物かごの引き分け
	 */
    @RequestMapping(value="deleteCart", method=RequestMethod.GET)
    public String deleteCart(int cart_id){
    	logger.info("deleteCart 1");
    	
        int result = dao.deleteCart(cart_id);
        
        logger.info("deleteCart 2");
        return "redirect:myCart";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
