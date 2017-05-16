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
import absensisekolah.TableModel.AbsensiGurudanStaffTableModel;
import absensisekolah.TableModel.AbsensiSiswaTableModel;
import absensisekolah.view.AbsensiFrame;
import absensisekolah.view.GurudanStaff.AbsensiStaff;
import absensisekolah.view.GurudanStaff.DataGurudanStaff;
import absensisekolah.view.GurudanStaff.GuruViewDetail;
import absensisekolah.view.MainFrame;
import absensisekolah.view.Siswa.AbsensiSiswa;
import javax.swing.JOptionPane;

public class AbsensiControler {

    AbsensiSiswa AbsSswView;
    AbsensiStaff AbsGrStView;
    AbsensiFrame AbsFrame;
    AbsensiSiswaTableModel AbsSswTM;
    AbsensiGurudanStaffTableModel AbsGrStTM;
    AbsensiSiswaDao AbsSswDao;
    AbsensiGurudanStaffDao AbsGrStDao;
    SiswaDao SswDao;
    MainFrame Mf;
    GuruViewDetail detailGuruView;
    DataGurudanStaff DGMView;
    GurudanStaffDao DGMDao;

    public AbsensiControler(AbsensiFrame AbsFrame, SiswaDao SswDao, AbsensiSiswa AbsSswView) {
        this.AbsFrame = AbsFrame;
        this.SswDao = SswDao;
        this.AbsSswView = AbsSswView;

    }

    public AbsensiControler(AbsensiSiswa AbsSswView, AbsensiStaff AbsGrStView) {
        this.AbsSswView = AbsSswView;
        this.AbsGrStView = AbsGrStView;
    }

    public AbsensiControler(AbsensiFrame AbsFrame, AbsensiSiswaDao AbsSswDao, AbsensiGurudanStaffDao AbsGrStDao) {
        this.AbsFrame = AbsFrame;
        this.AbsSswDao = AbsSswDao;
        this.AbsGrStDao = AbsGrStDao;
    }

    public void setAbsSswView(AbsensiSiswa AbsSswView) {
        this.AbsSswView = AbsSswView;
    }

    public void setAbsGrStView(AbsensiStaff AbsGrStView) {
        this.AbsGrStView = AbsGrStView;
    }

    public void TambahAbsenSiswa(SiswaDao siswa) {
        if (AbsFrame.getAbsnSsw().isSelected() && AbsFrame.getTextBox().getText() != null) {
            if (siswa.isSiswaRegistered(AbsFrame.getTextBox().getText())) {
                if (AbsSswDao.isAlready(AbsFrame.getTextBox().getText()) == false) {
                    AbsSswDao.TambahAbsnSSw(siswa.getSsw(), AbsFrame);
                    findList();
                } else {
                    JOptionPane.showMessageDialog(AbsFrame, "Maaf, Siswa Yang Anda Masukan Sudah Absen Untuk Hari Ini ");
                }
            } else {
                JOptionPane.showMessageDialog(AbsFrame, "Maaf, Siswa Yang Anda Masukan Tidak Terdaftar");
            }
        }

    }

    public void TambahAbsenGuru(GurudanStaffDao GrStDao) {

        if (AbsFrame.getAbsnPgw().isSelected() && AbsFrame.getTextBox().getText() != null) {
            if (GrStDao.isGurudanStaffRegistered(AbsFrame.getTextBox().getText())) {

                if (AbsGrStDao.isAlready(AbsFrame.getTextBox().getText()) == false) {
                    AbsGrStDao.TambahAbsenGuru(GrStDao.getGrSt(), AbsFrame);
                    findList();
                } else {
                    JOptionPane.showMessageDialog(AbsFrame, "Maaf, Guru/ Staff Yang Anda Masukan Sudah Absen Untuk Hari Ini");

                }
            } else {
                JOptionPane.showMessageDialog(AbsFrame, "Maaf, Guru/ Staff Yang Anda Masukan Tidak Terdaftar");

            }
        }

    }

    public void findList() {
        AbsSswView.getTableSiswa().setModel(new AbsensiSiswaTableModel(new AbsensiSiswaDao().getListAbsSiswaTDY()));
        AbsGrStView.getTableStaff().setModel(new AbsensiGurudanStaffTableModel(new AbsensiGurudanStaffDao().getListAbsGurudanStaffTDY()));

    }

    public void viewDetailGrSt() {

    }

}
