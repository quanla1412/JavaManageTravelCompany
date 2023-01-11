
package main;
import java.util.Scanner;
class HanhKhach extends ConNguoi{
    private String LoaiTV;
    private String DiemTichLuy;
    private static int idHKCur=0;
    
    public static String cdHKID(){
        return "HK" + ++idHKCur;
    }
    
    public HanhKhach(){
        super(cdHKID());
        LoaiTV = "";
        DiemTichLuy = "";
    }
    
    public HanhKhach(String Ten,String NgaySinh,String DiaChi,String Phone,String CMND,String LoaiTV,String DiemTichLuy){
        super(cdHKID(),Ten,NgaySinh,DiaChi,Phone,CMND);
        this.LoaiTV = LoaiTV;
        this.DiemTichLuy = DiemTichLuy;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập loại thành viên: ");
        LoaiTV = sc.nextLine();
        System.out.print("Nhập điểm tích lũy: ");
        DiemTichLuy = sc.nextLine();
    }
    @Override
    
    public void xuat(){
        super.xuat();
        System.out.println("Loại thành viên là: " + LoaiTV);
        System.out.println("Điểm tích lũy là: " + DiemTichLuy);
    }
    @Override
    public String toString(){
        return super.toString() + "," + LoaiTV + "," + DiemTichLuy + "\n";
    }
}
