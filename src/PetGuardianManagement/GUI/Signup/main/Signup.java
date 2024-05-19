/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PetGuardianManagement.GUI.Signup.main;

import PetGuardianManagement.BUS.SignUpBUS;
import PetGuardianManagement.GUI.Signin.main.Signin;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Signup extends javax.swing.JFrame {

    private int posX, posY;

    public Signup() {
        initComponents();
        setIconImage();

        // Email txtField
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mail.png")));
        txtEmail.setHint("Email");

        // Name txtField
        txtFirstName.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signup/icon/user.png")));
        txtFirstName.setHint("First Name");
        txtLastName.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signup/icon/user.png")));
        txtLastName.setHint("Last Name");

        // Password txtField
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/pass.png")));
        txtPassword.setHint("Password");

        // ConfirmPassword txtField
        txtConfirmPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/pass.png")));
        txtConfirmPassword.setHint("Confirm Password");

        // Add mouse listener for dragging the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - posX;
                int newY = e.getYOnScreen() - posY;
                setLocation(newX, newY);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new PetGuardianManagement.GUI.Signin.swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblReturnToSignin = new javax.swing.JLabel();
        txtEmail = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        txtFirstName = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        txtLastName = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        btnSignUp = new PetGuardianManagement.GUI.Signin.swing.Button();
        txtPassword = new PetGuardianManagement.GUI.Signin.swing.MyPasswordField();
        txtConfirmPassword = new PetGuardianManagement.GUI.Signin.swing.MyPasswordField();
        maskIcon = new javax.swing.JLabel();
        unmaskIcon = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetGuardianManagement");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 164, 96));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signup/icon/a2.png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 270, 230));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 69, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 192, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 69, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Please sign up to continue.");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 280, -1));

        lblReturnToSignin.setForeground(new java.awt.Color(255, 255, 255));
        lblReturnToSignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signup/icon/a5.png"))); // NOI18N
        lblReturnToSignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReturnToSignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnToSigninMouseClicked(evt);
            }
        });
        panelRound1.add(lblReturnToSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, -1));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        panelRound1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 290, 40));

        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyPressed(evt);
            }
        });
        panelRound1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 290, 40));

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastNameKeyPressed(evt);
            }
        });
        panelRound1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 290, 40));

        btnSignUp.setBackground(new java.awt.Color(255, 69, 0));
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("SIGN UP");
        btnSignUp.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        btnSignUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSignUpKeyPressed(evt);
            }
        });
        panelRound1.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 250, 50));

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        panelRound1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 290, -1));

        txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmPasswordKeyPressed(evt);
            }
        });
        panelRound1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 290, -1));

        maskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mask.png"))); // NOI18N
        maskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maskIconMouseClicked(evt);
            }
        });
        panelRound1.add(maskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 40, 40));

        unmaskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unmaskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/unmask.png"))); // NOI18N
        unmaskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unmaskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unmaskIconMouseClicked(evt);
            }
        });
        panelRound1.add(unmaskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 40, 40));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/close-white-20px.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set JFrame icon
    private void setIconImage() {
        Image originalImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/logo-filled-500.png"));
        setIconImage(originalImage);
    }

    private void lblReturnToSigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnToSigninMouseClicked
        Signin signin = new Signin();
        signin.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblReturnToSigninMouseClicked

    private void maskIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maskIconMouseClicked
        txtPassword.setEchoChar((char) 0);
        maskIcon.setVisible(false);
        maskIcon.setEnabled(false);
        unmaskIcon.setEnabled(true);
        unmaskIcon.setEnabled(true);
    }//GEN-LAST:event_maskIconMouseClicked

    private void unmaskIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unmaskIconMouseClicked
        txtPassword.setEchoChar((char) 8226);
        maskIcon.setVisible(true);
        maskIcon.setEnabled(true);
        unmaskIcon.setEnabled(false);
        unmaskIcon.setEnabled(false);
    }//GEN-LAST:event_unmaskIconMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Hiệu ứng fadein (opacity from 0 to 1)
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.parseFloat(val);
            this.setOpacity(f);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // SignUp action performed
        performedSignUp();

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtFirstNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_txtFirstNameKeyPressed

    private void txtLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_txtLastNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_txtConfirmPasswordKeyPressed

    private void btnSignUpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSignUpKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            performedSignUp();
        }
    }//GEN-LAST:event_btnSignUpKeyPressed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    public void performedSignUp() {
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        MessageDigest digest;
        StringBuilder hexHashPassword = new StringBuilder("Inital value");
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = digest.digest(password.getBytes());
            hexHashPassword = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexHashPassword.append('0');
                }
                hexHashPassword.append(hex);
            }
            System.out.println("Hashed Password (SHA-256): " + hexHashPassword.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (email.equals("") || firstName.equals("") || lastName.equals("") || password.equals("") || confirmPassword.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
        } else {
            // check input user
            String msg = "";
            if (!isValidEmail(email)) {
                msg += "* Email không hợp lệ.\n";
            }
            if (!isValidPassword(password)) {
                msg += "* Mật khẩu không hợp lệ. Mật khẩu cần có ít nhất 8 ký tự và phải bao gồm chữ in hoa, in thường, số và ký tự đặc biệt.\n";
            }
            if (!confirmPassword.equals(password)) {
                msg += "* Xác nhận mật khẩu không trùng khớp với mật khẩu.\n";
            }
            if (!isValidName(firstName) || !isValidName(lastName)) {
                msg += "* Tên không hợp lệ.\n";
            }
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(this, msg, "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    boolean isExistUser = SignUpBUS.getInstance().CheckExistUser(email);
                    if (isExistUser) {
                        JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);

                    } else {
                        String fullname = firstName + " " + lastName;
                        int createdUser = SignUpBUS.getInstance().createUser(email, hexHashPassword.toString(), fullname);
                        if (createdUser > 0) {
                            JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                            Signin signin = new Signin();
                            signin.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Tạo tài khoản thất bại!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
                        }

                    }
                } catch (Exception e) {
                    System.out.println("error here");
                    JOptionPane.showMessageDialog(this, e, "Lỗi !", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidName(String name) {
        return name.matches("[\\p{L} \\p{M}]+");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblReturnToSignin;
    private javax.swing.JLabel maskIcon;
    private PetGuardianManagement.GUI.Signin.swing.PanelRound panelRound1;
    private PetGuardianManagement.GUI.Signin.swing.MyPasswordField txtConfirmPassword;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtEmail;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtFirstName;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtLastName;
    private PetGuardianManagement.GUI.Signin.swing.MyPasswordField txtPassword;
    private javax.swing.JLabel unmaskIcon;
    // End of variables declaration//GEN-END:variables

}
