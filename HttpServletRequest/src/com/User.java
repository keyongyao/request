package com;

import java.util.Arrays;

public class User {
    public String name;
    @Override
	public String toString() {
		return "User [name=" + name + ", password=" + pwd + ", sex=" + sex + ", hobbies="
				+ Arrays.toString(hobby) + ", city=" + city + "]";
	}
	public String pwd;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String sex;
    public String[] hobby;;
    public String city;
}
