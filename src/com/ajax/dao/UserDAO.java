package com.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ajax.database.DatabaseConnection;
import com.ajax.dto.User;

public class UserDAO {
	
	public List<User> goster(){
	
	List<User> selected = new ArrayList<User>();
	
	try{
		
		Connection con=DatabaseConnection.getConnection(); 
		
		PreparedStatement ps=con.prepareStatement("select * from tablo");
		ResultSet sonuc = ps.executeQuery();
		
		while(sonuc.next()){
			
			User user = new User();
			user.setId(sonuc.getInt(1));
			user.setAd(sonuc.getString(2));
			user.setSoyad(sonuc.getString(3));
			user.setYas(sonuc.getString(4));
			user.setSehir(sonuc.getString(5));
			selected.add(user);
		}
		con.close();
	}catch (Exception e){
		e.printStackTrace();
	}
	
	return selected;
}
}
