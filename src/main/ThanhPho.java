
package main;

import java.util.Scanner;

public class ThanhPho {
    private String ten;
    private String khiHau;
    private String nhietDo;
    private String ngonNgu;
    private String ngayDen;
    private String ngayDi;   

    public ThanhPho() {
    }

    public ThanhPho(String ten, String khiHau, String nhietDo, String ngonNgu, String ngayDen, String ngayDi ) {
        this.ten = ten;
        this.khiHau = khiHau;
        this.nhietDo = nhietDo;
        this.ngonNgu = ngonNgu;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    public String getTen() {
        return ten;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên thành phố: ");
        ten = sc.nextLine();
        System.out.print("Nhập khí hậu: ");
        khiHau = sc.nextLine();
        System.out.print("Nhập nhiệt độ: ");
        nhietDo = sc.nextLine();
        System.out.print("Nhập ngôn ngữ: ");
        ngonNgu = sc.nextLine();
        System.out.print("Nhập ngày đến: ");
        ngayDen = sc.nextLine();
        System.out.print("Nhập ngày đi: ");
        ngayDi = sc.nextLine();
        System.out.println();
    }
    
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sửa tên thành phố: ");
        ten = sc.nextLine();
        System.out.print("Sửa khí hậu: ");
        khiHau = sc.nextLine();
        System.out.print("Sửa nhiệt độ: ");
        nhietDo = sc.nextLine();
        System.out.print("Sửa ngôn ngữ: ");
        ngonNgu = sc.nextLine();
        System.out.print("Sửa ngày đến: ");
        ngayDen = sc.nextLine();
        System.out.print("Sửa ngày đi: ");
        ngayDi = sc.nextLine();
        System.out.println();
    }

    public void xuat() {
        System.out.println("Thành phố: " + ten);
        System.out.println("Khí hậu: " + khiHau);
        System.out.println("Nhiệt độ ở mức: " + nhietDo);
        System.out.println("Ngôn ngữ: " + ngonNgu);
        System.out.println("Ngày đến: " + ngayDen);
        System.out.println("Ngày đi: " + ngayDi);    
    }
       
    public String toString(){
        return ten + "," + khiHau + "," + nhietDo + "," + ngonNgu + "," + ngayDen + "," + ngayDi + "\n";
    }
}   

