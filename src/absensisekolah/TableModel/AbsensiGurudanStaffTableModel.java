
package absensisekolah.TableModel;

import absensisekolah.Entity.AbsensiGurudanStaffView;
import absensisekolah.Entity.AbsensiSiswaView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AbsensiGurudanStaffTableModel extends AbstractTableModel {
    
    List <AbsensiGurudanStaffView> ListAbsnGrSt ;
    String [] ColName = {"Nama", "Jabatan", "Keterangan", "Tanggal"} ; 

    public AbsensiGurudanStaffTableModel() {
        ListAbsnGrSt = new ArrayList<AbsensiGurudanStaffView>() ;
    }


    public AbsensiGurudanStaffTableModel(List<AbsensiGurudanStaffView> ListAbsnGrSt) {
        this.ListAbsnGrSt = ListAbsnGrSt;
    }

    public void setListAbsnGrSt(List<AbsensiGurudanStaffView> ListAbsnGrSt) {
        this.ListAbsnGrSt = ListAbsnGrSt;
    } 

    @Override
    public int getRowCount() {
        return ListAbsnGrSt.size() ;
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
          return ListAbsnGrSt.get(i).getObject(i1) ;
    
    }
    
}
