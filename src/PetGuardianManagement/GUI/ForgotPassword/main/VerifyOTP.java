/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PetGuardianManagement.GUI.ForgotPassword.main;

import PetGuardianManagement.BUS.SignUpBUS;
import PetGuardianManagement.GUI.Signin.main.Signin;
import PetGuardianManagement.GUI.Signup.main.Signup;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class VerifyOTP extends javax.swing.JFrame {
    private static final String CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6;
    private static final SecureRandom random = new SecureRandom();
    private int posX, posY;
    private static final HashMap<String, String> otpStore = new HashMap<>();
    public static String EmailString = "";
    private static int countVerifyOTP=0;
    public VerifyOTP() {
        initComponents();
        setIconImage();

        // Email txtField
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signin/icon/mail.png")));
        txtEmail.setHint("Email");

        // OTP txtField
        txtOTP.setHint("Enter OTP");

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblReturnSignin = new javax.swing.JLabel();
        txtEmail = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        txtOTP = new PetGuardianManagement.GUI.Signin.swing.MyTextField();
        btnGetOTP = new PetGuardianManagement.GUI.Signin.swing.Button();
        btnVerifyOTP = new PetGuardianManagement.GUI.Signin.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetGuardianManagement");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/ForgotPassword/icon/a6.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 76, 267, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 69, 0));
        jLabel2.setText("OTP Verification");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 344, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 69, 0));
        jLabel3.setText("We will send you OTP to this email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 384, -1, -1));

        lblReturnSignin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Signup/icon/a5.png"))); // NOI18N
        lblReturnSignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReturnSignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnSigninMouseClicked(evt);
            }
        });
        jPanel1.add(lblReturnSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 290, 40));
        jPanel1.add(txtOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 290, 40));

        btnGetOTP.setBackground(new java.awt.Color(255, 69, 0));
        btnGetOTP.setForeground(new java.awt.Color(255, 255, 255));
        btnGetOTP.setText("Get OPT");
        btnGetOTP.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnGetOTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGetOTPMouseClicked(evt);
            }
        });
        jPanel1.add(btnGetOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 250, 50));

        btnVerifyOTP.setBackground(new java.awt.Color(255, 69, 0));
        btnVerifyOTP.setForeground(new java.awt.Color(255, 255, 255));
        btnVerifyOTP.setText("Verify OPT");
        btnVerifyOTP.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnVerifyOTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerifyOTPMouseClicked(evt);
            }
        });
        jPanel1.add(btnVerifyOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 250, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Set JFrame icon
    private void setIconImage() {
        Image originalImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/logo-filled-500.png"));
        setIconImage(originalImage);
    }

    private void lblReturnSigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnSigninMouseClicked
        Signin signin = new Signin();
        signin.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblReturnSigninMouseClicked

    private void btnGetOTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGetOTPMouseClicked
        if (!"".equals(txtEmail.getText()) && Signup.isValidEmail(txtEmail.getText())){
            EmailString = txtEmail.getText();
            forgotPassword(EmailString);         
            // Switch to Verify OTP
            txtEmail.setVisible(false);
            txtEmail.setEnabled(false);
            txtOTP.setVisible(true);
            txtOTP.setEnabled(true);
            btnGetOTP.setVisible(false);
            btnGetOTP.setEnabled(false);
            btnVerifyOTP.setVisible(true);
            btnVerifyOTP.setEnabled(true);
            jLabel3.setText("We have sent OTP to your email");
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin Email chính xác!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGetOTPMouseClicked

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

    private void btnVerifyOTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerifyOTPMouseClicked
        if (!"".equals(txtOTP.getText())){
            verifyOTP(txtOTP.getText());
        } else{
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập OTP!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnVerifyOTPMouseClicked

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
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new VerifyOTP().setVisible(true);
            }
        });
    }
    private static String generateOTP() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return otp.toString();
    }
    private static void saveOTP(String email, String otp) {
        otpStore.put(email, otp);
    }
    private static String getOTP(String email) {
        return otpStore.get(email);
    }

    private static void sendEmailOTP(String toEmail, String otp) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS
        props.put("mail.smtp.starttls.required", "true"); //
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); //
        String USERNAME = "20521291@gm.uit.edu.vn";
        String PASSWORD="";
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP code is: " + otp);

            Transport.send(message);
            System.out.println("OTP sent to email successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private static void sendEmailWarring(String toEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        String USERNAME = "20521291@gm.uit.edu.vn";
        String PASSWORD="";
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Warning: Unauthorized Access Attempt Detected");
            message.setText("""
                            Dear user,
                            
                            We detected an unauthorized access attempt.
                            If this was not you, please secure your account immediately.
                            
                            Best regards,
                            PGM Security Team""");

            Transport.send(message);
            System.out.println("Warning email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private void forgotPassword (String emailString){
        
        try {
            boolean isExistUser = SignUpBUS.getInstance().CheckExistUser(EmailString);
            if (isExistUser){
                JOptionPane.showMessageDialog(this, "Đang thực hiện yêu cầu\nVui lòng chờ trong giây lát!", "Thông báo!", JOptionPane.NO_OPTION);
                String otp = generateOTP();
                sendEmailOTP(emailString, otp);
                System.out.println("OTP generated and sent to: " + emailString);
                saveOTP(emailString, otp);
            }else{
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Lỗi !", JOptionPane.ERROR_MESSAGE);
        }

        
    }
    private void verifyOTP(String otp){
        if (txtOTP.getText().equals(getOTP(EmailString))){
            countVerifyOTP = 0;
            ResetPassword resetpass = new ResetPassword();
            resetpass.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "OTP của bạn không chính xác!", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            countVerifyOTP+=1;
            if (countVerifyOTP == 3){
                sendEmailWarring(EmailString);
                countVerifyOTP = 0;
                JOptionPane.showMessageDialog(this, "Bạn đã nhập sai quá nhiều lần.\nVui lòng kiểm tra email.", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
               // Switch to Verify OTP
                txtOTP.setVisible(false);
                txtOTP.setEnabled(false);
                txtEmail.setVisible(true);
                txtEmail.setEnabled(true);
                btnVerifyOTP.setVisible(false);
                btnVerifyOTP.setEnabled(false);
                btnGetOTP.setVisible(true);
                btnGetOTP.setEnabled(true);
                jLabel3.setText("Email");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.Signin.swing.Button btnGetOTP;
    private PetGuardianManagement.GUI.Signin.swing.Button btnVerifyOTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblReturnSignin;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtEmail;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtOTP;
    // End of variables declaration//GEN-END:variables

}
