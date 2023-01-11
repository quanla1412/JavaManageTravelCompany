package main;

import java.util.Scanner;

/**
 *
 * @author LeAnhQuan
 */
public class TourDuLich {
    private String idTour;
    private String tenTour="";
    private String ngayDi="";
    private String ngayVe="";
    private int giaTien=0;
    private static int curIdTour=1;
    private DanhSachThanhVien dstv;
    private DanhSachCoSoKinhDoanh dscskd;
    private DanhSachThanhPho dstp;
    private DanhSachPhuongTien dspt;
    
    public TourDuLich() {
        idTour = "T" + curIdTour++;
        dstv = new DanhSachThanhVien();
        dscskd = new DanhSachCoSoKinhDoanh();
        dstp = new DanhSachThanhPho();
        dspt = new DanhSachPhuongTien();
    }

    public TourDuLich(String tenTour, String ngayDi, String ngayVe, int giaTien, DanhSachThanhVien dstv, DanhSachCoSoKinhDoanh dscskd, DanhSachThanhPho dstp, DanhSachPhuongTien dspt) {   
        idTour = "T" + curIdTour++;
        this.tenTour=tenTour;
        this.ngayDi=ngayDi;
        this.ngayVe=ngayVe;
        this.giaTien=giaTien;
        this.dstv = dstv;
        this.dscskd = dscskd;
        this.dstp = dstp;
        this.dspt = dspt;
    }

    public String getTenTour() {
        return tenTour;
    }

    public String getIdTour() {
        return idTour;
    }

    public DanhSachThanhVien getDstv() {
        return dstv;
    }
    
    public void chinhSuaTV(){
        dstv.showMenu();
    }
    
    public void chinhSuaCS(){
        dscskd.showMenu();
    }
    
    public void chinhSuaTP(){
        dstp.showMenu();
    }
    
    public void chinhSuaPT(){
        dspt.showMenu();
    }
    
    public void nhap(){
        System.out.println("----------Thêm tour du lich moi-----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tour: ");
        tenTour = sc.nextLine();
        System.out.print("Nhap ngay di: ");
        ngayDi = sc.nextLine();
        System.out.print("Nhap ngay ve: ");
        ngayDi = sc.nextLine();
        System.out.print("Nhap gia tien: ");
        giaTien = sc.nextInt();
        
        dstv.them();
        dscskd.them();
        dstp.them();
        dspt.them();
    }
    
    public void xuat(){
        System.out.println("ID: " + idTour);
        System.out.println("Tên tour: " + tenTour);
        System.out.println("Ngày: " + ngayDi + " ~ " + ngayVe);
        dstv.xuat();
        dscskd.xuat();
        dstp.xuat();
        dspt.xuat();
        System.out.println("------Giá tour: " + giaTien + "VND");
    }
    
    @Override
    public String toString(){
        String str = tenTour + "," + ngayDi + "," + ngayVe + "," + giaTien + "\n";
        str += dstp.toString() + dscskd.toString() + dstv.toString() + dspt.toString();
        return str;        
    }
    
    public void datVe(){        
        dstv.datVe();
    }
    
    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===================Menu quản lý tour du lịch====================");
        System.out.println("1. Chinh sua thanh pho");
        System.out.println("2. Chinh sua co so kinh doanh");
        System.out.println("3. Chinh sua thanh vien");
        System.out.println("4. Chinh sua phuong tien");
        System.out.println("5. Xuat tour du lich");
        System.out.println("0. Thoat");
        System.out.printf("Vui long chon:");
        switch (sc.nextInt()){
            case 0:
                return;
            case 1:
                chinhSuaTP();
                break;
            case 2:
                chinhSuaCS();
                break;
            case 3:
                chinhSuaTV();
                break;
            case 4:
                chinhSuaPT();
                break;
            case 5:
                xuat();
                break;
            default:
                System.out.println("Nhap sai vui long nhap lai");
                break;
        }
        showMenu();
    }
}
