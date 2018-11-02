package com.spring.exam2.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.exam2.dao.UserDAO;
import com.spring.exam2.vo.User;



@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO dao;
	
	@Autowired
	JavaMailSender mailSender;
	
	
	/**
	 * join Form
	 */
	@RequestMapping (value="joinForm", method=RequestMethod.GET)
	public String joinForm(Model model) {
		logger.info("joinForm 1");
		
		User user = new User();
		model.addAttribute("user", user);
		
		logger.info("joinForm 2");
		return "user/joinForm";
	}
	
	/**
	 * join
	 */
	@RequestMapping (value="join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute("user") User user, Model model
			,RedirectAttributes redirectAttributes) throws MessagingException, UnsupportedEncodingException {
		logger.info("join 1");
		
		String key = new TempKey().getKey(50, false); 
		user.setUser_authCode(key);
		int result = dao.insertUser(user); 
		 
		MailHandler sendMail = new MailHandler(mailSender);
		
		sendMail.setSubject("[FAINT  서비스 이메일 인증]");
        sendMail.setText(
                new StringBuffer().append("<h1>메일인증</h1>").append(
                		"<a href='http://localhost:8090/exam2/user/emailConfirm?user_id=").
                append(user.getUser_id()).
                append("&user_authCode=").append(key).
                append("' target='_blank'>이메일 인증 확인</a>").toString());
        sendMail.setFrom("myroomnember5@gmail.com", "서어비스센터 ");
        sendMail.setTo(user.getUser_email());
        sendMail.send();
		
        
		if (result != 1) {
			model.addAttribute("errorMsg", "join fail");
			logger.info("join fail");
			return "user/joinForm";
		}
		
		String user_id = user.getUser_id();
		redirectAttributes.addAttribute("user_id", user_id);
		
		logger.info("join 2");
		return "redirect:emailConfirm";
	}
	
	/**
	 * email verify
	 */
	@RequestMapping(value = "emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(Model model, 
			@RequestParam(value="user_authCode",defaultValue="") String user_authCode,
			@RequestParam("user_id") String user_id
			) throws Exception {
		logger.info("emailConfirm 1");
		String msg;
	
		User user = dao.getUser(user_id);

		if (user.getUser_authCode().equals(user_authCode)) {
			int result = dao.userAuth(user_id);
			
			if (result != 1) {
				model.addAttribute("Msg", "인증 실패");
				logger.info("emailConfirm 이동 실패");
				return "user/emailConfirm";
			} 
			msg = "Thank you. Your email has been verified.";
		}	else {
			msg = "your email check please.";
		
		}

		model.addAttribute("Msg",msg);
		logger.info("emailConfirm 2");
		return "user/emailConfirm";
	}
	
	/**
	 * id check
	 */
	@ResponseBody
	@RequestMapping(value="idcheck", method=RequestMethod.POST)
	public String idcheck(String user_id, Model model) {
		logger.info("idcheck 1");
		User u = dao.getUser(user_id);
		
		if (u == null) {

			logger.info("idcheck pos 2");
			return "Available ID";
		} else {
			logger.info("idcheck imp 3");
			return "Unavailable ID";
		}
				
		
	}
	
	
	/**
	 * login Form
	 */
	@RequestMapping (value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "user/loginForm";
	}
	
	/**
	 * login 
	 */
	@RequestMapping (value="login", method=RequestMethod.POST)
	public String login(
			String user_id, String user_pass, 
			Model model, HttpSession session) {
		logger.info("login 1");
		User user = dao.getUser(user_id);
		
		if (user != null && user.getUser_pass().equals(user_pass)) {
			session.setAttribute("loginId", user.getUser_id());
		
		
			if(user.getUser_check() != 1) {
				model.addAttribute("Msg", "email check please.");
			}
			
			logger.info("login 2");
			return "redirect:/";
		}
		else {
			model.addAttribute("errorMsg", "ID 또는 비밀번호가 틀립니다.");
			logger.info("login fail");
			return "user/loginForm";
		}
		
	}
	
	/**
	 * logout
	 */
	@RequestMapping (value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * user info modification Form
	 */
	@RequestMapping (value="update", method=RequestMethod.GET)
	public String updateForm(HttpSession session, Model model) {
		//세션의 로그인ID로 개인정보를 검색하여 모델에 저장
		String id = (String) session.getAttribute("loginId");
		User user = dao.getUser(id);
	
		model.addAttribute("user", user);
		return "user/updateForm";
	}
	
	/**
	 * user info modification				
	 */
	@RequestMapping (value="update", method=RequestMethod.POST)
	public String update(
			@ModelAttribute("user") User user,Model model,
			SessionStatus sessionStatus, HttpSession session) {
		logger.info("update 시작");	
		int result = dao.updateUser(user);
		if (result != 1) {
			//DB update에 실패한 경우 alert() 출력용 메시지를 모델에 저장
			model.addAttribute("errorMsg", "수정 실패");
			return "user/updateForm";
		}
		
		session.setAttribute("loginName", user.getUser_name());
		model.addAttribute("result", user);
		sessionStatus.setComplete();
		logger.info("update 종료");	
		return "redirect:/";
	}
	
	/**
	 * find password Form			
	 */
	@RequestMapping (value="searchmy", method=RequestMethod.GET)
	public String searchmy() {
		logger.info("searchmy 1");	

		logger.info("searchmy 2");	
		return "user/searchmy";
	}
	
	/**
	 * find password
	 */
	@ResponseBody
	@RequestMapping (value="searchmypw", method=RequestMethod.POST)
	public String searchmypw(String user_id) {
		logger.info("searchmypw 1");	

		User user = dao.getUser(user_id);	
		String result;

		if(user != null) {
			result = user.getUser_pass();
		} else {
			result = "no result";
		}
		logger.info("searchmypw 2");	
		return result;
	}
	
}
