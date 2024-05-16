/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.f;
import static com.mycompany.baitaplon.SinhVien.s;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NOBITA
 */
public class HoiDongBaoVe {

    private int maHĐ;
    private List<BaoCao> dsKL = new ArrayList<>();//
    private Date ngayLamViec;//
    private List<GiangVien> dsGvThamGia = new ArrayList<>();//
    private static final int min = 3, max = 5;
    private final String[] mangLoaiNV = new String[]{"Thu Ki", "Phan Bien", "Uy Vien"};

    public HoiDongBaoVe(List<BaoCao> dsBaoCao, List<GiangVien> dsGV, String ngayLamViec, int maHD) throws ParseException {
        this.ngayLamViec = f.parse(ngayLamViec);
        this.dsGvThamGia = dsGV;
        this.dsKL = dsBaoCao;
        this.maHĐ = maHD;
    }

    public HoiDongBaoVe() {
    }

    public void chonBaoCao(DSBaoCao bc, List<BaoCao> dSMaSoBC) {
        int dem = 0;
        int chonBC;
        boolean check2;
        try {
            try {
                do {
                    do {
                        System.out.println("\t\t**********DSKL***********");
                        System.out.println("Danh sach MaBC Chua Co Trong HD: ");
                        System.out.print("Chon ma: ");
                        for (BaoCao x : dSMaSoBC) {
                            System.out.printf("[%d] ", x.getMaBC());
                        }
                        chonBC = Integer.parseInt(s.nextLine());
                        BaoCao bc1 = bc.layBCTheoMa(chonBC);// lấy ra BC bằng maxBC nhập vào
                        check2 = dSMaSoBC.contains(bc1);
                        if (check2 == true) {
                            bc1.hienThiBC();
                            dSMaSoBC.remove(bc1);
                            this.dsKL.add(bc1);// add bc lấy ra vào trong dsKL
                            BaoCaoKhoaLuan bc2 = (BaoCaoKhoaLuan) bc1;
                            bc2.setMaHD(this.maHĐ);
                            dem++;
                        } else {
                            System.out.println("Ma BC Khong Hop Le!");
                            System.out.println("Vui Long Nhap Lai!");
                        }
                    } while (check2 == false);
                    do {
                        System.out.print("1.Tiep tuc them BC\t\t2.Nhap Thanh Vien HD: ");
                        chonBC = Integer.parseInt(s.nextLine());
                        if (chonBC < 1 || chonBC > 2) {
                            System.out.println("Nhap sai, vui long nhap lai!");
                        }
                    } while (chonBC < 1 || chonBC > 2);
                    System.out.println("\n\t******* Vui Long Them Toi Thieu 1 BC *******");
                    System.out.println("\t********   Ban Da Them " + dem + " BC ******\n\n");

                } while (chonBC == 1 && dem >= 1);
            } catch (IndexOutOfBoundsException e) {
            }
        } catch (NumberFormatException e) {
        }
    }

    public void nhapNgayThang() throws ParseException {
        System.out.print("Nhap ngay lam viec: ");
        this.ngayLamViec = f.parse(s.nextLine());
    }

    public void chonMaGV(List<GiangVien> ds) {// 
        List<Integer> dsMa = new ArrayList<>();// tạo một list số
        for (GiangVien x : ds) { // tạo 1 gv x duyệt List GV truyền vào
            dsMa.add(x.getMaGV());// add mã đó vào trong dsMa
        }
        ds.forEach(a -> a.hienThi());// hiển thị danh sách truyền vào
        System.out.print("Chon ma GV : ");
        for (int x : dsMa) {
            System.out.printf("[%d] ", x);
        }
    }

    public void themTVHDupdate(DSGiangVien ds) {//

        int dem = 0;
        int chonGV;
        int chonTiepTuc;
        List<GiangVien> dsGvCT = ds.thanhVienThamGia("Chu Tich");
        List<GiangVien> dsGvTKi = ds.thanhVienThamGia("Thu Ki");
        List<GiangVien> dsGvPhanBien = ds.thanhVienThamGia("Phan Bien");
        List<GiangVien> dsGvUyVien = ds.thanhVienThamGia("Uy Vien");
        System.out.println("\t\t---Chon Chu Tich----");
        chonMaGV(dsGvCT);
        chonGV = Integer.parseInt(s.nextLine());
        GiangVien x = ds.layGiangVienDuaVaoMaGV(chonGV);
        this.dsGvThamGia.add(x);
        dsGvCT.remove(x);
        dem++;

        System.out.println("\t\t---Chon Thu Ki----");
        chonMaGV(dsGvTKi);
        chonGV = Integer.parseInt(s.nextLine());
        GiangVien x1 = ds.layGiangVienDuaVaoMaGV(chonGV);
        this.dsGvThamGia.add(x1);
        dsGvTKi.remove(x1);
        dem++;

        System.out.println("\t\t---Chon Phan Bien----");
        chonMaGV(dsGvPhanBien);
        chonGV = Integer.parseInt(s.nextLine());
        GiangVien x2 = ds.layGiangVienDuaVaoMaGV(chonGV);
        this.dsGvThamGia.add(x2);
        dsGvPhanBien.remove(x2);
        dem++;

        System.out.print("Ban co muon tiep tuc nhap: ");
        System.out.print("Tiep tuc [1]: ");
        chonTiepTuc = Integer.parseInt(s.nextLine());
        if (chonTiepTuc == 1) {
            do {
                System.out.println("\t\t----------Danh sach cac chuc vu----------");
                for (int i = 0; i < mangLoaiNV.length; i++) {
                    System.out.printf("%d.%s\t\t", i, mangLoaiNV[i]);
                }
                System.out.printf("Chon tu 0 den %s : ", mangLoaiNV.length - 1);
                chonGV = Integer.parseInt(s.nextLine());

                switch (chonGV) {// nếu chọn = 0 thì xuất danh sách chủ tịch
                    case 0 -> {
                        chonMaGV(dsGvTKi);
                        chonGV = Integer.parseInt(s.nextLine());
                        GiangVien x3 = ds.layGiangVienDuaVaoMaGV(chonGV);
                        this.dsGvThamGia.add(x3);
                        dsGvTKi.remove(x3);
                        dem++;
                        break;
                    }
                    case 1 -> {
                        System.out.println("\t\t---Chon Phan Bien----");
                        chonMaGV(dsGvPhanBien);
                        chonGV = Integer.parseInt(s.nextLine());
                        GiangVien x4 = ds.layGiangVienDuaVaoMaGV(chonGV);
                        this.dsGvThamGia.add(x4);
                        dsGvPhanBien.remove(x4);
                        dem++;
                    }
                    case 2 -> {
                        System.out.println("\t\t---Chon Uy Vien----");
                        chonMaGV(dsGvUyVien);
                        chonGV = Integer.parseInt(s.nextLine());
                        GiangVien x5 = ds.layGiangVienDuaVaoMaGV(chonGV);
                        this.dsGvThamGia.add(x5);
                        dsGvUyVien.remove(x5);
                        dem++;
                        break;
                    }
                }
                if (dem >= max) {
                    System.out.println("Ban da them toi da " + max + " GV ");
                    break;
                } else {
                    System.out.println("Tiep tuc them thanh vien:");
                    System.out.print("[1] Tiep tuc  ");
                    chonTiepTuc = Integer.parseInt(s.nextLine());
//                System.out.println("\n\t******* Vui Long Them Toi Thieu 3 GV *******");
                    System.out.println("\n\t******* Vui Long Them Toi Da 5 GV *******");
                    System.out.println("\t********   Ban Da Them " + dem + " GV ******\n\n");
                }
            } while (chonTiepTuc == 1 || dem < min);
        }
    }

    public int nhapMaHD() {
        System.out.print("Nhap ma HD: ");
        this.maHĐ = Integer.parseInt(s.nextLine());
        return this.maHĐ;
    }

    public void nhapHoiDong(DSBaoCao bc, DSGiangVien gv, List<BaoCao> dSMaSoBC) throws ParseException, FileNotFoundException {
        chonBaoCao(bc, dSMaSoBC);
        themTVHDupdate(gv);
        nhapNgayThang();

    }

    public void hienThi() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Ma HD: " + this.maHĐ);
        System.out.println("\n\t\t**********DS Khoa Luan***********\n");
        this.dsKL.forEach(a -> a.hienThiBC());
        System.out.println("\n\t\t**********DS Giang Vien***********\n");
        this.dsGvThamGia.forEach(a -> a.hienThi());
        System.out.println("Ngay lam viec:" + f.format(ngayLamViec) + "\n\n");
        System.out.println("\t\t\t----------------------Hoi dong tiep theo-------------------------");

    }

    public List<BaoCao> getDsKL() {
        return dsKL;
    }

    public void setDsKL(List<BaoCao> dsKL) {
        this.dsKL = dsKL;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public List<GiangVien> getDsGvThamGia() {
        return dsGvThamGia;
    }

    public void setDsGvThamGia(List<GiangVien> dsGvThamGia) {
        this.dsGvThamGia = dsGvThamGia;
    }

    public static int getMax() {
        return max;
    }

    public static int getMin() {
        return min;
    }

    public String[] getMangLoaiNV() {
        return mangLoaiNV;
    }

    public int getMaHĐ() {
        return maHĐ;
    }

    public void setMaHĐ(int maHĐ) {
        this.maHĐ = maHĐ;
    }

}

//    public void chonMaGV(List<GiangVien> ds, String nv) {// 
//        List<Integer> dsMa = new ArrayList<>();// tạo một list số
//        for (GiangVien x : ds) { // tạo 1 gv x duyệt List GV truyền vào
//            if (x.getNhiemVu().equals(nv)) {// nếu gv x == với nv đc truyền vào 
//                dsMa.add(x.getMaGV());// add mã đó vào trong dsMa
//            }
//        }
//        ds.forEach(a -> a.hienThi());// hiển thị danh sách truyền vào
//        System.out.print("Chon ma GV : ");
//        for (int x : dsMa) {
//            System.out.printf("[%d] ", x);
//        }
//    }
//    public void docFileGV(String s, String a) throws FileNotFoundException, ParseException {
//        File f = new File(s);
//        Scanner sc = new Scanner(f);
//        while (sc.hasNext()) {
//            int maGV = Integer.parseInt(sc.nextLine());
//            String hoTen = sc.nextLine();
//            String hocHam = sc.nextLine();
//            String hocVi = sc.nextLine();
//            boolean thamGia = Boolean.parseBoolean(sc.nextLine());
//            String nhiemVu = sc.nextLine();
//            GiangVien gv1 = new GiangVien(hoTen, hocHam, hocVi, thamGia, nhiemVu);
////            this.dsGiangVien.add(gv1);
//        }
//
//    }
//Chu Tich", "Thu Ki", "Phan Bien", "Uy Vien"
//    public void timKiemTheoNV(DSGiangVien ds) {
//        int chonNV;
//        List<GiangVien> dsChuTich = new ArrayList<>();
//        List<GiangVien> dsThuKi = new ArrayList<>();
//        List<GiangVien> dsPhanBien = new ArrayList<>();
//        List<GiangVien> dsUyVien = new ArrayList<>();
//        for (GiangVien x : ds.getDsGiangVienThamGia()) {
//            if (x.getNhiemVu().equals("Chu Tich")) {
//                dsChuTich.add(x);
//            } else if (x.getNhiemVu().equals("Thu Ki")) {
//                dsThuKi.add(x);
//            }
//            if (x.getNhiemVu().equals("Phan Bien")) {
//                dsPhanBien.add(x);
//            }
//            if (x.getNhiemVu().equals("Uy Vien")) {
//                dsUyVien.add(x);
//            }
//        }
//        do {
//            System.out.println("-----Danh sach cac chuc vu------");
//            for (int i = 0; i < mangLoaiNV.length; i++) {
//                System.out.printf("%d.%s\n", i, mangLoaiNV[i]);
//            }
//            System.out.printf("Chon tu 0 den %s : ", mangLoaiNV.length - 1);
//            chonNV = Integer.parseInt(s.nextLine());
//        } while (chonNV < 0 || chonNV >= mangLoaiNV.length);
//        do {
//            switch (chonNV) {
//                case 0 -> {
//                    for (GiangVien gv : dsChuTich) {
//                        gv.hienThi();
//                    }
//                }
//                case 1 -> {
//                    for (GiangVien gv : dsThuKi) {
//                        gv.hienThi();
//                    }
//                }
//                case 2 -> {
//                    for (GiangVien gv : dsPhanBien) {
//                        gv.hienThi();
//                    }
//                }
//                case 3 -> {
//                    for (GiangVien gv : dsUyVien) {
//                        gv.hienThi();
//                    }
//                }
//                default -> {
//                }
//            }
//        } while (chonNV < 0 || chonNV >= mangLoaiNV.length);
//
//    }
//        return ds.getDsGiangVienThamGia().stream().filter(a -> {
//            if (loaiNV.equals("")) {
//                return a instanceof  ;
//            } else if (loaiSP.equals("Bang Dia")) {
//                return a instanceof ;
//            }
//
//            return false;
//
//        }).collect(Collectors.toList());
//        public List<SanPham> timKiemTheoLoai(String loaiSP) {
//        return this.ds.stream().filter(a -> {
//            if (loaiSP.equals("Sach")) {
//                return a instanceof Sach;
//            } else if (loaiSP.equals("Bang Dia")) {
//                return a instanceof BangDia;
//            }
//
//            return false;
//
//        }).collect(Collectors.toList());
//    
//    public static void giangVienThamGia(DSGiangVien ds) {
//        for (GiangVien x : ds.getDsGiangVien()) {
//            if (x.isThamGiaKhoaLuan() == true) {
//                dsGiangVienThamGia.add(x);
//            }
//        }
//    }
//   
//    public void giangVienThamGia(DSGiangVien ds) {
//        for (GiangVien x : ds.getDsGiangVien()) {
//            if (x.isThamGiaKhoaLuan() == true) {
//                this.dsGvThamGia.add(x);
//            }
//        }
//    }
//    public GiangVien layGiangVienDuaVaoMaGV(int id) {
//        for (GiangVien x : this.dsGvThamGia) {
//            if (x.getMaGV() == id) {
//                return x;
//            }
//        }
//        return null;
//    }
//    public List<GiangVien> TimKiemTheoNV(String nv) {
//        return this.dsGvThamGia.stream()
//                .filter(h -> h.getNhiemVu().equals(nv))
//                .collect(Collectors.toList());
//    }
//      public List<GiangVien> TimKiemTheoNV(HoiDongBaoVe hd,String nv){
//        return hd.getDsGvThamGia().stream()
//                .filter(h ->h.getNhiemVu().equals(nv))
//                .collect(Collectors.toList());
//    }
//    public void hienThi(List<GiangVien> list){
//        list.stream().forEach(a ->a.hienThi());
//    }
//    public void themTVHD(DSGiangVien ds) {//
//        try {
//
//            int dem = 0;
//            int chonNV;
//            int chonGV;
//            int chonTiepTuc;
//            List<GiangVien> dsGvCT = ds.thanhVienThamGia("Chu Tich");
//            List<GiangVien> dsGvTKi = ds.thanhVienThamGia("Thu Ki");
//            List<GiangVien> dsGvPhanBien = ds.thanhVienThamGia("Phan Bien");
//            List<GiangVien> dsGvUyVien = ds.thanhVienThamGia("Uy Vien");
//            // vòng lặp hiện ra các chứa vụ trong mảng đã khai báo ở trên
//            do {
//                System.out.println("\t\t----------Danh sach cac chuc vu----------");
//                for (int i = 0; i < mangLoaiNV.length; i++) {
//                    System.out.printf("%d.%s\t\t", i, mangLoaiNV[i]);
//                }
//                System.out.printf("Chon tu 0 den %s : ", mangLoaiNV.length - 1);
//                chonNV = Integer.parseInt(s.nextLine());
//
//                switch (chonNV) {// nếu chọn = 0 thì xuất danh sách chủ tịch
//                    case 0 -> {
//                        dsGvCT.forEach(a -> a.hienThi());
//                        //                        chonMaGV(gv, "Chu Tich");
//                        chonGV = Integer.parseInt(s.nextLine());
//                        GiangVien x = ds.layGiangVienDuaVaoMaGV(chonGV);
//                        this.dsGvThamGia.add(x);
//                        //                        gv.remove(x);
//                        dem++;
//                        break;
//                    }
//                    case 1 -> {
//                        dsGvTKi.forEach(a -> a.hienThi());
//                        //                        chonMaGV(gv, "Thu Ki");
//                        chonGV = Integer.parseInt(s.nextLine());
//                        GiangVien x = ds.layGiangVienDuaVaoMaGV(chonGV);
//                        this.dsGvThamGia.add(x);
//                        //                        gv.remove(x);
//                        dem++;
//                        break;
//                    }
//                    case 2 -> {
//                        dsGvPhanBien.forEach(a -> a.hienThi());
//                        //                        chonMaGV(gv, "Phan Bien");
//                        chonGV = Integer.parseInt(s.nextLine());
//                        GiangVien x = ds.layGiangVienDuaVaoMaGV(chonGV);
//                        this.dsGvThamGia.add(x);
//                        //                        gv.remove(x);
//                        dem++;
//                        break;
//                    }
//                    case 3 -> {
//                        dsGvUyVien.forEach(a -> a.hienThi());
//                        chonMaGV(gv, "Uy Vien");
//                        chonGV = Integer.parseInt(s.nextLine());
//                        GiangVien x = ds.layGiangVienDuaVaoMaGV(chonGV);
//                        this.dsGvThamGia.add(x);
//                        //                        gv.remove(x);
//                        dem++;
//                        break;
//                    }
//                }
//                if (dem >= max) {
//                    System.out.println("Ban da them toi da " + max + " GV ");
//                    break;
//                } else {
//                    System.out.println("Tiep tuc them thanh vien:");
//                    System.out.print("[1] Tiep tuc  ");
//                    chonTiepTuc = Integer.parseInt(s.nextLine());
//                    System.out.println("\n\t******* Vui Long Them Toi Thieu 3 GV *******");
//                    System.out.println("\n\t******* Vui Long Them Toi Da 5 GV *******");
//                    System.out.println("\t********   Ban Da Them " + dem + " GV ******\n\n");
//                }
//
//            } while (chonTiepTuc == 1 || dem < min);
//        } catch (NumberFormatException ex) {
//        }
//    }
//    public void chonBaoCao(DSBaoCao bc, List<BaoCaoKhoaLuan> dsBaoCao) {
//        int dem = 0;
//        int chonBC;
//        try {
//            do {
//                List<Integer> dSMaSoBC = new ArrayList<>(); // list mã số BC
//                System.out.println("\t\t**********DSKL***********");
//                dsBaoCao.forEach(a -> a.hienThiBC()); // hiển thị danh sách BC
//                for (BaoCao x : dsBaoCao) { // duyệt List<BaoCao> truyền vào
//                    dSMaSoBC.add(x.getMaBC());// lấy ra mã số của List<BC> rồi add vào list mã số
//                }
//                System.out.print("Chon ma: "); // xuất ra các mã số có trong list mã số 
//                for (int x : dSMaSoBC) {
//                    System.out.printf("[%d] ", x);
//                }
//                chonBC = Integer.parseInt(s.nextLine());
//                BaoCao bc1 = bc.layBCTheoMa(chonBC);// lấy ra BC bằng maxBC nhập vào
//                dsBaoCao.remove((BaoCaoKhoaLuan) bc1);// xóa BC đó ra khỏi List<Bc> lũ nãy truyền vào
//                BaoCaoKhoaLuan bc2 = (BaoCaoKhoaLuan) bc1;
//                this.dsKL.add(bc2);// add bc lấy ra vào trong dsKL
//                bc2.setMaHD(this.maHĐ);
//                dem++;
//                do {
//                    System.out.print("1.Tiep tuc them BC\t\t2.Nhap Thanh Vien HD: ");
//                    chonBC = Integer.parseInt(s.nextLine());
//                    if (chonBC < 1 || chonBC > 2) {
//                        System.out.println("Nhap sai, vui long nhap lai!");
//                    }
//                } while (chonBC < 1 || chonBC > 2);
//                System.out.println("\n\t******* Vui Long Them Toi Thieu 1 BC *******");
//                System.out.println("\t********   Ban Da Them " + dem + " BC ******\n\n");
//            } while (chonBC == 1 && dem >= 1);
//        } catch (NumberFormatException e) {
//        }
//    }
//    public void nhapHoiDong(DSBaoCao bc, DSGiangVien gv) throws ParseException, FileNotFoundException {
////        List<BaoCaoKhoaLuan> dsBaoCao = bc.isbaoCaoKhoaLuan();
////        nhapMaHD();
//        chonBaoCao(bc, dsBaoCao);
//        themTVHDupdate(gv);
//        nhapNgayThang();
//    }
