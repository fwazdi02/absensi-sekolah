
package absensisekolah.Entity;

import java.util.Date;

public class User {
    
    int id ;
    String Usrnm ;
    String Passwd ;
    String Nama  ;
    String typeUser ;
    Date Created ;
    String Ket ;

    public User(int id, String Usrnm, String Passwd, String Nama, String typeUser, Date Created, String Ket) {
        this.id = id;
        this.Usrnm = Usrnm;
        this.Passwd = Passwd;
        this.Nama = Nama;
        this.typeUser = typeUser;
        this.Created = Created;
        this.Ket = Ket;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrnm() {
        return Usrnm;
    }

    public void setUsrnm(String Usrnm) {
        this.Usrnm = Usrnm;
    }

    public String getPsswd() {
        return Passwd;
    }

    public void setPsswd(String Psswd) {
        this.Passwd = Psswd;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public String getKet() {
        return Ket;
    }

    public void setKet(String Ket) {
        this.Ket = Ket;
    }
    
    public Object getObject (int index)
    {
        switch(index)
        {
            case 0 : return id;
            case 1 : return Usrnm;
            case 2 : return Passwd;
            case 3 : return Nama;
            case 4 : return typeUser;
            case 5 : return Created;
            case 6 : return Ket ;
            
            default: return null ;
        }
    }
    
    
    
}
