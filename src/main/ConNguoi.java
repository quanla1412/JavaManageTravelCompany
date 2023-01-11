
package main;

import java.util.Scanner;
class ConNguoi {
    private String ID;
    private String Ten;
    private String NgaySinh;
    private String DiaChi;
    private String Phone;
    private String CMND;
    
    public ConNguoi(String ID){
        this.ID = ID;
        Ten = "";
        NgaySinh = "";
        DiaChi = "";
        Phone = "";
        CMND = "";
    }
    
    public ConNguoi(String ID,String Ten,String NgaySinh,String DiaChi,String Phone,String CMND){
        this.ID = ID;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Phone = Phone;
        this.CMND = CMND;
    }

    public String getID() {
        return ID;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Tên: ");
        Ten = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        NgaySinh = sc.nextLine();
        System.out.print("Nhập địa Chỉ: ");
        DiaChi = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        Phone = sc.nextLine();
        System.out.print("Nhập CMND: ");
        CMND = sc.nextLine();
    }
    
    public void xuat(){
        System.out.println("ID là: " + ID);
        System.out.println("Tên là: " + Ten);
        System.out.println("Ngày sinh là: " + NgaySinh);
        System.out.println("Địa Chỉ là: " + DiaChi);
        System.out.println("Số điện thoại là: " + Phone);
        System.out.println("Số CMND là: " + CMND);
    }
    @Override
    public String toString(){
        String str;
        str =ID + ","+ Ten + "," + NgaySinh + "," + DiaChi + "," + Phone + "," + CMND ;
        return str;
    }
}
