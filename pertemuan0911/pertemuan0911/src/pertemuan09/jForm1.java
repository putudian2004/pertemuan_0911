package pertemuan09;

import java.awt.image.BufferedImage;
import static pertemuan09.koneksi.buatkoneks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIANSARIANI 2201010254
 * TGL : 2024-06-21
 */
public class jForm1 extends javax.swing.JFrame {
    DefaultTableModel TM = new DefaultTableModel();
    
    /**
     * Creates new form jForm1
     */
    public jForm1() throws SQLException {
        initComponents();
        tbteman.setModel(TM);
        TM.addColumn("IDTeman");
        TM.addColumn("Nama");
        TM.addColumn("Alamat");
        TM.addColumn("Telp");
        
//        Object[] dta = new Object[3];
//        dta[0] = "Wayan Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
//                
//        dta[0] = "Made Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
//        
//        dta[0] = "Nyoman Aruni";
//        dta[1] = "Jl. Saja susah";
//        dta[2] = "08877666";
//        TM.addRow(dta);
        List_All();
        kosongkanform();
    }
    private void List_All() throws SQLException{
        TM.getDataVector().removeAllElements();
        TM.fireTableDataChanged();
        
        Connection cnn = buatkoneks();
        if( !cnn.isClosed() ){
            
            String sql = "SELECT * FROM teman;";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            while( rs.next() ){
                Object[] dta = new Object[4];
                dta[0] = rs.getInt("idteman");
                dta[1] = rs.getString("nama");
                dta[2] = rs.getString("alamat");
                dta[3] = rs.getString("telp");
                TM.addRow(dta);
            }
        }
        
    }
    
    private void StoreData() throws SQLException{
        Connection cnn = buatkoneks();
        String NM = txNAMA.getText();
        String AL = txALAMAT.getText();
        String TL = txTELP.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("INSERT INTO teman(nama,alamat,telp) VALUES(?,?,?);");
            PS.setString(1, NM);
            PS.setString(2, AL);
            PS.setString(3, TL);
            PS.executeUpdate();
        }
    }
    private void UpdateData() throws SQLException{
        Connection cnn = buatkoneks();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("UPDATE teman SET nama=?, alamat=?, telp=? WHERE idteman=?;");
            PS.setString(1, txNAMA.getText() );
            PS.setString(2, txALAMAT.getText() );
            PS.setString(3, txTELP.getText() );
            PS.setString(4, txID.getText() );
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void destroyData() throws SQLException{
        Connection cnn = buatkoneks();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM teman WHERE idteman=?;");
            PS.setString(1, txID.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void kosongkanform(){
        txID.setText("");
        txNAMA.setText("");
        txALAMAT.setText("");
        txTELP.setText("");
    }
    
    private void viewpaspoto(String idteman){
        String ph0= "img/g.jpg";
        String ph="img/g"+idteman+".jpg";
        BufferedImage imgphoto = loadIMG.loadImage(ph);
        if(imgphoto == null){
            imgphoto = loadIMG.loadImage(ph0);
        }
        //mengubah image menjadi icon
        ImageIcon imgico = new ImageIcon(imgphoto);
        pasphoto.setIcon(imgico);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbteman = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txALAMAT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txTELP = new javax.swing.JTextField();
        txIDLABEL = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnBARU = new javax.swing.JButton();
        btnTUTUP = new javax.swing.JButton();
        btnUBAH = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        pasphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(450, 450));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Daftar Teman");

        tbteman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Alamat", "Telp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbteman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtemanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbteman);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("Telpon");

        txIDLABEL.setText("IDTeman");

        btnBARU.setText("Baru");
        btnBARU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBARUActionPerformed(evt);
            }
        });

        btnTUTUP.setText("TutupForm");
        btnTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTUTUPActionPerformed(evt);
            }
        });

        btnUBAH.setText("Ubah");
        btnUBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUBAHActionPerformed(evt);
            }
        });

        btnHAPUS.setText("Hapus");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });

        pasphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnBARU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUBAH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHAPUS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTUTUP))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(34, 34, 34)
                                .addComponent(txTELP)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txIDLABEL))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txID, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txNAMA)
                            .addComponent(txALAMAT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pasphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBARU, btnTUTUP});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txIDLABEL)
                            .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pasphoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txTELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBARU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTUTUP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbtemanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtemanMouseClicked
        txID.setText( tbteman.getValueAt( tbteman.getSelectedRow(),0 ).toString() );
        txNAMA.setText( tbteman.getValueAt( tbteman.getSelectedRow(), 1).toString() );
        txALAMAT.setText( tbteman.getValueAt(tbteman.getSelectedRow(), 2).toString() );
        txTELP.setText( tbteman.getValueAt(tbteman.getSelectedRow(), 3).toString() );
        viewpaspoto(txID.getText());
        
        btnBARU.setEnabled(true);
        btnHAPUS.setEnabled(true);
    }//GEN-LAST:event_tbtemanMouseClicked

    private void btnTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTUTUPActionPerformed
        if(btnTUTUP.getText().equals("TutupForm")){
            dispose();
        }else{
            btnTUTUP.setText("TutupForm");
            btnBARU.setText("Baru");
        }
            
    }//GEN-LAST:event_btnTUTUPActionPerformed

    private void btnBARUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBARUActionPerformed
        if(btnBARU.getText().equals("Baru")){
            btnBARU.setText("Simpan");
            btnTUTUP.setText("Batal");
            kosongkanform();
            tbteman.setEnabled(false);
        }else{
            btnBARU.setText("Baru");
            btnTUTUP.setText("TutupForm");
            tbteman.setEnabled(true);
            try {
                StoreData();
                List_All();
            } catch (SQLException ex) {
                Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBARUActionPerformed

    private void btnUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUBAHActionPerformed
        
        try {
            UpdateData();
            List_All();
            JOptionPane.showMessageDialog(this,"Data Telah di Update");
        } catch (SQLException ex) {
            Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnUBAHActionPerformed

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        try {
            int jwb = JOptionPane.showOptionDialog(
                    this, 
                    "Yakin akan menghapus data "+txNAMA.getText()+"?", 
                    "Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jwb == JOptionPane.YES_OPTION){
                destroyData();
                List_All();
            }
        } catch (SQLException ex) {
            Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

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
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jForm1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jForm1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBARU;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnTUTUP;
    private javax.swing.JButton btnUBAH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel pasphoto;
    private javax.swing.JTable tbteman;
    private javax.swing.JTextField txALAMAT;
    private javax.swing.JTextField txID;
    private javax.swing.JLabel txIDLABEL;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txTELP;
    // End of variables declaration//GEN-END:variables
}
