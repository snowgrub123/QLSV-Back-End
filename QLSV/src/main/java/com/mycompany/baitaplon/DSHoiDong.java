/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author NOBITA
 */
public class DSHoiDong {

    private List<HoiDongBaoVe> dsHD = new ArrayList<>();

    public void them(HoiDongBaoVe s) {
        this.dsHD.add(s);
    }

    public void hienThiHd() {
        this.dsHD.forEach(a -> a.hienThi());
    }

    public void docFileHD(String s, DSBaoCao dsBC, DSGiangVien dsgv) throws FileNotFoundException, ParseException {
        List<BaoCao> dsBaoCao = new ArrayList<>();
        List<GiangVien> dsGiangVien = new ArrayList<>();
        String ngay;
        File f = new File(s);
        Scanner sc = new Scanner(f);
        try {
            while (sc.hasNext()) {
                int maHD = Integer.parseInt(sc.nextLine());
                String ngaylamViec = sc.nextLine();
                ngay = ngaylamViec;
                String x = sc.nextLine();
                if (x.equals("DanhSachBC")) {
                    while (sc.nextLine().equals("DanhSachGV") == false) {
                        int maSo = Integer.parseInt(sc.nextLine());
                        BaoCao bc1 = dsBC.layBCTheoMa(maSo);
                        dsBaoCao.add(bc1);
                    }
                }
                while (sc.nextLine().equals("KetThuc") == false) {
                    int maGV = Integer.parseInt(sc.nextLine());
                    GiangVien gv1 = dsgv.layGiangVienDuaVaoMaGV(maGV);
                    dsGiangVien.add(gv1);
                }
                HoiDongBaoVe hd1 = new HoiDongBaoVe(dsBaoCao, dsGiangVien, ngay,maHD);
                this.dsHD.add(hd1);
                break;
            }
        } catch (NoSuchElementException e) {
        }
    }

    public HoiDongBaoVe timKiemTheoNgay(String ngay) throws ParseException {
        HoiDongBaoVe timTheoNgay = new HoiDongBaoVe();
        Date tim = f.parse(ngay);
        for (HoiDongBaoVe x : this.dsHD) {
            if (x.getNgayLamViec().equals(tim) == true) {
                timTheoNgay = x;
                return timTheoNgay;
            }
        }
        return null;
    }
    public DSHoiDong timKiemTheoNgay(String batDau,String ngayKT) throws ParseException {
        DSHoiDong dsHoiDong = new DSHoiDong();
        Date first = f.parse(batDau);
        Date last = f.parse(ngayKT);
        dsHoiDong.setDsHD(this.dsHD.stream().filter((a)
                ->{
            return (a.getNgayLamViec().before(last)
                    && a.getNgayLamViec().after(first))
                    ||a.getNgayLamViec().equals(first)
                    ||a.getNgayLamViec().equals(first);
        }).collect(Collectors.toCollection(ArrayList::new )));
        return dsHoiDong;
    }
    
//    public DSBaoCao timBCbyDate(String ngayBatdau, String ngayKetThuc) throws ParseException {
//        DSBaoCao dsTheoNgay = new DSBaoCao();
//        Date first = f.parse(ngayBatdau);
//        Date last = f.parse(ngayKetThuc);
//        // after :sau
//        dsTheoNgay.setDsBaoCao(this.dsBaoCao.stream().filter((a)
//                -> {
//            return (a.getNgayBC().before(last)
//                    && a.getNgayBC().after(first))
//                    || a.getNgayBC().equals(first)
//                    || a.getNgayBC().equals(last);
//        }).collect(Collectors.toCollection(ArrayList::new)));
//        return dsTheoNgay;
//    }

    public HoiDongBaoVe timHoiDongByID(int ma) {
        for (HoiDongBaoVe x : this.dsHD) {
            if (x.getMaHĐ() == ma) {
                return x;
            } 
        }
        return null;
    }
    public boolean checkTrungMaHD(int ma){
        for(HoiDongBaoVe x: this.dsHD){
            if(x.getMaHĐ() == ma){
                return false;
            }
        }
        return true;
    }
      public List<BaoCao> checkBCThamGia() {
        List<BaoCao> dsnew = new ArrayList<>();
        for (HoiDongBaoVe x : this.dsHD) {
           List<BaoCao> dsnew2= x.getDsKL();
            for(BaoCao y: dsnew2){
                dsnew.add(y);
            }
        }
        return dsnew;
    }

    public List<HoiDongBaoVe> getDsHD() {
        return dsHD;
    }

    public void setDsHD(List<HoiDongBaoVe> dsHD) {
        this.dsHD = dsHD;
    }
}
