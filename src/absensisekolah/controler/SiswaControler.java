/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Dao.SiswaDao;
import absensisekolah.Entity.Siswa;
import absensisekolah.TableModel.DataSiswaTableModel;
import absensisekolah.Utility.DateUtility;
import absensisekolah.view.Siswa.DataSiswa;
import absensisekolah.view.Siswa.SiswaViewDetail;

import java.util.Date;
import javax.swing.JOptionPane;

public class SiswaControler {

    SiswaDao SswDao;
    SiswaViewDetail SvDetail;
    Siswa Ssw;
    DateUtility du;
    DataSiswa DSView ;

    public SiswaControler(SiswaViewDetail SvDetail, SiswaDao SswDao) {
        this.SswDao = SswDao;
        this.SvDetail = SvDetail;
        du = new DateUtility();
    }

    public SiswaControler(SiswaDao SswDao, DataSiswa DSView) {
        this.SswDao = SswDao;
        this.DSView = DSView;
    }

    
    
//    public void saveUpdateAnggota() {
//        if (SvDetail.getNamax().getText().toString().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Nama Masih Kosong");
//        } else if (SvDetail.getNISNField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "NISN Masih Kosong");
//        } else if (SvDetail.getNISSField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "NISS Masih Kosong");
//        } else if (SvDetail.getKelJurField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Kelas/ Jurusan Masih Kosong");
//        } else if (SvDetail.getTempatLahirField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Tempat Lahir tidak valid");
//        } else if (SvDetail.getTanggalField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Tanggal Lahir Masih Kosong");
//        } else if (SvDetail.getJenKel().getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(SvDetail, "Jenis Kelamin Kosong");
//        } else if (SvDetail.getAsal_Sekolah().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Asal Sekolah Masih Kosong");
//        } else if (SvDetail.getAgamaField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Agama Masih Kosong");
//        } else if (SvDetail.getAlamatField().getText().equals("")) {
//            JOptionPane.showMessageDialog(SvDetail, "Alamat Masih Kosong");
//        } else {
//            Ssw = createSiswa();
// //           Ssw.setId(Integer.valueOf(SvDetail.geTextId().getText()));
//            //           if(AnggotaModel.updateAnggota(anggota)){
//            JOptionPane.showMessageDialog(SvDetail, "Update Data anggota sukses");
//            //               findListAnggota();
//            SvDetail.dispose();
////            }else{
////                JOptionPane.showMessageDialog(Mf, "Update Data anggota gagal");
////            }
//        }
//    }

    public void saveNewSiswa() {
        if(SvDetail.getNamaSiswa().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Nama Masih Kosong");
        } else if (SvDetail.getNISNField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "NISN Masih Kosong");
        } else if (SvDetail.getNISSField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "NISS Masih Kosong");
        } else if (SvDetail.getKelJurField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Kelas/ Jurusan Masih Kosong");
        } else if (SvDetail.getTempatLahirField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Tempat Lahir tidak valid");
        } else if (SvDetail.getTanggalField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Tanggal Lahir Masih Kosong");
        } else if (SvDetail.getJenKel().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(SvDetail, "Jenis Kelamin Tidak Valid");
        } else if (SvDetail.getAsal_Sekolah().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Asal Sekolah Masih Kosong");
        } else if (SvDetail.getAgamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Agama Masih Kosong");
        } else if (SvDetail.getAlamatField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Alamat Masih Kosong");
        } else {

            //           Ssw.setId(Integer.valueOf(SvDetail.geTextId().getText()));
            if (SswDao.TambahSSw(createSiswa())) {
                JOptionPane.showMessageDialog(SvDetail, "Tambah Data Siswa sukses");
                //               findListAnggota();
                SvDetail.dispose();
            } else {
                JOptionPane.showMessageDialog(SvDetail, "Tambah Data Siswa gagal");
            }
        }
    }

    
    public void saveUpdateSiswa(int id) {
        
        if(SvDetail.getNamaSiswa().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Nama Masih Kosong");
        } else if (SvDetail.getNISNField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "NISN Masih Kosong");
        } else if (SvDetail.getNISSField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "NISS Masih Kosong");
        } else if (SvDetail.getKelJurField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Kelas/ Jurusan Masih Kosong");
        } else if (SvDetail.getTempatLahirField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Tempat Lahir tidak valid");
        } else if (SvDetail.getTanggalField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Tanggal Lahir Masih Kosong");
        } else if (SvDetail.getJenKel().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(SvDetail, "Jenis Kelamin Tidak Valid");
        } else if (SvDetail.getAsal_Sekolah().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Asal Sekolah Masih Kosong");
        } else if (SvDetail.getAgamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Agama Masih Kosong");
        } else if (SvDetail.getAlamatField().getText().equals("")) {
            JOptionPane.showMessageDialog(SvDetail, "Alamat Masih Kosong");
        } else {

            Ssw = createSiswa() ;
            Ssw.setId(Integer.valueOf(SvDetail.getId().getText()));
            if (SswDao.updateSsw(Ssw)) {
                JOptionPane.showMessageDialog(SvDetail, "Update Data Siswa sukses");
                //               findListAnggota();
                SvDetail.dispose();
            } else {
                JOptionPane.showMessageDialog(SvDetail, "Update Data Siswa gagal");
            }
        }
    }

    
    
    public Siswa createSiswa() {

        Ssw = new Siswa(0, SvDetail.getNISNField().getText(), SvDetail.getNISSField().getText(),
                SvDetail.getNamaSiswa().getText(), SvDetail.getKelJurField().getText(),
                SvDetail.getTempatLahirField().getText(),
                du.createDate(SvDetail.getTanggalField().getText()),
                SvDetail.getJenKel().getSelectedItem().toString(),
                SvDetail.getAsal_Sekolah().getText(),
                SvDetail.getAgamaField().getText(), SvDetail.getAlamatField().getText());
        
        return Ssw;

    }

    public void findListSiswa() {

    }

    public void showDetail (int id)
    {
        
         Ssw = SswDao.getSswx(id) ;
         SvDetail.getId().setText(""+id);
         SvDetail.getNISNField().setText(Ssw.getNISN());
         SvDetail.getNISSField().setText(Ssw.getNISS());
         SvDetail.getNamaSiswa().setText(Ssw.getNama()); 
         SvDetail.getKelJurField().setText(Ssw.getKelJur());       
         SvDetail.getTempatLahirField().setText(Ssw.getTmptLahir());
         SvDetail.getTanggalField().setText(Ssw.getTanggalLahir().toString()); ;
         SvDetail.getJenKel().setSelectedIndex(getJenKelInt(Ssw.getJenKel()));
         SvDetail.getAsal_Sekolah().setText(Ssw.getAsalSekolah());
         SvDetail.getAgamaField().setText(Ssw.getAgama());
         SvDetail.getAlamatField().setText(Ssw.getAlamat());
        
    
    }
    
    public void saveDeleteAnggota(int id) {
        if(JOptionPane.showConfirmDialog(SvDetail, "Apakah anda yakin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
                if(SswDao.deleteAnggota(id)){
                    JOptionPane.showMessageDialog(SvDetail, "Delete data Siswa sukses");
//                    findListAnggota();
                }else{
                    JOptionPane.showMessageDialog(SvDetail, "Delete data Siswa gagal");
                }
        }
    }
    
    
    public void findList() {
        if (DSView.getByNmField().isEnabled()) {
            if (DSView.getByNmField().getText().equals("")) {
                refreshList () ;
                JOptionPane.showMessageDialog(DSView, "Tolong Masukan Nama Siswa Yang Akan Dicari");
            }
            else {
                    DSView.getTableDS().setModel(new DataSiswaTableModel(SswDao.getListSiswabyName(DSView.getByNmField().getText())));         
       
            }
        }

        if (DSView.getByKelJurField().isEnabled()) {
            if (DSView.getByKelJurField().getText().equals("")) {
                refreshList () ;
                JOptionPane.showMessageDialog(DSView, "Tolong Masukan Tanggal Yang Akan Dicari");
            }
            else {
                    DSView.getTableDS().setModel(new DataSiswaTableModel(SswDao.getListSiswabyKelJur(DSView.getByKelJurField().getText().toString())));         
       
            }
        }

    }
    
    
    public void refreshList ()
    {
         DSView.getTableDS().setModel(new DataSiswaTableModel(SswDao.getListSiswa()));         
       
    }
    
    
    public int getJenKelInt (String Ket)
    {
        if (Ket.equalsIgnoreCase(JenKel.LAKILAKI.getKet()))
            return JenKel.LAKILAKI.getSt() ;
        else if (Ket.equalsIgnoreCase(JenKel.PEREMPUAN.getKet()))
            return JenKel.PEREMPUAN.getSt() ;
        else 
           return 0 ;
        
    }
    
    
    public enum JenKel {

        LAKILAKI (1, "LAKI-LAKI"),
        PEREMPUAN (2, "PEREMPUAN");
        
        private JenKel(int st, String Ket) {
            this.Ket = Ket;
            this.st = st;
        }

        String Ket;
        int st;

        public String getKet() {
            return Ket;
        }

        public int getSt() {
            return st;
        }

    }

}
