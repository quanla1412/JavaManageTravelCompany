
package main;
import java.util.Scanner;
class HuongDanVien extends ConNguoi{
    private String KinhNghiem;
    private String NgayVaoLam;
    private static int idHDVCur=0;
    
    public static String cdHDVID(){
        return "HDV" + ++idHDVCur;
    }
    
    public HuongDanVien(){
        super(cdHDVID());
        KinhNghiem = "";
        NgayVaoLam = "";
    }
    
    public HuongDanVien(String Ten,String NgaySinh,String DiaChi,String Phone,String CMND,String KinhNghiem,String NgayVaoLam){
        super(cdHDVID(),Ten,NgaySinh,DiaChi,Phone,CMND);
        this.KinhNghiem = KinhNghiem;
        this.NgayVaoLam = NgayVaoLam;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kinh nghiệm HDV: ");
        KinhNghiem = sc.nextLine();
        System.out.print("Nhập ngày vào làm: ");
        NgayVaoLam = sc.nextLine();
    }
    @Override
    
    public void xuat(){
        super.xuat();
        System.out.println("Kinh nghiệm HDV là: " + KinhNghiem);
        System.out.println("Ngày vào làm là: " + NgayVaoLam);
    }
    @Override
    public String toString(){
        return super.toString() + "," + KinhNghiem + "," + NgayVaoLam + "\n";
    }
}
