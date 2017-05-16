
package absensisekolah.TableModel;

import absensisekolah.Entity.AbsensiSiswaView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AbsensiSiswaTableModel extends AbstractTableModel {
    
    List <AbsensiSiswaView> ListAbsnSiswa ;
    String [] ColName = {"Nama", "Kelas", "Keterangan", "Tanggal"} ; 

    
    public AbsensiSiswaTableModel() {
        ListAbsnSiswa = new ArrayList<AbsensiSiswaView> () ;
    }
    
    
    public AbsensiSiswaTableModel(List<AbsensiSiswaView> ListAbsnSiswa) {
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
        return 4 ;
    }

    @Override
    public String getColumnName(int i) {
    return ColName[i];
    }
    
  
  
    @Override
    public Object getValueAt(int i, int i1) {
//        return null ;
        return ListAbsnSiswa.get(i).getObject(i1) ;
    }
    
}
