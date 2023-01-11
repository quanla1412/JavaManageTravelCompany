/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class DanhSachCoSoKinhDoanh implements DanhSach{
    private CoSoKinhDoanh[] dscskd;
    private int soLuongCS;
    
    public DanhSachCoSoKinhDoanh(){
        soLuongCS = 0;
        dscskd = new CoSoKinhDoanh[0];
    }
    public DanhSachCoSoKinhDoanh(CoSoKinhDoanh[] dscskd,int soLuongCS){
        this.dscskd = dscskd;
        this.soLuongCS = soLuongCS;
    }
    
    public void xuat(){
        xuatKhachSan();
        xuatNhaHang();
    }
    
    public void xuatTen(){
        xuatTenKhachSan();
        xuatTenNhaHang();
    }
    
    public void xuatKhachSan(){
        System.out.println("---------- Danh sách khách sạn ----------");
        for(int i =0;i<soLuongCS;i++){
            if (dscskd[i] instanceof KhachSan){
                System.out.println("Thông tin khách sạn thứ " + (i+1)+": ");
                dscskd[i].xuat();
                System.out.println();
            }
        }
        System.out.println("------------------------------------");
    }
    
    public void xuatTenKhachSan(){        
        System.out.println("---------- Danh sách khách sạn ----------");
        int stt=1;
        for(int i =0;i<soLuongCS;i++){
            if (dscskd[i] instanceof KhachSan){
                System.out.println( stt++ + "." + dscskd[i].getTen());
            }
        }
        System.out.println("------------------------------------");
    }
    
    
    public void xuatNhaHang(){
        System.out.println("---------- Danh sách nhà hàng ----------");
        for(int i=0;i<soLuongCS;i++){
            if (dscskd[i] instanceof NhaHang){
                System.out.println("Thong tin nha hang thu " + (i+1) +":");
                dscskd[i].xuat();
                System.out.println();
            }
        } 
        System.out.println("------------------------------------");
    }
    
    public void xuatTenNhaHang(){        
        System.out.println("---------- Danh sách nhà hàng ----------");
        int stt=1;
        for(int i =0;i<soLuongCS;i++){
            if (dscskd[i] instanceof NhaHang){
                System.out.println( stt++ + "." + dscskd[i].getTen());
            }
        }
        System.out.println("------------------------------------");
    }
    
    @Override
    public void them(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Thêm cơ sở kinh doanh mới ----------");
        System.out.printf("Nhập số lượng cơ sở kinh doanh muốn thêm: ");
        int n = sc.nextInt();
        dscskd = Arrays.copyOf(dscskd, soLuongCS+n);
        for(int i=0;i<n;i++){
            System.out.println("Chọn 1 nếu muốn nhập nhà hàng, chọn 2 nếu muốn nhập khách sạn");
            switch(sc.nextInt()) {
                case 1:
                    dscskd[soLuongCS+i] = new NhaHang();
                    dscskd[soLuongCS+i].nhap();
                case 2:
                    dscskd[soLuongCS+i] = new KhachSan();
                    dscskd[soLuongCS+i].nhap();
                default:
                    System.out.println("Chọn sai định dạng, vui lòng chọn lại");
                    i--;
                    break;                    
            }
        }
        System.out.println("---------- Thêm thành công " + n + "cơ sở kinh doanh ----------");
    }
    
    
    @Override
    public void sua(){
        Scanner sc = new Scanner(System.in);
        xuatTen();
        System.out.println("---------- Sửa cơ sở kinh doanh ----------");
        System.out.print("Nhập tên cơ sở kinh doanh cần sửa: ");
        sc.nextLine();
        String ten = sc.nextLine();
        for(int i=0;i<dscskd.length;i++){
            if(dscskd[i].getTen().equals(ten)){
                dscskd[i].nhap();
                System.out.println("---------- Sửa thành công ----------");
                return;
            }
        }
        System.out.println("---------- Không tìm thấy -----------");
    }
    

    @Override
    public void xoa(){
        Scanner sc = new Scanner(System.in);
        xuatTen();
        System.out.println("---------- Xóa cơ sở kinh doanh ----------");
        System.out.print("Nhập tên cơ sở kinh doanh muốn xóa: ");
        sc.nextLine();
        String ten = sc.nextLine();
        for(int i=0;i<dscskd.length;i++){
            if(dscskd[i].getTen().equals(ten)){
                for(int j=i;j<soLuongCS-1;j++){
                    dscskd[j] = dscskd[j+1];
                }
                dscskd = Arrays.copyOf(dscskd,--soLuongCS);
                System.out.println("---------- Xóa thành công ----------");
                return;
            }
        }
        System.out.println("---------- Không tìm thấy ----------");
    }
    
    
    

    @Override
    public void timKiem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Tìm kiếm cơ sở kinh doanh ----------");
        System.out.print("Nhập tên cơ sở kinh doanh bạn muốn tìm: ");
        sc.nextLine();
        String ten = sc.nextLine();
        for(int i=0;i<dscskd.length;i++){
            if(dscskd[i].getTen().equals(ten)){
                System.out.println();
                dscskd[i].xuat();
                System.out.println();
                return;
            }
        }
        System.out.println(" ----------Không tìm thấy ----------");
    }
    
    public void tinhTien(){
        System.out.println("------------------Tính tiền cơ sở kinh doanh------------------");
        for(int i=0;i<soLuongCS;i++){
            if(dscskd[i] instanceof NhaHang){
                System.out.println("Nhà hàng " + dscskd[i].getTen() +": ");
                dscskd[i].tinhTien();
                System.out.println("");
            }
            else{
                System.out.println("Khách sạn " + dscskd[i].getTen() +": ");
                dscskd[i].tinhTien();
                System.out.println("");
            }
        }
        System.out.println("------------------------------------");
    }
    
    @Override
    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        int x=0;
        do{
            System.out.println("---------- Menu Quản lý Cơ sở kinh doanh -----------");
            System.out.println("1. Thêm cơ sở kinh doanh");
            System.out.println("2. Xóa cơ sở kinh doanh");
            System.out.println("3. Sửa cơ sở kinh doanh");
            System.out.println("4. Tìm kiếm  cơ sở kinh doanh");
            System.out.println("5. Xuất danh sách khách sạn");
            System.out.println("6. Xuất danh sách nhà hàng");
            System.out.println("7. Xuất danh sách cơ sở kinh doanh");
            System.out.println("8. Tính tiền");
            System.out.println("-----------------------------------------------------");
            System.out.println("0. Thoát");
            System.out.printf("Vui lòng chọn: ");
            x = sc.nextInt();
            switch (x){
                case 0:
                    break;
                case 1:
                    them();
                    break;
                case 2:
                    xoa();
                    break;
                case 3:
                    sua();
                    break;
                case 4:
                    timKiem();
                    break;
                case 5:
                    xuatKhachSan();
                    break;
                case 6:
                    xuatNhaHang();
                    break;
                case 7:
                    xuat();
                    break;
                case 8:
                    tinhTien();
                    break;
                default:
                    System.out.println("Vui lòng chọn lại");
                    break;
            }
        } while (x!=0);
    }
    
    @Override
    public String toString(){
        String str = soLuongCS + "\n";
        for(int i=0; i<soLuongCS ; i++){
            str += dscskd[i].toString();
        }
        return str;
    }
}
