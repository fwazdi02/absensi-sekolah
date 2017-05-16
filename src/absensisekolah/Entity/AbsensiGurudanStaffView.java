/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class AbsensiGurudanStaffView {
    
    int id ;
    String NIGS ;
    String Nama ;
    String Jabatan ;
    String Ket ;
    Date Tanggal ;

    public AbsensiGurudanStaffView() {
    }

    public AbsensiGurudanStaffView(int id, Date Tanggal, String Nama, String Jabatan, String Ket) {
        this.id = id;
        this.NIGS = NIGS;
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }
    
    
    
    public AbsensiGurudanStaffView(String Nama, String Jabatan, String Ket, Date Tanggal) {
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    public String getKet() {
        return Ket;
    }

    public void setKet(String Ket) {
        this.Ket = Ket;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }
    
    
    
    
    public Object getObject(int index) {
        switch(index){
            case 0: return Nama;
            case 1: return Jabatan;
            case 2: return Ket;
            case 3: return Tanggal ;
            default: return null;
        }
    }
    
    public Object getObjectM(int index) {
        switch(index){
            case 0: return id;
            case 1: return Tanggal;
            case 2: return Nama;
            case 3: return Jabatan;
            case 4: return Ket ;
            default: return null;
        }
        
    }
    
    
}
