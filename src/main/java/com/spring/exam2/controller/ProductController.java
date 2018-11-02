package com.spring.exam2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.spring.exam2.dao.ProductDAO;
import com.spring.exam2.util.FileService;
import com.spring.exam2.util.PageNavigator;
import com.spring.exam2.vo.Product;


@Controller
@RequestMapping("prod")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductDAO dao;

	//게시판 관련 상수값들
	final int countPerPage = 9;				
	final int pagePerGroup = 5;				
	final String uploadPath = "/boardfile";	
	
	
	
	/**
	 * product insert Form
	 */
	@RequestMapping (value="prodForm", method=RequestMethod.GET)
	public String prodForm() {
		logger.info("prodForm 1");
		
		logger.info("prodForm 2");
		return "product/prodForm";
	}
	
	/**
	 * product insert
	 */
	@RequestMapping (value="insertProd", method=RequestMethod.POST)
	public String insertProd(Product prod, MultipartFile upload, 
			HttpSession session, Model model,
		    @RequestParam("upload") MultipartFile file) {		
		logger.info("insertProd 1");

		
		if (!upload.isEmpty()) {
			String savedfile = FileService.saveFile(upload, uploadPath);
			prod.setProd_img(upload.getOriginalFilename());
			prod.setProd_saveimg(savedfile);

		}
		dao.insertProd(prod);
		
		logger.info("insertProd 2");
		return "redirect:outerList";
	}
	
	/**
	 * product list
	 */
	@RequestMapping (value="outerList", method=RequestMethod.GET)
	public String list(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="typeText", defaultValue="") String typeText,
			Model model) {
		logger.debug("page: {}, searchText: {}", page);
		logger.info("outerList 1");

		int total = dao.getTotal(typeText);			
		

		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total); 
		

		ArrayList<Product> boardlist = dao.listBoard(typeText, navi.getStartRecord(), navi.getCountPerPage());
	
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("navi", navi);
		model.addAttribute("typeText",typeText);
		
		logger.info("outerList 2");
		return "product/prodList";
	}
	
	/**
	 * product read
	 */
	@RequestMapping (value="read", method=RequestMethod.GET)
	public String read(int prod_id, Model model) throws IOException {
		logger.info("read 1");
		//전달된 글 번호로 해당 글정보 읽기
		Product prod = dao.getProd(prod_id);

		model.addAttribute("prod", prod);
		
		logger.info("read 2");    
		return "product/prodRead";
	}

}
