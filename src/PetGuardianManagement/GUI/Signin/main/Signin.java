package PetGuardianManagement.GUI.Signin.main;

import PetGuardianManagement.GUI.ForgotPassword.main.VerifyOTP;
import PetGuardianManagement.GUI.Signup.main.Signup;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class Signin extends javax.swing.JFrame {

    private int posX, posY;

    public Signin() {
        initComponents();
        setIconImage();

        // Email txtField
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mail.png")));
        txtEmail.setHint("Email");

        // Password txtField
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/pass.png")));
        txtPassword.setHint("Password");

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
        jLabel1 = new javax.swing.JLabel();
        panelRound2 = new PetGuardianManagement.GUI.Signin.swing.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maskIcon = new javax.swing.JLabel();
        unmaskIcon = new javax.swing.JLabel();
        chkboxRememberPassword = new javax.swing.JCheckBox();
        lblForgetPassword = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();
        txtEmail = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        txtPassword = new PetGuardianManagement.GUI.Signin.swing.MyPasswordField();
        btnSignin = new PetGuardianManagement.GUI.Signin.swing.Button();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 164, 96));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 69, 0));
        jLabel3.setText("Sign in");
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 18, 120, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/login.png"))); // NOI18N
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 320, 290));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/a3.png"))); // NOI18N
        panelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 40, 40));

        maskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mask.png"))); // NOI18N
        maskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maskIconMouseClicked(evt);
            }
        });
        panelRound2.add(maskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 40, 40));

        unmaskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unmaskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/unmask.png"))); // NOI18N
        unmaskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unmaskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unmaskIconMouseClicked(evt);
            }
        });
        panelRound2.add(unmaskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 40, 40));

        chkboxRememberPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkboxRememberPassword.setText("Remember Password");
        panelRound2.add(chkboxRememberPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        lblForgetPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblForgetPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblForgetPassword.setText("Forget Password?");
        lblForgetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseClicked(evt);
            }
        });
        panelRound2.add(lblForgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 121, 27));

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Don't have an account? ");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 160, -1));

        lblSignUp.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(255, 69, 0));
        lblSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignUp.setText("<HTML><u>Sign up</u></HTML>");
        lblSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpMouseClicked(evt);
            }
        });
        panelRound2.add(lblSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 60, -1));
        panelRound2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 250, 40));
        panelRound2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 250, -1));

        btnSignin.setBackground(new java.awt.Color(255, 69, 0));
        btnSignin.setForeground(new java.awt.Color(255, 255, 255));
        btnSignin.setText("SIGN IN");
        btnSignin.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        panelRound2.add(btnSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 250, 50));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 830, 400));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/close-white-20px.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 490));

        setSize(new java.awt.Dimension(930, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set JFrame icon
    private void setIconImage() {
        Image originalImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/logo-filled-500.png"));
        setIconImage(originalImage);
    }

    // Hiển thị password
    private void maskIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maskIconMouseClicked
        txtPassword.setEchoChar((char) 0);
        maskIcon.setVisible(false);
        maskIcon.setEnabled(false);
        unmaskIcon.setEnabled(true);
        unmaskIcon.setEnabled(true);
    }//GEN-LAST:event_maskIconMouseClicked

    // Che password
    private void unmaskIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unmaskIconMouseClicked
        txtPassword.setEchoChar((char) 8226);
        maskIcon.setVisible(true);
        maskIcon.setEnabled(true);
        unmaskIcon.setEnabled(false);
        unmaskIcon.setEnabled(false);
    }//GEN-LAST:event_unmaskIconMouseClicked

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

    // Đóng chương trình
    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseClicked
        Signup signup = new Signup();
        signup.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblSignUpMouseClicked

    private void lblForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseClicked
        // Switch to VerifyOTP GUI
        VerifyOTP verifyOTP = new VerifyOTP();
        verifyOTP.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblForgetPasswordMouseClicked

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
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Signin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnSignin;
    private javax.swing.JCheckBox chkboxRememberPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblForgetPassword;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel maskIcon;
    private PetGuardianManagement.GUI.Signin.swing.PanelRound panelRound2;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtEmail;
    private PetGuardianManagement.GUI.Signin.swing.MyPasswordField txtPassword;
    private javax.swing.JLabel unmaskIcon;
    // End of variables declaration//GEN-END:variables

}
