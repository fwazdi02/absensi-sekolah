/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class SiswaView {
    
    int Id ;
    String NISN ;
    String NISS ;
    String Nama ;
    String KelJur ;
    String TmptLahir ;
    Date TanggalLahir ;
    String JenKel ;
    String AsalSekolah ;
    String Agama ;
    String Alamat ;

    public SiswaView(int Id, String NISS, String Nama, String KelJur) {
        this.Id = Id;
        this.NISS = NISS;
        this.Nama = Nama;
        this.KelJur = KelJur;
    }

    public SiswaView(int Id, String NISN, String NISS, String Nama, String KelJur, String TmptLahir, Date TanggalLahir, String JenKel, String AsalSekolah, String Agama, String Alamat) {
        this.Id = Id;
        this.NISN = NISN;
        this.NISS = NISS;
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.TmptLahir = TmptLahir;
        this.TanggalLahir = TanggalLahir;
        this.JenKel = JenKel;
        this.AsalSekolah = AsalSekolah;
        this.Agama = Agama;
        this.Alamat = Alamat;
    }

    public SiswaView(String NISN, String NISS, String Nama, String KelJur, String TmptLahir, Date TanggalLahir, String JenKel, String AsalSekolah, String Agama, String Alamat) {
        this.NISN = NISN;
        this.NISS = NISS;
        this.Nama = Nama;
        this.KelJur = KelJur;
        this.TmptLahir = TmptLahir;
        this.TanggalLahir = TanggalLahir;
        this.JenKel = JenKel;
        this.AsalSekolah = AsalSekolah;
        this.Agama = Agama;
        this.Alamat = Alamat;
    }
    
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNISN() {
        return NISN;
    }

    public void setNISN(String NISN) {
        this.NISN = NISN;
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

    public String getTmptLahir() {
        return TmptLahir;
    }

    public void setTmptLahir(String TmptLahir) {
        this.TmptLahir = TmptLahir;
    }

    public Date getTanggalLahir() {
        return TanggalLahir;
    }

    public void setTanggalLahir(Date TanggalLahir) {
        this.TanggalLahir = TanggalLahir;
    }

    public String getJenKel() {
        return JenKel;
    }

    public void setJenKel(String JenKel) {
        this.JenKel = JenKel;
    }

    public String getAsalSekolah() {
        return AsalSekolah;
    }

    public void setAsalSekolah(String AsalSekolah) {
        this.AsalSekolah = AsalSekolah;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String Agama) {
        this.Agama = Agama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
 
    
    
    
    public Object getObject(int index) {
        switch(index){
            case 0: return Id;
            case 1: return NISN;
            case 2: return NISS;
            case 3: return Nama;
            case 4: return KelJur;
            case 5: return TmptLahir;
            case 6: return TanggalLahir;
            case 7: return JenKel;
            case 8: return AsalSekolah;
            case 9: return Agama;
            case 10: return Alamat;
          
            default: return null;
        }
    }
    
    
    
}
