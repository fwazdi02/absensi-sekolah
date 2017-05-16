/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.view.Report;

import absensisekolah.Utility.DbUtility;
import absensisekolah.controler.reportControler;
import absensisekolah.view.MainFrame;
import com.toedter.calendar.JMonthChooser;
import java.awt.BorderLayout;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class JIntReport extends javax.swing.JInternalFrame {

    MainFrame Mf;
    reportControler controler;
    private DbUtility dbu;

    public JIntReport(MainFrame Mf) {
        this.Mf = Mf;
        initComponents();
        setSize(Mf.getMainPane().getSize());
        dbu = new DbUtility();
        controler = new reportControler(this);
        KelJur.setEnabled(false);
        Bulan.setEnabled(false);
        Lht.setEnabled(false);
        
    }

    public JPanel getMainPane() {
        return MainPane;
    }

    public JMonthChooser getBulan() {
        return Bulan;
    }

    public JTextField getKelJur() {
        return KelJur;
    }

    public JComboBox getJenLap() {
        return JenLap;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JenLap = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        Lht = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Bulan = new com.toedter.calendar.JMonthChooser();
        jLabel3 = new javax.swing.JLabel();
        KelJur = new javax.swing.JTextField();

        MainPane.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Jenis Laporan");

        JenLap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Laporan--", "Absensi Guru/ Staff", "Absensi Siswa", "Laporan Bulanan" }));
        JenLap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JenLapItemStateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find by :", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        Lht.setText("Lihat");
        Lht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LhtActionPerformed(evt);
            }
        });

        jLabel2.setText("Bulan");

        Bulan.setMonth(1);

        jLabel3.setText("Kelas/ Jurusan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KelJur, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Lht, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(KelJur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Lht, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JenLap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JenLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LhtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LhtActionPerformed

        controler.Tampil();

//        dbu = new DbUtility() ;
//         
//        File namaFile = new File("/report/LaporanBulanan.jasper");
//        JasperReport jasper;
//        JasperDesign JasDes;
//        JasperPrint jp;
//        InputStream stream = getClass().getResourceAsStream("./report/LaporanBulanan.jasper");
//
//     
//    try {
//        
//            JasDes = JRXmlLoader.load("./src/report/LaporanBulanan.jrxml");
//            jasper = JasperCompileManager.compileReport(JasDes) ;
//            
////            try {
////	JasperCompileManager.compileReportToFile("/report/LaporanBulanan.jrxm",
////	"/report/LaporanBulanan.jasper");
////        } catch (JRException e1) {
////            	e1.printStackTrace();
////    }
// 
//            jp = JasperFillManager.fillReport(jasper, null, dbu.getConnection());
//       //     JasperViewer.viewReport(jp, false);
//            
//            JRViewer JRV = new JRViewer(jp) ;
//            
//         
//            MainPane.removeAll();
//            MainPane.add(JRV, BorderLayout.CENTER) ;
//            MainPane.updateUI();
//            
//    } catch (Exception ex) {
//            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
//        }

    }//GEN-LAST:event_LhtActionPerformed

    private void JenLapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JenLapItemStateChanged

        if (JenLap.getSelectedIndex() == 0) {
            KelJur.setEnabled(false);
            Bulan.setEnabled(false);
            Lht.setEnabled(false);

        } else if (JenLap.getSelectedIndex() == 1) {
            KelJur.setEnabled(false);
            Bulan.setEnabled(true);
            Lht.setEnabled(true);
        } else if (JenLap.getSelectedIndex() == 2) {
            KelJur.setEnabled(true);
            Bulan.setEnabled(true);
            Lht.setEnabled(true);
        } else if (JenLap.getSelectedIndex() == 3) {
            KelJur.setEnabled(false);
            Bulan.setEnabled(true);
            Lht.setEnabled(true);
        }


    }//GEN-LAST:event_JenLapItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser Bulan;
    private javax.swing.JComboBox JenLap;
    private javax.swing.JTextField KelJur;
    private javax.swing.JButton Lht;
    private javax.swing.JPanel MainPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}