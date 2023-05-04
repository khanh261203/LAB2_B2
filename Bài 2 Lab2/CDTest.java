/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

import java.util.Scanner;

public class CDTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chon, n;
		double amount;
		System.out.println("----oOo-- CHƯƠNG TRÌNH QUẢN LÝ DANH SÁCH CD --oOo----");
		System.out.println("Nhập số lượng CD để khởi tạo danh sách : ");
		n = sc.nextInt();
		CDList ds = new CDList(n);
		System.out.println("Danh sách đã được tạo !");
		
		do {
			menu();
			System.out.println("-Lựa chọn : ");
			chon = sc.nextInt();
			
			switch(chon) {
				case 1 :
					nhapCung(ds);
					break;
				case 2 :
					ds.them(nhapMem());
					break;
				case 3 :
					xoa(ds);
					break;
				case 4 :
					CD cdDeSua = sua(ds);
					if(cdDeSua != null) {
						ds.sua(cdDeSua);
						System.out.println("Cập nhật thành công !");
					}	
					break;
				case 5 :
					timKiem(ds);
					break;
				case 6 :
					xuat(ds);
					break;
				case 7 :
					ds.sapXepTheoGiaThanh();
					System.out.println("Đã sắp xếp theo giá thành !\n");
					break;
				case 8 :
					ds.sapXepTheoTuaCD();
					System.out.println("Đã sắp xếp theo tựa CD !\n");
					break;
				case 9 :
					System.out.println("Tổng giá thành CD trong danh sách : "+ds.getTongGiaThanh());
					break;
				case 10	:
					xuatDSTheoDonGiaCanTim(ds);
					break;
				case 11 :
					System.out.println("Cảm ơn đã sử dụng chương trình <33");
					break;
				default :
					System.out.println("Lựa chọn không hợp lệ !\n");
					break;
			}
		}while(chon != 11);
	}
	static void menu() {
		System.out.println("\n\n===================MENU==================");
		System.out.println("*  1/ Nhập cứng.                        *");
		System.out.println("*  2/ Thêm.                             *");
		System.out.println("*  3/ Xóa.                              *");
		System.out.println("*  4/ Sửa.                              *");
		System.out.println("*  5/ Tìm kiếm.                         *");
		System.out.println("*  6/ Xuất.                             *");
		System.out.println("*  7/ Sắp xếp tăng dần theo giá thành.  *");
		System.out.println("*  8/ Sắp xếp tăng dần theo tựa CD.     *");
		System.out.println("*  9/ Xuất tổng giá thành.              *");
		System.out.println("*  10/ Xuất theo đơn giá cần tìm.       *");
		System.out.println("*  11/ Thoát.                           *");
		System.out.println("=========================================");
	}
	static void menuSua() {
		System.out.println(" |----------ALTER---------");
		System.out.println(" |  1/ Sửa tựa CD.      |");
		System.out.println(" |  2/ Sửa số bài hát.  |");
		System.out.println(" |  3/ Sửa giá thành.   |");
		System.out.println(" |  4/ Thoát.           |");
		System.out.println("------------------------|");
	}
	
	static CD sua(CDList ds) {
		Scanner sc = new Scanner(System.in);
		CD cdSua = null; // Phải khai báo ở đây thì mới return được.
		int maSua, pos, chon, soBaiHatMoi;
		int ktra = 0; // biến kiểm tra đề phòng trường hợp người dùng không sửa nhưng chọn thoát.
		String tuaMoi;
		double giaMoi;
		System.out.println("Nhập mã CD muốn chỉnh sửa : ");
		maSua = sc.nextInt();
		pos = ds.timKiem(maSua);
		if(pos == -1) {
			System.out.println("Mã CD vừa nhập không tồn tại trong danh sách !\n");
			return null;
		}
		else {
			cdSua = ds.getDS()[pos];
			System.out.println("Thông tin về CD mà bạn sắp sửa : ( "+ ds.getDS()[pos] +" )");
			do {
				menuSua();
				System.out.println("-Lựa chọn : ");
				chon = sc.nextInt();
				
				switch(chon) {
					case 1 :
						System.out.println("Nhập tựa CD mới : ");
						sc.nextLine(); tuaMoi = sc.nextLine();
						cdSua.setTuaCD(tuaMoi); ktra =1;
						break;
					case 2 :
						System.out.println("Nhập số bài hát mới : ");
						soBaiHatMoi = sc.nextInt();
						cdSua.setSoBaiHat(soBaiHatMoi); ktra = 1;
						break;
					case 3 :
						System.out.println("Nhập giá thành mới : ");
						giaMoi = sc.nextDouble();
						cdSua.setGiaThanh(giaMoi); ktra = 1;
						break;
					case 4 : 
						System.out.println("Hoàn tất cập nhật CD !");
						break;
					default :
						System.out.println("Lựa chọn không hợp lệ !");
						break;
				}
			}while(chon != 4);
		}
	if(ktra != 0) {
		return cdSua;
	}
	return null;
	}
	
	static void xoa(CDList ds) {
		Scanner sc = new Scanner(System.in);
		int maXoa, pos;
		System.out.println("Nhập mã CD muốn xóa : ");
		maXoa = sc.nextInt();
		pos = ds.timKiem(maXoa);
		if(pos == -1) {
			System.out.println("Mã CD vừa nhập không tồn tại trong danh sách !\n");
			return;
		}
		else {
			String acp;
			CD cdXoa = ds.getDS()[pos];
			System.out.println("\nBạn có chắc chắn muốn xóa CD này khỏi danh sách ? (Y/N)");
			acp = new Scanner(System.in).nextLine();
			if (acp.equals("y")||acp.equals("Y")) {
				ds.xoa(cdXoa);
				System.out.println("Xóa thành công");
			}
			else {
				System.out.println("Xóa không thành công !");
			}
		}
	}
	
	static void nhapCung(CDList ds) {
		CD temp = null;
		temp = new CD(1, "SEE SING SHARE 4", 9, 1000);
		ds.them(temp);
		temp = new CD(2, "Purpose", 19, 1500);
		ds.them(temp);
		temp = new CD(3, "Different World", 15, 1750.5);
		ds.them(temp);
	}
	static CD nhapMem() {
		Scanner sc = new Scanner(System.in);
		int maCD, soBaiHat;
		String tuaCD;
		double giaThanh;
		
		System.out.println("Nhập mã CD : ");
		maCD = sc.nextInt();sc.nextLine();
		System.out.println("Nhập tựa CD :");
		tuaCD = sc.nextLine();
		System.out.println("Nhập số bài hát :");
		soBaiHat = sc.nextInt();
		System.out.println("Nhập giá thành : ");
		giaThanh = sc.nextDouble();
		
		CD temp = new CD(maCD, tuaCD, soBaiHat, giaThanh);
		return temp;
	}
	static void xuat(CDList ds) {
		System.out.println("\n\n======================================================================");
		System.out.println(String.format("| %-10s |%-30s |%10s |%10s |", "Mã CD", "Tựa CD", "Số bài hát", "Giá thành"));
		System.out.println("+====================================================================+");
		for(int i = 0; i < ds.getSoLuongHT(); i++) {
			System.out.println(ds.getDS()[i]);
		}
		System.out.println("======================================================================\n\n");
	}

	static void timKiem(CDList ds) {
		Scanner sc = new Scanner(System.in);
		int maTim, pos;
		System.out.println("Nhập mã CD cần tìm : ");
		maTim = sc.nextInt();
		pos = ds.timKiem(maTim);
		if(pos == -1) {
			System.out.println("Không tìm thấy mã CD vừa nhập trong danh sách!\n");
			return;
		}
		else {
			System.out.println("CD có mã tương ứng nằm tại vị trí "+pos+" trong mảng ( Phần tử thứ "+(pos+1)+" )\n");
		}
	}
	
	static void xuatDSTheoDonGiaCanTim(CDList ds) {
		System.out.println("Nhập số tiền mà bạn muốn mua CD: ");
		double soTien = new Scanner(System.in).nextInt();
		System.out.println("Danh sách các CD phù hợp với số tiền vừa nhập :");
		CD temp[] = ds.getDSNhoHon(soTien);
		if (ds.getSoLuongHTCuaDonGia() != 0) {
			for(int i=0; i<ds.getSoLuongHTCuaDonGia(); i++) {
				System.out.println(temp[i]);
			}
		} else
			System.out.println("Không có CD nào thỏa mãn yêu cầu.");
	}
}

