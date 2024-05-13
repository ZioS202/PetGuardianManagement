/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetGuardianManagement.GUI.topUp.main;

import javax.swing.JOptionPane;
import PetGuardianManagement.DTO.KhachHangDTO;
import PetGuardianManagement.BUS.TopUpBUS;
/**
 *
 * @author RAVEN
 */
public class TopUp extends javax.swing.JPanel {
    KhachHangDTO kh = new KhachHangDTO();
    /**
     * Creates new form Form_1
     */
    public TopUp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btTopUp = new PetGuardianManagement.GUI.Signin.swing.Button();
        txtfldTopUp = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        bt10000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        bt20000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        bt50000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        bt100000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        bt200000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        bt500000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(895, 563));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cooper", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 69, 0));
        jLabel1.setText("Số tiền nạp");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 140, 30));

        btTopUp.setBackground(new java.awt.Color(255, 69, 0));
        btTopUp.setForeground(new java.awt.Color(255, 255, 255));
        btTopUp.setText("Nạp Tiền");
        btTopUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTopUpActionPerformed(evt);
            }
        });
        jPanel1.add(btTopUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 160, 80));

        txtfldTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfldTopUpActionPerformed(evt);
            }
        });
        jPanel1.add(txtfldTopUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 530, -1));

        bt10000d.setBackground(new java.awt.Color(255, 69, 0));
        bt10000d.setForeground(new java.awt.Color(255, 255, 255));
        bt10000d.setText("10000đ");
        bt10000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt10000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt10000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt10000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 102, 50));

        bt20000d.setBackground(new java.awt.Color(255, 69, 0));
        bt20000d.setForeground(new java.awt.Color(255, 255, 255));
        bt20000d.setText("20000đ");
        bt20000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt20000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt20000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt20000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 102, 50));

        bt50000d.setBackground(new java.awt.Color(255, 69, 0));
        bt50000d.setForeground(new java.awt.Color(255, 255, 255));
        bt50000d.setText("50000đ");
        bt50000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt50000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt50000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt50000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 102, 50));

        bt100000d.setBackground(new java.awt.Color(255, 69, 0));
        bt100000d.setForeground(new java.awt.Color(255, 255, 255));
        bt100000d.setText("100000đ");
        bt100000d.setFocusable(false);
        bt100000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt100000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt100000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt100000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 102, 50));

        bt200000d.setBackground(new java.awt.Color(255, 69, 0));
        bt200000d.setForeground(new java.awt.Color(255, 255, 255));
        bt200000d.setText("200000đ");
        bt200000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt200000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt200000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt200000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 102, 50));

        bt500000d.setBackground(new java.awt.Color(255, 69, 0));
        bt500000d.setForeground(new java.awt.Color(255, 255, 255));
        bt500000d.setText("500000đ");
        bt500000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt500000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt500000dActionPerformed(evt);
            }
        });
        jPanel1.add(bt500000d, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 102, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/TopUp/icon/top-up.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 180, 130));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 69, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nạp Tiền");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 530, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTopUpActionPerformed
        // TODO add your handling code here:
        kh.setIMaKH(6);
        try {
            if (Integer.parseInt(txtfldTopUp.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Số tiền nạp không được bé hơn 0");  
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tiền nạp không hợp lệ");
        }
        TopUpBUS.getInstance().TopUpAcc(kh, Long.parseLong(txtfldTopUp.getText()));
        JOptionPane.showMessageDialog(this, "Nạp tiền thành công");
    }//GEN-LAST:event_btTopUpActionPerformed

    private void txtfldTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfldTopUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldTopUpActionPerformed

    private void bt10000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt10000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("10000");
    }//GEN-LAST:event_bt10000dActionPerformed

    private void bt20000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt20000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("20000");
    }//GEN-LAST:event_bt20000dActionPerformed

    private void bt50000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt50000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("50000");
    }//GEN-LAST:event_bt50000dActionPerformed

    private void bt100000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt100000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("100000");
    }//GEN-LAST:event_bt100000dActionPerformed

    private void bt200000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt200000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("200000");
    }//GEN-LAST:event_bt200000dActionPerformed

    private void bt500000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt500000dActionPerformed
        // TODO add your handling code here:
        txtfldTopUp.setText("500000");
    }//GEN-LAST:event_bt500000dActionPerformed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button bt100000d;
    private PetGuardianManagement.GUI.Signin.swing.Button bt10000d;
    private PetGuardianManagement.GUI.Signin.swing.Button bt200000d;
    private PetGuardianManagement.GUI.Signin.swing.Button bt20000d;
    private PetGuardianManagement.GUI.Signin.swing.Button bt500000d;
    private PetGuardianManagement.GUI.Signin.swing.Button bt50000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btTopUp;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtfldTopUp;
    // End of variables declaration//GEN-END:variables
}
