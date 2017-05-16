/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Dao;

import absensisekolah.Entity.ObjPrediksi;
import absensisekolah.Utility.DbUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrediksiDao {

    Connection con ;
    ObjPrediksi Obj ;
    List<ObjPrediksi> ListObj ;
   
    public PrediksiDao() {
        con = new DbUtility().getConnection();
    }

    public List<ObjPrediksi> getListObj() {
        return ListObj;
    }

    
    
    
    
    public boolean IsObjSiswaAvaliable (String Name)
    {
        ListObj = new ArrayList<ObjPrediksi> () ;
        String query = "SELECT * FROM siswa WHERE nama_siswa=?" ;
        
        PreparedStatement ps = null ;
           try {
                ps = con.prepareStatement(query) ;
                ps.setString(1, Name);
                ResultSet rs = ps.executeQuery() ;
                while (rs.next())
                {
                    Obj = new ObjPrediksi(rs.getString(3), rs.getString(4), rs.getString(5)) ;
                    ListObj.add(Obj) ;
                    return true ;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PrediksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false ;
        
    }
    
    
    public boolean IsObjGrStAvaliable (String Name)
    {
        ListObj = new ArrayList<ObjPrediksi> () ;
        String query = "SELECT * FROM guru WHERE nama_guru=?" ;
        
        PreparedStatement ps = null ;
           try {
                ps = con.prepareStatement(query) ;
                ps.setString(1, Name);
                ResultSet rs = ps.executeQuery() ;
                while (rs.next())
                {
                    Obj = new ObjPrediksi(rs.getString(3), rs.getString(4), rs.getString(5)) ;                 
                    ListObj.add(Obj) ;
                    return true ;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PrediksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false ;
        
    }
    
    
    
    
    
    
    public List<ObjPrediksi> getListPrediksiSiswa (String Name)
    {
        ListObj = new ArrayList<ObjPrediksi> () ;
        String query = "SELECT * FROM siswa WHERE nama_siswa=?" ;
        
        PreparedStatement ps = null ;
           try {
                ps = con.prepareStatement(query) ;
                ps.setString(1, Name);
                ResultSet rs = ps.executeQuery() ;
                
                while (rs.next())
                {
                    Obj = new ObjPrediksi(rs.getString(3), rs.getString(4), rs.getString(5)) ;
//                    System.out.println("a : "+rs.getString(3)+"b : "+rs.getString(4)+" c : " +rs.getString(5));
                   
                    ListObj.add(Obj) ;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PrediksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return ListObj ;
        
    }
    
    
    public List<ObjPrediksi> getListPrediksiGuru (String Name)
    {
        ListObj = new ArrayList<ObjPrediksi> () ;
        String query = "SELECT * FROM guru WHERE nama_guru=?" ;
        
        PreparedStatement ps = null ;
           try {
                ps = con.prepareStatement(query) ;
                ps.setString(1, Name);
                ResultSet rs = ps.executeQuery() ;
                while (rs.next())
                {
                    Obj = new ObjPrediksi(rs.getString(3), rs.getString(4), rs.getString(5)) ;
                    ListObj.add(Obj) ;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PrediksiDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return ListObj ;
        
    }

   
    
    
   
    
    
    
}
