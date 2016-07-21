package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.CityService;
import com.neuedu.my12306.usermgr.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
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
		String action =request.getParameter("action");
		if(null == action || "register".equals(action)){
			doRegister(request,response);
		}else if("check".equals(action)){
			doUsernameCheck(request,response);
		}
	}

	private void doUsernameCheck(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		UserService userService =UserService.getInstance();
		User tmp =new User();
		tmp.setUsername(username);
		User dbUser =userService.findUser(tmp);
		String result ="0";
		if(dbUser==null){
			result="1";
		}
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.print(result);
		out.close();
	}

	private void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CityService c=CityService.getService();
		String username=request.getParameter("username");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		String birth=request.getParameter("birth");
		String certType=request.getParameter("certType");
		String certNumber=request.getParameter("certNumber");
		String userType=request.getParameter("userType");
//		String province=request.getParameter("province");
		String city=request.getParameter("city");
		Integer city1=(c.findByCity(city).getId());
		String password=request.getParameter("password");
		UserService userService =UserService.getInstance();
		User tmp =new User();
		tmp.setUsername(username);
		tmp.setRealname(realname);
		tmp.setSex(sex);
		tmp.setContent(email);
		tmp.setBirthday(Date.valueOf(birth));
		tmp.setCert_type(Integer.valueOf(certType));
		tmp.setCert(certNumber);
		tmp.setUser_type(Integer.valueOf(userType));
		tmp.setCity(city1);
		tmp.setPassword(password);
		tmp.setRule("1");
		tmp.setStatus("1");
		boolean dbUser =userService.add(tmp);
		String result ="0";
		if(dbUser){
			result="1";
		}
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.print(result);
		out.close();
	}

}
