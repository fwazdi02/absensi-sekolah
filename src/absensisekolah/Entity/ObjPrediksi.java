/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Entity;

public class ObjPrediksi {
    
    String NoInduk ;
    String Nama ;
    String Status ;

    public ObjPrediksi(String NoInduk, String Nama, String Status) {
        this.NoInduk = NoInduk;
        this.Nama = Nama;
        this.Status = Status;
    }

    public String getNoInduk() {
        return NoInduk;
    }

    public void setNoInduk(String NoInduk) {
        this.NoInduk = NoInduk;
    }

    
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public Object getObject(int index) {
        switch(index){
            case 0: return NoInduk;
            case 1: return Nama;
            case 2: return Status;
            default: return null;
        }
    }
    

    
}
