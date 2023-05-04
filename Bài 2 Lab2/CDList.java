/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author ADMIN
 */
public class CDList {
	private CD[] ds;
	private int soLuongHienTai;
	private int soLuongHTCuaDonGia;
	
	public CDList(int soLuong) {
		if(soLuong > 0) {
			ds = new CD[soLuong];
			soLuongHienTai = 0;
		}
		else {
			System.out.println("Số lượng CD phải lớn hơn 0 !");
		}
	}
	
	public CD[] getDS() {
		return ds;
	}
	
	public int getSoLuongHT() {
		return soLuongHienTai;
	}
	
	public int getSoLuongHTCuaDonGia() {
		return soLuongHTCuaDonGia;
	}
	
	//Phương thức tăng kích thước mảng
	public void tangKichThuoc() {
		CD[] temp = new CD[ds.length];
		for(int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}
	
	//Phương thức tìm kiếm 1 CD trong mảng (trả về vị trí trong mảng nếu tìm thấy)
	public int timKiem(int maCD) {
		for(int i = 0; i < soLuongHienTai; i++) {
			if(ds[i].getMaCD() == maCD) {
				return i;
			}
		}
		return -1; // trả về -1 nếu không tìm thấy
	}
	
	//Phương thức thêm 1 CD vào danh sách
	public void them(CD a) {
		if(soLuongHienTai == ds.length) {
			tangKichThuoc();
		}
		if(timKiem(a.getMaCD()) == -1 || ds[0]==null) {
			ds[soLuongHienTai] = a;
			soLuongHienTai++;
		}
		else {
			System.out.println("Mã CD này đã tồn tại trong danh sách !");
		}
	}
	
	//Phương thức sắp xếp tăng dần theo giá thành( Sử dụng thuật toán sắp xếp chèn)
	public void sapXepTheoGiaThanh() {
		CD temp = null;
		int i, pos;
		for(i = 1; i < soLuongHienTai; i++) {
			temp = ds[i];
			for(pos = i-1; (pos >= 0) && ( ds[pos].getGiaThanh() > temp.getGiaThanh() ); pos--) {
				ds[pos+1] = ds[pos];
			}
			ds[pos+1] = temp;
		}
	}
	
	//Phương thức sắp xếp tăng dần theo tựa CD ( Sử dụng thuật toán sắp xếp chèn)
	public void sapXepTheoTuaCD() {
		CD temp = null;
		int i, pos;
		for(i = 1; i < soLuongHienTai; i++) {
			temp = ds[i];
			for(pos = i-1; (pos >= 0) && ( ds[pos].getTuaCD().compareTo(temp.getTuaCD()) > 0 ); pos--) {
				ds[pos+1] = ds[pos];
			}
			ds[pos+1] = temp;
		}
	}
	
	//Phương thức tính tổng giá thành
	public double getTongGiaThanh() {
		double sum = 0;
		for(int i = 0; i < soLuongHienTai; i++) {
			sum += ds[i].getGiaThanh();
		}
		return sum;
	}
	
	//Phương thức trả về danh sách CD có giá thành nhỏ hơn x.
	public CD[] getDSNhoHon(double x) {
		CD[] temp = new CD[ds.length];
		soLuongHTCuaDonGia = 0;
		for(int i = 0; i < soLuongHienTai; i++) {
			if(ds[i].getGiaThanh() <= x) {
				temp[soLuongHTCuaDonGia] = ds[i];
				soLuongHTCuaDonGia++;
			}
		}
		return temp;
	}
	
	//Phương thức xóa 1 CD khỏi mảng
	public void xoa(CD cdXoa) {
		int i, pos = timKiem(cdXoa.getMaCD());
		for(i = pos; i < soLuongHienTai-1; i++) {
			ds[i] = ds[i+1];
		}
		ds[i] = null;
		soLuongHienTai--;
	}
	
	//Phương thức cập nhật việc sửa đổi cho 1 CD 
	public void sua(CD cdSua) {
		int pos = timKiem(cdSua.getMaCD());
		ds[pos] = cdSua;
	}
}

