package com.neuedu.my12306.common;


public class ServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2571084252421965400L;
	private String str;
	public ServiceException() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	public ServiceException(String str, Exception e) {
		// TODO Auto-generated constructor stub
		super();
		this.str=str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return getStr();
	}
	

}
