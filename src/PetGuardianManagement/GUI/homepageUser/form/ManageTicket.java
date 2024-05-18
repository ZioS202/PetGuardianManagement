/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetGuardianManagement.GUI.homepageUser.form;

import PetGuardianManagement.BUS.BuyTicketBUS;
import PetGuardianManagement.BUS.ManageTicketBUS;
import PetGuardianManagement.DAO.VeDAO;
import PetGuardianManagement.DTO.LoaiVeDTO;
import PetGuardianManagement.DTO.VeDTO;
import PetGuardianManagement.ExtendFunctions;
import PetGuardianManagement.GUI.BuyTicket.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RAVEN
 */
public class ManageTicket extends javax.swing.JPanel {

    /**
     * Creates new form Form_1
     */
    public ManageTicket() {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getViewport().setBackground(Color.WHITE);
        btnKichHoat.setEnabled(false);
        btnXoa.setEnabled(false);

        // Search txtField
        txtSearch.setPrefixIcon(new ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/homepageUser/icon/search.png")));
        txtSearch.setHint("Search");

        // Add a MouseListener to the panel to detect clicks outside the table
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the click was outside the table
                Point point = e.getPoint();
                Component component = SwingUtilities.getDeepestComponentAt(ManageTicket.this, point.x, point.y);
                if (component != table && component != table.getTableHeader()) {
                    // Clear the table selection
                    table.clearSelection();
                    // Unfocus all component
                    ManageTicket.this.requestFocusInWindow();

                    btnXoa.setEnabled(false);
                    btnKichHoat.setEnabled(false);
                }
            }
        });

        // Setting ID column contains numeric data
        Object[][] data = {};
        Object[] columnNames = {"ID", "Loại Vé", "Ngày Kích Hoạt", "Ngày Hết Hạn", "Trạng Thái"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Integer.class;
                }
                return String.class;
            }
        };
        table.setModel(model);
        txtSearchDocumentListener();
        tableLoadData();
    }

    private boolean isHetHan(Date date) {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // Check if the given date is before now

        return calendar.getTime().before(new Date());
    }

    public void tableClearSelection() {
        table.clearSelection();
    }

    public final void tableLoadData() {
        btnKichHoat.setEnabled(false);
        btnXoa.setEnabled(false);
        table.clearAllRows();

        for (int i = 0; i < ManageTicketBUS.getInstance().getLstVeSize(); i++) {
            VeDTO ve = ManageTicketBUS.getInstance().getVe(i);
            LoaiVeDTO loaiVe = BuyTicketBUS.getInstance().searchLoaiVe(ve.getIMaLoaiVe());
            if (ve.getStrTrangThai().equals("Đang sử dụng")) {
                if (isHetHan(ve.getDateNgayHetHan())) {
                    ve.setStrTrangThai("Đã hết hạn");
                    if (ManageTicketBUS.getInstance().updateVEDB(ve) > 0) {
                        ManageTicketBUS.getInstance().updateVe(ve);
                        table.addRow(new Object[]{ve.getIMaVe(), loaiVe.getStrTenLoaiVe(), ExtendFunctions.DateFormat(ve.getdateNgayKichHoat()), ExtendFunctions.DateFormat(ve.getDateNgayHetHan()), ve.getStrTrangThai()});
                    }
                } else {
                    table.addRow(new Object[]{ve.getIMaVe(), loaiVe.getStrTenLoaiVe(), ExtendFunctions.DateFormat(ve.getdateNgayKichHoat()), ExtendFunctions.DateFormat(ve.getDateNgayHetHan()), ve.getStrTrangThai()});
                }
            } else {
                table.addRow(new Object[]{ve.getIMaVe(), loaiVe.getStrTenLoaiVe(), ExtendFunctions.DateFormat(ve.getdateNgayKichHoat()), ExtendFunctions.DateFormat(ve.getDateNgayHetHan()), ve.getStrTrangThai()});
            }
        }
    }

    private void tableUpdateRow(VeDTO data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(data.getIMaVe())) {
                model.setValueAt(ExtendFunctions.DateFormat(data.getdateNgayKichHoat()), i, 2);
                model.setValueAt(ExtendFunctions.DateFormat(data.getDateNgayHetHan()), i, 3);
                model.setValueAt(data.getStrTrangThai(), i, 4);
            }
        }
    }

    private void txtSearchDocumentListener() {
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(rowSorter);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFilter();
            }

            private void updateFilter() {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);  // No filter if the text field is empty
                } else {
                    // Convert search text to lowercase for case-insensitive comparison
                    String lowerCaseText = text.toLowerCase(Locale.ROOT);
                    rowSorter.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
                        @Override
                        public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                            for (int i = 0; i < entry.getValueCount(); i++) {
                                String cellValue = entry.getStringValue(i).toLowerCase(Locale.ROOT);
                                if (cellValue.contains(lowerCaseText)) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    });
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKichHoat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        spTable = new javax.swing.JScrollPane();
        table = new PetGuardianManagement.GUI.Admin.HomepageAdmin.swing.Table();
        txtSearch = new PetGuardianManagement.GUI.Signin.swing.MyTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnKichHoat.setBackground(new java.awt.Color(238, 77, 45));
        btnKichHoat.setFont(new java.awt.Font("Cooper", 1, 14)); // NOI18N
        btnKichHoat.setForeground(new java.awt.Color(255, 255, 255));
        btnKichHoat.setText("Kích Hoạt");
        btnKichHoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKichHoatMouseClicked(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(238, 77, 45));
        btnXoa.setFont(new java.awt.Font("Cooper", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Loại Vé", "Ngày Kích Hoạt", "Ngày Hết Hạn", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKichHoat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKichHoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        btnXoa.setEnabled(true);

        // Get view index of seletected row
        int viewRow = table.getSelectedRow();
        // Convert view index to model index
        int modelRow = table.convertRowIndexToModel(viewRow);

        // Get Ve TrangThai
        String trangThai = model.getValueAt(modelRow, 4).toString();
        if (trangThai.equals("Chưa kích hoạt")) {
            btnKichHoat.setEnabled(true);
        } else if (trangThai.equals("Đang sử dụng") || trangThai.equals("Đã hết hạn")) {
            btnKichHoat.setEnabled(false);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnKichHoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKichHoatMouseClicked
        if (btnKichHoat.isEnabled()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Get view index of seletected row
            int viewRow = table.getSelectedRow();
            // Convert view index to model index
            int modelRow = table.convertRowIndexToModel(viewRow);

            // Get Ve ID
            int id = (Integer) model.getValueAt(modelRow, 0);
            int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn kích hoạt vé " + id + "?", "Xác nhận kích hoạt", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                // Get the current date and time
                Date now = new Date();
                // Create a Calendar instance and set it to the current date and time
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(now);

                VeDTO ve = ManageTicketBUS.getInstance().getVe(modelRow);
                ve.setStrTrangThai("Đang sử dụng");
                ve.setdateNgayKichHoat(now);

                // Get Loai Ve
                String loaiVe = model.getValueAt(modelRow, 1).toString();

                switch (loaiVe) {
                    case "Vé Ngày" -> {// Add one day to the current date
                        calendar.add(Calendar.DAY_OF_YEAR, 1);
                    }
                    case "Vé Tuần" -> {// Add one week to the current date
                        calendar.add(Calendar.DAY_OF_YEAR, 7);
                    }
                    case "Vé Tháng" -> {// Add one month to the current date
                        calendar.add(Calendar.MONTH, 1);
                    }
                }
                ve.setDateNgayHetHan(calendar.getTime());

                if (ManageTicketBUS.getInstance().updateVEDB(ve) > 0) {
                    ManageTicketBUS.getInstance().updateVe(ve);
                    tableUpdateRow(ve);
                    btnKichHoat.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnKichHoatMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        if (btnXoa.isEnabled()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Get view index of seletected row
            int viewRow = table.getSelectedRow();
            // Convert view index to model index
            int modelRow = table.convertRowIndexToModel(viewRow);

            // Get Ve ID
            int id = (Integer) model.getValueAt(modelRow, 0);
            int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa vé " + id + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                if (VeDAO.getInstance().delete(id) > 0) {
                    ManageTicketBUS.getInstance().deleteVe(id);
                    model.removeRow(modelRow);
                    btnXoa.setEnabled(false);
                    btnKichHoat.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKichHoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane spTable;
    private PetGuardianManagement.GUI.Admin.HomepageAdmin.swing.Table table;
    private PetGuardianManagement.GUI.Signin.swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
