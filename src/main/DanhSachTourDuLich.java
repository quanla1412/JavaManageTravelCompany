package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author LeAnhQuan
 */
public class DanhSachTourDuLich implements DanhSach{
    private TourDuLich tdl[];
    private int soLuongTour;

    public DanhSachTourDuLich() {
        tdl = new TourDuLich[0];
        soLuongTour = 0;
    }

    public DanhSachTourDuLich(TourDuLich[] tdl, int soLuongTour) {
        this.tdl = tdl;
        this.soLuongTour = soLuongTour;
    }
    
    @Override
    public void them(){
        tdl = Arrays.copyOf(tdl, soLuongTour+1);
        tdl[soLuongTour] = new TourDuLich() ;
        tdl[soLuongTour++].nhap();        
    }
    
    @Override
    public void xuat(){
        System.out.println("*************************************************");
        System.out.println("===========Danh sách tour du lịch===============");
        for(int i=0;i<tdl.length;i++){
            System.out.println("Tour " + (i+1) + ": ");
            tdl[i].xuat();
            System.out.println("\n*************************************************");
        }
    }
    
    public void xuatTen(){
        System.out.println("---------- Danh sách tour du lịch ----------");
        for(int i=0;i<tdl.length;i++){
            System.out.println((i+1) + "." + tdl[i].getIdTour() + " : " + tdl[i].getTenTour());
        }
    }
    
    public void ghiFile(){
        BufferedWriter fr = null; 
        try {
            fr = new BufferedWriter(new FileWriter("danh_sach_tour.txt"));
            fr.write(toString());
            System.out.println("-------------Xuất thành công-----------\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }       
    }
    
    public void docFile(){
        BufferedReader br = null;
        tdl = Arrays.copyOf(tdl,0);
        try {
            br = new BufferedReader(new FileReader("danh_sach_tour.txt"));
            
            soLuongTour = Integer.parseInt(br.readLine());
            tdl = Arrays.copyOf(tdl,soLuongTour);
            
            for(int i=0;i<soLuongTour;i++){
                
                String[] infoTour = br.readLine().split(",");

                int soLuongTP = Integer.parseInt(br.readLine());
                ThanhPho tp[] = new ThanhPho[soLuongTP];
                for(int j=0;j<soLuongTP;j++){
                    String[] infoTP = br.readLine().split(",");
                    tp[j] = new ThanhPho(infoTP[0],infoTP[1],infoTP[2],infoTP[3],infoTP[4],infoTP[5]);
                }
                DanhSachThanhPho dstp= new DanhSachThanhPho(tp,tp.length);

                int soLuongCS = Integer.parseInt(br.readLine());
                CoSoKinhDoanh cs[] = new CoSoKinhDoanh[soLuongCS];
                for(int j=0;j<soLuongCS;j++){
                    String[] infoCS = br.readLine().split(",");
                    if(infoCS[0].equals("NH"))  cs[j] = new NhaHang(infoCS[1],infoCS[2],infoCS[3],infoCS[4],infoCS[5],Integer.parseInt(infoCS[6]));
                    else cs[j] = new KhachSan(infoCS[1],infoCS[2],infoCS[3],infoCS[4],infoCS[5],Integer.parseInt(infoCS[6]));
                }
                DanhSachCoSoKinhDoanh dscskd = new DanhSachCoSoKinhDoanh(cs,cs.length);

                int soLuongTV = Integer.parseInt(br.readLine());
                ConNguoi tv[] = new ConNguoi[soLuongTV];
                for(int j=0;j<soLuongTV;j++){
                    String[] infoTV = br.readLine().split(",");
                    if(infoTV[0].contains("HK"))  tv[j] = new HanhKhach(infoTV[1],infoTV[2],infoTV[3],infoTV[4],infoTV[5],infoTV[6],infoTV[7]);
                    else tv[j] = new HuongDanVien(infoTV[1],infoTV[2],infoTV[3],infoTV[4],infoTV[5],infoTV[6],infoTV[7]);
                }
                DanhSachThanhVien dstv = new DanhSachThanhVien(tv,tv.length);

                int soLuongPT = Integer.parseInt(br.readLine());
                PhuongTien pt[] = new PhuongTien[soLuongPT];
                for(int j=0;j<soLuongPT;j++){
                    String[] infoPT = br.readLine().split(",");
                    pt[j] = new PhuongTien(infoPT[0],Integer.parseInt(infoPT[1]),infoPT[2]);
                }
                DanhSachPhuongTien dspt= new DanhSachPhuongTien(pt,pt.length);
            
                tdl[i] = new TourDuLich(infoTour[0],infoTour[1],infoTour[2],Integer.parseInt(infoTour[3]),dstv,dscskd,dstp,dspt);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {            
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public String toString(){
        String str = soLuongTour + "\n";
        for(int i=0;i<tdl.length;i++){
            str += tdl[i].toString();
        }
        return str;
    }
    
    @Override
    public void sua(){
        xuatTen();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id tour bạn muốn chỉnh sửa hoặc xem chi tiết: ");
        String str = sc.nextLine();
        for(int i=0;i<tdl.length;i++){
            if(tdl[i].getIdTour().equals(str)){
                tdl[i].showMenu();
                return;
            }
        }
        System.out.println("------------Không tìm thấy-------------");        
    }
    
    @Override
    public void xoa(){ 
        xuatTen();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id tour muốn xóa: ");
        String str = sc.nextLine();
        for(int i=0;i<tdl.length;i++){
            if(tdl[i].getIdTour().equals(str)){
                for(int j=i;j<tdl.length-1;j++){
                    tdl[j]=tdl[j+1];
                }
                tdl = Arrays.copyOf(tdl, --soLuongTour);
                System.out.println("------------Xóa thành công-------------");
                return;
            }
        }
        System.out.println("------------Không tìm thấy-------------");
    }
    
    @Override
    public void timKiem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("------------Tìm kiếm tour--------------");
        System.out.println("Nhập id tour cần tìm kiếm:");
        String ten = sc.nextLine();
        for(int i=0;i<soLuongTour;i++){
            if(tdl[i].getIdTour().equals(ten)){
                tdl[i].xuat();
                return;
            }
        }
        System.out.println("------------Không tìm thấy-------------");
    }
    
    public void datVe(){
        xuatTen();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id tour bạn muốn đặt vé: ");
        String str = sc.nextLine();
        for(int i=0;i<tdl.length;i++){
            if(tdl[i].getIdTour().equals(str)){
                tdl[i].datVe();
                return;
            }
        }
    }
    
    public void showHanhKhach(){
        System.out.println("------------ Danh sách các hành khách --------------");
        for(int i=0;i<tdl.length;i++){
            System.out.println("Tour " + tdl[i].getIdTour() + ": ");
            tdl[i].getDstv().xuatHanhKhach();
        }
    }
    
    public void showHuongDanVien(){
        System.out.println("------------ Danh sách các hướng dẫn viên --------------");
        for(int i=0;i<tdl.length;i++){
            System.out.println("Tour " + tdl[i].getIdTour() + ": ");
            tdl[i].getDstv().xuatHuongDanVien();
        }
    }
    
     public void showMenu(){
         Scanner sc = new Scanner(System.in);
        int x = 0;
        do {            
            System.out.println("---------- Menu quản lý danh sách tour du lịch ----------");
            System.out.println("1. Thêm tour");
            System.out.println("2. Chỉnh sửa hoặc xem chi tiết tour");
            System.out.println("3. Xóa tour");
            System.out.println("4. Tìm kiếm tour");
            System.out.println("5. Xuất danh sách tour");
            System.out.println("6. Xuất file danh sách tour");
            System.out.println("7. Đặt vé tour ");
            System.out.println("8. Xuất danh sách tất cả hành khách ");
            System.out.println("9. Xuất danh sách tất cả hướng dẫn viên ");            
            System.out.println("10. Đọc file danh sách tour ");          
            System.out.println("11. Tóm tắt danh sách tour ");
            System.out.println("0. Thoát");
            System.out.println("---------------------------------------------------------");
            System.out.print("Vui lòng chọn: ");
            x  = sc.nextInt();
            switch (x) {
                case 0:
                    sc.nextLine();
                    String check = "a";
                    while (!check.equals("Y") && !check.equals("N")) {  
                        System.out.print("Bạn muốn lưu lại danh sách tour hiện tại ? [Y/N]: ");
                        check = sc.nextLine();
                    }
                    if(check.equals("Y"))   ghiFile();
                    break;
                case 1:
                    them();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    timKiem();
                    break;
                case 5:
                    xuat();
                    break;
                case 6:
                    ghiFile();
                    break;
                case 7:
                    datVe();
                    break;   
                case 8:
                    showHanhKhach();
                    break;
                case 9:
                    showHuongDanVien();
                    break;
                case 10:
                    docFile();
                    break;
                case 11:
                    xuatTen();
                    break;
                default:
                   System.out.println("Nhập sai vui lòng nhập lại: ");
                   break;
            }
        } while (x != 0);   
    }
}
