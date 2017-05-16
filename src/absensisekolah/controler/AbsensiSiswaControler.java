/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Dao.AbsensiGurudanStaffDao;
import absensisekolah.Dao.AbsensiSiswaDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.Entity.AbsensiSiswa;
import absensisekolah.TableModel.DASTableModel;
import absensisekolah.Utility.DateUtility;
import absensisekolah.view.GurudanStaff.AbsensiStaff;
import absensisekolah.view.MainFrame;
import absensisekolah.view.Siswa.AbsnsiSiswaViewDetail;
import absensisekolah.view.Siswa.DataAbsensiSiswa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Conite
 */
public class AbsensiSiswaControler {

    DataAbsensiSiswa DASView;
    AbsensiStaff AbsGrSt;
    AbsensiSiswaDao AbsSswDao;
    AbsensiGurudanStaffDao AbsGrStDao;
    MainFrame Mf;
    AbsnsiSiswaViewDetail ASVD;
    DateUtility du;
    SiswaDao Siswa;
    AbsensiSiswa AbsSsw;
   
    public AbsensiSiswaControler(AbsnsiSiswaViewDetail ASVD, AbsensiSiswaDao AbsSswDao, DataAbsensiSiswa DASView) {
        this.ASVD = ASVD;
        this.AbsSswDao = AbsSswDao;
        this.DASView = DASView;
        du = new DateUtility();
        Siswa = new SiswaDao();
    }

    public AbsensiSiswaControler(AbsnsiSiswaViewDetail ASVD, AbsensiSiswaDao AbsSswDao) {
        this.ASVD = ASVD;
        this.AbsSswDao = AbsSswDao;
        du = new DateUtility();
        Siswa = new SiswaDao();
    }
    
    public AbsensiSiswaControler(DataAbsensiSiswa DASView, AbsensiSiswaDao AbsSswDao) {
        this.DASView = DASView;
        this.AbsSswDao = AbsSswDao;
        du = new DateUtility();
        Siswa = new SiswaDao();
    }

    public void setDASView(DataAbsensiSiswa DASView) {
        this.DASView = DASView;
    }

    
    
    public void saveNewAbsSiswa() {
        if (ASVD.getNamaSiswa().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Nama Masih Kosong");
        } else if (ASVD.getNISSField().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "NISS Masih Kosong");
        } else if (ASVD.getKelJurField().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Kelas/ Jurusan Masih Kosong");
        } else if (ASVD.getKet().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(ASVD, "Keterangan Belum DiPilih");
        } else if (ASVD.getTanggal().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Tanggal Lahir Masih Kosong");
        } else {

            AbsSsw = createSiswa();
            if (Siswa.isSiswaRegistered(AbsSsw.getNISS())) {
                if (AbsSswDao.TambahAbsnSSwMF(AbsSsw)) {
                    JOptionPane.showMessageDialog(ASVD, "Tambah Data Absen Siswa sukses");
                    refreshList();
                    ASVD.dispose();
                } else {
                    JOptionPane.showMessageDialog(ASVD, "Tambah Data Absen Siswa gagal");
                }
            }
            else {
             JOptionPane.showMessageDialog(ASVD, "Maaf, Siswa Yang Anda Masukan Belum Terdaftar");
                   
            }
        }

    }

    public void saveUpdateAbsSiswa() {
        if (ASVD.getNamaSiswa().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Nama Masih Kosong");
        } else if (ASVD.getNISSField().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "NISS Masih Kosong");
        } else if (ASVD.getKelJurField().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Kelas/ Jurusan Masih Kosong");
        } else if (ASVD.getKet().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(ASVD, "Keterangan tidak valid");
        } else if (ASVD.getTanggal().getText().equals("")) {
            JOptionPane.showMessageDialog(ASVD, "Tanggal Lahir Masih Kosong");
        } else {

            AbsSsw = createSiswa();
            AbsSsw.setId(Integer.valueOf(ASVD.getId().getText()));
            if (AbsSswDao.updateAbsensiSsw(AbsSsw)) {
                JOptionPane.showMessageDialog(ASVD, "Update Data Absen Siswa sukses");
                ASVD.dispose();
                refreshList();
            } else {
                JOptionPane.showMessageDialog(ASVD, "Update Data Absen Siswa gagal");
            }

        }

    }

    public void saveDeleteAnggota(int id) {
        if (JOptionPane.showConfirmDialog(ASVD, "Apakah anda yakin menghapus data ini?", "Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            if (AbsSswDao.deleteAbsensiSsw(id)) {
                JOptionPane.showMessageDialog(ASVD, "Delete data Absen Siswa sukses");
                refreshList();
            } else {
                JOptionPane.showMessageDialog(ASVD, "Delete data Absen Siswa gagal");
            }
        }
    }

    public AbsensiSiswa createSiswa() {

        AbsSsw = new AbsensiSiswa(0, ASVD.getNISSField().getText(),
                ASVD.getNamaSiswa().getText(), ASVD.getKelJurField().getText(),
                ASVD.getKet().getSelectedItem().toString(),
                du.createDate(ASVD.getTanggal().getText()));

        return AbsSsw;

    }

    public void showDetail(int id) {
        
        AbsSsw = AbsSswDao.getAbsnSsw(id);
        ASVD.getId().setText(""+AbsSsw.getId());
        ASVD.getNISSField().setText(AbsSsw.getNISS());
        ASVD.getNamaSiswa().setText(AbsSsw.getNama());
        ASVD.getKelJurField().setText(AbsSsw.getKelJur());
        ASVD.getKet().setSelectedIndex(getKetInt(AbsSsw.getKet()));
        ASVD.getTanggal().setText(AbsSsw.getTanggal().toString());
        
        
        
    }

    public void findList() {
        if (DASView.getByNmField().isEnabled()) {
            if (DASView.getByNmField().getText().equals("")) {
                refreshList();
                JOptionPane.showMessageDialog(DASView, "Tolong Masukan Nama Siswa Yang Akan Dicari");
            } else {
                DASView.getTableDAS().setModel(new DASTableModel(AbsSswDao.getListAbsSiswabyName(DASView.getByNmField().getText())));

            }
        }

        if (DASView.getBydtField().isEnabled()) {
            if (DASView.getBydtField().getText().equals("")) {
                refreshList();
                JOptionPane.showMessageDialog(DASView, "Tolong Masukan Tanggal Yang Akan Dicari");
            } else {
                DASView.getTableDAS().setModel(new DASTableModel(AbsSswDao.getListAbsSiswabyDate(DASView.getBydtField().getText().toString())));

            }
        }

    }

    public int getKetInt(String Ket) {
        if (Ket.equalsIgnoreCase("IZIN")) {
            return 1;
        } else if (Ket.equalsIgnoreCase("SAKIT")) {
            return 2;
        } else if (Ket.equalsIgnoreCase("ALFA")) {
            return 3;
        } else {
            return 0;
        }

    }

    public void refreshList() {
        DASView.getTableDAS().setModel(new DASTableModel(AbsSswDao.getListAbsSiswaM()));
    }

}
