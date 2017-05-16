/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Dao.GurudanStaffDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.Entity.GurudanStaff;
import absensisekolah.TableModel.DataGuruTableModel;
import absensisekolah.Utility.DateUtility;
import absensisekolah.view.GurudanStaff.DataGurudanStaff;
import absensisekolah.view.GurudanStaff.GuruViewDetail;
import absensisekolah.view.MainFrame;

import java.util.Date;
import javax.swing.JOptionPane;

public class GuruStaffControler {

    MainFrame Mf;
    GuruViewDetail GvDetail;
    GurudanStaff GrSt;
    GurudanStaffDao GrStDao;
    DateUtility du;
    DataGurudanStaff DGView ;

    public GuruStaffControler(GuruViewDetail GvDetail, GurudanStaffDao GrStDao) {
        this.GvDetail = GvDetail;
        this.GrStDao = GrStDao;
        du = new DateUtility();
    }

    public GuruStaffControler(GurudanStaffDao GrStDao, DataGurudanStaff DGView) {
        this.GrStDao = GrStDao;
        this.DGView = DGView;
    }

    
    
    
//    public void saveUpdateAnggota() {
//        if(GvDetail.getNamaField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Nama Masih Kosong");
//        }else if (GvDetail.getNipField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "NIP Masih Kosong");
//        }else if(GvDetail.getNIGSField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "NIGS Masih Kosong");
//        }else if(GvDetail.getJbtn().getSelectedIndex() == 0){
//            JOptionPane.showMessageDialog(GvDetail, "Jabatan tidak Valid");
//        }else if(GvDetail.getPendField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Pendidikan Terakhir Masih Kosong");
//        }else if(GvDetail.getTempatLahirField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Tempat Lahir Masih Kosong");
//        }else if(GvDetail.getTanggalField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Tanggal Lahir Masih Kosong");
//        }else if(GvDetail.getJenKel().getSelectedIndex() == 0){
//            JOptionPane.showMessageDialog(GvDetail, "Jenis Kelamin Tidak Valid");
//        }else if(GvDetail.getAgamaField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Agama Masih Kosong");
//        }else if(GvDetail.getAlamatField().getText().equals("")){
//            JOptionPane.showMessageDialog(GvDetail, "Alamat Masih Kosong");
//        }else{
//            GrSt = createGrSt();
// //           Ssw.setId(Integer.valueOf(SvDetail.geTextId().getText()));
// //           if(AnggotaModel.updateAnggota(anggota)){
//                JOptionPane.showMessageDialog(GvDetail, "Update Data anggota sukses");
// //               findListAnggota();
//                GvDetail.dispose();
////            }else{
////                JOptionPane.showMessageDialog(Mf, "Update Data anggota gagal");
////            }
//        }
//    }
    public void saveNewGuruStaff() {
        if (GvDetail.getNamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Nama Masih Kosong");
        } else if (GvDetail.getNipField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "NIP Masih Kosong");
        } else if (GvDetail.getNIGSField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "NIGS Masih Kosong");
        } else if (GvDetail.getJbtn().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(GvDetail, "Jabatan tidak Valid");
        } else if (GvDetail.getPendField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Pendidikan Terakhir Masih Kosong");
        } else if (GvDetail.getTempatLahirField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Tempat Lahir Masih Kosong");
        } else if (GvDetail.getTanggalField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Tanggal Lahir Masih Kosong");
        } else if (GvDetail.getJenKel().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(GvDetail, "Jenis Kelamin Tidak Valid");
        } else if (GvDetail.getAgamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Agama Masih Kosong");
        } else if (GvDetail.getAlamatField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Alamat Masih Kosong");
        } else {
            GrSt = createGrSt() ;
            if (GrStDao.TambahGurudanStaff(GrSt)) {

                JOptionPane.showMessageDialog(GvDetail, "Tambah Data Guru/ Staff Sukses");
                GvDetail.dispose();
            } else {
                JOptionPane.showMessageDialog(GvDetail, "Tambah Data Guru/ Staff Gagal");
            }
        }
    }

     public void saveUpdateGuruStaff(int id) {
   
        if (GvDetail.getNamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Nama Masih Kosong");
        } else if (GvDetail.getNipField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "NIP Masih Kosong");
        } else if (GvDetail.getNIGSField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "NIGS Masih Kosong");
        } else if (GvDetail.getJbtn().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(GvDetail, "Jabatan tidak Valid");
        } else if (GvDetail.getPendField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Pendidikan Terakhir Masih Kosong");
        } else if (GvDetail.getTempatLahirField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Tempat Lahir Masih Kosong");
        } else if (GvDetail.getTanggalField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Tanggal Lahir Masih Kosong");
        } else if (GvDetail.getJenKel().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(GvDetail, "Jenis Kelamin Tidak Valid");
        } else if (GvDetail.getAgamaField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Agama Masih Kosong");
        } else if (GvDetail.getAlamatField().getText().equals("")) {
            JOptionPane.showMessageDialog(GvDetail, "Alamat Masih Kosong");
        } else {
            GrSt = createGrSt() ;
            GrSt.setId(Integer.valueOf(GvDetail.getId().getText()));
            if (GrStDao.updateGurudanStaff(GrSt)) {

                JOptionPane.showMessageDialog(GvDetail, "Update Data Guru/ Staff Sukses");
                GvDetail.dispose();
            } else {
                JOptionPane.showMessageDialog(GvDetail, "Update Data Guru/ Staff Gagal");
            }
        }
    }

    public GurudanStaff createGrSt() {
        GrSt = new GurudanStaff(0, GvDetail.getNipField().getText(), GvDetail.getNIGSField().getText(), GvDetail.getNamaField().getText(),
                GvDetail.getJbtn().getSelectedItem().toString(), GvDetail.getTempatLahirField().getText(), du.createDate(GvDetail.getTanggalField().getText()),
                GvDetail.getJenKel().getSelectedItem().toString(), GvDetail.getPendField().getText(), GvDetail.getAgamaField().getText(), GvDetail.getAlamatField().getText());

        return GrSt;
    }
    

    public void showDetail (int id)
    {
        GrSt = GrStDao.getGurudanStaff(id) ;
         GvDetail.getId().setText(""+id);
         GvDetail.getNipField().setText(GrSt.getNIP());
         GvDetail.getNIGSField().setText(GrSt.getNIGS());
         GvDetail.getNamaField().setText(GrSt.getNama()); 
         GvDetail.getJbtn().setSelectedIndex(getJBTNInt(GrSt.getJabatan()));       
         GvDetail.getTempatLahirField().setText(GrSt.getTmptLahir());
         GvDetail.getTanggalField().setText(GrSt.getTanggalLahir().toString()); ;
         GvDetail.getJenKel().setSelectedIndex(getJenKelInt(GrSt.getJenKel()));
         GvDetail.getPendField().setText(GrSt.getPendidikan());
         GvDetail.getAgamaField().setText(GrSt.getAgama());
         GvDetail.getAlamatField().setText(GrSt.getAlamat());
        
    
    }
    
    public void saveDeleteAnggota(int id) {
        if(JOptionPane.showConfirmDialog(GvDetail, "Apakah anda yakin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
                if(GrStDao.deleteAnggota(id)){
                    JOptionPane.showMessageDialog(GvDetail, "Delete data Guru/ Staff sukses");
//                    findListAnggota();
                }else{
                    JOptionPane.showMessageDialog(GvDetail, "Delete data Guru/ Staff gagal");
                }
        }
    }
    
    
    public void findList() {
        if (DGView.getByNmField().isEnabled()) {
            if (DGView.getByNmField().getText().equals("")) {
                refreshList () ;
                JOptionPane.showMessageDialog(DGView, "Tolong Masukan Nama Siswa Yang Akan Dicari");
            }
            else {
                    DGView.getTableDG().setModel(new DataGuruTableModel(GrStDao.getListGurudanStaffbyName(DGView.getByNmField().getText())));         
       
            }
        }

        if (DGView.getByJbtnField().isEnabled()) {
            if (DGView.getByJbtnField().getText().equals("")) {
                refreshList () ;
                JOptionPane.showMessageDialog(DGView, "Tolong Masukan Tanggal Yang Akan Dicari");
            }
            else {
                    DGView.getTableDG().setModel(new DataGuruTableModel(GrStDao.getListGurudanStaffbyJbtn(DGView.getByJbtnField().getText())));         
       
            }
        }

    }
    
    
    public void refreshList ()
    {
         DGView.getTableDG().setModel(new DataGuruTableModel(GrStDao.getListGurudanStaff()));         
       
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
    public int getJBTNInt (String Ket)
    {
        if (Ket.equalsIgnoreCase(JBTN.GURU.getKet()))
            return JBTN.GURU.getSt() ;
        else if (Ket.equalsIgnoreCase(JBTN.STAFF_TU.getKet()))
            return JBTN.STAFF_TU.getSt() ;
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
    
    public enum JBTN {

        GURU (1, "GURU"),
        STAFF_TU (2, "STAFF TU");
        
        private JBTN(int st, String Ket) {
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
