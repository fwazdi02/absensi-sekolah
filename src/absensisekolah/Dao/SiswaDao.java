/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.Dao;

import absensisekolah.Entity.Siswa;
import absensisekolah.Entity.SiswaView;
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

public class SiswaDao {

    Connection con;
    SiswaView sswView;
    Siswa ssw;
    List<SiswaView> ListSiswa;

    public SiswaDao() {
        con = new DbUtility().getConnection();
    }

    public Siswa getSsw() {
        return ssw;
    }

    public boolean TambahSSw(Siswa ssw) {
        String query = "INSERT INTO siswa  (NISN, NISS, Nama_Siswa, Keljur, Tempat_Lahir, Tanggal_Lahir, JenKel, Asal_Sekolah, Agama, Alamat)"
                + " values (?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setObject(1, ssw.getNISN());
            ps.setObject(2, ssw.getNISS());
            ps.setObject(3, ssw.getNama());
            ps.setObject(4, ssw.getKelJur());
            ps.setObject(5, ssw.getTmptLahir());
            ps.setObject(6, ssw.getTanggalLahir());
            ps.setObject(7, ssw.getJenKel());
            ps.setObject(8, ssw.getAsalSekolah());
            ps.setObject(9, ssw.getAgama());
            ps.setObject(10, ssw.getAlamat());
          
            con.setAutoCommit(false);
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

    public boolean updateSsw(Siswa ssw) {
        boolean result = false;
        String query = "UPDATE siswa SET NISN=?, NISS=?, Nama_Siswa=?, Keljur=?, Tempat_Lahir=?, Tanggal_Lahir=?, "
                + "JenKel=?, Asal_Sekolah=?, Agama=?, Alamat=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(query) ;
            for (int i = 1; i <= 10; i++) {
                ps.setObject(i, ssw.getObject(i));
            }
            ps.setInt(11, ssw.getId());
            if (ps.executeUpdate() == 1) result = true;
            con.commit();
//            System.out.println("result ssw : " + result);
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

    public boolean deleteAnggota(int id) {
        String query = "DELETE FROM Siswa WHERE id=?";
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

    public Siswa getSswx(int id) {

        String query = "SELECT * FROM siswa WHERE id=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ssw = new Siswa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ssw;

    }

    public boolean isSiswaRegistered(String NISS) {
        String query = "SELECT * FROM siswa WHERE niss=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, NISS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ssw = new Siswa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));

                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return false;

    }

    public List<SiswaView> getListSiswa() {
        ListSiswa = new ArrayList<SiswaView>();
        String query = "SELECT * FROM siswa ORDER BY id";
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                sswView = new SiswaView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                ListSiswa.add(sswView);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ListSiswa;

    }

    
    public List<SiswaView> getListSiswabyName(String Nama) {
        ListSiswa = new ArrayList<SiswaView>();
        String query = "SELECT * FROM siswa WHERE nama_siswa = ? ORDER BY id";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query) ;
            stmt.setString(1, Nama);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                sswView = new SiswaView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                ListSiswa.add(sswView);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ListSiswa;

    }
    
    
    public List<SiswaView> getListSiswabyKelJur(String KelJur) {
        ListSiswa = new ArrayList<SiswaView>();
        String query = "SELECT * FROM siswa WHERE KelJur = ? ORDER BY id";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query) ;
            stmt.setString(1, KelJur);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                sswView = new SiswaView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                ListSiswa.add(sswView);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ListSiswa;

    }
    
    
    
    
}
