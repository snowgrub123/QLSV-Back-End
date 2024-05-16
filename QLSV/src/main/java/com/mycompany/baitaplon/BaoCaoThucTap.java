/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.s;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author NOBITA
 */
public class BaoCaoThucTap extends BaoCao{
    private String thongTinDanhGia;

    public BaoCaoThucTap() {
    }

    public BaoCaoThucTap(String tenBC,
             String ngayBC, String tenGV, String chuoiLink, double diemBC, String danhGia,List<Integer> maSV) throws ParseException {
        super(tenBC, ngayBC, tenGV, chuoiLink,maSV);
        this.setLoaiBaoCao(mangloaiBC[0]);
        this.diemBC = diemBC;
        this.thongTinDanhGia = danhGia;

    }

    @Override
    public void NhapDiem() {
        double diem = 0;
        do {
            System.out.print("Nhap diem bao cao:");
            diem = Double.parseDouble(s.nextLine());
            if (diem < 0 || diem > 10) {
                System.out.println("Hay nhap diem >=0 va diem <=10");
            }
        } while (diem < 0 || diem > 10);
        setDiemBC(diem);
    }

    @Override
    public void nhapBaoCao() throws ParseException, FileNotFoundException {
        super.nhapBaoCao();
        setLoaiBaoCao(mangloaiBC[0]);
        System.out.print("Nhap thong tin danh gia:");
        this.thongTinDanhGia = s.nextLine();
    }

    @Override
    public void hienThiBC() {
        super.hienThiBC();
        System.out.printf("\t\t\tThong tin danh gia:%s", this.thongTinDanhGia + "\n");
    }
    
    public String getThongTinDanhGia() {
        return thongTinDanhGia;
    }

    public void setThongTinDanhGia(String thongTinDanhGia) {
        this.thongTinDanhGia = thongTinDanhGia;
    }
}
