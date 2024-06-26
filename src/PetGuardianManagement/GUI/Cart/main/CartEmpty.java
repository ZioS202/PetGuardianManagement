/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PetGuardianManagement.GUI.Cart.main;

import PetGuardianManagement.GUI.homepageUser.main.homepageUser;

/**
 *
 * @author ductt
 */
public class CartEmpty extends javax.swing.JPanel {

    /**
     * Creates new form CartEmpty
     */
    public CartEmpty() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyIcon = new javax.swing.JLabel();
        labelgiohangtrong = new javax.swing.JLabel();
        btnMuaNgay = new PetGuardianManagement.GUI.Signin.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        emptyIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Cart/icon/EmptyCart.png"))); // NOI18N

        labelgiohangtrong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelgiohangtrong.setForeground(new java.awt.Color(147, 147, 172));
        labelgiohangtrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelgiohangtrong.setText("Giỏ hàng của bạn còn trống");

        btnMuaNgay.setBackground(new java.awt.Color(238, 77, 45));
        btnMuaNgay.setForeground(new java.awt.Color(255, 255, 255));
        btnMuaNgay.setText("Mua Ngay");
        btnMuaNgay.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        btnMuaNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMuaNgayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelgiohangtrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(emptyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMuaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(emptyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelgiohangtrong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMuaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuaNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMuaNgayMouseClicked
        btnMuaNgay.hideCursor();
        homepageUser.getInstance().clickMenuItem(7);
        btnMuaNgay.restoreCursor();
    }//GEN-LAST:event_btnMuaNgayMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnMuaNgay;
    private javax.swing.JLabel emptyIcon;
    private javax.swing.JLabel labelgiohangtrong;
    // End of variables declaration//GEN-END:variables
}
