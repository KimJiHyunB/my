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

/**
 * product controller
 * write, read, list, delete, modify
 */

@Controller
@RequestMapping("prod")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	// 会員関連データ処理客体
	@Autowired
	ProductDAO dao;

	
	final int countPerPage = 9;				// ページ当たりの文章数			
	final int pagePerGroup = 5;				//ページ移動グループ当たり表示するページ数
	final String uploadPath = "/boardfile";	// ファイルアップロード経路
	
	
	
	/**
	 * product insert Form
	 * @param
	 */
	@RequestMapping (value="prodForm", method=RequestMethod.GET)
	public String prodForm() {
		logger.info("prodForm 1");
		
		logger.info("prodForm 2");
		return "product/prodForm";
	}
	
	/**
	 * product insert
	 * @param prod 入力した商品内容
	 */
	@RequestMapping (value="insertProd", method=RequestMethod.POST)
	public String insertProd(Product prod, MultipartFile upload, 
			HttpSession session, Model model,
		    @RequestParam("upload") MultipartFile file) {		
		logger.info("insertProd 1");

		// セッションでログインしたユーザーのIDを読んでprod 客体の作成者情報にセッティング
		String prod_id = (String) session.getAttribute("logid");
		prod.setProd_id(prod_id);
		
		// 添付ファイルがある場合,指定された経路に保存し,原本ファイル名と保存されたファイル名をprod客体にセット
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
	 * @param page 現在のページ。なければ1
	 * @param searchText 検索語。なければ""
	 */
	@RequestMapping (value="outerList", method=RequestMethod.GET)
	public String list(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="typeText", defaultValue="") String typeText,
			Model model) {
		logger.debug("page: {}, searchText: {}", page);
		logger.info("outerList 1");

		// 掲示板の書き込みの全数
		int total = dao.getTotal(typeText);			
		
		// ページ計算のためのオブジェクト生成
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total); 
		
		// 検色語と開始位置,ページあたりの文数を伝え,リスト読み
		ArrayList<Product> boardlist = dao.listBoard(typeText, navi.getStartRecord(), navi.getCountPerPage());
	
		//ページ情報オブジェクトや書き込みリスト,検索語をモデルに保存
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("navi", navi);
		model.addAttribute("typeText",typeText);
		
		logger.info("outerList 2");
		return "product/prodList";
	}
	
	/**
	 * product read
	 * @param boardnum 選択した文の番号
	 * @return 該当書き込みの情報
	 */
	@RequestMapping (value="read", method=RequestMethod.GET)
	public String read(int prod_id, Model model) throws IOException {
		logger.info("read 1");
		// 配信された掲示文書で該当文書を読む
		Product prod = dao.getProd(prod_id);

		model.addAttribute("prod", prod);
		
		logger.info("read 2");    
		return "product/prodRead";
	}

}
