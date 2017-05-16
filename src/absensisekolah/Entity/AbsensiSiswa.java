/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class AbsensiSiswa {
    
    int id ;
    String NISS ;
    String Nama ;
    String KelJur ;
    String Ket ;
    Date Tanggal ; 

    public AbsensiSiswa() {
    }

    public AbsensiSiswa(int id, String NISS, String Nama, String KelJur, String Ket, Date Tanggal) {
        this.id = id;
        this.NISS = NISS;
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }


    
    public AbsensiSiswa(String NISS, String Nama, String KelJur, String Ket, Date Tanggal) {
        this.NISS = NISS ;
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.Ket = Ket;
        this.Tanggal = Tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            case 0: return id;
            case 1: return NISS;
            case 2: return Nama;
            case 3: return KelJur;
            case 4: return Ket ;
            case 5: return Tanggal;
            default: return null;
        }
        
        }

    
    
    }
    
    
    
    
