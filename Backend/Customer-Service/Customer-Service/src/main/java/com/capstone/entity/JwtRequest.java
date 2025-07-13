package com.capstone.entity;

import lombok.Builder;

@Builder
public class JwtRequest {

	private String custid;
    private String password;
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    public JwtRequest() {
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String custid, String password) {
		super();
		this.custid = custid;
		this.password = password;
	}
	@Override
	public String toString() {
		return "JwtRequest [custid=" + custid + ", password=" + password + "]";
	}
}
