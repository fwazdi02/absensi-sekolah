/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.view;

import absensisekolah.Dao.AbsensiGurudanStaffDao;
import absensisekolah.Dao.AbsensiSiswaDao;
import absensisekolah.Dao.GurudanStaffDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.Entity.AbsensiGurudanStaffView;
import absensisekolah.TableModel.DAGTableModel;
import absensisekolah.TableModel.DASTableModel;
import absensisekolah.TableModel.DataGuruTableModel;
import absensisekolah.TableModel.DataSiswaTableModel;
import absensisekolah.Utility.DbUtility;
import absensisekolah.controler.AbsensiGuruStaffControler;
import absensisekolah.controler.AbsensiSiswaControler;
import absensisekolah.controler.GuruStaffControler;
import absensisekolah.controler.SiswaControler;
import absensisekolah.view.GurudanStaff.AbsnsiGuruStaffViewDetail;
import absensisekolah.view.GurudanStaff.DataAbsensiGurudanStaff;
import absensisekolah.view.GurudanStaff.DataGurudanStaff;
import absensisekolah.view.GurudanStaff.GuruViewDetail;
import absensisekolah.view.Report.JIntReport;
import absensisekolah.view.Siswa.AbsnsiSiswaViewDetail;
import absensisekolah.view.Siswa.DataAbsensiSiswa;
import absensisekolah.view.Siswa.DataSiswa;
import absensisekolah.view.Siswa.SiswaViewDetail;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xdyingx
 */
public class MainFrame extends javax.swing.JFrame {

    private Toolkit tk;
    private Dimension Dim;
    DataAbsensiGurudanStaff DAGFrame;
    DataAbsensiSiswa DASFrame;
    DataSiswa DataSiswaFrame;
    DataGurudanStaff DataGrStFrame;
    SiswaViewDetail SVD;
    GuruViewDetail GVD;
    AbsnsiSiswaViewDetail ASVD;
    AbsnsiGuruStaffViewDetail AGVD;
    boolean Mdf;
    GuruStaffControler GrstCon;
    SiswaControler SswCon;
    AbsensiGuruStaffControler AGrstCon;
    AbsensiSiswaControler ASswCon;
    AbsensiFrame AbsFrame;
    DbUtility dbu ;
    JIntReport Ji ;

    public MainFrame() {

        tk = Toolkit.getDefaultToolkit();
        Dim = tk.getScreenSize();
        initComponents();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int taskBarHeight = Dim.height - winSize.height;
        setSize(Dim.width, Dim.height - taskBarHeight);
        setIconImage(new ImageIcon (getClass().getResource("/absensisekolah/Img/Planner64.png")).getImage());
        //setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)) ;

    }

  
    public boolean isMdf() {
        return Mdf;
    }

    public void setMdf(boolean Mdf) {
        this.Mdf = Mdf;
    }

    public JDesktopPane getMainPane() {
        return MainPane;
    }

    public JButton getDelete() {
        return Delete;
    }

    public JButton getModify() {
        return Modify;
    }

    public JButton getAddNew() {
        return addNew;
    }

    public JInternalFrame getOpenFrm() {
        JInternalFrame[] AllFrm = MainPane.getAllFrames();
        if (AllFrm.length != 0) {
            return AllFrm[AllFrm.length - 1];
        } else {
            return null;
        }
    }

    public void setEnableButton() {
        addNew.setEnabled(true);
        Delete.setEnabled(true);
        Modify.setEnabled(true);
    }

    public void setDisableButton() {
        addNew.setEnabled(false);
        Delete.setEnabled(false);
        Modify.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        DAG = new javax.swing.JButton();
        DAS = new javax.swing.JButton();
        DataGuru = new javax.swing.JButton();
        DataSiswa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        addNew = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        LihatLaporan = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        MainPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Utama - Absensi Sekolah v.0.1");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        DAG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/outline24x24.png"))); // NOI18N
        DAG.setText("Absensi Guru/ Staff");
        DAG.setToolTipText("Data Absensi Guru/ Staff");
        DAG.setFocusable(false);
        DAG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DAGActionPerformed(evt);
            }
        });
        jToolBar1.add(DAG);

        DAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/outline24x24.png"))); // NOI18N
        DAS.setText("Absensi Siswa");
        DAS.setToolTipText("Data Absensi Siswa");
        DAS.setFocusable(false);
        DAS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DASActionPerformed(evt);
            }
        });
        jToolBar1.add(DAS);

        DataGuru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/businessman.png"))); // NOI18N
        DataGuru.setText("Guru/ Staff");
        DataGuru.setToolTipText("Data Guru/ Staff");
        DataGuru.setFocusable(false);
        DataGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataGuruActionPerformed(evt);
            }
        });
        jToolBar1.add(DataGuru);

        DataSiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/user24x24.png"))); // NOI18N
        DataSiswa.setText("Siswa");
        DataSiswa.setToolTipText("Data Siswa");
        DataSiswa.setFocusable(false);
        DataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataSiswaActionPerformed(evt);
            }
        });
        jToolBar1.add(DataSiswa);
        jToolBar1.add(jSeparator1);

        addNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/add24x24.png"))); // NOI18N
        addNew.setToolTipText("Tambah Data Baru");
        addNew.setFocusable(false);
        addNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });
        jToolBar1.add(addNew);

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/plus_minus_1.png"))); // NOI18N
        Delete.setToolTipText("Hapus Data");
        Delete.setFocusable(false);
        Delete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(Delete);

        Modify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/edit24x24.png"))); // NOI18N
        Modify.setToolTipText("Edit Data");
        Modify.setFocusable(false);
        Modify.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });
        jToolBar1.add(Modify);
        jToolBar1.add(jSeparator2);

        LihatLaporan.setText("Lihat Laporan");
        LihatLaporan.setFocusable(false);
        LihatLaporan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LihatLaporan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LihatLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatLaporanActionPerformed(evt);
            }
        });
        jToolBar1.add(LihatLaporan);
        jToolBar1.add(jSeparator3);

        jButton8.setText("Sign out");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        MainPane.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout MainPaneLayout = new javax.swing.GroupLayout(MainPane);
        MainPane.setLayout(MainPaneLayout);
        MainPaneLayout.setHorizontalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        MainPaneLayout.setVerticalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
            .addComponent(MainPane)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DAGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DAGActionPerformed
        DAGFrame = new DataAbsensiGurudanStaff(this);
        DAGFrame.getTableDAG().setModel(new DAGTableModel(new AbsensiGurudanStaffDao().getListAbsGurudanStaffM()));
        MainPane.removeAll();
        MainPane.add(DAGFrame);
    }//GEN-LAST:event_DAGActionPerformed

    private void DASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DASActionPerformed
        DASFrame = new DataAbsensiSiswa(this);
        DASFrame.getTableDAS().setModel(new DASTableModel(new AbsensiSiswaDao().getListAbsSiswaM()));
        MainPane.removeAll();
        MainPane.add(DASFrame);
    }//GEN-LAST:event_DASActionPerformed

    private void DataGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataGuruActionPerformed
        DataGrStFrame = new DataGurudanStaff(this);
        DataGrStFrame.getTableDG().setModel(new DataGuruTableModel(new GurudanStaffDao().getListGurudanStaff()));
        MainPane.removeAll();
        MainPane.add(DataGrStFrame);
    }//GEN-LAST:event_DataGuruActionPerformed

    private void DataSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataSiswaActionPerformed
        DataSiswaFrame = new DataSiswa(this);
        DataSiswaFrame.getTableDS().setModel(new DataSiswaTableModel(new SiswaDao().getListSiswa()));
        MainPane.removeAll();
        MainPane.add(DataSiswaFrame);
    }//GEN-LAST:event_DataSiswaActionPerformed

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed

        if (getOpenFrm() != null && getOpenFrm().equals(DAGFrame)) {

            AGVD = new AbsnsiGuruStaffViewDetail(this, true, DAGFrame);
            AGVD.setVisible(true);
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DASFrame)) {
            ASVD = new AbsnsiSiswaViewDetail(this, true, DASFrame);
            ASVD.setVisible(true);

        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataSiswaFrame)) {
            SVD = new SiswaViewDetail(this, true, DataSiswaFrame);
            SVD.setVisible(true);
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataGrStFrame)) {
            GVD = new GuruViewDetail(this, true, DataGrStFrame);
            GVD.setVisible(true);
        }

    }//GEN-LAST:event_addNewActionPerformed

    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed

        Mdf = true;
        if (getOpenFrm() != null && getOpenFrm().equals(DAGFrame)) {

            AGVD = new AbsnsiGuruStaffViewDetail(this, true, DAGFrame);
        
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DASFrame)) {
            ASVD = new AbsnsiSiswaViewDetail(this, true, DASFrame);
           
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataSiswaFrame)) {
            SVD = new SiswaViewDetail(this, true, DataSiswaFrame);
          
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataGrStFrame)) {
            GVD = new GuruViewDetail(this, true, DataGrStFrame);
        }

    }//GEN-LAST:event_ModifyActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        if (getOpenFrm() != null && getOpenFrm().equals(DAGFrame)) {

            if (DAGFrame.getIdGrSt() != 0) {
                AGrstCon = new AbsensiGuruStaffControler(AGVD, new AbsensiGurudanStaffDao());
                AGrstCon.saveDeleteAnggota(DAGFrame.getIdGrSt());
            }

        }
        if (getOpenFrm() != null && getOpenFrm().equals(DASFrame)) {

            if (DASFrame.getIdSiswa() != 0) {
                ASswCon = new AbsensiSiswaControler(ASVD, new AbsensiSiswaDao());
                ASswCon.saveDeleteAnggota(DASFrame.getIdSiswa());
            }
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataSiswaFrame)) {
            if (DataSiswaFrame.getIdSiswa() != 0) {
                SswCon = new SiswaControler(SVD, new SiswaDao());
                SswCon.saveDeleteAnggota(DataSiswaFrame.getIdSiswa());
            }
        }
        if (getOpenFrm() != null && getOpenFrm().equals(DataGrStFrame)) {
            if (DataGrStFrame.getIdGrSt() != 0) {
                GrstCon = new GuruStaffControler(GVD, new GurudanStaffDao());
                GrstCon.saveDeleteAnggota(DataGrStFrame.getIdGrSt());

            }
        }

    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
        AbsFrame = new AbsensiFrame();
        AbsFrame.setVisible(true);
     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void LihatLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatLaporanActionPerformed
    
         Ji = new JIntReport(this) ;
         Ji.setVisible(true);
        MainPane.removeAll();
        MainPane.add(Ji) ;

    }//GEN-LAST:event_LihatLaporanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DAG;
    private javax.swing.JButton DAS;
    private javax.swing.JButton DataGuru;
    private javax.swing.JButton DataSiswa;
    private javax.swing.JButton Delete;
    private javax.swing.JButton LihatLaporan;
    private javax.swing.JDesktopPane MainPane;
    private javax.swing.JButton Modify;
    private javax.swing.JButton addNew;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
