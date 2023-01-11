
package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;
public class DanhSachThanhVien  implements DanhSach{
    ConNguoi [] dstv;
    int soLuongThanhVien;
    
    public DanhSachThanhVien(){
        soLuongThanhVien = 0;
        dstv = new ConNguoi[0];
   }
    public DanhSachThanhVien(ConNguoi[] dstv,int soLuongThanhVien){
        this.dstv=dstv;
        this.soLuongThanhVien= soLuongThanhVien ;
    }
    
    @Override
    public void them(){
        Scanner sc = new Scanner(System.in);
        System.out.println ("----- Thêm thành viên -----");
        System.out.print("Nhập số lượng thành viên muốn thêm: ");
        int n = sc.nextInt();
        dstv = Arrays.copyOf(dstv,soLuongThanhVien+n);
        for (int i=0;i<n;i++)
        {
           System.out.println ("Chọn 1 nếu muốn thêm hành khách, Chọn 2 nếu muốn thêm hướng dẫn viên ");
            switch (sc.nextInt())
            {
            case 1: 
                dstv[soLuongThanhVien+i]= new HanhKhach();
                dstv[soLuongThanhVien+i].nhap();
                break;
            case 2:
                dstv[soLuongThanhVien+i] = new HuongDanVien();
                dstv[soLuongThanhVien+i].nhap();
                break;
            default:
                System.out.println ("Nhập sai vui lòng nhập lại ");
                i--;
                break;
            }
        }
        soLuongThanhVien+=n;
        System.out.println("------------------------");
    }
    
    
    @Override
    public void xuat()
    {  
        System.out.println("---------- Danh sách thành viên ----------");
        for (int i=0;i<soLuongThanhVien;i++) 
        {
            System.out.println("Thành viên thứ "+(i+1)+" :");
            dstv[i].xuat();
            System.out.println();
        }
        System.out.println("--------------------------\n");
    }
    
    public void xuatHanhKhach(){
        for(int i=0;i<dstv.length;i++){
            if(dstv[i] instanceof HanhKhach){
                dstv[i].xuat();
            }
        }
    }
    
    public void xuatHuongDanVien(){
        for(int i=0;i<dstv.length;i++){
            if(dstv[i] instanceof HuongDanVien){
                dstv[i].xuat();
                System.out.println("");
            }
        }
    }
    
    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Sửa thành viên ----------");
        System.out.print("Nhập ID cần sửa: ");
        sc.nextLine();
        String ID = sc.nextLine();
        for(int i = 0; i < soLuongThanhVien; i++)
        {
            if(dstv[i].getID().equals(ID)){                               
                dstv[i].nhap();
                System.out.println("-------------Sửa thành công--------------"); 
                return;
            }
        }
        System.out.println("---------- Không tìm thấy ----------");        
    }
    
    @Override
    public void xoa (){ 
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Xóa thành viên ----------");
        System.out.print("Nhập ID cần xóa: ");
        sc.nextLine();
        String str = sc.nextLine();
        for (int i=0;i<soLuongThanhVien;i++)
        {
            if (dstv[i].getID().equals(str))
            {
                for (int j=i;j<soLuongThanhVien-1;j++){
                    dstv[j]=dstv[j+1];
                }
                dstv =Arrays.copyOf(dstv,--soLuongThanhVien);
                System.out.println("---------- Xóa thành công ----------");
                return;
            }
        }  
        System.out.println("---------- Không tìm thấy ----------"); 
    }
    
    @Override
    public void timKiem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Tìm kiếm thành viên ----------");
        System.out.print("Nhập ID cần tìm: ");
        sc.nextLine();
        String str = sc.nextLine();
        for (int i=0;i<dstv.length;i++)
        {
            if (dstv[i].getID().equals(str))
            {
                dstv[i].xuat();
                return;
            }
        }
        System.out.println("---------- Không tìm thấy ----------");    
    }
    
    public void datVe ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("\n------------Nhập thông tin thành viên---------------");
        System.out.print("Nhập số lượng thành viên muốn nhập: ");
        int n = sc.nextInt();
        dstv = Arrays.copyOf(dstv,soLuongThanhVien+n);
        for (int i=0;i<n;i++)
        {
            dstv[soLuongThanhVien+i]= new HanhKhach();
            dstv[soLuongThanhVien+i].nhap();
            System.out.println();
        }
        soLuongThanhVien+=n;
        System.out.println("-------------Đặt vé thành công-----------");
    }
    
    @Override
    public String toString(){
      String str = soLuongThanhVien + "\n";
        for (int i=0;i<dstv.length;i++) 
        {
            str+=dstv[i].toString();
        }
      return str;
    }
    public void docFile(){
        try{
           BufferedReader br = new BufferedReader (new FileReader("input.txt")); 
           String line = br.readLine();
           while (line != null) {
               String tv[] = line.split(",");
               dstv = Arrays.copyOf(dstv, soLuongThanhVien+1);
               if(tv[0].equals("HK")){
                   dstv[soLuongThanhVien++] = new HanhKhach(tv[1],tv[2],tv[3],tv[4],tv[5],tv[6],tv[7]);
               }else{
                   dstv[soLuongThanhVien++] = new HuongDanVien(tv[1],tv[2],tv[3],tv[4],tv[5],tv[6],tv[7]);
               }
               
               line = br.readLine();
            }   
           br.close();
        }catch (Exception ex) {
           ex.printStackTrace();    
        }
    }
    public void ghiFile(){
        try{
            FileWriter fw = new FileWriter("data.txt");
            fw.write(toString());
            fw.close();
            System.out.println("\n---------- Xuất file thành công ----------");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    /*******************SHOW MENU**********************/
    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        int x = 0;
        do {            
            System.out.println("---------- Menu Quản lý thành viên tour ----------");
            System.out.println("1. Thêm thành viên");
            System.out.println("2. Xóa thành viên");
            System.out.println("3. Sửa thành viên");
            System.out.println("4. Tìm kiếm thành viên");
            System.out.println("5. Xuất danh sách thành viên");
            System.out.println("6. Xuất file danh sách thành viên");
            System.out.println("7. Đọc danh sách toàn bộ thành viên mới qua file ");
            System.out.println("0. Thoát");
            System.out.println("--------------------------------------------------");
            System.out.print("Vui lòng chọn: ");
            x  = sc.nextInt();
            switch (x) {
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
                    xuat();
                    break;
                case 6:
                    ghiFile();
                    break;
                case 7:
                    docFile();
                    break;    
                default:
                   System.out.println("Nhập sai vui lòng nhập lại: ");
                   break;
            }
        } while (x != 0);   
    }
}
