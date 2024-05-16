/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NOBITA
 */
public class DSGiangVien {

    private List<GiangVien> dsGiangVien = new ArrayList<>();
    public boolean checkMaGV(int maGV){
        for(GiangVien x: this.dsGiangVien){
            if(x.getMaGV() == maGV){
                return true;// ma da ton tai
            }
        }
        return false;
    }

    public void themGiangVien(GiangVien gv) {
        this.dsGiangVien.add(gv);
    }

    public void hienThi() {
        this.dsGiangVien.forEach(a -> a.hienThi());
    }

    public boolean xoaGV(int ma) {
        for (GiangVien x : this.dsGiangVien) {
            if (x.getMaGV() == ma) {
                this.dsGiangVien.remove(x);
                return true;
            }
        }
        return false;
    }

    public GiangVien layGiangVienDuaVaoMaGV(int id) {
        for (GiangVien x : this.dsGiangVien) {
            if (x.getMaGV() == id) {
                return x;
            }
        }
        return null;
    }

    public List<GiangVien> thanhVienThamGia(String nv) {
//        List<Integer> dsMa = new ArrayList<>();
        List<GiangVien> dsThamGia = new ArrayList<>();
        for (GiangVien x : this.dsGiangVien) {
            if (x.isThamGiaKhoaLuan() == true) {
                if (x.getNhiemVu().equals(nv) == true) {
//                    dsMa.add(x.getMaGV());
                    dsThamGia.add(x);
                }
            }
        }
        return dsThamGia;

    }
    public List<GiangVien> thanhVienThamGia() {
        List<Integer> dsMa = new ArrayList<>();
        List<GiangVien> dsThamGia = new ArrayList<>();
        for (GiangVien x : this.dsGiangVien) {
            if (x.isThamGiaKhoaLuan() == true) {
                dsMa.add(x.getMaGV());
                dsThamGia.add(x);
            }
        }
        return dsThamGia;
    }
    public void docFileGV(String s) throws FileNotFoundException, ParseException {
        File f = new File(s);
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            int maGV = Integer.parseInt(sc.nextLine());
            String hoTen = sc.nextLine();
            String hocHam = sc.nextLine();
            String hocVi = sc.nextLine();
            boolean thamGia = Boolean.parseBoolean(sc.nextLine());
            String nhiemVu = sc.nextLine();
            GiangVien gv1 = new GiangVien(hoTen, hocHam, hocVi, thamGia, nhiemVu);
            this.dsGiangVien.add(gv1);
        }
    }
    public List<GiangVien> getDsGiangVien() {
        return dsGiangVien;
    }
    public void setDsGiangVien(List<GiangVien> dsGiangVien) {
        this.dsGiangVien = dsGiangVien;
    }
}
//    public void luuGV(String path, GiangVien s) throws IOException {
////        String ngay = f.format(s.get);
//        File f = new File(path);
//        FileWriter w = new FileWriter(f, true);
//        try ( PrintWriter pw = new PrintWriter(w)) {
//            pw.println(s.getMaGV());
//            pw.println(s.getHoten());
//            pw.println(s.getHocHam());
//            pw.println(s.getHocVi());
//            pw.println(s.getNhiemVu());
//        }
//    }
