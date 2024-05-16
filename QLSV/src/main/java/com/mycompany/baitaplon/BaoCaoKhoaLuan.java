/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.s;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NOBITA
 */
public class BaoCaoKhoaLuan extends BaoCaoDoAn {

    private int MaHD;
    private String danhGiaGVPhanBien;
    private List<GiangVien> gvThamGia = new ArrayList<>();

    public BaoCaoKhoaLuan() {
    }

    public BaoCaoKhoaLuan(String tenBC, String ngayBC, String tenGV, String chuoiLink, double diemBC, double tiLeDaoVan, String danhGiaGVPhanBien, int maHD, List<Integer> maSV) throws ParseException {
        super(tenBC, ngayBC, tenGV, chuoiLink, diemBC, tiLeDaoVan, maSV);
        this.setLoaiBaoCao(mangloaiBC[2]);
        this.danhGiaGVPhanBien = danhGiaGVPhanBien;
        this.MaHD = maHD;
    }
    public static void nhapDiemBCKL(int maBC, DSBaoCao dsBC, DSHoiDong dshd, double diem) {
        BaoCaoKhoaLuan bc1 = dsBC.layBCKLbyMa(maBC);
        int maHD = bc1.getMaHD();
        HoiDongBaoVe x = dshd.timHoiDongByID(maHD);
        List<GiangVien> giangVien = x.getDsGvThamGia();
        int dem;
        double tong = 0;
        List<Integer> sl = new ArrayList<>();
        for (GiangVien y : giangVien) {
            sl.add(y.getMaGV());
        }
        dem = sl.size();
        System.out.printf("HD Co %d Thanh Vien\n", dem);
//                                    for (int i = 1; i <= dem; i++) {
        for (GiangVien i : giangVien) {
            do {
                System.out.print("Nhap diem cua " + i.getNhiemVu() + " " + i.getHoten() + " : ");
                diem = Double.parseDouble(s.nextLine());
                if (diem < 0 || diem > 10) {
                    System.out.println("Vui long nhap lai diem!");
                    System.out.println("Diem >=0 hoac Diem <=10");
                }
            } while (diem < 0 || diem > 10);
            tong += diem;
        }
//                                    }
        System.out.println("Them diem cho BC thanh cong!");
        System.out.println("Diem cua HD cho BC la: " + tong / dem);
        bc1.setDiemBC(tong / dem);
        System.out.println("BC Sau Khi Them Diem");
        bc1.hienThiBC();
    }

    @Override
    public void nhapBaoCao() throws ParseException, FileNotFoundException {
        super.nhapBaoCao();
        setLoaiBaoCao(mangloaiBC[2]);
        System.out.print("Nhap danh gia GV phan bien:");
        this.danhGiaGVPhanBien = s.nextLine();
    }

    @Override
    public void hienThiBC() {
        super.hienThiBC();
        System.out.print("\tDanh gia GV phan bien: " + this.danhGiaGVPhanBien + "\n");
        if (this.MaHD != -1) {
            System.out.println("Bao Cao Co Ma HD la: " + this.MaHD);
        } else {
            System.out.println("Bao Cao Chua co HD!");
        }
    }

    public String getDanhGiaGVPhanBien() {
        return danhGiaGVPhanBien;
    }

    public void setDanhGiaGVPhanBien(String danhGiaGVPhanBien) {
        this.danhGiaGVPhanBien = danhGiaGVPhanBien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public List<GiangVien> getGvThamGia() {
        return gvThamGia;
    }

    public void setGvThamGia(List<GiangVien> gvThamGia) {
        this.gvThamGia = gvThamGia;
    }

}
