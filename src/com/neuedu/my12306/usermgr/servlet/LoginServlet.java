package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (null == action || "login".equals(action)) {
			try {
				doLogin(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserService userService=UserService.getInstance();
		User tmp =new User();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		tmp.setUsername(username);
		tmp.setPassword(Md5Utils.md5(password));
		User dbUser =userService.findUser(tmp);
		
		if ("1".equals(dbUser.getRule())) {
			response.sendRedirect(request.getContextPath()
					+ "/Admin/Index.jsp");
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/User/Index.jsp");
		}

		// TODO Auto-generated method stub
		
	}

}
