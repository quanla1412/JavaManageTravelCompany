
package main;
import java.util.Scanner;
/**
 *
 * @author Nhat Tan
 */
public class PhuongTien {
    private String bienKiemsoat="";
    private int soChongoi=0;
    private String loaiPhuongtien="";
    
    public PhuongTien() {        
    }
    
    public PhuongTien(String bienKiemsoat, int soChongoi, String loaiPhuongtien) {
        this.bienKiemsoat = bienKiemsoat;
        this.soChongoi = soChongoi;
        this.loaiPhuongtien = loaiPhuongtien;        
    }
    
    public String getbienKiemsoat(){
        return bienKiemsoat;
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập biển số kiểm soát: ");
        bienKiemsoat = sc.nextLine();
        System.out.print("Nhập số chỗ ngồi: ");
        soChongoi = sc.nextInt();
        System.out.print("Nhập loại phương tiện: ");
        sc.nextLine();
        loaiPhuongtien = sc.nextLine();
        System.out.println();
    }
    
    public void xuat() {
        System.out.println("Biến số xe: " + bienKiemsoat);
        System.out.println("Số chỗ ngồi: " + soChongoi);
        System.out.println("Phương tiện: " + loaiPhuongtien);
    }
    
    @Override
    public String toString(){
        return bienKiemsoat + "," + soChongoi + "," + loaiPhuongtien + "\n";
    }
}
