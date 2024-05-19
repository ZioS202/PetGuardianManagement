/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetGuardianManagement.GUI.topUp.main;

import PetGuardianManagement.BUS.CartBUS;
import PetGuardianManagement.BUS.TopUpBUS;
import PetGuardianManagement.ExtendFunctions;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class TopUp extends javax.swing.JPanel {

    private long soDu;

    public TopUp() {
        initComponents();
        txtTopUp.setHint("Số tiền nạp");
        loadSoDu();
    }

    public void clearTxtTopUp() {
        txtTopUp.setText("");
    }

    public final void loadSoDu() {
        soDu = CartBUS.getInstance().getSoDuKhachHang();
        lbSoDu.setText(ExtendFunctions.CurrencyFormat(soDu));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtTopUp = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        btn10000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        btn20000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        btn50000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        btn500000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        btn200000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        btn100000d = new PetGuardianManagement.GUI.Signin.swing.Button();
        jLabel3 = new javax.swing.JLabel();
        btnTopUp = new PetGuardianManagement.GUI.Signin.swing.Button();
        Title = new javax.swing.JLabel();
        lbSoDu = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(895, 563));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cooper", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 148, 34));
        jLabel1.setText("Số tiền nạp");

        btn10000d.setBackground(new java.awt.Color(255, 69, 0));
        btn10000d.setForeground(new java.awt.Color(255, 255, 255));
        btn10000d.setText("10.000 ₫");
        btn10000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn10000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10000dActionPerformed(evt);
            }
        });

        btn20000d.setBackground(new java.awt.Color(255, 69, 0));
        btn20000d.setForeground(new java.awt.Color(255, 255, 255));
        btn20000d.setText("20.000 ₫");
        btn20000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn20000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20000dActionPerformed(evt);
            }
        });

        btn50000d.setBackground(new java.awt.Color(255, 69, 0));
        btn50000d.setForeground(new java.awt.Color(255, 255, 255));
        btn50000d.setText("50.000 ₫");
        btn50000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn50000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn50000dActionPerformed(evt);
            }
        });

        btn500000d.setBackground(new java.awt.Color(255, 69, 0));
        btn500000d.setForeground(new java.awt.Color(255, 255, 255));
        btn500000d.setText("500.000 ₫");
        btn500000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn500000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500000dActionPerformed(evt);
            }
        });

        btn200000d.setBackground(new java.awt.Color(255, 69, 0));
        btn200000d.setForeground(new java.awt.Color(255, 255, 255));
        btn200000d.setText("200.000 ₫");
        btn200000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn200000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn200000dActionPerformed(evt);
            }
        });

        btn100000d.setBackground(new java.awt.Color(255, 69, 0));
        btn100000d.setForeground(new java.awt.Color(255, 255, 255));
        btn100000d.setText("100.000 ₫");
        btn100000d.setFocusable(false);
        btn100000d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn100000d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn100000dActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/TopUp/icon/top-up.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        btnTopUp.setBackground(new java.awt.Color(255, 69, 0));
        btnTopUp.setForeground(new java.awt.Color(255, 255, 255));
        btnTopUp.setText("Nạp Tiền");
        btnTopUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUpActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Cooper", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(243, 148, 34));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Số dư:");

        lbSoDu.setFont(new java.awt.Font("Cooper", 0, 24)); // NOI18N
        lbSoDu.setForeground(new java.awt.Color(243, 148, 34));
        lbSoDu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoDu.setText("0 ₫");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSoDu)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTopUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn10000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn100000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn200000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(btn500000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn20000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(btn50000d, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTopUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title)
                    .addComponent(lbSoDu))
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn20000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn50000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn500000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn100000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn200000d, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUpActionPerformed
        try {
            long amount = Long.parseLong(txtTopUp.getText());
            if (amount < 0) {
                JOptionPane.showMessageDialog(null, "Số tiền nạp không được bé hơn 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (TopUpBUS.getInstance().TopUpAcc(amount) > 0) {
                JOptionPane.showMessageDialog(null, "Nạp tiền thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtTopUp.setText("");
                soDu += amount;
                lbSoDu.setText(ExtendFunctions.CurrencyFormat(soDu));
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tiền nạp phải là số", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnTopUpActionPerformed

    private void btn10000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("10000");
    }//GEN-LAST:event_btn10000dActionPerformed

    private void btn20000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("20000");
    }//GEN-LAST:event_btn20000dActionPerformed

    private void btn50000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn50000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("50000");
    }//GEN-LAST:event_btn50000dActionPerformed

    private void btn100000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn100000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("100000");
    }//GEN-LAST:event_btn100000dActionPerformed

    private void btn200000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn200000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("200000");
    }//GEN-LAST:event_btn200000dActionPerformed

    private void btn500000dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500000dActionPerformed
        // TODO add your handling code here:
        txtTopUp.setText("500000");
    }//GEN-LAST:event_btn500000dActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private PetGuardianManagement.GUI.Signin.swing.Button btn100000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btn10000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btn200000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btn20000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btn500000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btn50000d;
    private PetGuardianManagement.GUI.Signin.swing.Button btnTopUp;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel lbSoDu;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtTopUp;
    // End of variables declaration//GEN-END:variables
}