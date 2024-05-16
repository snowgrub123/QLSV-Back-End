/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NOBITA
 */
public class SinhVien {

    private static int dem = 0;
    public static Scanner s = new Scanner(System.in);
    public static SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    private String khoaHoc;
    private int maSV;
    private String tenSV;
    private String gioiTinh;
    private Date namSinh;
    private String chuyenNghanh;
    private int maBC;
    private static boolean check = false;
    private boolean checkSinhVien = false;

    {
        ++dem;
        this.maSV = dem;
//        this.maBC = String.format("BC%s", dem);
    }

    public SinhVien() {
    }

    public SinhVien(String khoaHoc, String tenSV, String gioiTinh, String namSinh, String chuyenNghanh,boolean tinhTrang,int maBC) throws ParseException {
        this.maSV = maSV;
        this.khoaHoc = khoaHoc;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.namSinh = f.parse(namSinh);
        this.chuyenNghanh = chuyenNghanh;
        this.checkSinhVien = tinhTrang;
        this.maBC = maBC;
    }

    public void kiemTraDate(Date ngay) throws ParseException {
        do {
            f.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            System.out.print("Nhap ngay sinh(dd/mm/yyyy): ");
            try {
                ngay = f.parse(s.nextLine());
                check = true;// parse dateString thành kiểu Date
            } catch (ParseException e) {
                System.out.println("Ngay thang khong hop le!");
                check = false;
            }
        } while (check == false);
        this.namSinh = ngay;
        System.out.println("Nhap ngay thang thanh cong!");
    }

//    public static void kiemTraMaSoSV(int maSo) throws FileNotFoundException {
//        String fileString = "src/main/java/dsSV";
//        File f = new File(fileString);
//        Scanner sc = new Scanner(f);
//        List<Integer> list = new ArrayList<Integer>();
//        while (sc.hasNext()) {
//            int maSo1 = Integer.parseInt(sc.nextLine());
//            String khoaHoc = sc.nextLine();
//            String hoTen = sc.nextLine();
//            String gioitinh = sc.nextLine();
//            String namSinh = sc.nextLine();
//            String chuyenNganh = sc.nextLine();
//            String maBC = sc.nextLine();
//            list.add(maSo1);
//        }
//        int max = Collections.max(list);
//        if (maSo <= max) {
//            maSo = max++;
//            dem = maSo;
//        }
//    }

    public void nhapSV() throws ParseException, FileNotFoundException {
//        kiemTraMaSoSV(this.maSV);
        System.out.print("Nhap khoa hoc: ");
        khoaHoc = s.nextLine();
        System.out.print("Nhap ten SV: ");
        this.tenSV = s.nextLine();
        int gTinh = 1;
        do {
            System.out.print("Nhap gioi tinh(Nam(1),Nu(2)): ");
            gTinh = s.nextInt();
            s.nextLine();
        } while (gTinh != 1 && gTinh != 2);
        if (gTinh == 1) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nu";
        }
        kiemTraDate(this.namSinh);
        System.out.print("Nhap chuyen nganh:");
        chuyenNghanh = s.nextLine();
        System.out.println();
    }

    //Masp ,String khoaHoc,String tenSV, String gioiTinh, String namSinh, String chuyenNghanh, MaBc
    public void hienThi() {
        System.out.printf("""
                          [MSSV]:%d
                          \t[Khoa hoc]:%s\t\t\t[Ten SV]:%s
                          \t[Gioi Tinh]:%s\t\t\t[Nam Sinh]:%s
                          \t[Chuyen Nganh]:%s""",
                this.maSV, this.khoaHoc, this.tenSV,
                this.gioiTinh, f.format(namSinh), this.chuyenNghanh);
        if (this.getMaBC() != -1) {
            System.out.println("\t\t[Ma BC]: " + this.maBC);
        }else{
            System.out.println("\t\t[Ma BC]: Chua Co Du Lieu");
        }
        if(checkSinhVien == true){
            System.out.println("SV Da co BC !");
        }else 
            System.out.println("SV Chua Tham gia BC");
    }
    /**
     * @return the khoaHoc
     */
    public String getKhoaHoc() {
        return khoaHoc;
    }

    /**
     * @param khoaHoc the khoaHoc to set
     */
    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    /**
     * @return the maSV
     */
    public int getMaSV() {
        return maSV;
    }

    /**
     * @param maSV the maSV to set
     */
    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    /**
     * @return the tenSV
     */
    public String getTenSV() {
        return tenSV;
    }

    /**
     * @param tenSV the tenSV to set
     */
    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the namSinh
     */
    public Date getNamSinh() {
        return namSinh;
    }

    /**
     * @param namSinh the namSinh to set
     */
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    /**
     * @return the chuyenNghanh
     */
    public String getChuyenNghanh() {
        return chuyenNghanh;
    }

    /**
     * @param chuyenNghanh the chuyenNghanh to set
     */
    public void setChuyenNghanh(String chuyenNghanh) {
        this.chuyenNghanh = chuyenNghanh;
    }

    /**
     * @return the maBC
     */
    public int getMaBC() {
        return maBC;
    }
//
//    /**
//     * @param maBC the maBC to set
//     */
    public void setMaBC(int maBC) {
        this.maBC = maBC;
    }

    public void setCheckSinhVien(boolean checkSinhVien) {
        this.checkSinhVien = checkSinhVien;
    }
}
