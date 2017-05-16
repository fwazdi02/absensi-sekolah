/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Dao.AbsensiGurudanStaffDao;
import absensisekolah.Dao.AbsensiSiswaDao;
import absensisekolah.Dao.GurudanStaffDao;
import absensisekolah.Dao.PrediksiDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.TableModel.AbsensiGurudanStaffTableModel;
import absensisekolah.TableModel.AbsensiSiswaTableModel;
import absensisekolah.TableModel.PrediksiTableModel;
import absensisekolah.view.AbsensiFrame;
import absensisekolah.view.GurudanStaff.AbsensiStaff;
import absensisekolah.view.PrediksiView;
import absensisekolah.view.PrediksiViewNotVisible;
import absensisekolah.view.Siswa.AbsensiSiswa;
import javax.swing.JLabel;

public class PrediksiControler {

    AbsensiSiswa AbsSswView;
    AbsensiStaff AbsGrStView;
    AbsensiFrame AbsFrame;
    AbsensiSiswaTableModel AbsSswTM;
    AbsensiGurudanStaffTableModel AbsGrStTM;
    AbsensiSiswaDao AbsSswDao;
    AbsensiGurudanStaffDao AbsGrStDao;
    SiswaDao SswDao;
    GurudanStaffDao GrStDao;
    PrediksiView Pv;
    PrediksiViewNotVisible PvNt;
    PrediksiDao PDao;
    JLabel StsData;

    public PrediksiControler(AbsensiFrame AbsFrame) {
        this.AbsFrame = AbsFrame;
        PDao = new PrediksiDao();
       
    }

    public void TampilPreSiswa() {
        Pv = new PrediksiView(AbsFrame, true);
        PvNt = new PrediksiViewNotVisible(AbsFrame, true);

        if (AbsFrame.getAbsnSsw().isSelected()) {

            if (PDao.IsObjSiswaAvaliable(AbsFrame.getTextBox().getText())) {
                Pv.getTablePred().setModel(new PrediksiTableModel(PDao.getListPrediksiSiswa(AbsFrame.getTextBox().getText())));
                Pv.setVisible(true);
                AbsFrame.getEntr().setEnabled(true);
            } else {
                PvNt.setVisible(true);
//                AbsFrame.getEntr().setEnabled(false);
            }

        }

    }

    public void TampilPreGuru() {

        Pv = new PrediksiView(AbsFrame, true);
        PvNt = new PrediksiViewNotVisible(AbsFrame, true);

        if (AbsFrame.getAbsnPgw().isSelected()) {

            if (PDao.IsObjGrStAvaliable(AbsFrame.getTextBox().getText())) {
                Pv.getTablePred().setModel(new PrediksiTableModel(PDao.getListPrediksiGuru(AbsFrame.getTextBox().getText())));
                Pv.setVisible(true);
                AbsFrame.getEntr().setEnabled(true);
            } else {
//                AbsFrame.getEntr().setEnabled(false);
                PvNt.setVisible(true);
            }

        }

    }

}
