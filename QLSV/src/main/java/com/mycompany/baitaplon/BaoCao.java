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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author NOBITA
 */
public abstract class BaoCao {

    private static int demBC = 0;
    private static final int min = 1;
    private static final int max = 2;
    private int maBC;
    private String tenBC;
    private Date ngayBC;
    private String tenGV;
    private String chuoiLink;
    private String loaiBaoCao;
    protected double diemBC;
    protected static final String[] mangloaiBC = new String[]{"Thuc Tap", "Do An", "Khoa Luan"};
    public static boolean check = false;
    private List<Integer> maSVBC = new ArrayList<>(max);

    {
        ++demBC;
        this.maBC = demBC;
    }

    public BaoCao() {
    }

    public BaoCao(String tenBC, String ngayBC, String tenGV, String chuoiLink, List<Integer> maSV) throws ParseException {
        this.maBC = maBC;
        this.tenBC = tenBC;
        this.ngayBC = f.parse(ngayBC);
        this.tenGV = tenGV;
        this.chuoiLink = chuoiLink;
        this.maSVBC = maSV;
    }

    public abstract void NhapDiem();

    public void kiemTraDate(Date ngay) throws ParseException {
        do {
            f.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            System.out.print("Nhap ngay BC(dd/mm/yyyy): ");
            try {
                ngay = f.parse(s.nextLine());
                check = true;// parse dateString thành kiểu Date
            } catch (ParseException e) {
                System.out.println("Ngay thang khong hop le!");
                check = false;
            }
        } while (check == false);
        this.ngayBC = ngay;
        System.out.println("Nhap ngay thang thanh cong!");
    }

    public void nhapBaoCao() throws ParseException, FileNotFoundException {
        do {
            try {
                System.out.print("Nhap Ten BC : ");
                this.tenBC = s.nextLine();
                kiemTraDate(this.ngayBC);
//                System.out.print("Nhap Ten GV phu trach : ");
//                this.tenGV = s.nextLine();
                System.out.print("Nhap Link : ");
                this.chuoiLink = s.nextLine();
                check = true;
            } catch (ParseException e) {
                System.out.println("Nhap sai dinh dang");
                check = false;
            }
        } while (check == false);
    }

    public void ganGiangVien(DSGiangVien danhSachGV) {
        int maGV;
        GiangVien newGV;
        do {
            System.out.print("Chon Ma GV cho BC:");
            maGV = Integer.parseInt(s.nextLine());
            if (danhSachGV.checkMaGV(maGV)) {
                System.out.println("GV Ban Da Chon!");
                newGV = danhSachGV.layGiangVienDuaVaoMaGV(maGV);
                newGV.hienThi();
                this.tenGV = newGV.getHoten();
                System.out.println("Da Chon GV Phu Trach Thanh Cong!");
            } else {
                System.out.println("Ma GV Khong Ton Tai!");
            }
        } while (danhSachGV.checkMaGV(maGV) == false);
    }

    public List<Integer> nhapSinhVienThamGia(List<Integer> sVChuaThamGia, DsSinhVien dsSinhVien) {
        int ma;
        List<Integer> sVChuaThamGia1 = sVChuaThamGia;
        System.out.print("Danh sach MSSV Chua Tham Gia BC: ");
        sVChuaThamGia1.forEach(a ->System.out.printf("%d\t", a));
        boolean check1;
        for (int x = min; x <= max; x++) {
            try {
                try {
                    do {
                        System.out.printf("\nNhap msSV thu %d tham gia BC\n", x);
                        System.out.print(" (Nhap -1 Neu ko co MSSV):");
                        ma = Integer.parseInt(s.nextLine());
                        check1 = sVChuaThamGia1.contains(ma);
                        if (check1 == true) {
                            if (ma != -1) {
                                this.maSVBC.add(ma);
                                SinhVien sv1 = dsSinhVien.laySVTheoMa(ma);
                                sv1.setMaBC(this.maBC);
                                sVChuaThamGia1.remove(sVChuaThamGia.indexOf(ma));
                            }
                        } else if (check1 == false) {
                            System.out.println("MSSV Khong Hop Le!");
                            System.out.println("Vui long nhap lai!");
                        }
                    } while (check1 == false);
                } catch (IndexOutOfBoundsException e) {
                }
            } catch (NullPointerException e) {
            }

        }
        return sVChuaThamGia1;
    }
    

    public void hienThiBC() {
        System.out.printf("[Ma BC]:%d\n\t[Ten BC]:%s\t\t\t\t"
                + "[Ngay BC]:%s\n\tLink:%s\t\t\t\tLoai BC:%s",
                this.maBC, this.tenBC, f.format(ngayBC),
                this.chuoiLink, this.loaiBaoCao);
        try {
            if (this.getTenGV().equalsIgnoreCase("Chua Co GV")) {
                System.out.print("\n\tTen GV Phu Trach: Chua Co GV Huong Dan! ");
            } else {
                System.out.print("\tTen GV Phu Trach: " + this.tenGV);
            }
        } catch (NullPointerException e) {
            System.out.print("\n\tTen GV Phu Trach: Chua Co GV Huong Dan! ");
        }
        try {
            if (this.getDiemBC() != -1) {
                System.out.print("\t[Diem BC]: " + this.diemBC);
            } else {
                System.out.print("\t[Diem BC]: Chua Co Diem");
            }
        } catch (NullPointerException e) {
            System.out.print("\t[Diem BC]: Chua Co Diem");
        }
        System.out.print("\n\tMSSV tham Gia BC :");
        for (int x : this.maSVBC) {
            System.out.printf("%d  ", x);
        }
    }

    public static int getMax() {
        return max;
    }

    public static int getMin() {
        return min;
    }

    public String[] getMangloaiBC() {
        return mangloaiBC;
    }

    public int getMaBC() {
        return maBC;
    }

    public void setMaBC(int maBC) {
        this.maBC = maBC;
    }

    public String getTenBC() {
        return tenBC;
    }

    public void setTenBC(String tenBC) {
        this.tenBC = tenBC;
    }

    public Date getNgayBC() {
        return ngayBC;
    }

    public void setNgayBC(Date ngayBC) {
        this.ngayBC = ngayBC;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getChuoiLink() {
        return chuoiLink;
    }

    public void setChuoiLink(String chuoiLink) {
        this.chuoiLink = chuoiLink;
    }

    public String getLoaiBaoCao() {
        return loaiBaoCao;
    }

    public void setLoaiBaoCao(String loaiBaoCao) {
        this.loaiBaoCao = loaiBaoCao;
    }

    public double getDiemBC() {
        return diemBC;
    }

    public void setDiemBC(double diemBC) {
        this.diemBC = diemBC;
    }

    public List<Integer> getMaSVBC() {
        return maSVBC;
    }

    public void setMaSVBC(List<Integer> maSVBC) {
        this.maSVBC = maSVBC;
    }

}
