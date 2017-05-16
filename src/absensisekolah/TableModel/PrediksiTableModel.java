/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.TableModel;

import absensisekolah.Entity.ObjPrediksi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PrediksiTableModel extends AbstractTableModel {

    List <ObjPrediksi> listObj ;
    String [] Header = {"No.Induk", "Nama", "Status"} ;

    
    
    public PrediksiTableModel() {
        listObj = new ArrayList<ObjPrediksi>  () ;
     }

    public PrediksiTableModel(List<ObjPrediksi> listObj) {
        this.listObj = listObj;
    }
    
    public void setListObj(List<ObjPrediksi> listObj) {
        this.listObj = listObj;
    }

    @Override
    public String getColumnName(int i) {
        return Header[i] ;
    }

   
    @Override
    public int getRowCount() {
        return listObj.size() ;
    }

    @Override
    public int getColumnCount() {
        return 3 ;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return listObj.get(i).getObject(i1) ;
    }
    
}
