/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class AbsensiGurudanStaff {
    
    int id ;
    String NIGS ;
    String Nama ;
    String Jabatan ;
    String Ket ;
    Date Tanggal ;

    public AbsensiGurudanStaff() {
    }

    public AbsensiGurudanStaff(int id, String NIGS, String Nama, String Jabatan, String Ket, Date Tanggal) {
        this.id = id;
        this.NIGS = NIGS;
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }
    
    public AbsensiGurudanStaff(String Nama, String Jabatan, String Ket, Date Tanggal) {
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNIGS() {
        return NIGS;
    }

    public void setNIGS(String NIGS) {
        this.NIGS = NIGS;
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
            case 0: return id;
            case 1: return NIGS;
            case 2: return Nama;
            case 3: return Jabatan;
            case 4: return Ket ;
            case 5: return Tanggal;
            default: return null;
        }
        
    }
    
    
}
