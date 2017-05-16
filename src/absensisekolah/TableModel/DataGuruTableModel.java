
package absensisekolah.TableModel;

import absensisekolah.Entity.AbsensiSiswaView;
import absensisekolah.Entity.GurudanStaff;
import absensisekolah.Entity.Siswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DataGuruTableModel extends AbstractTableModel {
    
    List <GurudanStaff> ListGurudanStaff ;
    String [] ColName = {"id","NIP","NIGS","Nama", "Jabatan", "Tempat Lahir", "Tanggal Lahir",
                            "JenKel", "Pendidikan", "Agama", "Alamat"} ; 

    
    public DataGuruTableModel() {
        ListGurudanStaff = new ArrayList<GurudanStaff> () ;
    }
    
    
    public DataGuruTableModel(List<GurudanStaff> ListGurudanStaff) {
        this.ListGurudanStaff = ListGurudanStaff;
    }

    public void setListAbsnSiswa(List<GurudanStaff> ListGurudanStaff) {
        this.ListGurudanStaff = ListGurudanStaff;
    }
    
    

    @Override
    public int getRowCount() {
        return ListGurudanStaff.size();
    }

    @Override
    public int getColumnCount() {
        return 11 ;
    }

    @Override
    public String getColumnName(int i) {
    return ColName[i];
    }
    
  
  
    @Override
    public Object getValueAt(int i, int i1) {
//        return null ;
        return ListGurudanStaff.get(i).getObject(i1) ;
    }
    
}
