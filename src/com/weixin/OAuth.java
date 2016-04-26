package com.weixin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class OAuth
 */
@WebServlet("/OAuth")
public class OAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> mapParam=new HashMap<String, String>();
		mapParam.put("response_type", "code");
		mapParam.put("client_id", "1104939497");
		mapParam.put("redirect_uri", "https%3a%2f%2fwww.baidu.com%2f");
		mapParam.put("state", "fxb208");
		mapParam.put("scope", "get_user_info");
		String sd=WXHttpUtils.mapRequest("https://graph.qq.com/oauth2.0/authorize", mapParam, "GET");
		//response.getWriter().println(sd);
		response.sendRedirect("http://www.baidu.com");
		System.out.println(sd);
	}

}
