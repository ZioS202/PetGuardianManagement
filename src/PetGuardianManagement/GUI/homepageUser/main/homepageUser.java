/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PetGuardianManagement.GUI.homepageUser.main;

import PetGuardianManagement.BUS.CartBUS;
import PetGuardianManagement.BUS.ManageTicketBUS;
import PetGuardianManagement.GUI.Admin.HomepageAdmin.form.changePassword;
import PetGuardianManagement.GUI.BuyTicket.main.BuyTicket;
import PetGuardianManagement.GUI.Cart.main.Cart;
import PetGuardianManagement.GUI.Cart.main.CartEmpty;
import PetGuardianManagement.GUI.Signin.main.Signin;
import PetGuardianManagement.GUI.homepageUser.event.EventMenuSelected;
import PetGuardianManagement.GUI.homepageUser.form.AccountInformation;
import PetGuardianManagement.GUI.homepageUser.form.ManageTicket;
import PetGuardianManagement.GUI.homepageUser.form.petInfor;
import PetGuardianManagement.GUI.topUp.main.TopUp;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author theha
 */
public class homepageUser extends javax.swing.JFrame {

    private AccountInformation accInfor;
    public ManageTicket manageTicket;
    private petInfor petInfor;
    private BuyTicket buyTicket;
    public Cart cart;
    public CartEmpty cartEmpty;
    private TopUp topUp;
    private changePassword changePassword1;

    private Dimension mainPanelSize;

    private static homepageUser instance;

    // Public static method to access the single instance
    public static homepageUser getInstance() {
        if (instance == null) {
            instance = new homepageUser();
        }
        return instance;
    }

    private homepageUser() {
        initComponents();
        setIconImage();
        setBackground(new Color(0, 0, 0, 0));

        accInfor = new AccountInformation();
        petInfor = new petInfor();

        winButton.initEvent(this, panelBorder, menu, header, mainPanel);
        menu.initMoving(homepageUser.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                System.out.println("Selected index " + index);
                switch (index) {
                    case 0 -> {
                        setForm(accInfor);
                    }
                    case 1 -> {
                        if (manageTicket == null) {
                            manageTicket = new ManageTicket();
                        } else {
                            manageTicket.tableLoadData();
                        }
                        setForm(manageTicket);
                    }
                    case 2 -> {
                        setForm(petInfor);
                    }
                    case 3 -> {
                        // Check if User's GioHang is empty
                        if (CartBUS.getInstance().getLstModelItemSize() == 0) {
                            if (cartEmpty == null) {
                                cartEmpty = new CartEmpty();
                            }
                            setForm(cartEmpty);
                        } else {
                            if (cart == null) {
                                cart = new Cart();
                            } else {
                                mainPanelSize = mainPanel.getSize();
                                switch (mainPanelSize.width) {
                                    case 895 -> {
                                        cart.loadData();
                                    }
                                    case 1615 -> {
                                        cart.loadDataMaximizeScreen();
                                    }
                                }
                                cart.loadTongTien();
                                System.out.println(mainPanelSize.width == 895);
                            }
                            setForm(cart);
                        }
                    }
                    case 7 -> {
                        if (buyTicket == null) {
                            buyTicket = new BuyTicket();
                        }
                        setForm(buyTicket);
                    }
                    case 8 -> {
                        if (topUp == null) {
                            topUp = new TopUp();
                        } else {
                            topUp.clearTxtTopUp();
                            topUp.loadSoDu();
                        }
                        setForm(topUp);
                    }
                    case 9 -> {
                        if (changePassword1 == null) {
                            changePassword1 = new changePassword();
                        }
                        setForm(changePassword1);
                    }
                    case 10 -> {
                        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn ứng dụng chuyển hướng đến trang thông tin ứng dụng?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.OK_OPTION) {
                            String url = "https://petguardian.onrender.com/home";
                            if (Desktop.isDesktopSupported()) {
                                try {
                                    Desktop desktop = Desktop.getDesktop();
                                    desktop.browse(new URI(url));
                                } catch (IOException | URISyntaxException e) {
                                    System.out.println(e);
                                }
                            } else {
                                System.err.println("Desktop is not supported.");
                            }
                        }
                    }
                    case 11 -> {
                        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.OK_OPTION) {
                            Signin signin = new Signin();
                            signin.setVisible(true);
                            dispose();
                            Signin.User = null;
                            instance = null;
                            cart = null;
                            manageTicket = null;
                            CartBUS.getInstance().cleanUp();
                            ManageTicketBUS.getInstance().cleanUp();
                            System.gc();
                        }

                    }

                }
            }
        });
        setForm(accInfor);
    }

    public void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public void clickMenuItem(int index) {
        menu.clickSpecificMenuItem(index);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder = new PetGuardianManagement.GUI.homepageUser.swing.PanelBorder();
        menu = new PetGuardianManagement.GUI.homepageUser.component.Menu();
        mainPanel = new javax.swing.JPanel();
        header = new PetGuardianManagement.GUI.homepageUser.component.Header();
        winButton = new PetGuardianManagement.GUI.homepageUser.swing.WinButton.WinButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetGuardianManagement");
        setName("homepageUser"); // NOI18N
        setUndecorated(true);

        panelBorder.setBackground(new java.awt.Color(255, 255, 255));

        menu.setMinimumSize(new java.awt.Dimension(279, 700));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorderLayout = new javax.swing.GroupLayout(panelBorder);
        panelBorder.setLayout(panelBorderLayout);
        panelBorderLayout.setHorizontalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderLayout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorderLayout.setVerticalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorderLayout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set JFrame icon
    private void setIconImage() {
        Image originalImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/logo-filled-500.png"));
        setIconImage(originalImage);
    }

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
            java.util.logging.Logger.getLogger(homepageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepageUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.homepageUser.component.Header header;
    private javax.swing.JPanel mainPanel;
    private PetGuardianManagement.GUI.homepageUser.component.Menu menu;
    private PetGuardianManagement.GUI.homepageUser.swing.PanelBorder panelBorder;
    private PetGuardianManagement.GUI.homepageUser.swing.WinButton.WinButton winButton;
    // End of variables declaration//GEN-END:variables
}
