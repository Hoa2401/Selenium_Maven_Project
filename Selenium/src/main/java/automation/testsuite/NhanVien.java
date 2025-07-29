package automation.testsuite;

import org.testng.annotations.Test;
import java.util.Scanner;

public class NhanVien {
@Test
public void NhanVien() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhập số lượng nhân viên: ");
	int soLuong = sc.nextInt();
	sc.nextLine();
	String[] danhSach = new String[soLuong];
	for ( int i =0; i< soLuong; i++) {
		System.out.println("Nhập tên nhân viên " + (i+1) + ": ");
		danhSach[i] = sc.nextLine();
	}
	 System.out.println("\nDanh sách nhân viên :");
     for (String ten : danhSach) {
         System.out.println("" +ten);
     }

}
}
