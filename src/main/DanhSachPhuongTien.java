/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nhat Tan
 */
public class DanhSachPhuongTien implements DanhSach{
    private PhuongTien dspt[];
    private int soLuongPt;
    
    public DanhSachPhuongTien() {
        dspt = new PhuongTien[0];
        this.soLuongPt = soLuongPt;
    }
    
    public DanhSachPhuongTien(PhuongTien dspt[], int soLuongPt) {
        this.dspt = dspt;
        this.soLuongPt = soLuongPt;
    }
    
    //Thêm
    public void them() {
        System.out.println("----------- Thêm phương tiện mới ---------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn muốn nhập bao nhiêu phương tiện: ");
        int n = sc.nextInt();
        dspt = Arrays.copyOf(dspt, soLuongPt+n); 
        
        for(int i=0; i<n; i++){   
            dspt[soLuongPt+i] = new PhuongTien();
            dspt[soLuongPt+i].nhap();
        }
        soLuongPt+=n;
        System.out.println("---------- Thêm thành công " + n + " phương tiện ----------");
    }
    
    //Xuất    
    public void xuat(){
        if(dspt.length == 0) {
            System.out.println("---------- Danh sách trống ----------");
        }
        else {
            System.out.println("-----------Danh sách phương tiện----------");
            for(int i=0;i<soLuongPt;i++){
                System.out.println("Phương tiện thứ " + (i+1) + ": ");
                dspt[i].xuat();
            }
        }
    }
    
    //Xuất biển kiểm soát các phương tiện
    public void xuatTen(){        
        System.out.println("-----------Danh sách phương tiện----------");
        for(int i=0;i<dspt.length;i++){
            System.out.println( (i+1) + ": " + dspt[i].getbienKiemsoat());
        }
    }
    
    //Tìm kiếm
    public void timKiem(){
        System.out.println("---------- Tìm kiếm phương tiện ----------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển số phương tiện muốn tìm:  ");
        String findMa = sc.nextLine();
        for(int i=0;i<soLuongPt;i++){
            if(dspt[i].getbienKiemsoat().equals(findMa)){
                dspt[i].xuat();
                return;
            } 
        }
        System.out.println("------Không tìm thấy phương tiện có biển số " + findMa + "------\n");
    }
    
    //Sửa    
    public void sua(){
        xuatTen();
        System.out.println("-----------Sửa thông tin phương tiện-----------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển số phương tiện mà bạn muốn sửa:  ");        
        String findMa = sc.nextLine();
        
        for(int i=0;i<soLuongPt;i++){
            if(dspt[i].getbienKiemsoat().equals(findMa)){
                dspt[i].nhap();
                System.out.println("------Sửa thành công-------");
                return;
            } 
        }
        System.out.println("------Không tìm thấy phương tiện có biển số " + findMa + "-----");
        System.out.println();
    }
    
    //Xóa
    public void xoa() {
        xuatTen();
        System.out.println("----------Xóa phương tiện----------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển số phương tiện mà bạn muốn xóa:  ");        
        String str = sc.nextLine();

        for(int i=0;i<soLuongPt-1;i++){
            if(dspt[i].getbienKiemsoat().equals(str)){
                for(int j=i; j<dspt.length-1;j++){
                    dspt[j] = dspt[j+1];
                }
            }
            dspt = Arrays.copyOf(dspt, --soLuongPt);
            System.out.println("-----Xóa thành công-----");
            return; 
        }
        System.out.println("------Không tìm thấy phương tiện có biển số " + str + "------");
        System.out.println();
    }
    
    //Menu
    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        int x=0;
        do {
            System.out.println("---------- Menu quản lý phương tiện ----------");
            System.out.println("1.Nhập phương tiện");
            System.out.println("2.Sửa thông tin phương tiện");
            System.out.println("3.Tìm kiếm phương tiện");
            System.out.println("4.Xuất danh sách phương tiện đang có");
            System.out.println("5.Xóa phương tiện");
            System.out.println("0.Thoát"); 
            System.out.println("----------------------------------------------");
            System.out.print("Vui lòng chọn số: ");
            x=sc.nextInt();
            switch(x){
                case 1:
                    them();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    timKiem();
                    break;
                case 4:
                    xuat();
                    break;
                case 5:
                    xoa();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập sai cú pháp, vui lòng nhập lại!");
                    break;
            }
        } while (x!=0);
    }
    
    public String toString(){
        String str= soLuongPt + "\n";
        for(int i=0;i<soLuongPt;i++){
            str += dspt[i].toString();
        }
        return str;
    }
}

