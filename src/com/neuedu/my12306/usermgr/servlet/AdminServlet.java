package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.*;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ("show".equals(action)) {
			try {
				doShow(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private void doShow(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 根据页面要求的页数，每页的记录数，生成数据，然后传到页面
		UserService us = UserService.getInstance();
		String strPageSize = request.getParameter("pageSize");
		String strPageNum = request.getParameter("page");
		int pageSize = 10, pageNum = 1;
		if (strPageSize != null) {
			pageSize = Integer.parseInt(strPageSize);
		}
		if (strPageNum != null) {
			pageNum = Integer.parseInt(strPageNum);
		}
		List<User> userList = us.getUserListRS(pageSize, pageNum, new User());
		// 包装成json数据
		JSONObject data = new JSONObject();
		String msg;
		if (userList != null) {
			data.put("users", userList);
		} else {
			data.put("users", null);
		}
		request.setAttribute("data", data);// request范围
		request.getRequestDispatcher("/Admin/Index.jsp")
				.forward(request, response);
	}
}
