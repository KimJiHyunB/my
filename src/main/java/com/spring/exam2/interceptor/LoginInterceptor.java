package com.spring.exam2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ユーザーログイン確認インターセプタ HandlerInterceptorAdapterを相続して定義。
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	// コントローラのメソッド実行前に処理
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("LoginInterceptor 実行");
		
		// セッションのログイン情報読取
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("logId");
		
		// ログインされない場合,ログインページに移動
		if (loginId == null) {
			//request.getContextPath()でルート経路を求め,絶対に経路で処理
			response.sendRedirect(request.getContextPath() + "/user/loginForm");
			return false;
		}
		//　ログインされた場合に要請した経路で進行
		return super.preHandle(request, response, handler);
	}

}
