/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensisekolah.view;

import absensisekolah.Dao.AbsensiGurudanStaffDao;
import absensisekolah.Dao.AbsensiSiswaDao;
import absensisekolah.Dao.GurudanStaffDao;
import absensisekolah.Dao.PrediksiDao;
import absensisekolah.Dao.SiswaDao;
import absensisekolah.TableModel.AbsensiGurudanStaffTableModel;
import absensisekolah.TableModel.AbsensiSiswaTableModel;
import absensisekolah.TableModel.PrediksiTableModel;
import absensisekolah.Utility.jamdigital;
import absensisekolah.controler.AbsensiControler;
import absensisekolah.controler.PrediksiControler;
import absensisekolah.view.GurudanStaff.AbsensiStaff;
import absensisekolah.view.GurudanStaff.DataAbsensiGurudanStaff;
import absensisekolah.view.Siswa.AbsensiSiswa;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Conite
 */
public class AbsensiFrame extends javax.swing.JFrame {

    private Toolkit tk;
    private Dimension Dim;
    String StsAbs;
    SiswaDao SswDao;
    GurudanStaffDao GrStDao;
    AbsensiGurudanStaffDao AbsGrStDao;
    AbsensiSiswaDao AbsSswDao;
    AbsensiSiswa AbsnSiswaFrm;
    AbsensiStaff AbsnStaffFrm;
    MainFrame MainFrm;
    PrediksiView Pv;
    AbsensiControler controler;
    PrediksiControler PControler;
    jamdigital jd ;

    public AbsensiFrame() {

        tk = Toolkit.getDefaultToolkit();
        Dim = tk.getScreenSize();
        initComponents();
        setIconImage(new ImageIcon (getClass().getResource("/absensisekolah/Img/Planner64.png")).getImage());
        
        SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMMM yyyy");
        Date date = new Date();
        LabelTanggal.setText(df.format(date));
      
        AbsSswDao = new AbsensiSiswaDao();
        AbsGrStDao = new AbsensiGurudanStaffDao();
        SswDao = new SiswaDao();
        GrStDao = new GurudanStaffDao();
        AbsnStaffFrm = new AbsensiStaff(this);
        AbsnSiswaFrm = new AbsensiSiswa(this);
        controler = new AbsensiControler(this, AbsSswDao, AbsGrStDao) ;
        
        controler.setAbsSswView(AbsnSiswaFrm);
        controler.setAbsGrStView(AbsnStaffFrm);
            
           
           
        

        
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setExtendedState(MAXIMIZED_BOTH);
        int taskBarHeight = Dim.height - winSize.height;
        setSize(Dim.width, Dim.height - taskBarHeight);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
//        System.out.println("X : " + Dim.width + "Y : " + (Dim.height - taskBarHeight));

        StsAbsnIzin.setSelected(true);
        AbsnSsw.setSelected(true);
        DeskPane.add(AbsnSiswaFrm);
        PControler = new PrediksiControler(this);
        

    }

    public String getStsAbs() {
        return StsAbs;
    }

    public JDesktopPane getDeskPane() {
        return DeskPane;
    }

    public JCheckBoxMenuItem getATop() {
        return ATop;
    }

    public JToggleButton getAbsnPgw() {
        return AbsnPgw;
    }

    public JToggleButton getAbsnSsw() {
        return AbsnSsw;
    }

    public JRadioButton getStsAbsnAlfa() {
        return StsAbsnAlfa;
    }

    public JRadioButton getStsAbsnIzin() {
        return StsAbsnIzin;
    }

    public JRadioButton getStsAbsnSakit() {
        return StsAbsnSakit;
    }

    public JButton getEntr() {
        return Entr;
    }

    public void setEntr(JButton Entr) {
        this.Entr = Entr;
    }

    public JTextField getTextBox() {
        return TextBox;
    }

    public void setTextBox(JTextField TextBox) {
        this.TextBox = TextBox;
    }

    public JCheckBoxMenuItem getMyAlwaysOnTop() {
        return ATop;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpMenu = new javax.swing.JPopupMenu();
        ATop = new javax.swing.JCheckBoxMenuItem();
        LgnAdmin = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        Mnmz = new javax.swing.JButton();
        Clse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PrefButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LabelTanggal = new javax.swing.JLabel();
        LabelJam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        TextBox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        AbsnSsw = new javax.swing.JToggleButton();
        AbsnPgw = new javax.swing.JToggleButton();
        Entr = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        StsAbsnSakit = new javax.swing.JRadioButton();
        StsAbsnIzin = new javax.swing.JRadioButton();
        StsAbsnAlfa = new javax.swing.JRadioButton();
        DeskPane = new javax.swing.JDesktopPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        ATop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ATop.setText("Always On Top");
        ATop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATopActionPerformed(evt);
            }
        });
        PopUpMenu.add(ATop);

        LgnAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LgnAdmin.setText("Adminisrator");
        LgnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LgnAdminActionPerformed(evt);
            }
        });
        PopUpMenu.add(LgnAdmin);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        Mnmz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/MnMz24x9.png"))); // NOI18N
        Mnmz.setBorderPainted(false);
        Mnmz.setFocusable(false);
        Mnmz.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/MnMz24x9_d.png"))); // NOI18N
        Mnmz.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Mnmz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnmzActionPerformed(evt);
            }
        });

        Clse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/delete24x24.png"))); // NOI18N
        Clse.setBorderPainted(false);
        Clse.setFocusable(false);
        Clse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/delete24x24_d.png"))); // NOI18N
        Clse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/about.png"))); // NOI18N
        jLabel4.setText("SMK Agri Insani - Sistem Informasi Management Absensi v.1.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Mnmz, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Clse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mnmz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Clse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PrefButton.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        PrefButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/services.png"))); // NOI18N
        PrefButton.setText("Preference");
        PrefButton.setBorderPainted(false);
        PrefButton.setContentAreaFilled(false);
        PrefButton.setFocusPainted(false);
        PrefButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/servicesRollOver.png"))); // NOI18N
        PrefButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/servicesRollOver.png"))); // NOI18N
        PrefButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrefButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrefButtonMouseExited(evt);
            }
        });
        PrefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrefButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PrefButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(PrefButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        LabelTanggal.setFont(new java.awt.Font("Century Gothic", 1, 32)); // NOI18N
        LabelTanggal.setText("12, November 1999");

        LabelJam.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        LabelJam.setText("24 : 59 : 59");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/planner_1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/absensisekolah/Img/clock_1.png"))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Nama Atau Nomor Induk", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        TextBox.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TextBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TextBoxFocusLost(evt);
            }
        });
        TextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextBoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(TextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(TextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        AbsnSsw.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        AbsnSsw.setText("Siswa");
        AbsnSsw.setFocusPainted(false);
        AbsnSsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbsnSswActionPerformed(evt);
            }
        });

        AbsnPgw.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        AbsnPgw.setText("Staff/ Guru");
        AbsnPgw.setFocusPainted(false);
        AbsnPgw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbsnPgwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AbsnPgw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AbsnSsw, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AbsnSsw)
                    .addComponent(AbsnPgw))
                .addContainerGap())
        );

        Entr.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        Entr.setText("Masukan");
        Entr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrActionPerformed(evt);
            }
        });

        StsAbsnSakit.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        StsAbsnSakit.setText("Sakit");
        StsAbsnSakit.setFocusPainted(false);
        StsAbsnSakit.setFocusable(false);
        StsAbsnSakit.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StsAbsnSakitStateChanged(evt);
            }
        });

        StsAbsnIzin.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        StsAbsnIzin.setText("Izin");
        StsAbsnIzin.setFocusPainted(false);
        StsAbsnIzin.setFocusable(false);
        StsAbsnIzin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StsAbsnIzinStateChanged(evt);
            }
        });

        StsAbsnAlfa.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        StsAbsnAlfa.setText("Alfa");
        StsAbsnAlfa.setFocusPainted(false);
        StsAbsnAlfa.setFocusable(false);
        StsAbsnAlfa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StsAbsnAlfaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(StsAbsnIzin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(StsAbsnSakit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(StsAbsnAlfa)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StsAbsnIzin)
                    .addComponent(StsAbsnSakit)
                    .addComponent(StsAbsnAlfa)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Entr, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(157, 157, 157))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(162, 162, 162)))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Entr, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelJam)
                    .addComponent(LabelTanggal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelJam)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DeskPane.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout DeskPaneLayout = new javax.swing.GroupLayout(DeskPane);
        DeskPane.setLayout(DeskPaneLayout);
        DeskPaneLayout.setHorizontalGroup(
            DeskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        DeskPaneLayout.setVerticalGroup(
            DeskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        jLabel3.setText("Jalan Raya Cibanteng Proyek, Desa Cihideung, RT. 04/ 03 Kec. Ciampea Kab. Bogor, Kode Pos : 16620");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DeskPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(DeskPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnmzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnmzActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_MnmzActionPerformed

    private void ClseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClseActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_ClseActionPerformed

    private void PrefButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrefButtonMouseEntered

        PrefButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_PrefButtonMouseEntered

    private void PrefButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrefButtonMouseExited
        PrefButton.setForeground(Color.BLACK);

    }//GEN-LAST:event_PrefButtonMouseExited

    private void ATopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATopActionPerformed
        
        if (ATop.isSelected())
        {
            setAlwaysOnTop(true);
         
        }
        else {
            setAlwaysOnTop(false);
        }
        
    }//GEN-LAST:event_ATopActionPerformed

    private void PrefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrefButtonActionPerformed
        PopUpMenu.show(this, PrefButton.getLocationOnScreen().x, PrefButton.getLocationOnScreen().y + PrefButton.getHeight());
        PopUpMenu.show();
  
    }//GEN-LAST:event_PrefButtonActionPerformed

    private void LgnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LgnAdminActionPerformed

        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        dispose();

    }//GEN-LAST:event_LgnAdminActionPerformed

    private void AbsnPgwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbsnPgwActionPerformed

        if (AbsnPgw.isSelected()) {
            AbsnSsw.setSelected(false);
            DeskPane.removeAll();  
           
            controler.findList();
            
            AbsnStaffFrm.getTableStaff().setModel(new AbsensiGurudanStaffTableModel(new AbsensiGurudanStaffDao().getListAbsGurudanStaffTDY()));
            DeskPane.add(AbsnStaffFrm);
        }

        if (AbsnSsw.isSelected() == false) {
            AbsnPgw.setSelected(true);
        }

    }//GEN-LAST:event_AbsnPgwActionPerformed

    private void AbsnSswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbsnSswActionPerformed

        if (AbsnSsw.isSelected()) {
            AbsnPgw.setSelected(false);
            DeskPane.removeAll();
           
            controler.findList();
            
            AbsnSiswaFrm.getTableSiswa().setModel(new AbsensiSiswaTableModel(new AbsensiSiswaDao().getListAbsSiswaTDY()));
            DeskPane.add(AbsnSiswaFrm);
        }

        if (AbsnPgw.isSelected() == false) {
            AbsnSsw.setSelected(true);
        }


    }//GEN-LAST:event_AbsnSswActionPerformed

    private void StsAbsnIzinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StsAbsnIzinStateChanged

        if (StsAbsnIzin.isSelected()) {
            StsAbsnAlfa.setSelected(false);
            StsAbsnSakit.setSelected(false);
        }

        if (StsAbsnAlfa.isSelected() == false && StsAbsnSakit.isSelected() == false) {
            StsAbsnIzin.setSelected(true);
        }

        if (StsAbsnIzin.isSelected()) {
            StsAbs = StsAbsen.IZIN.getKet();
        }

    }//GEN-LAST:event_StsAbsnIzinStateChanged

    private void StsAbsnSakitStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StsAbsnSakitStateChanged

        if (StsAbsnSakit.isSelected()) {
            StsAbsnIzin.setSelected(false);
            StsAbsnAlfa.setSelected(false);

        }

        if (StsAbsnAlfa.isSelected() == false && StsAbsnIzin.isSelected() == false) {
            StsAbsnSakit.setSelected(true);
        }

        if (StsAbsnSakit.isSelected()) {
            StsAbs = StsAbsen.SAKIT.getKet();
        }


    }//GEN-LAST:event_StsAbsnSakitStateChanged

    private void StsAbsnAlfaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StsAbsnAlfaStateChanged

        if (StsAbsnAlfa.isSelected()) {
            StsAbsnIzin.setSelected(false);
            StsAbsnSakit.setSelected(false);

        }

        if (StsAbsnIzin.isSelected() == false && StsAbsnSakit.isSelected() == false) {
            StsAbsnAlfa.setSelected(true);
        }

        if (StsAbsnAlfa.isSelected()) {
            StsAbs = StsAbsen.ALFA.getKet();
        }
    }//GEN-LAST:event_StsAbsnAlfaStateChanged

    private void EntrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrActionPerformed

        if (AbsnSsw.isSelected() && AbsnPgw.isSelected() == false) {

//            if (SswDao.isSiswaRegistered(TextBox.getText().toString())) {
//                AbsSswDao.TambahAbsnSSw(SswDao.getSsw(TextBox.getText()), this);
//                
//             }

            controler.TambahAbsenSiswa(SswDao);
            
        }
        if (AbsnSsw.isSelected() == false && AbsnPgw.isSelected()) {

//            if (GrStDao.isGurudanStaffRegistered(TextBox.getText().toString())) {
//                AbsGrStDao.TambahAbsenGuru(GrStDao.getGrSt(), this) ;
//      
//            }
            controler.TambahAbsenGuru(GrStDao);
            
        }

        controler.findList();

        
    }//GEN-LAST:event_EntrActionPerformed

    private void TextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextBoxFocusGained


    }//GEN-LAST:event_TextBoxFocusGained

    private void TextBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextBoxFocusLost


    }//GEN-LAST:event_TextBoxFocusLost

    private void TextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextBoxKeyReleased
        int Ev = evt.getKeyCode();
        if (Ev == evt.VK_ENTER) {
            if (!TextBox.getText().isEmpty()) {
                PControler.TampilPreSiswa();
            }

            if (!TextBox.getText().isEmpty()) {
                PControler.TampilPreGuru();
            }

        }
    }//GEN-LAST:event_TextBoxKeyReleased

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
            java.util.logging.Logger.getLogger(AbsensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbsensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbsensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbsensiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbsensiFrame().setVisible(true);
            }
        });
    }

    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbsensiFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbsensiFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbsensiFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AbsensiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public enum StsAbsen {

        IZIN(1, "IZIN"),
        SAKIT(2, "SAKIT"),
        ALFA(3, "ALFA");

        private StsAbsen(int st, String Ket) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem ATop;
    private javax.swing.JToggleButton AbsnPgw;
    private javax.swing.JToggleButton AbsnSsw;
    private javax.swing.JButton Clse;
    private javax.swing.JDesktopPane DeskPane;
    private javax.swing.JButton Entr;
    private javax.swing.JLabel LabelJam;
    private javax.swing.JLabel LabelTanggal;
    private javax.swing.JMenuItem LgnAdmin;
    private javax.swing.JButton Mnmz;
    private javax.swing.JPopupMenu PopUpMenu;
    private javax.swing.JButton PrefButton;
    private javax.swing.JRadioButton StsAbsnAlfa;
    private javax.swing.JRadioButton StsAbsnIzin;
    private javax.swing.JRadioButton StsAbsnSakit;
    private javax.swing.JTextField TextBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
