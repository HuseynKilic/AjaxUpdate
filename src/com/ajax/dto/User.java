package com.ajax.dto;

public class User {
	
	int id;
	private String ad;
	private String soyad;
	private String yas;
	private String sehir;


	public User(){
		super();
		
	}


public User(int id, String ad, String soyad, String yas, String sehir){
	super();
	this.id = id;
	this.ad = ad;
	this.soyad = soyad;
	this.yas = yas;
	this.sehir = sehir;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAd() {
	return ad;
}

public void setAd(String ad) {
	this.ad = ad;
}

public String getSoyad() {
	return soyad;
}

public void setSoyad(String soyad) {
	this.soyad = soyad;
}

public String getYas() {
	return yas;
}

public void setYas(String yas) {
	this.yas = yas;
}

public String getSehir() {
	return sehir;
}

public void setSehir(String sehir) {
	this.sehir = sehir;
}

}
