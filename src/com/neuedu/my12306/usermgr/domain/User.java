package com.neuedu.my12306.usermgr.domain;

import java.sql.Date;

public class User {
	private CertType certType;
	private Province provience;
	private City city2;
	private int autoLogin;
	private String code;
	private String password2;
	private String passwordOld;
	private Integer id;
	private Integer city;
	private Integer cert_type;
	private Integer user_type;
	private String username;
	private String password;
	private String rule;
	private String realname;
	private String sex;
	private Date birthday;
	private String cert;
	private String content;
	private String status;
	private String login_ip;
	private String image_path;
	private UserType userType;

	public int getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(int autoLogin) {
		this.autoLogin = autoLogin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getCert_type() {
		return cert_type;
	}

	public void setCert_type(Integer cert_type) {
		this.cert_type = cert_type;
	}
	
	public void setCertType(CertType cert_type) {
		this.certType = cert_type;
	}
	
	public CertType getCertType() {
		return certType;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public void setCity(City city2) {
		// TODO Auto-generated method stub
	    this.city2=city2;	
	}
	
	public City getcity() {
		return city2;
	}

	public Province getProvience() {
		return provience;
	}

	public void setProvience(Province provience) {
		this.provience = provience;
	}

	public void setUserType(UserType userType) {
		// TODO Auto-generated method stub
		this.userType = userType;
		
	}
	
	public UserType getUserType() {
		return userType;
	}


}
