package com.ticket.message;

import java.util.Date;



public class User {
	private int id;
	private String loginName;
	private int uid;
	private String realName;
	private String sex;
	private String city;
	private String cardType;
	private String cardNmuber;
	private Date birthday;
	private String type;
	private String info;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNmuber() {
		return cardNmuber;
	}

	public void setCardNmuber(String cardNmuber) {
		this.cardNmuber = cardNmuber;
	}

	public Date getBirdathy() {
		return birthday;
	}

	public void setBirdathy(Date birdathy) {
		this.birthday = birdathy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
