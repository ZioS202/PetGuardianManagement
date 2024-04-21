package PetGuardianManagement.GUI.homepageUser.swing.WinButton;

import PetGuardianManagement.GUI.homepageUser.component.Header;
import PetGuardianManagement.GUI.homepageUser.component.Menu;
import PetGuardianManagement.GUI.homepageUser.swing.PanelBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WinButton extends javax.swing.JPanel {

    public WinButton() {
        initComponents();
        setOpaque(false);
    }

    public void initEvent(JFrame fram, PanelBorder panel, Menu menu, Header header, JPanel mainPanel) {
        // Close button
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        // Minimize button
        cmdMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
        // Maximize button
        cmdRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fram.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    panel.setRound(20);
                    menu.setRound(20);
                    header.setRound(20);
                    header.setPreferredSize(header.getMinimumSize());
                    mainPanel.setPreferredSize(mainPanel.getMinimumSize());
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    fram.setExtendedState(JFrame.NORMAL);
                } else {
                    panel.setRound(0);
                    menu.setRound(0);
                    header.setRound(0);
                    int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    header.setPreferredSize(new Dimension(screenWidth - menu.getWidth(), 45));
                    mainPanel.setPreferredSize(new Dimension(screenWidth - menu.getWidth(), screenHeight - header.getHeight()));
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdClose = new PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button();
        cmdMi = new PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button();
        cmdRe = new PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button();

        cmdClose.setBackground(new java.awt.Color(240, 61, 61));

        cmdMi.setBackground(new java.awt.Color(227, 226, 68));

        cmdRe.setBackground(new java.awt.Color(67, 199, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button cmdClose;
    private PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button cmdMi;
    private PetGuardianManagement.GUI.homepageUser.swing.WinButton.Button cmdRe;
    // End of variables declaration//GEN-END:variables
}
