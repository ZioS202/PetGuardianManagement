package PetGuardianManagement.GUI.Cart.component;

import PetGuardianManagement.BUS.CartBUS;
import PetGuardianManagement.ExtendFunctions;
import PetGuardianManagement.GUI.Cart.main.CartEmpty;
import PetGuardianManagement.GUI.Cart.model.ModelItem;
import PetGuardianManagement.GUI.homepageUser.main.homepageUser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Item extends javax.swing.JPanel {

    private ModelItem data;

    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel1.setBackground(new Color(242, 242, 242));
        txtSoLuongOnlyAllowNumbers();
        txtSoLuongFocusLostHandler();
        txtSoLuongDocumentListener();

        // Add mouse listener to this JPanel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When clicked outside of the text field
                if (!txtSoLuong.getBounds().contains(e.getPoint())) {
                    // Remove focus from text field
                    Item.this.requestFocusInWindow();
                }
            }
        });
    }

    public ModelItem getData() {
        return data;
    }

    public void setData(ModelItem data) {
        this.data = data;
        lbItemName.setText(data.getLoaiVe().getStrTenLoaiVe());
        lbPrice.setText(ExtendFunctions.CurrencyFormat(data.getLoaiVe().getLGiaVe()));
        switch (data.getLoaiVe().getIMaLoaiVe()) {
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
        txtSoLuong.setText(Long.toString(data.getSoLuong()));
        lbSoTien.setText(ExtendFunctions.CurrencyFormat(data.getLoaiVe().getLGiaVe() * data.getSoLuong()));
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

    // Create a document filter to only allow numbers in txtSoLuong, and limit character to 3
    private void txtSoLuongOnlyAllowNumbers() {
        ((AbstractDocument) txtSoLuong.getDocument()).setDocumentFilter(new DocumentFilter() {
            int maxCharacters = 3;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (containsOnlyNumbers(string) && fb.getDocument().getLength() + string.length() <= maxCharacters) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (containsOnlyNumbers(text) && fb.getDocument().getLength() + text.length() - length <= maxCharacters) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean containsOnlyNumbers(String text) {
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    // FocusLost handler for txtSoLuong
    private void txtSoLuongFocusLostHandler() {
        txtSoLuong.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // Check if txtSoLuong is empty. Or txtSoLuong is 0
                if (txtSoLuong.getText().isEmpty() || Integer.parseInt(txtSoLuong.getText()) == 0) {
                    txtSoLuong.setText("1");
                }

                // Update to lstModelItem(CartBUS) and ChiTietGioHang table
                if (Integer.parseInt(txtSoLuong.getText()) != data.getSoLuong()) {
                    int oldSoLuong = data.getSoLuong();
                    data.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                    // updateSoLuongMua có thể gặp lỗi khi thao tác với DB. Trường hợp lỗi sẽ reverse txtSoLuong
                    // Nếu thành công thì update lstModelItem(CartBUS)
                    if (CartBUS.getInstance().updateSoLuongMua(data) > 0) {
                        if (CartBUS.getInstance().updateModelItem(data) > 0) {
                            // Update lbTongTien(CartGUI)
                            homepageUser.getInstance().cart.loadTongTien();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        txtSoLuong.setText(String.valueOf(oldSoLuong));
                        data.setSoLuong(oldSoLuong);
                    }
                }
            }
        });

    }

    // Add DocumentListener for txtSoLuong
    private void txtSoLuongDocumentListener() {
        txtSoLuong.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTxtSoTien();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTxtSoTien();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTxtSoTien();
            }

            private void updateTxtSoTien() {
                String soLuongText = txtSoLuong.getText();
                if (!soLuongText.isEmpty()) {
                    int soLuong = Integer.parseInt(soLuongText);
                    long soTien = soLuong * data.getLoaiVe().getLGiaVe();
                    lbSoTien.setText(ExtendFunctions.CurrencyFormat(soTien));
                } else {
                    lbSoTien.setText("0 ₫");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        pic = new PetGuardianManagement.GUI.BuyTicket.swing.PictureBox();
        btnDelete = new javax.swing.JButton();
        lbSoTien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPlus = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        btnMinus = new javax.swing.JButton();
        lbPrice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lbSoTien.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbSoTien.setForeground(new java.awt.Color(243, 148, 34));
        lbSoTien.setText("0 ₫");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnPlus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Cart/icon/icons8-plus-12.png"))); // NOI18N
        btnPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlusMouseClicked(evt);
            }
        });

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("SL Vé");

        btnMinus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Cart/icon/icons8-minus-12.png"))); // NOI18N
        btnMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMinus)
                .addGap(4, 4, 4)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnPlus)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMinus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(76, 76, 76));
        lbPrice.setText("0 ₫");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(lbPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(lbSoTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(lbItemName))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbSoTien)
                                .addComponent(btnDelete))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // deleteChiTietGioHang có thể gặp lỗi khi thao tác với DB.
        // Nếu thành công thì mới deleteModelItem trong lstModelItem(CartBUS)
        if (CartBUS.getInstance().deleteChiTietGioHang(data.getLoaiVe().getIMaLoaiVe()) > 0) {
            if (CartBUS.getInstance().deleteModelItem(data.getLoaiVe().getIMaLoaiVe()) > 0) {
                // Update lbTongTien(CartGUI)
                Dimension itemSize = this.getSize();
                switch (itemSize.width) {
                    case 1570 -> {
                        homepageUser.getInstance().cart.loadDataMaximizeScreen();
                    }
                    case 850 -> {
                        homepageUser.getInstance().cart.loadData();
                    }
                }
                homepageUser.getInstance().cart.loadTongTien();

                // Nếu GioHang của User trống (tức là không còn ChiTietGioHang), thì xóa GioHang của User
                if (CartBUS.getInstance().getLstModelItemSize() == 0) {
                    if (CartBUS.getInstance().deleteGioHang() == 0) {
                        // deleteGioHang có thể gặp lỗi khi thao tác với DB.
                        // TODO: Cần thêm cơ chế thử lại n lần sau n giây
                        JOptionPane.showMessageDialog(null, "Thao tác xóa GioHang thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Hiển thị cartEmpty
                        if (homepageUser.getInstance().cartEmpty == null) {
                            homepageUser.getInstance().cartEmpty = new CartEmpty();
                        }
                        homepageUser.getInstance().setForm(homepageUser.getInstance().cartEmpty);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusMouseClicked
        int currentSoLuong = Integer.parseInt(txtSoLuong.getText());
        int newSoLuong = currentSoLuong - 1;
        if (newSoLuong <= 0) {
            newSoLuong = 1;
        }
        long soTien = newSoLuong * data.getLoaiVe().getLGiaVe();
        lbSoTien.setText(ExtendFunctions.CurrencyFormat(soTien));
        txtSoLuong.setText(String.valueOf(newSoLuong));

        // Update to lstModelItem(CartBUS) and ChiTietGioHang table
        if (newSoLuong != data.getSoLuong()) {
            int oldSoLuong = currentSoLuong;
            data.setSoLuong(newSoLuong);
            // updateSoLuongMua có thể gặp lỗi khi thao tác với DB. Trường hợp lỗi sẽ reverse txtSoLuong
            // Nếu thành công thì update lstModelItem(CartBUS)
            if (CartBUS.getInstance().updateSoLuongMua(data) > 0) {
                if (CartBUS.getInstance().updateModelItem(data) > 0) {
                    // Update lbTongTien(CartGUI)
                    homepageUser.getInstance().cart.loadTongTien();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtSoLuong.setText(String.valueOf(oldSoLuong));
                data.setSoLuong(oldSoLuong);
            }
        }
    }//GEN-LAST:event_btnMinusMouseClicked

    private void btnPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlusMouseClicked
        int currentSoLuong = Integer.parseInt(txtSoLuong.getText());
        int newSoLuong = currentSoLuong + 1;
        long soTien = newSoLuong * data.getLoaiVe().getLGiaVe();
        lbSoTien.setText(ExtendFunctions.CurrencyFormat(soTien));
        txtSoLuong.setText(String.valueOf(newSoLuong));

        // Update to lstModelItem(CartBUS) and ChiTietGioHang table
        if (newSoLuong != data.getSoLuong()) {
            int oldSoLuong = currentSoLuong;
            data.setSoLuong(newSoLuong);
            // updateSoLuongMua có thể gặp lỗi khi thao tác với DB. Trường hợp lỗi sẽ reverse txtSoLuong
            // Nếu thành công thì update lstModelItem(CartBUS)
            if (CartBUS.getInstance().updateSoLuongMua(data) > 0) {
                if (CartBUS.getInstance().updateModelItem(data) > 0) {
                    // Update lbTongTien(CartGUI)
                    homepageUser.getInstance().cart.loadTongTien();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại. Vui lòng thử lại sau.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtSoLuong.setText(String.valueOf(oldSoLuong));
                data.setSoLuong(oldSoLuong);
            }
        }
    }//GEN-LAST:event_btnPlusMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSoTien;
    private PetGuardianManagement.GUI.BuyTicket.swing.PictureBox pic;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
