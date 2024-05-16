/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NOBITA
 */
public class DsSinhVien {

    private List<SinhVien> dsSV = new ArrayList<>();

    public void themSV(SinhVien sv) {
        this.dsSV.add(sv);

    }
    public SinhVien laySVTheoMa(int maSV){
        for(SinhVien x: this.dsSV){
            if(x.getMaSV()== maSV)
                return x;
        }
        return null;
    }
    public boolean xoaSinhVien(int sv) {
        for (SinhVien x : this.dsSV) {
            if (x.getMaSV() == sv) {
                this.dsSV.remove(x);
                return true;
            }
        }
        return false;
    }
    public void hienThi() {
        for (SinhVien sv : this.dsSV) {
            sv.hienThi();
        }
        System.out.println();
    }
//String khoaHoc,String tenSV, String gioiTinh, String namSinh, String chuyenNghanh
    public void docFileSV(String s) throws FileNotFoundException, ParseException {
        File f = new File(s);
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            int maSo = Integer.parseInt(sc.nextLine());
            String khoaHoc = sc.nextLine();
            String hoTen = sc.nextLine();
            String gioitinh = sc.nextLine();
            String namSinh = sc.nextLine();
            String chuyenNganh = sc.nextLine();
            int maBC = Integer.parseInt(sc.nextLine());
            boolean thamGia = Boolean.parseBoolean(sc.nextLine());
            SinhVien sv = new SinhVien(khoaHoc, hoTen, gioitinh, namSinh, chuyenNganh,thamGia,maBC);
            this.dsSV.add(sv);
        }
    }

    public void luuSV(String path, SinhVien s) throws IOException {
        String ngay = f.format(s.getNamSinh());
        File f = new File(path);
        FileWriter w = new FileWriter(f, true);
        try ( PrintWriter pw = new PrintWriter(w)) {
            pw.println(s.getMaSV());
            pw.println(s.getKhoaHoc());
            pw.println(s.getTenSV());
            pw.println(s.getGioiTinh());
            pw.println(ngay);
            pw.println(s.getChuyenNghanh());
            pw.println(s.getMaBC());
        }
    }

    public List<SinhVien> getDsSV() {
        return dsSV;
    }

    public void setDsSV(List<SinhVien> dsSV) {
        this.dsSV = dsSV;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
