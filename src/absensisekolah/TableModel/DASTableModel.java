
package absensisekolah.TableModel;

import absensisekolah.Entity.AbsensiSiswaView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DASTableModel extends AbstractTableModel {
    
    List <AbsensiSiswaView> ListAbsnSiswa ;
    String [] ColName = {"id","Tanggal","Nama", "Kelas", "Keterangan"} ; 

    
    public DASTableModel() {
        ListAbsnSiswa = new ArrayList<AbsensiSiswaView> () ;
    }
    
    
    public DASTableModel(List<AbsensiSiswaView> ListAbsnSiswa) {
        this.ListAbsnSiswa = ListAbsnSiswa;
    }

    public void setListAbsnSiswa(List<AbsensiSiswaView> ListAbsnSiswa) {
        this.ListAbsnSiswa = ListAbsnSiswa;
    }
    
    

    @Override
    public int getRowCount() {
        return ListAbsnSiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 5 ;
    }

    @Override
    public String getColumnName(int i) {
    return ColName[i];
    }
    
  
  
    @Override
    public Object getValueAt(int i, int i1) {
//        return null ;
        return ListAbsnSiswa.get(i).getObjectM(i1) ;
    }
    
}
