package PetGuardianManagement.GUI.BuyTicket.component;

import PetGuardianManagement.DTO.LoaiVeDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;

public class Item extends javax.swing.JPanel {

    private LoaiVeDTO data;

    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public LoaiVeDTO getData() {
        return data;
    }

    public void setData(LoaiVeDTO data) {
        this.data = data;
        lbItemName.setText(data.getStrTenLoaiVe());
        lbPrice.setText(CurrencyFormat(data.getLongGiaVe()));
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

    private String CurrencyFormat(long amount) {
        Locale locale = new Locale("vi", "VN"); // Locale for Vietnamese
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        pic = new PetGuardianManagement.GUI.BuyTicket.swing.PictureBox();
        lbPrice = new javax.swing.JLabel();
        button1 = new PetGuardianManagement.GUI.Signin.swing.Button();
        button2 = new PetGuardianManagement.GUI.Signin.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("0 ₫");

        button1.setBackground(new java.awt.Color(238, 77, 45));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Mua Ngay");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        button2.setBackground(new java.awt.Color(255, 238, 232));
        button2.setBorder(null);
        button2.setForeground(new java.awt.Color(238, 77, 45));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/BuyTicket/icon/icons8-add-shopping-cart-32.png"))); // NOI18N
        button2.setText("Thêm");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

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
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button button1;
    private PetGuardianManagement.GUI.Signin.swing.Button button2;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private PetGuardianManagement.GUI.BuyTicket.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
