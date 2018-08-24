package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.MyConnection;

public class LoginDAO {
	public int checkLogin(String username,String password) {
		int result=0;
		try {
			System.out.println(username+password);
		if(username.equals("admin")&&password.equals("admin")) {
			result=1;
			
		}
		else {
		String CHECK_DETAILS="select password from Login where username=?;";
		PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(CHECK_DETAILS);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(1).equals(password)) {
				result=2;
			}
			
		}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result:"+result);
		return result;
	}
}
