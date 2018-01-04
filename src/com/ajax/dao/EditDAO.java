package com.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.ajax.database.DatabaseConnection;
import com.ajax.dto.User;


public class EditDAO {
	public static int duzenle(User user){
		
	
		int status=0;
	try{
		
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("update tablo set ad=?, soyad=?, yas=?, sehir=? where id=?");
		
		ps.setString(1, user.getAd());
		ps.setString(2, user.getSoyad());
		ps.setString(3, user.getYas());
		ps.setString(4, user.getSehir());
		ps.setInt(5, user.getId());
		
		status = ps.executeUpdate();
		
		ps.close();
		
	}catch (Exception e){
		e.printStackTrace();
	}
	return status;
	
}
	
}