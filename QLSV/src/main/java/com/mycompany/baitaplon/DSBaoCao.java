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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author NOBITA
 */
public class DSBaoCao {

    private List<BaoCao> dsBaoCao = new ArrayList<>();

    public void themBC(BaoCao bc) {
        this.dsBaoCao.add(bc);
    }

    public List<Integer> checkSVThamGia() {
        List<Integer> maSV = new ArrayList<>();
        for (BaoCao x : this.dsBaoCao) {
            List<Integer> maSV2 = x.getMaSVBC();
            for (int y : maSV2) {
                maSV.add(y);
            }
        }
        return maSV;
    }
//    public List<SinhVien> checkSVThamGia(DsSinhVien dsSV) {
//        List<Integer> maSV = new ArrayList<>();
//        List<SinhVien> dsSinhVienThamGia = new ArrayList<>();
//        List<SinhVien> dsTong = dsSV.getDsSV();
//        for (BaoCao x : this.dsBaoCao) {
//            List<Integer> maSV2 = x.getMaSVBC();
//            for (int y : maSV2) {
//                maSV.add(y);
//            }
//        }
//        for (int z : maSV) {
//            SinhVien x1 = dsSV.laySVTheoMa(z);
//            dsSinhVienThamGia.add(x1);
//        }
//        dsTong.removeAll(dsSinhVienThamGia);
//        return dsTong;
//    }

    public boolean checkMaBC(int maBC) {
        for (BaoCao x : this.dsBaoCao) {
            if (x.getMaBC() == maBC) {
                return true;
            }
        }
        return false;
    }

    public boolean xoaBC(int maBC) {
        for (BaoCao x : this.dsBaoCao) {
            if (x.getMaBC() == maBC) {
                this.dsBaoCao.remove(x);
                return true;
            }
        }
        return false;
    }

    public boolean suaBC(int maBC) {//ma
        this.dsBaoCao.forEach(b -> {
            if (b.getMaBC() == maBC) {
                try {
                    b.nhapBaoCao();
                    b.NhapDiem();
                } catch (ParseException e) {

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DSBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return true;
    }

    public BaoCao layBCTheoMa(int id) {
        for (BaoCao x : this.dsBaoCao) {
            if (x.getMaBC() == id) {
                return x;
            }
        }
        return null;
    }

    public BaoCaoKhoaLuan layBCKLbyMa(int id) {
        BaoCaoKhoaLuan bc1 = new BaoCaoKhoaLuan();
        for (BaoCao x : this.dsBaoCao) {
            if (x.getMaBC() == id) {
                bc1 = (BaoCaoKhoaLuan) x;
                return bc1;
            }
        }
        return null;
    }

    public boolean timBCTheoTen(String ten) {
        for (BaoCao x : this.dsBaoCao) {
            if (x.getTenBC().equals(ten)) {
                x.hienThiBC();
                return true;
            }
        }
        return false;
    }

    public void sapXepTen() {
        Collections.sort(this.dsBaoCao, Comparator.comparing(BaoCao::getTenBC));
    }

//    public void sapXepNgayPL() {
//        Collections.sort(dsBaoCao, Comparator.comparing(BaoCao::getLoaiBaoCao).thenComparing(BaoCao::getNgayBC));
//    }
    public void sapXepBCNgay() {
        Collections.sort(dsBaoCao, Comparator.comparing(BaoCao::getNgayBC));
    }

    public List<BaoCao> xemBCTheoLoai(String path) throws ClassNotFoundException {
        List<BaoCao> kq = new ArrayList<>();
        Class bc = Class.forName(path);
        for (BaoCao x : this.dsBaoCao) {
            if (x.getClass().equals(bc) == true) {
                kq.add(x);
            }
        }
        return kq;
    }

    public List<BaoCao> isbaoCaoKhoaLuan() {
        List<BaoCao> dsKL = new ArrayList<>();
        for (BaoCao x : this.dsBaoCao) {
            if (x.getLoaiBaoCao().equals("Khoa Luan")) {
                dsKL.add(x);
            }
        }
        return dsKL;
    }

    public DSBaoCao timBCbyDate(String ngayBatdau, String ngayKetThuc) throws ParseException {
        DSBaoCao dsTheoNgay = new DSBaoCao();
        Date first = f.parse(ngayBatdau);
        Date last = f.parse(ngayKetThuc);
        // after :sau
        dsTheoNgay.setDsBaoCao(this.dsBaoCao.stream().filter((a)
                -> {
            return (a.getNgayBC().before(last)
                    && a.getNgayBC().after(first))
                    || a.getNgayBC().equals(first)
                    || a.getNgayBC().equals(last);
        }).collect(Collectors.toCollection(ArrayList::new)));
        return dsTheoNgay;
    }

    public void docFileBC(String s) throws FileNotFoundException, ParseException {
        File f = new File(s);
        Scanner sc = new Scanner(f);
//        List<Integer> dsMaSVDA = new ArrayList<>();
        while (sc.hasNext()) {
            int maSo = Integer.parseInt(sc.nextLine());
            String tenBC = sc.nextLine();
            String ngayBC = sc.nextLine();
            String tenGV = sc.nextLine();
            String link = sc.nextLine();
            String loai = sc.nextLine();
            double diem = Double.parseDouble(sc.nextLine());

            if (s.contains("DSBCDAN")) {
                List<Integer> dsMaSVDA = new ArrayList<>();
                double tyLe = Double.parseDouble(sc.nextLine());
                int maSV = Integer.parseInt(sc.nextLine());
                if (maSV != -1) {
                    dsMaSVDA.add(maSV);
                }
                int maSV1 = Integer.parseInt(sc.nextLine());
                if (maSV1 != -1) {
                    dsMaSVDA.add(maSV1);
                }
                BaoCaoDoAn bc1 = new BaoCaoDoAn(tenBC, ngayBC, tenGV, link, diem, tyLe, dsMaSVDA);
                this.dsBaoCao.add(bc1);
            } else if (s.contains("DSBCTTTN")) {
                List<Integer> dsMaSVTT = new ArrayList<>();
                String danhGia = sc.nextLine();
                int maSV = Integer.parseInt(sc.nextLine());
                if (maSV != -1) {
                    dsMaSVTT.add(maSV);
                }
                int maSV1 = Integer.parseInt(sc.nextLine());
                if (maSV1 != -1) {
                    dsMaSVTT.add(maSV1);
                }
                BaoCaoThucTap bc1 = new BaoCaoThucTap(tenBC, ngayBC, tenGV, link, diem, danhGia, dsMaSVTT);
                this.dsBaoCao.add(bc1);
            } else if (s.contains("DSBCKLTN")) {
                List<Integer> dsMaSVKL = new ArrayList<>();
                double tyLe = Double.parseDouble(sc.nextLine());
                String dGiaPhanBien = sc.nextLine();
                int maHD = Integer.parseInt(sc.nextLine());
                int maSV = Integer.parseInt(sc.nextLine());
                int maSV1 = Integer.parseInt(sc.nextLine());
                if (maSV != -1) {
                    dsMaSVKL.add(maSV);
                }
                if (maSV1 != -1) {
                    dsMaSVKL.add(maSV1);
                }
                BaoCaoKhoaLuan bc1 = new BaoCaoKhoaLuan(tenBC, ngayBC, tenGV, link, diem, tyLe, dGiaPhanBien, maHD, dsMaSVKL);
                this.dsBaoCao.add(bc1);
            }
        }
    }

    public void luuBC(String path, BaoCaoDoAn s) throws IOException {
        String ngay = f.format(s.getNgayBC());
        File f = new File(path);
        FileWriter w = new FileWriter(f, true);
        try ( PrintWriter pw = new PrintWriter(w)) {
            pw.println(s.getMaBC());
            pw.println(s.getTenBC());
            pw.println(ngay);
            pw.println(s.getTenGV());
            pw.println(s.getChuoiLink());
            pw.println(s.getLoaiBaoCao());
            pw.println(s.getDiemBC());
            pw.println(s.getTiLeDaoVan());
        }
    }

    public void luuBC(String path, BaoCaoThucTap s) throws IOException {
        String ngay = f.format(s.getNgayBC());
        File f = new File(path);
        FileWriter w = new FileWriter(f, true);
        try ( PrintWriter pw = new PrintWriter(w)) {
            pw.println(s.getMaBC());
            pw.println(s.getTenBC());
            pw.println(ngay);
            pw.println(s.getTenGV());
            pw.println(s.getChuoiLink());
            pw.println(s.getLoaiBaoCao());
            pw.println(s.getDiemBC());
            pw.println(s.getThongTinDanhGia());
        }
    }

    public void luuBC(String path, BaoCaoKhoaLuan s) throws IOException {
        String ngay = f.format(s.getNgayBC());
        File f = new File(path);
        FileWriter w = new FileWriter(f, true);
        try ( PrintWriter pw = new PrintWriter(w)) {
            pw.println(s.getMaBC());
            pw.println(s.getTenBC());
            pw.println(ngay);
            pw.println(s.getTenGV());
            pw.println(s.getChuoiLink());
            pw.println(s.getLoaiBaoCao());
            pw.println(s.getDiemBC());
            pw.println(s.getTiLeDaoVan());
            pw.println(s.getDanhGiaGVPhanBien());

        }
    }

    public List<Integer> checkSVThamGia(DSBaoCao dsBC, DsSinhVien dsSinhVien) {
        List<Integer> maSV = dsBC.checkSVThamGia();// DS MSSV da tham gia BC
        List<SinhVien> sinhVien = new ArrayList<>();// List SV da tham Gia BC
        try {
            for (int x : maSV) {
                sinhVien.add(dsSinhVien.laySVTheoMa(x));
            }
            for (SinhVien y : sinhVien) { // duyet List SV
                y.setCheckSinhVien(true);// set 
            }
        } catch (NullPointerException e) {
        }
        List<SinhVien> sinhVienChuaTG = dsSinhVien.getDsSV();
        List<Integer> maSVChuaThamGia = new ArrayList<>();// DS MSSV da tham gia BC
        sinhVienChuaTG.removeAll(sinhVien);
        for (SinhVien z : sinhVienChuaTG) {
            maSVChuaThamGia.add(z.getMaSV());
        }
        return maSVChuaThamGia;
    }

    public void hienThiBC() {
        this.dsBaoCao.forEach(a -> a.hienThiBC());
    }

    public List<BaoCao> getDsBaoCao() {
        return dsBaoCao;
    }

    public void setDsBaoCao(List<BaoCao> dsBaoCao) {
        this.dsBaoCao = dsBaoCao;
    }

}
