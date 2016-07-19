package com.neuedu.my12306.usermgr.domain;

public class CertType {
private Integer id;
private String content;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

@Override
public String toString(){
	return "证件类型编号:"+id+"证件类型:"+content;
}
}
