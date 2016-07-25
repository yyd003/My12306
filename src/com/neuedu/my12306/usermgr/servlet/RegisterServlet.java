package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.common.*;
import com.neuedu.my12306.usermgr.domain.*;
import com.neuedu.my12306.usermgr.service.*;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (null == action || "register".equals(action)) {
			doRegister(request, response);
		} else if ("check".equals(action)) {
			doUsernameCheck(request, response);
		} else if ("show".equals(action)) {
			dataInit(request, response);
			request.getRequestDispatcher("/UserRegistration.jsp").forward(
					request, response);
		} else if ("findCity".equals(action)) {
			doFindCity(request, response);
		}
	}

	private void doFindCity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		JSONObject jsonData = new JSONObject();
		CityService cts = CityService.getService();
		List<City> dataList = new ArrayList<City>();
		try {
			dataList = cts.getCityListByProid(request
					.getParameter("provinceId"));
			System.out.println(dataList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dataList != null) {
			jsonData.put("data", dataList);
		} else {
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("city", jsonData);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// String cityData = jsonData.toString();
		out.print(jsonData);
		out.close();
	}

	private void dataInit(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		certTypeDataInit(request, response);
		userTypeDataInit(request, response);
		provienceDataInit(request, response);
	}

	private void provienceDataInit(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		JSONObject jsonData = new JSONObject();
		ProvinceService cts = ProvinceService.getService();
		List<Province> dataList = new ArrayList<Province>();
		try {
			dataList = cts.getlist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dataList != null) {
			jsonData.put("data", dataList);
		} else {
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("province", jsonData);
	}

	private void userTypeDataInit(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONObject jsonData = new JSONObject();
		UserTypeService cts = UserTypeService.getService();
		List<UserType> dataList = new ArrayList<UserType>();
		try {
			dataList = cts.getlist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dataList != null) {
			jsonData.put("data", dataList);
		} else {
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("userType", jsonData);

	}

	private void certTypeDataInit(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		JSONObject jsonData = new JSONObject();
		CertTypeService cts = CertTypeService.getService();
		List<CertType> dataList = new ArrayList<CertType>();
		try {
			dataList = cts.getlist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dataList != null) {
			jsonData.put("data", dataList);
		} else {
			jsonData.put("data", null);
		}
		request.getSession().setAttribute("certType", jsonData);

	}

	private void doUsernameCheck(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		UserService userService = UserService.getInstance();
		User tmp = new User();
		tmp.setUsername(username);
		User dbUser = userService.findUser(tmp);
		String result = "0";
		if (dbUser == null) {
			result = "1";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

	private void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CityService c = CityService.getService();
		String username = request.getParameter("username");
		// System.out.println(username);
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		// String email=request.getParameter("email");
		String birth = request.getParameter("birth");
		String certType = request.getParameter("certType");
		String certNumber = request.getParameter("cert");
		String userType = request.getParameter("userType");
		// String province=request.getParameter("province");
		String city = request.getParameter("city");

		// city=new String(city.getBytes("ISO-8859-1"),"UTF-8");
		// System.out.println(city);

		// System.out.println(city);
		City cf = c.findByCity(city);

		Integer i = cf.getId();
		System.out.println(i);
		Integer city1 = i;
		String password = request.getParameter("password");
		UserService userService = UserService.getInstance();
		User tmp = new User();
		tmp.setUsername(username);
		tmp.setRealname(realname);
		tmp.setSex(sex);
		// tmp.setContent(email);
		tmp.setBirthday(Date.valueOf(birth));
		tmp.setCert_type(Integer.valueOf(certType));
		tmp.setCert(certNumber);
		tmp.setUser_type(Integer.valueOf(userType));
		tmp.setCity(city1);
		tmp.setPassword(Md5Utils.md5(password));
		tmp.setRule("2");
		tmp.setStatus("1");
		tmp.setLogin_ip(request.getRemoteAddr());
		boolean dbUser = userService.add(tmp);
		String msg = null;
		if (!dbUser) {
			// MD5
			msg = "注册成功";
		} else {
			msg = "用户名重复";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head> <meta charset='UTF-8'>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
