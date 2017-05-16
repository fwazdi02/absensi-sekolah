/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.Dao;

import absensisekolah.Entity.AbsensiGurudanStaff;
import absensisekolah.Entity.AbsensiGurudanStaffView;
import absensisekolah.Entity.GurudanStaff;
import absensisekolah.Utility.DateUtility;
import absensisekolah.Utility.DbUtility;
import absensisekolah.view.AbsensiFrame;
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

public class AbsensiGurudanStaffDao {

    Connection con;
    AbsensiGurudanStaffView AbsGrStView;
    AbsensiGurudanStaff AbsGrSt;
    List<AbsensiGurudanStaffView> listAbsGrSt;
    DateUtility du;

    public AbsensiGurudanStaffDao() {
        con = new DbUtility().getConnection();
        du = new DateUtility();
    }

    public boolean TambahAbsenGuru(GurudanStaff GrSt, AbsensiFrame AbsFrame) {
        String query = "INSERT INTO absensistaff  (NIGS, Nama, Jabatan, Keterangan, Tanggal) values (?,?,?,?, CURRENT_DATE ()) ";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps.setObject(1, GrSt.getNIGS());
            ps.setObject(2, GrSt.getNama());
            ps.setObject(3, GrSt.getJabatan());
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

    public boolean TambahAbsnGrStMF(AbsensiGurudanStaff GrSt) {
        String query = "INSERT INTO absensistaff  (NIGS, Nama, Jabatan, Keterangan, Tanggal) values (?,?,?,?,?) ";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps.setObject(1, GrSt.getNIGS());
            ps.setObject(2, GrSt.getNama());
            ps.setObject(3, GrSt.getJabatan());
            ps.setObject(4, GrSt.getKet());
            ps.setObject(5, GrSt.getTanggal());

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

    public boolean updateAbsensiGrSt(AbsensiGurudanStaff GrSt) {
        boolean result = false;
        String query = "UPDATE absensistaff SET NIGS=?, Nama=?, Jabatan=?, Keterangan=?, Tanggal=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            for (int i = 1; i <= 5; i++) {
                ps.setObject(i, GrSt.getObject(i));
            }
            ps.setInt(6, GrSt.getId());
            if (ps.executeUpdate() == 1) {
                result = true;
            }
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

    public boolean deleteAbsensiGrSt(int id) {
        String query = "DELETE FROM absensistaff WHERE id=?";
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

    public AbsensiGurudanStaff getAbsnGrSt(int id) {

        String query = "SELECT * FROM absensistaff WHERE id=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AbsGrSt = new AbsensiGurudanStaff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return AbsGrSt;

    }

    public List<AbsensiGurudanStaffView> getListAbsGurudanStaffTDY() {
        listAbsGrSt = new ArrayList<AbsensiGurudanStaffView>();
        String query = "SELECT * FROM absensistaff WHERE tanggal = CURRENT_DATE () ORDER BY id";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AbsGrStView = new AbsensiGurudanStaffView(rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                listAbsGrSt.add(AbsGrStView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsGrSt;
    }

    public List<AbsensiGurudanStaffView> getListAbsGurudanStaffM() {
        listAbsGrSt = new ArrayList<AbsensiGurudanStaffView>();
        String query = "SELECT * FROM absensistaff ORDER BY id";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                AbsGrStView = new AbsensiGurudanStaffView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
                listAbsGrSt.add(AbsGrStView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsGrSt;
    }

    public List<AbsensiGurudanStaffView> getListAbsGurudanStaffbyName(String Nama) {
        listAbsGrSt = new ArrayList<AbsensiGurudanStaffView>();
        String query = "SELECT * FROM absensistaff WHERE nama= ? ORDER BY id";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, Nama);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AbsGrStView = new AbsensiGurudanStaffView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
                listAbsGrSt.add(AbsGrStView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsGrSt;
    }

    public List<AbsensiGurudanStaffView> getListAbsGurudanStaffbyDate(String dt) {
        listAbsGrSt = new ArrayList<AbsensiGurudanStaffView>();
        String query = "SELECT * FROM absensistaff WHERE Tanggal= ? ORDER BY id";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.setDate(1, du.createDate(dt));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AbsGrStView = new AbsensiGurudanStaffView(rs.getInt(1), rs.getDate(6), rs.getString(3), rs.getString(4), rs.getString(5));
                listAbsGrSt.add(AbsGrStView);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbsensiGurudanStaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAbsGrSt;
    }

    public boolean isAlready (String NIGS) {

        String query = "SELECT * FROM absensistaff  WHERE NIGS= ? && Tanggal = CURRENT_DATE ()";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, NIGS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AbsGrSt = new AbsensiGurudanStaff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                return true ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        return false;

    }

}
