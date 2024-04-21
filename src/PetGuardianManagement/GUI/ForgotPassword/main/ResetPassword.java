/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PetGuardianManagement.GUI.ForgotPassword.main;

//import PetGuardianManagement.GUI.DangNhap;
//import static PetGuardianManagement.GUI.InitPublic.getHashPassword;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class ResetPassword extends javax.swing.JFrame {

    private int posX, posY;

    public ResetPassword() {
        initComponents();
        setIconImage();

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        txtPassword = new PetGuardianManagement.GUI.Signin.swing.MyPasswordField();
        txtConfirmPassword = new PetGuardianManagement.GUI.Signin.swing.MyPasswordField();
        btnSubmit = new PetGuardianManagement.GUI.Signin.swing.Button();
        maskIcon = new javax.swing.JLabel();
        unmaskIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetGuardianManagement");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/ForgotPassword/icon/imgResetPassword.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 69, 0));
        jLabel1.setText("Change Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/ForgotPassword/icon/close-orange-20px.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 30));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 250, -1));
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 250, -1));

        btnSubmit.setBackground(new java.awt.Color(255, 69, 0));
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 200, 50));

        maskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mask.png"))); // NOI18N
        maskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maskIconMouseClicked(evt);
            }
        });
        jPanel1.add(maskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 40, 40));

        unmaskIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unmaskIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/unmask.png"))); // NOI18N
        unmaskIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unmaskIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unmaskIconMouseClicked(evt);
            }
        });
        jPanel1.add(unmaskIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set JFrame icon
    private void setIconImage() {
        Image originalImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/logo-filled-500.png"));
        setIconImage(originalImage);
    }

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
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel maskIcon;
    private PetGuardianManagement.GUI.Signin.swing.MyPasswordField txtConfirmPassword;
    private PetGuardianManagement.GUI.Signin.swing.MyPasswordField txtPassword;
    private javax.swing.JLabel unmaskIcon;
    // End of variables declaration//GEN-END:variables

}
