/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author ADMIN
 */
import java.util.InputMismatchException;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;
	
	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}
	public CD() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		if(maCD > 0) {
			this.maCD = maCD;
		}
		else {
			this.maCD = 999999;
		}
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		if(!tuaCD.equals("")) {
			this.tuaCD = tuaCD;
		}
		else {
			this.tuaCD = "Chưa xác định";
		}
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		if(soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		}
		else {
			//throw new InputMismatchException("Số bài hát phải lớn hơn 0 !");
			System.out.println("Số bài hát phải lớn hơn 0 !");
		}
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) {
		if(giaThanh > 0) {
			this.giaThanh = giaThanh;
		}
		else {
			//throw new InputMismatchException("Giá thành phải lớn hơn 0 !");
			System.out.println("Giá thành phải lớn hơn 0 !");
		}
	}
	
	@Override
	public String toString() {
		return String.format("| %-10d |%-30s |%10d |%10.2f |", getMaCD(), getTuaCD(), getSoBaiHat(), getGiaThanh());
	}
	
	
	
	
}

