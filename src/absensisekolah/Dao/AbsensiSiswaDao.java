/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.Dao;

import absensisekolah.Entity.AbsensiSiswa;
import absensisekolah.Entity.AbsensiSiswaView;
import absensisekolah.Entity.Siswa;
import absensisekolah.Entity.SiswaView;
import absensisekolah.Utility.DateUtility;
import absensisekolah.Utility.DbUtility;
import absensisekolah.view.AbsensiFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AbsensiSiswaDao {

    Connection con;
    AbsensiSiswaView AbsSiswaView;
    AbsensiSiswa AbsSw ;
    List<AbsensiSiswaView> listAbsSiswa;
    DateUtility du ;

    public AbsensiSiswaDao() {
        con = new DbUtility().getConnection();
        du = new DateUtility() ;
    }

    public boolean TambahAbsnSSw(Siswa ssw, AbsensiFrame AbsFrame) {
        String query = "INSERT INTO absensisiswa  (NISS, Nama, Keljur, Keterangan, Tanggal) values (?,?,?,?, CURRENT_DATE ()) ";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps.setObject(1, ssw.getNISS());
            ps.setObject(2, ssw.getNama());
            ps.setObject(3, ssw.getKelJur());
            ps.setObject(4, AbsFrame.getStsAbs());
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
    
    public boolean TambahAbsnSSwMF(AbsensiSiswa ssw) {
        String query = "INSERT INTO absensisiswa  (NISS, Nama, Keljur, Keterangan, Tanggal) values (?,?,?,?,?) ";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps.setObject(1, ssw.getNISS());
            ps.setObject(2, ssw.getNama());
            ps.setObject(3, ssw.getKelJur());
            ps.setObject(4, ssw.getKet());
            ps.setObject(5, ssw.getTanggal());
            
            
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
    
    
    public boolean updateAbsensiSsw(AbsensiSiswa ssw) {
        boolean result = false;
        String query = "UPDATE absensisiswa SET NISS=?, Nama=?, Keljur=?, Keterangan=?, Tanggal=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query) ;
            for (int i = 1; i <= 5; i++) {
                ps.setObject(i, ssw.getObject(i));
            }
            ps.setInt(6, ssw.getId());
            if (ps.executeUpdate() == 1) result = true;
            con.commit();
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when update data \n Error: " + e.getMessage());
            try {
                con.rollback();
                ps.close();
            } catch (Exception ex) {
            }
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
        }
        return result;
    }

    
    
    public boolean deleteAbsensiSsw(int id) {
        String query = "DELETE FROM absensisiswa WHERE id=?";
        PreparedStatement statement = null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            con.setAutoCommit(false);
            if (statement.executeUpdate() == 1) {
                con.commit();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: " + e.getMessage());
            try {
                con.rollback();
                statement.close();
            } catch (Exception ex) {
            }
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

    public AbsensiSiswa getAbsnSsw(int id) {

        String query = "SELECT * FROM absensisiswa WHERE id=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AbsSw = new AbsensiSiswa (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)) ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return AbsSw;

    }
    
    

    public List<AbsensiSiswaView> getListAbsSiswaTDY() {
        listAbsSiswa = new ArrayList<AbsensiSiswaView>();
        String query = "SELECT * FROM absensisiswa WHERE tanggal = CURRENT_DATE () ORDER BY id";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AbsSiswaView = new AbsensiSiswaView(rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                listAbsSiswa.add(AbsSiswaView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiSiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsSiswa;
    }
    
    
    public List<AbsensiSiswaView> getListAbsSiswaM() {
        listAbsSiswa = new ArrayList<AbsensiSiswaView>();
        String query = "SELECT * FROM absensisiswa ORDER BY id";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AbsSiswaView = new AbsensiSiswaView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
//                System.out.println(AbsSiswaView.getNama());
                listAbsSiswa.add(AbsSiswaView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiSiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsSiswa;
    }

    
    public List<AbsensiSiswaView> getListAbsSiswabyName(String Name) {
        listAbsSiswa = new ArrayList<AbsensiSiswaView>();
        String query = "SELECT * FROM absensisiswa WHERE nama= ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AbsSiswaView = new AbsensiSiswaView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
//                System.out.println(AbsSiswaView.getNama());
                listAbsSiswa.add(AbsSiswaView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiSiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsSiswa;
    }

    public List<AbsensiSiswaView> getListAbsSiswabyDate(String dt) {
        listAbsSiswa = new ArrayList<AbsensiSiswaView>();
        String query = "SELECT * FROM absensisiswa WHERE tanggal= ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.setDate(1, du.createDate(dt));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AbsSiswaView = new AbsensiSiswaView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
//                System.out.println(AbsSiswaView.getNama());
                listAbsSiswa.add(AbsSiswaView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiSiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsSiswa;
    }
    
    
    
    public boolean isAlready(String NISS) {

        String query = "SELECT * FROM absensisiswa WHERE NISS= ? && Tanggal = CURRENT_DATE ()";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, NISS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AbsSw = new AbsensiSiswa (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)) ;
                return true ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    
}
