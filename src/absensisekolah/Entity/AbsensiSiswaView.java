/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class AbsensiSiswaView {
    
    int id ;
    String NISS ;
    String Nama ;
    String KelJur ;
    String Ket ;
    Date Tanggal ; 

    public AbsensiSiswaView() {
    }

    public AbsensiSiswaView(int id, Date Tanggal, String Nama, String KelJur, String Ket) {
        this.id = id;
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }

    
    public AbsensiSiswaView(String Nama, String KelJur, String Ket, Date Tanggal) {
       
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }

    public String getNISS() {
        return NISS;
    }

    public void setNISS(String NISS) {
        this.NISS = NISS;
    }

    
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getKelJur() {
        return KelJur;
    }

    public void setKelJur(String KelJur) {
        this.KelJur = KelJur;
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
            case 1: return KelJur;
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
            case 3: return KelJur;
            case 4: return Ket ;
            default: return null;
        }
        
        }

    
    
}
