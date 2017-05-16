/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.controler;

import absensisekolah.Utility.DbUtility;
import absensisekolah.view.Report.JIntReport;
import java.awt.BorderLayout;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class reportControler {

    Connection con;
    JIntReport LaporanFrame;

    public reportControler() {
        con = new DbUtility().getConnection();
    }

    public reportControler(JIntReport LaporanFrame) {
        con = new DbUtility().getConnection();
        this.LaporanFrame = LaporanFrame;
    }

    public void Tampil() {
        if (LaporanFrame.getJenLap().getSelectedIndex() == 0) {
           JOptionPane.showMessageDialog(LaporanFrame, "Tidak Ada Jenis Laporan Yang Dipilih");
        } else if (LaporanFrame.getJenLap().getSelectedIndex() == 1) {
            int Bln = LaporanFrame.getBulan().getMonth() ;
//            System.out.println("Bulan : " + LaporanFrame.getBulan().getMonth());
            LaporanAbsensiGurudanStaff();
        } else if (LaporanFrame.getJenLap().getSelectedIndex() == 2) {
//            System.out.println("Bulan : " + LaporanFrame.getBulan().getMonth());
           LaporanAbsensiKelas();
        } else if (LaporanFrame.getJenLap().getSelectedIndex() == 3) {
//            System.out.println("Bulan : " + LaporanFrame.getBulan().getMonth());
            LaporanBulanan();
        }

    }

    public void LaporanBulanan() {

        File namaFile = new File("/report/LaporanBulanan.jasper");
        JasperReport jasper;
        JasperDesign JasDes;
        JasperPrint jp;
        InputStream stream = getClass().getResourceAsStream("./report/LaporanBulanan.jasper");
        Map <String, Object> map = new HashMap<String, Object>() ;
        map.put("intBulanMP", LaporanFrame.getBulan().getMonth()+1) ;
        
        try {

            JasDes = JRXmlLoader.load("./src/report/LaporanBulanan.jrxml");
            jasper = JasperCompileManager.compileReport(JasDes);

//            try {
//	JasperCompileManager.compileReportToFile("/report/LaporanBulanan.jrxm",
//	"/report/LaporanBulanan.jasper");
//        } catch (JRException e1) {
//            	e1.printStackTrace();
//    }
            jp = JasperFillManager.fillReport(jasper, map, con);
            //     JasperViewer.viewReport(jp, false);

            JRViewer JRV = new JRViewer(jp);

            LaporanFrame.getMainPane().removeAll();
            LaporanFrame.getMainPane().add(JRV, BorderLayout.CENTER);
            LaporanFrame.getMainPane().updateUI();

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(LaporanFrame, ex.getMessage());
        }

    }

    public void LaporanAbsensiKelas() {

        File namaFile = new File("/report/LaporanAbsensiKelas2.jasper");
        JasperReport jasper;
        JasperDesign JasDes;
        JasperPrint jp;
        InputStream stream = getClass().getResourceAsStream("./report/LaporanAbsensiKelas2.jasper");
        Map <String, Object> map = new HashMap<String, Object>() ;
        map.put("KelJur", LaporanFrame.getKelJur().getText().toString()) ;
        map.put("intBln", LaporanFrame.getBulan().getMonth()+1) ;
                
                
        try {

            JasDes = JRXmlLoader.load("./src/report/LaporanAbsensiKelas2.jrxml");
            jasper = JasperCompileManager.compileReport(JasDes);

//            try {
//	JasperCompileManager.compileReportToFile("/report/LaporanBulanan.jrxm",
//	"/report/LaporanBulanan.jasper");
//        } catch (JRException e1) {
//            	e1.printStackTrace();
//    }
            jp = JasperFillManager.fillReport(jasper, map, con);
            //     JasperViewer.viewReport(jp, false);

            JRViewer JRV = new JRViewer(jp);

            LaporanFrame.getMainPane().removeAll();
            LaporanFrame.getMainPane().add(JRV, BorderLayout.CENTER);
            LaporanFrame.getMainPane().updateUI();

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(LaporanFrame, ex.getMessage());
        }

    }

    public void LaporanAbsensiGurudanStaff() {

        File namaFile = new File("/report/LaporanAbsensiGuruStaff.jasper");
        JasperReport jasper;
        JasperDesign JasDes;
        JasperPrint jp;
        InputStream stream = getClass().getResourceAsStream("./report/LaporanAbsensiGuruStaff.jasper");
         Map <String, Object> map = new HashMap<String, Object>() ;
         map.put("IntBulan", LaporanFrame.getBulan().getMonth()+1) ;
        
        try {

            JasDes = JRXmlLoader.load("./src/report/LaporanAbsensiGuruStaff.jrxml");
            jasper = JasperCompileManager.compileReport(JasDes);

//            try {
//	JasperCompileManager.compileReportToFile("/report/LaporanBulanan.jrxm",
//	"/report/LaporanBulanan.jasper");
//        } catch (JRException e1) {
//            	e1.printStackTrace();
//    }
            jp = JasperFillManager.fillReport(jasper, map, con);
            //     JasperViewer.viewReport(jp, false);

            JRViewer JRV = new JRViewer(jp);

            LaporanFrame.getMainPane().removeAll();
            LaporanFrame.getMainPane().add(JRV, BorderLayout.CENTER);
            LaporanFrame.getMainPane().updateUI();

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(LaporanFrame, ex.getMessage());
        }

    }

}
