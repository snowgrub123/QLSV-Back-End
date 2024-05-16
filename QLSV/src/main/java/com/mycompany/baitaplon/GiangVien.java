/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitaplon;

import static com.mycompany.baitaplon.SinhVien.s;

/**
 *
 * @author NOBITA
 */
public class GiangVien {
    private static int dem = 0;
    private int maGV;
    private String hoten;
    private String hocHam;
    private String hocVi;
    private String nhiemVu;
    private boolean thamGiaKhoaLuan;
    private static final String[] mangLoaiNV = new String[]{"Chu Tich", "Thu Ki", "Phan Bien", "Uy Vien", "Khong Nhiem Vu"};
    private static final String[] mangHocHam = new String[]{"Giao Su", "Pho Giao Su", "Khong Hoc Ham"};
    private static final String[] mangHocVi = new String[]{"Thac Si", "Tien Si", "Tien Si Khoa Hoc"};
    {
        ++dem;
        this.maGV = dem;
    }
    public GiangVien() {
    }
    public GiangVien(String hoten, String hocHam, String hocVi, boolean thamGia, String nhiemVu) {
        this.hoten = hoten;
        this.hocHam = hocHam;
        this.hocVi = hocVi;
        this.thamGiaKhoaLuan = thamGia;
        this.nhiemVu = nhiemVu;
    }
    
    public void chonHocHamHocVi() {
        int chonHV;
        int chonHH;
        do {
            System.out.println("-----Chon Hoc Vi-----");
            for (int i = 0; i < mangHocVi.length; i++) {
                System.out.printf("%d.%s\n", i, mangHocVi[i]);
            }
            System.out.printf("Chon tu 0 den %s : ", mangHocVi.length - 1);
            chonHV = Integer.parseInt(s.nextLine());
        } while (chonHV < 0 || chonHV > mangHocVi.length);
        this.hocVi = mangHocVi[chonHV];
        do {
            System.out.println("-----Chon Hoc Ham-----");
            for (int i = 0; i < mangHocHam.length; i++) {
                System.out.printf("%d.%s\n", i, mangHocHam[i]);
            }
            System.out.printf("Chon tu 0 den %s : ", mangHocHam.length - 1);
            chonHH = Integer.parseInt(s.nextLine());
        } while (chonHH < 0 || chonHH > mangHocHam.length);
        this.hocHam = mangHocHam[chonHH];
    }

    public void chonNV() {
        int chonNV;
        do {
            System.out.println("-----Danh sach nhiem vu-----");
            for (int i = 0; i < mangLoaiNV.length; i++) {
                System.out.printf("%d.%s\n", i, mangLoaiNV[i]);
            }
            System.out.printf("Chon tu 0 den %s : ", mangLoaiNV.length - 1);
            chonNV = Integer.parseInt(s.nextLine());
            if (chonNV == 0 || chonNV == 1 || chonNV == 2 || chonNV == 3) {
                setThamGiaKhoaLuan(true);
            } else if (chonNV == 4) {
                setThamGiaKhoaLuan(false);
            }
        } while (chonNV < 0 || chonNV >= mangLoaiNV.length);
        this.nhiemVu = mangLoaiNV[chonNV];

    }
    public void hienThi() {
        System.out.printf("[Ma GV]: %d\n\t[Ten GV]: %s\t\t\t[Hoc Vi]: %s\n\t[Hoc Ham]: %s\t\t\t",
                this.maGV, this.hoten, this.hocVi, this.hocHam);
        if (this.thamGiaKhoaLuan == true) {
            System.out.println("\tTham gia khoa luan");
        } else {
            System.out.println("\tKhong tham gia khoa luan");
        }
        System.out.println("\t[Nhiem vu] : " + this.nhiemVu +"\n");
    }

    public void nhapGV() {
        System.out.print("Nhap ten GV : ");
        this.hoten = s.nextLine();
        chonHocHamHocVi();
        chonNV();
    }
    public int getMaGV() {
        return maGV;
    }
    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }
    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getHocHam() {
        return hocHam;
    }
    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }
    public String getHocVi() {
        return hocVi;
    }
    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }
    public String getNhiemVu() {
        return nhiemVu;
    }
    public void setNhiemVu(String nhiemVu) {
        this.nhiemVu = nhiemVu;
    }
    public boolean isThamGiaKhoaLuan() {
        return thamGiaKhoaLuan;
    }
    public void setThamGiaKhoaLuan(boolean thamGiaKhoaLuan) {
        this.thamGiaKhoaLuan = thamGiaKhoaLuan;
    }
    public String[] getMangLoaiNV() {
        return mangLoaiNV;
    }
    public String[] getMangHocHam() {
        return mangHocHam;
    }

}
