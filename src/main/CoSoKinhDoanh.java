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
public abstract class CoSoKinhDoanh {
    private String ten;
    private String diaChi;
    private String sao;
    
    public abstract void tinhTien();
    
    
    public CoSoKinhDoanh(){
        this.ten = "";
        this.diaChi = "";
        this.sao = "";
    }
    
    public CoSoKinhDoanh(String ten, String diaChi, String sao){
        this.ten = ten;
        this.diaChi = diaChi;
        this.sao = sao;
    }

    public String getTen() {
        return ten;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên cơ sở kinh doanh: ");
        ten = sc.nextLine();
        System.out.print("Nhập địa chỉ cơ sở kinh doanh: ");
        diaChi = sc.nextLine();
        System.out.print("Nhập số sao của cơ sở kinh doanh: ");
        sao = sc.nextLine();
    }
    
    public void xuat(){
        System.out.println("Ten co so kinh doanh: " + ten);
        System.out.println("Dia chi co so kinh doanh: " + diaChi);
        System.out.println("Sao cua co so kinh doanh: " + sao);
    }
    
    @Override
    public String toString(){
        return ten + "," + diaChi + "," + sao;
    }
}
