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
public class BaoCaoDoAn extends BaoCao{
    private double tiLeDaoVan;

    public BaoCaoDoAn() {
    }

    public BaoCaoDoAn(String tenBC, String ngayBC, String tenGV, String chuoiLink, double diemBC,double tiLeDaoVan,List<Integer> maSV) throws ParseException {
        super(tenBC, ngayBC, tenGV, chuoiLink,maSV);
        this.setLoaiBaoCao(mangloaiBC[1]);
        this.diemBC = diemBC;
        this.tiLeDaoVan = tiLeDaoVan;
        
    }

    @Override
    public void nhapBaoCao() throws ParseException, FileNotFoundException {
            super.nhapBaoCao();
            setLoaiBaoCao(mangloaiBC[1]);
            do{
                System.out.print("Nhap ti le dao van:");
                this.tiLeDaoVan = Double.parseDouble(s.nextLine());
            }while(this.tiLeDaoVan < 0 || this.tiLeDaoVan >100);
            
    }
    @Override
    public void NhapDiem() {
        double diem = 0;
        do {
            System.out.print("Nhap diem:");
            diem = Double.parseDouble(s.nextLine());
            if (diem < 0 || diem > 10) {
                System.out.println("Hay nhap diem >=0 va diem <=10");
            }
        } while (diem < 0 || diem > 10);
        setDiemBC(diem);
    }

    @Override
    public void hienThiBC() {
            super.hienThiBC();
            System.out.print("\t\t\tTi le dao van: " + this.tiLeDaoVan +"\n");
    }
    
    public void setTiLeDaoVan(double tiLeDaoVan) {
        this.tiLeDaoVan = tiLeDaoVan;
    }

    public double getTiLeDaoVan() {
        return tiLeDaoVan;
    }
    
}
