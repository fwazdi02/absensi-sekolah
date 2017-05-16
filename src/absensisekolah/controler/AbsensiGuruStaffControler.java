/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Dao.AbsensiGurudanStaffDao;
import absensisekolah.Dao.AbsensiSiswaDao;
import absensisekolah.Dao.GurudanStaffDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.Entity.AbsensiGurudanStaff;
import absensisekolah.Entity.AbsensiSiswa;
import absensisekolah.TableModel.DAGTableModel;
import absensisekolah.Utility.DateUtility;
import absensisekolah.view.GurudanStaff.AbsensiStaff;
import absensisekolah.view.GurudanStaff.AbsnsiGuruStaffViewDetail;
import absensisekolah.view.GurudanStaff.DataAbsensiGurudanStaff;
import absensisekolah.view.MainFrame;
import absensisekolah.view.Siswa.AbsnsiSiswaViewDetail;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Conite
 */
public class AbsensiGuruStaffControler {

    AbsensiGurudanStaff AbsGrSt;
    AbsensiGurudanStaffDao AbsGrStDao;
    MainFrame Mf;
    AbsnsiGuruStaffViewDetail AGVD;
    DateUtility du;
    DataAbsensiGurudanStaff DAGView ;
    GurudanStaffDao GrSt ;

    public AbsensiGuruStaffControler(AbsnsiGuruStaffViewDetail AGVD, AbsensiGurudanStaffDao AbsGrStDao) {
        this.AGVD = AGVD;
        this.AbsGrStDao = AbsGrStDao;
        du = new DateUtility();
        GrSt = new GurudanStaffDao() ;
        
    }

    public AbsensiGuruStaffControler(AbsensiGurudanStaffDao AbsGrStDao, DataAbsensiGurudanStaff DAGView) {
        this.AbsGrStDao = AbsGrStDao;
        this.DAGView = DAGView;
        du = new DateUtility();
        GrSt = new GurudanStaffDao() ;
    }

    
    
    public void saveNewAbsStaff() {
        if (AGVD.getNamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Nama Masih Kosong");
        } else if (AGVD.getNIGSField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "NISS Masih Kosong");
        } else if (AGVD.getJbtnField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Kelas/ Jurusan Masih Kosong");
        } else if (AGVD.getKet().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(AGVD, "Keterangan tidak valid");
        } else if (AGVD.getTanggal().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Tanggal Lahir Masih Kosong");
        } else {

            AbsGrSt = createGrSt();
          if(GrSt.isGurudanStaffRegistered(AbsGrSt.getNIGS()))
          {
            if (AbsGrStDao.TambahAbsnGrStMF(AbsGrSt)) {
                JOptionPane.showMessageDialog(AGVD, "Tambah Data Absen Guru/ Staff sukses");
                AGVD.dispose();
                refreshList();
            } else {
                JOptionPane.showMessageDialog(AGVD, "Tambah Data Absen Guru/ Staff gagal");
            }
          }
          else {
                  JOptionPane.showMessageDialog(AGVD, "Maaf, Guru/ Staff Yang Anda Masukan Belum Terdaftar");
            
          }
        }

    }

    public void saveUpdateAbsGrSt() {
        if (AGVD.getNamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Nama Masih Kosong");
        } else if (AGVD.getNIGSField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "NISS Masih Kosong");
        } else if (AGVD.getJbtnField().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Kelas/ Jurusan Masih Kosong");
        } else if (AGVD.getKet().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(AGVD, "Keterangan tidak valid");
        } else if (AGVD.getTanggal().getText().equals("")) {
            JOptionPane.showMessageDialog(AGVD, "Tanggal Lahir Masih Kosong");
        } else {

            AbsGrSt = createGrSt();
            AbsGrSt.setId(Integer.valueOf(AGVD.getId().getText()));
            if (AbsGrStDao.updateAbsensiGrSt(AbsGrSt)) {
                JOptionPane.showMessageDialog(AGVD, "Update Data Absen Guru/ Staff sukses");
                AGVD.dispose();
                refreshList();
            } else {
                JOptionPane.showMessageDialog(AGVD, "Update Data Absen Guru/ Staff gagal");
            }

        }

    }

    public void saveDeleteAnggota(int id) {

        if (JOptionPane.showConfirmDialog(AGVD, "Apakah anda yakin menghapus data ini?", "Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            if (AbsGrStDao.deleteAbsensiGrSt(id)) {
                JOptionPane.showMessageDialog(AGVD, "Delete Data Absen Guru/ Staff sukses");
//                    findListAnggota();
            } else {
                JOptionPane.showMessageDialog(AGVD, "Delete Data Absen Guru/ Staff  gagal");
            }
        }
    }

    public AbsensiGurudanStaff createGrSt() {

        AbsGrSt = new AbsensiGurudanStaff(0, AGVD.getNIGSField().getText(),
                AGVD.getNamaField().getText(), AGVD.getJbtnField().getText(),
                AGVD.getKet().getSelectedItem().toString(),
                du.createDate(AGVD.getTanggal().getText()));

        return AbsGrSt;

    }

    public void showDetail(int id) {

        AbsGrSt = AbsGrStDao.getAbsnGrSt(id);
        AGVD.getId().setText("" + id);
        AGVD.getNIGSField().setText(AbsGrSt.getNIGS());
        AGVD.getNamaField().setText(AbsGrSt.getNama());
        AGVD.getJbtnField().setText(AbsGrSt.getJabatan());
        AGVD.getKet().setSelectedIndex(getKetInt(AbsGrSt.getKet()));
        AGVD.getTanggal().setText(AbsGrSt.getTanggal().toString());

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

    
     public void findList() {
        if (DAGView.getByNmField().isEnabled()) {
            if (DAGView.getByNmField().getText().equals("")) {
                refreshList ();
                JOptionPane.showMessageDialog(DAGView, "Tolong Masukan Nama Siswa Yang Akan Dicari");
            }
            else {
                    DAGView.getTableDAG().setModel(new DAGTableModel(AbsGrStDao.getListAbsGurudanStaffbyName(DAGView.getByNmField().getText())));         
       
            }
        }

        if (DAGView.getBydtField().isEnabled()) {
            if (DAGView.getBydtField().getText().equals("")) {
                refreshList () ;
                JOptionPane.showMessageDialog(DAGView, "Tolong Masukan Tanggal Yang Akan Dicari");
            }
            else {
                    DAGView.getTableDAG().setModel(new DAGTableModel(AbsGrStDao.getListAbsGurudanStaffbyDate(DAGView.getBydtField().getText().toString())));         
       
            }
        }

    }
    
     
     public void refreshList ()
     {
        DAGView.getTableDAG().setModel(new DAGTableModel(AbsGrStDao.getListAbsGurudanStaffM()));         
       
     }
             
    
}
