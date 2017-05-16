/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

import java.util.Date;

public class GurudanStaff {
    
    int id;
    String NIP ;
    String NIGS ;
    String Nama ;
    String Jabatan ;
    String TmptLahir ;
    Date TanggalLahir ;
    String JenKel ;
    String Pendidikan ;
    String Agama ;
    String Alamat ;

    public GurudanStaff(int id, String NIGS, String Nama, String Jabatan) {
        this.id = id;
        this.NIGS = NIGS;
        this.Nama = Nama;
        this.Jabatan = Jabatan;
    }

    public GurudanStaff(String NIP, String NIGS, String Nama, String Jabatan, String TmptLahir, Date TanggalLahir, String JenKel, String Pendidikan, String Agama, String Alamat) {
        this.NIP = NIP;
        this.NIGS = NIGS;
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.TmptLahir = TmptLahir;
        this.TanggalLahir = TanggalLahir;
        this.JenKel = JenKel;
        this.Pendidikan = Pendidikan;
        this.Agama = Agama;
        this.Alamat = Alamat;
    }

    public GurudanStaff(int id, String NIP, String NIGS, String Nama, String Jabatan, String TmptLahir, Date TanggalLahir, String JenKel, String Pendidikan, String Agama, String Alamat) {
        this.id = id;
        this.NIP = NIP;
        this.NIGS = NIGS;
        this.Nama = Nama;
        this.Jabatan = Jabatan;
        this.TmptLahir = TmptLahir;
        this.TanggalLahir = TanggalLahir;
        this.JenKel = JenKel;
        this.Pendidikan = Pendidikan;
        this.Agama = Agama;
        this.Alamat = Alamat;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
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

    public String getPendidikan() {
        return Pendidikan;
    }

    public void setPendidikan(String Pendidikan) {
        this.Pendidikan = Pendidikan;
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
            case 0: return id;
            case 1: return NIP;
            case 2: return NIGS;
            case 3: return Nama;
            case 4: return Jabatan;
            case 5: return TmptLahir;
            case 6: return TanggalLahir;
            case 7: return JenKel;
            case 8: return Pendidikan;
            case 9: return Agama;
            case 10: return Alamat;
          
            default: return null;
        }
    }
    
    
    

    
}
