package PetGuardianManagement.GUI.BuyTicket.component;

import PetGuardianManagement.BUS.BuyTicketBUS;
import PetGuardianManagement.DTO.LoaiVeDTO;
import PetGuardianManagement.ExtendFunctions;
import PetGuardianManagement.GUI.homepageUser.main.homepageUser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Item extends javax.swing.JPanel {

    private LoaiVeDTO data;

    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        pic = new PetGuardianManagement.GUI.BuyTicket.swing.PictureBox();
        lbPrice = new javax.swing.JLabel();
        btnMuaNgay = new PetGuardianManagement.GUI.Signin.swing.Button();
        btnThemVaoGio = new PetGuardianManagement.GUI.Signin.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("0 ₫");

        btnMuaNgay.setBackground(new java.awt.Color(238, 77, 45));
        btnMuaNgay.setForeground(new java.awt.Color(255, 255, 255));
        btnMuaNgay.setText("Mua Ngay");
        btnMuaNgay.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnMuaNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMuaNgayMouseClicked(evt);
            }
        });

        btnThemVaoGio.setBackground(new java.awt.Color(255, 238, 232));
        btnThemVaoGio.setBorder(null);
        btnThemVaoGio.setForeground(new java.awt.Color(238, 77, 45));
        btnThemVaoGio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/BuyTicket/icon/icons8-add-shopping-cart-32.png"))); // NOI18N
        btnThemVaoGio.setText("Thêm");
        btnThemVaoGio.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnThemVaoGio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemVaoGioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrice)
                            .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMuaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuaNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public LoaiVeDTO getData() {
        return data;
    }

    public void setData(LoaiVeDTO data) {
        this.data = data;
        lbItemName.setText(data.getStrTenLoaiVe());
        lbPrice.setText(ExtendFunctions.CurrencyFormat(data.getLGiaVe()));
        switch (data.getIMaLoaiVe()) {
            case 1 -> {
                pic.setImage(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/BuyTicket/icon/VeNgay.png")));
            }
            case 2 -> {
                pic.setImage(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/BuyTicket/icon/VeTuan.png")));
            }
            case 3 -> {
                pic.setImage(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/BuyTicket/icon/VeThang.png")));
            }
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(grphcs);
    }

    private void btnMuaNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMuaNgayMouseClicked
        if (BuyTicketBUS.getInstance().buyTicket(data.getIMaLoaiVe()) > 0) {
            // Switch to Cart GUI
            btnMuaNgay.hideCursor();
            homepageUser.getInstance().clickMenuItem(3);
            btnMuaNgay.restoreCursor();
        } else {
            JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnMuaNgayMouseClicked

    private void btnThemVaoGioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVaoGioMouseClicked
        if (BuyTicketBUS.getInstance().buyTicket(data.getIMaLoaiVe()) > 0) {
            JOptionPane.showMessageDialog(null, "Thêm vào giỏ hàng thành công.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemVaoGioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnMuaNgay;
    private PetGuardianManagement.GUI.Signin.swing.Button btnThemVaoGio;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private PetGuardianManagement.GUI.BuyTicket.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
