
package absensisekolah.TableModel;

import absensisekolah.Entity.AbsensiSiswaView;
import absensisekolah.Entity.Siswa;
import absensisekolah.Entity.SiswaView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DataSiswaTableModel extends AbstractTableModel {
    
    List <SiswaView> ListSiswa ;
    String [] ColName = {"id","NISN","NISS","Nama", "Kelas/Jurusan", "Tempat Lahir", "Tanggal Lahir",
                            "JenKel", "Asal Sekolah", "Agama", "Alamat"} ; 

    
    public DataSiswaTableModel() {
        ListSiswa = new ArrayList<SiswaView> () ;
    }
    
    
    public DataSiswaTableModel(List<SiswaView> ListSiswa) {
        this.ListSiswa = ListSiswa;
    }

    public void setListAbsnSiswa(List<SiswaView> ListSiswa) {
        this.ListSiswa = ListSiswa;
    }
    
    

    @Override
    public int getRowCount() {
        return ListSiswa.size();
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
        return ListSiswa.get(i).getObject(i1) ;
    }
    
}
