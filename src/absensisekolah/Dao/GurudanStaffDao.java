/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package absensisekolah.Dao;

import absensisekolah.Entity.GurudanStaff;
import absensisekolah.Entity.Siswa;
import absensisekolah.Utility.DateUtility;
import absensisekolah.Utility.DbUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GurudanStaffDao {
    
    Connection con;
    GurudanStaff GrSt ;
    List<GurudanStaff> ListGurudanstaff ;
    DateUtility du ;
    
    public GurudanStaffDao() {
        con = new DbUtility().getConnection();
        du = new DateUtility() ;
    }
    
    
    public GurudanStaff getGrSt() {
        return GrSt;
    }

  
    public boolean TambahGurudanStaff(GurudanStaff GrSt) {
        String query = "INSERT INTO guru  (NIP, NIGS, Nama_Guru, Jabatan, Tempat_Lahir, Tanggal_Lahir, JenKel, Pendidikan, Agama, Alamat)"+
                " values (?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps.setObject(1, GrSt.getNIP());
            ps.setObject(2, GrSt.getNIGS());
            ps.setObject(3, GrSt.getNama());
            ps.setObject(4, GrSt.getJabatan());
            ps.setObject(5, GrSt.getTmptLahir());
            ps.setObject(6, GrSt.getTanggalLahir());
            ps.setObject(7, GrSt.getJenKel());
            ps.setObject(8, GrSt.getPendidikan());
            ps.setObject(9, GrSt.getAgama());
            ps.setObject(10, GrSt.getAlamat());
            if (ps.executeUpdate() == 1) {
                con.commit();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: " + ex.getMessage());
            try {
                con.rollback();
                ps.close();
            } catch (Exception e) {
            }
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }

        }

        return true;

    }
    
    public boolean updateGurudanStaff(GurudanStaff GrSt){
        boolean result = false;
        String query = "UPDATE guru SET NIP=?, NIGS=?, Nama_Guru=?, Jabatan=?, Tempat_Lahir=?, Tanggal_Lahir=?, "
                + "JenKel=?, Pendidikan=?, Agama=?, Alamat=? WHERE id=?" ;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(query);
            for(int i=1; i<=10;i++)statement.setObject(i, GrSt.getObject(i));
            statement.setInt(11, GrSt.getId());
            con.setAutoCommit(false);
            if(statement.executeUpdate()==1){
                result = true;
            }
                con.commit();
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error when update data \n Error: "+e.getMessage());
            try {con.rollback(); statement.close(); } catch (Exception ex) { }
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return result;
    }

    public boolean deleteAnggota(int id){
        String query = "DELETE FROM guru WHERE id=?";
        PreparedStatement statement=null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            con.setAutoCommit(false);
            if(statement.executeUpdate() == 1) con.commit();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: "+e.getMessage());
            try {con.rollback(); statement.close();} catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    
    

    public GurudanStaff getGurudanStaff (int id)
    {
        String query = "SELECT * FROM guru WHERE id=?" ;
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(query) ;
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery() ;
            while (rs.next())
            {
                GrSt = new GurudanStaff (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)) ;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return GrSt ;
    
    
    }
    
    
    public boolean isGurudanStaffRegistered (String NIGS)
    {
        String query = "SELECT * FROM guru WHERE NIGS=?" ;
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(query) ;
            ps.setString(1, NIGS);
            ResultSet rs = ps.executeQuery() ;
            while (rs.next())
            {
                GrSt = new GurudanStaff (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)) ;
                
               return true ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
     
        return false;
        
    }
    
    public List<GurudanStaff> getListGurudanStaff ()
    {
        ListGurudanstaff = new ArrayList<GurudanStaff>() ;
        String query = "SELECT * FROM guru ORDER BY id" ;
        Statement stmt = null;
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                    GrSt = new GurudanStaff (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)) ;
//                    System.out.println(GrSt.getNama());
                    ListGurudanstaff.add(GrSt) ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return ListGurudanstaff;
        
    }
    
    
    
    public List<GurudanStaff> getListGurudanStaffbyName (String Name)
    {
        ListGurudanstaff = new ArrayList<GurudanStaff>() ;
        String query = "SELECT * FROM guru WHERE nama_guru=? ORDER BY id" ;
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                    GrSt = new GurudanStaff (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)) ;
//                    System.out.println(GrSt.getNama());
                    ListGurudanstaff.add(GrSt) ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return ListGurudanstaff;
        
    }
    
    public List<GurudanStaff> getListGurudanStaffbyJbtn (String Jbtn)
    {
        ListGurudanstaff = new ArrayList<GurudanStaff>() ;
        String query = "SELECT * FROM guru WHERE Jabatan=? ORDER BY id" ;
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, Jbtn);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                    GrSt = new GurudanStaff (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)) ;
//                    System.out.println(GrSt.getNama());
                    ListGurudanstaff.add(GrSt) ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return ListGurudanstaff;
        
    }
    
    
     
    
    
}
