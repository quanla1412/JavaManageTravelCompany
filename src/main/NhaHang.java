/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class NhaHang extends CoSoKinhDoanh {
    
    private String combo;
    private String ngay;
    private int giaCombo;
    
    public NhaHang(String ten, String diaChi, String sao, String combo, String ngay, int giaCombo){
        super(ten,diaChi,sao);
        this.combo = combo;
        this.ngay = ngay;
        this.giaCombo = giaCombo;
    }
    
    public NhaHang(){
        super();
        this.combo = "";
        this.ngay = "";
        this.giaCombo = 0;
    }
    
    @Override
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhập tên combo: ");
        combo = sc.nextLine();
        System.out.println("Nhập giá combo: ");
        giaCombo = sc.nextInt();
        System.out.println("Nhập ngày đến: ");
        sc.nextLine();
        ngay = sc.nextLine();
    }
   
    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println("Combo: " + combo);
        System.out.println("Giá combo: " + giaCombo +" VND");
        System.out.println("Ngày: " + ngay);
    }
    
    @Override
    public String toString(){
        return "NH," + super.toString() + "," + combo + "," + ngay + "," + giaCombo + "\n";
    }
    
    @Override
    public void tinhTien() {
        System.out.println("Tiền sử dụng nhà hàng: "  + giaCombo + " VND");
    }
    
}
