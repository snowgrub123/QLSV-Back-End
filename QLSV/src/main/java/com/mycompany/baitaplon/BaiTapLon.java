/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.f;
import static com.mycompany.baitaplon.SinhVien.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NOBITA
 */
public class BaiTapLon {

    public static void tiepTucNhap(int chon) {
        try {
            do {
                System.out.print("1.Tiep tuc \t2.Thoat nhap : ");
                chon = Integer.parseInt(s.nextLine());
                if (chon < 1 || chon > 2) {
                    System.out.println("Nhap sai, vui long nhap lai!");
                }
            } while (chon < 1 || chon > 2);
        } catch (NumberFormatException e) {
        }
    }
    public static List<BaoCao> checkBCThamGia(DSHoiDong dsHD, DSBaoCao dsBC) {
        List<BaoCao> maBC = dsHD.checkBCThamGia();
        List<BaoCao> dsTong = dsBC.isbaoCaoKhoaLuan();
        dsTong.removeAll(maBC);
        return dsTong;
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException {

        String dsDA = "src/main/java/DSBCDAN";
        String dsTTTN = "src/main/java/DSBCTTTN";
        String dsKLTN = "src/main/java/DSBCKLTN";
        String dsGV = "src/main/java/DSGV";
        String filesv = "src/main/java/dsSV";
        String pathDA = "com.mycompany.baitaplon.BaoCaoDoAn";
        String pathKL = "com.mycompany.baitaplon.BaoCaoKhoaLuan";
        String pathTT = "com.mycompany.baitaplon.BaoCaoThucTap";
        DSGiangVien dSGV = new DSGiangVien();
        dSGV.docFileGV(dsGV);
        DsSinhVien dsSV = new DsSinhVien();
        DsSinhVien dsSV1 = dsSV;
        DSBaoCao dsBC = new DSBaoCao();
        dsBC.docFileBC(dsDA);
        dsBC.docFileBC(dsTTTN);
        dsBC.docFileBC(dsKLTN);
        dsSV.docFileSV(filesv);
        DSHoiDong dshd = new DSHoiDong();
        String danhSachHD1 = "src/main/java/DSHD1";
        dshd.docFileHD(danhSachHD1, dsBC, dSGV);
        String danhSachHD2 = "src/main/java/DSHD2";
        dshd.docFileHD(danhSachHD2, dsBC, dSGV);
        String danhSachHD3 = "src/main/java/DSHD3";
        dshd.docFileHD(danhSachHD3, dsBC, dSGV);
        List<BaoCao> dsBC1 = checkBCThamGia(dshd, dsBC);
        int chon = 0;
        do {
            try {
                do {
                    System.out.println("\t \t\t\t  /***---------MENU---------***/\n");
                    System.out.print("1.Sinh Vien\t2.Bao Cao\t3.Giang Vien\t4.Hoi Dong\t5.Thoat");
                    System.out.print("\t\tNhap lua chon: ");
                    chon = Integer.parseInt(s.nextLine());
                    System.out.println();
                    if (chon < 1 || chon > 5) {
                        System.out.println("Nhap sai, vui long nhap lai!");
                    }
                } while (chon < 1 || chon > 5);
            } catch (NumberFormatException e) {
            }
            switch (chon) {
                case 1 -> {
                    int chonSV = 0;
                    try {
                        do {
                            System.out.println("\t \t\t\t------Sinh Vien------\n");
                            System.out.println("""
                                                                           \t1.Xem danh sach SV.
                                                                           \t\t\t   2.Them SV vao danh sach.
                                                                           \t\t\t\t\t\t  3.Xoa SV khoi danh sach.
                                                                            """);
                            System.out.print("Nhap lua chon: ");
                            chonSV = Integer.parseInt(s.nextLine());
                            if (chonSV < 1 || chonSV > 3) {
                                System.out.println("Nhap sai, vui long nhap lai!");
                            }
                        } while (chonSV < 1 || chonSV > 3);
                    } catch (NumberFormatException e) {
                    }
                    switch (chonSV) {
                        case 1 -> {
                            dsSV.hienThi();
                        }
                        case 2 -> {
                            do {
                                SinhVien sv = new SinhVien();
                                sv.nhapSV();
                                dsSV.themSV(sv);
//                                dsSV.luuSV(filesv, sv);
                                sv.hienThi();
//                                tiepTucNhap(chon);
                            } while (chon == 1);
                            break;
                        }
                        case 3 -> {
                            try {
                                int maSo;
                                System.out.println("Nhap MSSV can xoa:");
                                maSo = Integer.parseInt(s.nextLine());
                                dsSV.xoaSinhVien(maSo);
                            } catch (NumberFormatException e) {
                            }
                        }
                    }
                }
                case 2 -> {
                    int chonBC = 0;
                    try {
                        do {
                            System.out.println("\t \t\t\t---------MENU BAO CAO---------\n");
                            System.out.println("""
                                                                           \t1.Xem danh sach BC.\t\t5.Xem BC theo loai.\t\t\t9.Tim BC Theo Khoang TG.
                                                                           \t2.Them BC\t\t\t6.Sap xep BC theo ten.\t\t\t10.Them Diem BC.
                                                                           \t3.Xoa BC.\t\t\t7.Sap xep BC theo ngay.\t\t\t11.Xem Thong Tin HDBV theo Ma BC.
                                                                           \t4.Update BC.\t\t\t8.Tim BC theo ten.\t\t\t12.Gan GV Huong Dan Cho BC""");
                            System.out.print("\nNhap lua chon : ");
                            chonBC = Integer.parseInt(s.nextLine());
                            if (chonBC < 1 || chonBC > 12) {
                                System.out.println("Nhap sai, vui long nhap lai!");
                            }
                        } while (chonBC < 1 || chonBC > 12);
                    } catch (NumberFormatException e) {
                    }
                    switch (chonBC) {
                        case 1 -> {
                            dsBC.hienThiBC();
                            break;
                        }
                        case 2 -> {
                            int ctn = 0;
                            do {
                                int ctn1 = 0;
                                try {
                                    do {
                                        System.out.print("1.BC Do An\t\t2.BC Thuc Tap\t\t3.BC Khoa Luan");
                                        System.out.print("\t\tNhap lua chon: ");
                                        ctn1 = Integer.parseInt(s.nextLine());
                                        if (ctn1 < 1 || ctn1 > 3) {
                                            System.out.println("Nhap sai, vui long nhap lai!");
                                        }
                                    } while (ctn1 < 1 || ctn1 > 3);
                                } catch (NumberFormatException e) {
                                }
                                switch (ctn1) {
                                    case 1 -> {
//                                        BaoCaoDoAn bc = new BaoCaoDoAn();
//                                        bc.nhapBaoCao();
//                                        for(int x:maSVChuaThamGia){
//                                            System.out.printf("%d",x);
                                        List<Integer> SVChuaThamGiaBC = dsBC.checkSVThamGia(dsBC, dsSV1);
                                        SVChuaThamGiaBC.add(-1);
                                        BaoCaoDoAn bc = new BaoCaoDoAn();
                                        bc.nhapBaoCao();
                                        bc.nhapSinhVienThamGia(SVChuaThamGiaBC, dsSV1);
                                        dsBC.themBC(bc);
//                                        dsBC.luuBC(dsDA, bc);
                                        System.out.println("Them Thanh Cong BC Do An");
                                    }
                                    case 2 -> {
//                                        BaoCaoThucTap bc = new BaoCaoThucTap();
//                                        bc.nhapBaoCao();
//                                        List<Integer> checSV = bc.nhapSinhVienThamGia(SVChuaThamGiaBC, dsSV);
//                                        dsBC.themBC(bc);
//                                        SVChuaThamGiaBC = checSV;
//                                        dsBC.luuBC(dsTTTN, bc);
//                                        List<Integer> checSV = checkSVThamGia(dsBC, dsSV);
                                        List<Integer> SVChuaThamGiaBC = dsBC.checkSVThamGia(dsBC, dsSV1);
                                        SVChuaThamGiaBC.add(-1);
                                        BaoCaoThucTap bc = new BaoCaoThucTap();
                                        bc.nhapBaoCao();
                                        bc.nhapSinhVienThamGia(SVChuaThamGiaBC, dsSV1);
                                        dsBC.themBC(bc);
//                                        dsBC.luuBC(dsTTTN, bc);
                                        System.out.println("Them Thanh Cong BC Thuc Tap");
                                    }
                                    case 3 -> {
                                        List<Integer> SVChuaThamGiaBC = dsBC.checkSVThamGia(dsBC, dsSV1);
                                        SVChuaThamGiaBC.add(-1);
                                        BaoCaoKhoaLuan bc = new BaoCaoKhoaLuan();
                                        bc.nhapBaoCao();
                                        bc.nhapSinhVienThamGia(SVChuaThamGiaBC, dsSV1);
                                        dsBC.themBC(bc);
//                                        dsBC.luuBC(dsKLTN, bc);
                                        System.out.println("Them Thanh Cong BC Khoa Luan");
                                    }
                                }
                                tiepTucNhap(ctn);
                            } while (ctn == 1);
                            break;
                        }
                        case 3 -> {
                            int ma;
                            int dem;
                            do {
                                System.out.print("Nhap Ma BC can xoa: ");
                                ma = Integer.parseInt(s.nextLine());
                                if (dsBC.xoaBC(ma) == true) {
                                    System.out.println("Xoa thanh cong");
                                    do {
                                        System.out.print("Xem lai danh sach: ");
                                        System.out.println("1.Xem\t2.Thoat: ");
                                        dem = Integer.parseInt(s.nextLine());
                                        if (dem == 1) {
                                            dsBC.hienThiBC();
                                        } else if (dem == 2) {
                                            break;
                                        }
                                        if (dem < 1 || dem > 2) {
                                            System.out.println("Nhap sai, vui long nhap lai!");
                                        }
                                    } while (dem < 1 || dem > 2);
                                } else {
                                    System.out.println("Ma khong ton tai");
                                }
                            } while (ma == 1);
                            break;
                        }
                        case 4 -> {
                            try {
                                int ma;
                                System.out.println("\t \t\t\t---------DS BAO CAO---------\n");
                                dsBC.hienThiBC();
                                System.out.print("Nhap Ma BC can sua: ");
                                ma = Integer.parseInt(s.nextLine());
                                if (dsBC.suaBC(ma) == true) {
                                    System.out.println("Sua thanh cong");
                                    System.out.println("BC sau khi sua!\n");
                                    dsBC.layBCTheoMa(ma).hienThiBC();
                                } else {
                                    System.out.println("Ma khong ton tai");
                                }
                            } catch (NumberFormatException e) {
                            }
                            break;
                        }
                        case 5 -> {
                            try {
                                int chonXem;
                                do {
                                    System.out.println("1.BC Do An\t2.BC Thuc Tap\t3.BC Khoa Luan");
                                    chonXem = Integer.parseInt(s.nextLine());
                                    if (chonXem < 1 || chonXem > 3) {
                                        System.out.println("Nhap sai, vui long nhap lai!");
                                    }
                                } while (chonXem < 1 || chonXem > 3);
                                switch (chonXem) {
                                    case 1 -> {
                                        dsBC.xemBCTheoLoai(pathDA).forEach(a -> a.hienThiBC());
                                        break;
                                    }
                                    case 2 -> {
                                        dsBC.xemBCTheoLoai(pathTT).forEach(a -> a.hienThiBC());
                                        break;
                                    }
                                    case 3 -> {
                                        dsBC.xemBCTheoLoai(pathKL).forEach(a -> a.hienThiBC());
                                        break;
                                    }
                                }
                                tiepTucNhap(chonXem);
                            } catch (NumberFormatException e) {
                            }
                        }
                        case 6 -> {
                            dsBC.sapXepTen();
                            System.out.println("Sap xep thanh cong!");
                            int dem;
                            do {
                                System.out.print("Xem lai danh sach: ");
                                System.out.println("\t1.Xem lai\t2.Thoat: ");
                                dem = Integer.parseInt(s.nextLine());
                                if (dem == 1) {
                                    dsBC.hienThiBC();
                                } else {
                                    break;
                                }
                                if (dem < 1 || dem > 2) {
                                    System.out.println("Nhap sai, vui long nhap lai!");
                                }
                            } while (dem < 1 || dem > 2);
                            break;
                        }
                        case 7 -> {
                            dsBC.sapXepBCNgay();
                            dsBC.hienThiBC();
                            break;
                        }
                        case 8 -> {
                            String ten;
                            System.out.print("Nhap ten ban can tim : ");
                            ten = s.nextLine();
                            if (dsBC.timBCTheoTen(ten)) {
                                System.out.println("Tim thay BC");
                            } else {
                                System.out.println("Ten BC khong ton tai");
                            }
                            break;
                        }
                        case 9 -> {
                            String batDau, ketThuc;
                            Date d, t;
                            do {
                                System.out.print("Nhap ngay bat dau : ");
                                batDau = s.nextLine();
                                d = f.parse(batDau);
                                System.out.print("Nhap ngay ket thuc(>= ngay bat dau) : ");
                                ketThuc = s.nextLine();
                                t = f.parse(ketThuc);
                            } while (d.compareTo(t) == 1);
                            DSBaoCao dsTheoNgay = dsBC.timBCbyDate(batDau, ketThuc);
                            dsTheoNgay.sapXepBCNgay();
                            dsTheoNgay.hienThiBC();
                            break;
                        }
                        case 10 -> {
                            int maBC;
                            double diem = 0;
                            System.out.print("Nhap MaBC can nhap diem:");
                            maBC = Integer.parseInt(s.nextLine());
                            if (dsBC.checkMaBC(maBC) == true) {
                                dsBC.layBCTheoMa(maBC).hienThiBC();
                                if (dsBC.layBCTheoMa(maBC).getLoaiBaoCao().equalsIgnoreCase("Khoa Luan") == false) {
                                    do {
                                        dsBC.layBCTheoMa(maBC).NhapDiem();
                                        if (diem < 0 || diem > 10) {
                                            System.out.println("Vui long nhap lai diem!");
                                            System.out.println("Diem >=0 hoac Diem <=10");
                                        }
                                    } while (diem < 0 || diem > 10);
                                    System.out.println("Them Diem Thanh Cong!");
                                } else {
                                    BaoCaoKhoaLuan.nhapDiemBCKL(maBC, dsBC, dshd, diem);
//                                    BaoCaoKhoaLuan bc1 = dsBC.layBCKLbyMa(maBC);
//                                    int maHD = bc1.getMaHD();
//                                    HoiDongBaoVe x = dshd.timHoiDongByID(maHD);
//                                    List<GiangVien> giangVien = x.getDsGvThamGia();
//                                    int dem;
//                                    double tong = 0;
//                                    List<Integer> sl = new ArrayList<>();
//                                    for (GiangVien y : giangVien) {
//                                        sl.add(y.getMaGV());
//                                    }
//                                    dem = sl.size();
//                                    System.out.printf("HD Co %d Thanh Vien\n", dem);
////                                    for (int i = 1; i <= dem; i++) {
//                                    for (GiangVien i : giangVien) {
//                                        do {
//                                            System.out.print("Nhap diem cua " + i.getNhiemVu() + " " + i.getHoten() + " : ");
//                                            diem = Double.parseDouble(s.nextLine());
//                                            if (diem < 0 || diem > 10) {
//                                                System.out.println("Vui long nhap lai diem!");
//                                                System.out.println("Diem >=0 hoac Diem <=10");
//                                            }
//                                        } while (diem < 0 || diem > 10);
//                                        tong += diem;
//                                    }
////                                    }
//                                    System.out.println("Them diem cho BC thanh cong!");
//                                    System.out.println("Diem cua HD cho BC la: " + tong / dem);
//                                    bc1.setDiemBC(tong / dem);
//                                    System.out.println("BC Sau Khi Them Diem");
//                                    bc1.hienThiBC();
                                }
                            } else {
                                System.out.println("Ma BC khong ton tai");
                            }

                        }
                        case 11 -> {
                            int maBC;
                            do {
                                System.out.print("Nhap MaBC De Tim HD:");
                                maBC = Integer.parseInt(s.nextLine());
                                if (dsBC.checkMaBC(maBC) == true) {
                                    if (dsBC.layBCTheoMa(maBC).getLoaiBaoCao().equalsIgnoreCase("Khoa Luan") == true) {
                                        BaoCaoKhoaLuan x = dsBC.layBCKLbyMa(maBC);
                                        x.hienThiBC();
                                        int y = x.getMaHD();
                                        dshd.timHoiDongByID(y).hienThi();
                                    } else {
                                        System.out.println("Ma BC Hop Le!");
                                        System.out.println("Vui long nhap lai!");
                                    }
                                } else {
                                    System.out.println("Ma BC Khong Ton Tai!");
                                }
                            } while (dsBC.checkMaBC(maBC) == false || dsBC.layBCTheoMa(maBC).getLoaiBaoCao().equalsIgnoreCase("Khoa Luan") == false);

                        }
                        case 12 -> {
                            int maBC;
                            do {
                                System.out.print("Nhap MaBC Can Them GV Phu Trach:");
                                maBC = Integer.parseInt(s.nextLine());
                                if (dsBC.checkMaBC(maBC) == true) {
                                    BaoCao x = dsBC.layBCTheoMa(maBC);
                                    x.ganGiangVien(dSGV);
                                    System.out.println("BC Sau Khi Them GV");
                                    x.hienThiBC();
                                } else {
                                    System.out.println("Ma BC Khong Ton Tai!");
                                }
                            } while (dsBC.checkMaBC(maBC) == false);
                        }
                    }
                }
                case 3 -> {
                    int chonSV = 0;
                    try {
                        do {
                            System.out.println("\t \t\t\t/***------Giang Vien------/***\n");
                            System.out.println("""
                                                                           \t\t1.Xem danh sach GV.\t\t3.Xoa GV khoi danh sach.
                                                                            \t\t2.Them GV vao danh sach.
                                                                            """);
                            System.out.print("Nhap lua chon: ");
                            chonSV = Integer.parseInt(s.nextLine());
                            if (chonSV < 1 || chonSV > 3) {
                                System.out.println("Nhap sai, vui long nhap lai!");
                            }
                        } while (chonSV < 1 || chonSV > 3);
                    } catch (NumberFormatException e) {
                    }
                    switch (chonSV) {
                        case 1 -> {
                            dSGV.hienThi();
                        }
                        case 2 -> {
                            int chon10;
//                            do {
                            GiangVien gv = new GiangVien();
                            gv.nhapGV();
                            dSGV.themGiangVien(gv);
                            gv.hienThi();
//                                tiepTucNhap(chon10);
//                            } while (chon10 == 1);
                            break;
                        }
                        case 3 -> {
                            int maSo;
                            System.out.println("Nhap MSGV can xoa:");
                            maSo = Integer.parseInt(s.nextLine());
                            if (dSGV.xoaGV(maSo)) {
                                int dem;
                                System.out.println("Xoa thanh cong");
                                do {
                                    System.out.print("Xem lai danh sach: ");
                                    System.out.println("1.Xem\t2.Thoat: ");
                                    dem = Integer.parseInt(s.nextLine());
                                    dSGV.hienThi();
                                    if (dem == 1) {

                                    } else {
                                        break;
                                    }
                                    if (dem < 1 || dem > 2) {
                                        System.out.println("Nhap sai, vui long nhap lai!");
                                    }
                                } while (dem < 1 || dem > 2);
                            } else {
                                System.out.println("Ma khong ton tai");
                            }
                            break;
                        }
                    }
                }
                case 4 -> {
                    int chonSV = 0;
                    try {
                        do {
                            System.out.println("\t \t\t\t/***------Hoi Dong------***/\n");
                            System.out.println("""
                                                                           \t\t1.Xem danh sach Hoi Dong.\t\t3.Tim kiem HD theo ngay
                                                                           \t\t2.Them HD.\t\t\t\t4.Tim Kiem HD Theo Khoang TG
                                                                           \t\t5.Tim HD theo ma.
                                                                           """);
                            System.out.print("Nhap lua chon: ");
                            chonSV = Integer.parseInt(s.nextLine());
                            System.out.println();
                            if (chonSV < 1 || chonSV > 5) {
                                System.out.println("Nhap sai, vui long nhap lai!");
                            }
                        } while (chonSV < 1 || chonSV > 5);
                    } catch (NumberFormatException e) {
                    }
                    switch (chonSV) {
                        case 1 -> {
                            dshd.hienThiHd();
                        }
                        case 2 -> {
                            do {
                                int x;
                                HoiDongBaoVe bv = new HoiDongBaoVe();
                                do {
                                    x = bv.nhapMaHD();
                                    if (dshd.checkTrungMaHD(x) == false) {
                                        System.out.println("Ma HD Da Ton Tai!");
                                        System.out.println("Vui long nhap lai!");
                                    }
                                } while (dshd.checkTrungMaHD(x) == false);
                                bv.nhapHoiDong(dsBC, dSGV, dsBC1);
                                System.out.println("\tThem thanh cong");
                                System.out.println("\t \t\t\t***------Hoi Dong Da Them------***\n");
                                dshd.them(bv);
                                bv.hienThi();
//                                tiepTucNhap(chonSV);
                            } while (chon == 1);
                            break;
                        }
                        case 3 -> {
                            String ngay;
                            Date d;
                            try {
                                System.out.print("Nhap ngay can tim(dd/MM/dddd) : ");
                                ngay = s.nextLine();
                                d = f.parse(ngay);
                                if (dshd.timKiemTheoNgay(ngay) != null) {
                                    dshd.timKiemTheoNgay(ngay).hienThi();
                                } else {
                                    System.out.println("Ngay thang ko co HD!");
                                }
                                tiepTucNhap(chonSV);
                            } catch (NullPointerException e) {
                            }
                            break;
                        }
                        case 4 -> {
                            String batDau, ketThuc;
                            Date d, t;
                            do {
                                System.out.print("Nhap ngay bat dau : ");
                                batDau = s.nextLine();
                                d = f.parse(batDau);
                                System.out.print("Nhap ngay ket thuc(>= ngay bat dau) : ");
                                ketThuc = s.nextLine();
                                t = f.parse(ketThuc);
                            } while (d.compareTo(t) == 1);
                            DSHoiDong dsTheoNgay = dshd.timKiemTheoNgay(batDau, ketThuc);
//                            dsTheoNgay.sapXepBCNgay();
                            dsTheoNgay.hienThiHd();
                            break;
                        }
                        case 5 -> {
                            int maHD;
                            do {
                                System.out.print("Nhap MaHD De Tim HD:");
                                maHD = Integer.parseInt(s.nextLine());
                                if (dshd.checkTrungMaHD(maHD) == false) {
                                    HoiDongBaoVe bv = dshd.timHoiDongByID(maHD);
                                    bv.hienThi();
                                } else {
                                    System.out.println("Ma HD Khong Ton Tai!");
                                }
                            } while (dshd.checkTrungMaHD(maHD) == true);
                        }

                    }
                }
                default -> {
                }
            }
        } while (chon != 5);
    }
}
