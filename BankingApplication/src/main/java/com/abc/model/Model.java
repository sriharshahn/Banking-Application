package com.abc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private String name;
    private 	String custid;
	private int accno;
	private  String pwd;
	private int bal;
	private String email;
	private Connection con;
	private PreparedStatement pstmt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Model() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");//Loading The Driver
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication","root","root");
	System.out.println("Loading the driver and  establishing the connection is completed");
	}
	public boolean register() throws Exception {
		String s="insert into ABCBank values(?,?,?,?,?,?)";
		 pstmt=con.prepareStatement(s);
		 pstmt.setString(1, name);
		 
		 pstmt.setString(2, custid);
		 pstmt.setInt(3, accno);
		 pstmt.setString(4, pwd);
		 pstmt.setInt(5, bal);
		 pstmt.setString(6, email);
		 
	int x=pstmt.executeUpdate();
	if(x>0)
	{
		return true;
	}
		 
		return false;
	}
	public boolean login() throws SQLException {
		String s="select * from abcbank where custid=? and pwd=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, custid);
		pstmt.setString(2, pwd);
		ResultSet res=pstmt.executeQuery();
		while(res.next()==true)
		{
			accno=res.getInt("accno");
			return true;
		}
		return false;
	}
	
		
}
