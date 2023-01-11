/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class KhachSan extends CoSoKinhDoanh {
    private String ngayDen;
    private String ngayDi;
    private int donGia;
    
    public KhachSan(){
        super();
        this.ngayDen = "";
        this.ngayDi = "";
        this.donGia = 0;
    }
    
    public KhachSan(String ten, String diaChi, String sao, String ngayDen, String ngayDi, int donGia){
        super(ten,diaChi,sao);
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.donGia = donGia;
    }
    
    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhập ngày đến: ");
        ngayDen = sc.nextLine();
        System.out.println("Nhập ngày đi: ");
        ngayDi = sc.nextLine();
        System.out.println("Nhập đơn giá: ");
        donGia = sc.nextInt();
    }
    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Ngày đến: " + ngayDen);
        System.out.println("Ngày đi: " + ngayDi);
        System.out.println("Đơn giá 1 đêm: " + donGia + " VND");
    }
    
    @Override
    public String toString(){
        return "KS," + super.toString() + "," +ngayDen + "," + ngayDi + "," + donGia + "\n";
    }
    
    @Override
    public void tinhTien() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date startDate = dateFormat.parse(ngayDen);
            Date endDate = dateFormat.parse(ngayDi);
            
            long startValue = startDate.getTime();
            long endValue = endDate.getTime();
            
            long tmp = Math.abs(endValue - startValue);
            
            long result = tmp/(24*60*60*1000);
            
            System.out.printf("Tiền sử dụng khách sạn:" + (result*donGia) +" VND" );
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
