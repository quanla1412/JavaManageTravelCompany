/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import java.util.Arrays;/**
 *
 * @author Nhat Tan
 */
public class DanhSachThanhPho implements DanhSach{
    private ThanhPho dstp[];
    private int soLuongTp;
    
    public DanhSachThanhPho() {
        dstp = new ThanhPho[0];
        soLuongTp=0;
    }
    
    public DanhSachThanhPho(ThanhPho dstp[], int soLuongTp) {
        this.dstp = dstp;
        this.soLuongTp = soLuongTp;
    }

    
    // Thêm thành phố
    @Override
    public void them() {
        System.out.println("---------- Thêm thành phố ----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn muốn nhập bao nhiêu thành phố: ");
        int n = sc.nextInt();
        dstp = Arrays.copyOf(dstp, soLuongTp+n); 
        
        for(int i=0; i<n; i++){   
            dstp[soLuongTp+i] = new ThanhPho();
            dstp[soLuongTp+i].nhap();
        }
        soLuongTp+=n;
        System.out.println("---------- Thêm thành công " + n + " thành phố ----------");
    }
    
   
    // Xuất thành phố
    @Override
    public void xuat(){
        if(dstp.length == 0) {
            System.out.println("---------- Danh sách trống ----------");
            return ;
        }
        System.out.println("---------- Danh sách thành phố ----------");
        for(int i=0;i<soLuongTp;i++){
            System.out.println("Thành phố thứ " + (i+1) + ": ");
            dstp[i].xuat();
            System.out.println();
        }
        System.out.println("----------------------------------------------");

    }
    
   //Tìm kiếm     
    @Override
    public void timKiem(){
        System.out.println("---------- Tìm kiếm thành phố ----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên thành phố muốn tìm:  ");
        String findTen = sc.nextLine();
        int s = 0;
        for(int i=0;i<soLuongTp;i++){
            if(dstp[i].getTen().equals(findTen)){
                dstp[i].xuat();
                return;
            } 
        }
        System.out.println("----- Không tìm thấy thành phố có tên " + findTen + " ------");
        System.out.println();
    }
    
    //Xuất danh sách tên các thành phố
    public void xuatTen() {
        System.out.println("----- Danh sách thành phố -----");
        for(int i=0; i<dstp.length;i++){
            System.out.println( (i+1) + "." + dstp[i].getTen());
        }        
    }
    
   //Sửa
    @Override
    public void sua(){
        xuatTen();
        System.out.println("---------- Sửa thành phố ----------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên thành phố muốn sửa:  ");
        String str = sc.nextLine();
        int s = 0;
        for(int i=0;i<soLuongTp;i++){
            if(dstp[i].getTen().equals(str)){
                dstp[i].sua();
                System.out.println("---------- Sửa thành công ----------");
                return;
            }
        }
        System.out.println(" ------ Không tìm thấy thành phố có tên " + str + " ----------");
    }
       
    // Xóa
    @Override
    public void xoa() {
        xuatTen();
        System.out.println("---------- Xóa thành phố ----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên thành phố cần xóa: ");
        String str = sc.nextLine();
        for(int i=0; i<dstp.length; i++){
            if(dstp[i].getTen().equals(str)){
                for(int j=i;j<dstp.length-1;j++){
                    dstp[j] = dstp[j+1];
                }
                dstp = Arrays.copyOf(dstp, dstp.length - 1);
                soLuongTp--;
                System.out.println("-----Đã xóa thành công-----\n");
                return;
            }
        }
        System.out.println("-----Không tìm thấy thành phố-----\n");
        
    }
        
    
    
    
//Menu   
    @Override
    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        int x=0;
        do {
            System.out.println("===== Quản lý thành phố =====");
            System.out.println(" 1.Thêm thành phố");
            System.out.println(" 2.Sửa thông tin thành phố ");
            System.out.println(" 3.Tìm kiếm thành phố ");
            System.out.println(" 4.Xuất danh sách thành phố đang có ");
            System.out.println(" 5.Xóa thành phố ");
            System.out.println(" 0.Thoát");
            System.out.println("=============================");
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
                    System.out.println("Nhập sai cú pháp, vui lòng nhập lại!!");
                    break;
            }
        } while (x!=0);
    }
    
    @Override
    public String toString(){ 
        String str = soLuongTp + "\n";
        for(int i=0;i<soLuongTp;i++){
            str+=dstp[i].toString();
        }     
        return str;
    }
}
