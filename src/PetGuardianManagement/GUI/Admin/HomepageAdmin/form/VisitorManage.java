/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PetGuardianManagement.GUI.Admin.HomepageAdmin.form;

import PetGuardianManagement.GUI.BuyTicket.swing.ScrollBar;
import PetGuardianManagement.BUS.VisitorManagementBUS;
import PetGuardianManagement.DTO.ChiTietRaVaoDTO;
import PetGuardianManagement.DAO.ChiTietRaVaoDAO;
import PetGuardianManagement.DAO.KhachHangDAO;
import PetGuardianManagement.DAO.NguoiDungDAO;
import PetGuardianManagement.DAO.ThuCungDAO;
import PetGuardianManagement.DAO.VeDAO;
import PetGuardianManagement.DTO.KhachHangDTO;
import PetGuardianManagement.DTO.NguoiDungDTO;
import PetGuardianManagement.DTO.ThuCungDTO;
import PetGuardianManagement.DTO.VeDTO;
import PetGuardianManagement.ExtendFunctions;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import javax.swing.JTextField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author sourcePJ
 */
public class VisitorManage extends javax.swing.JPanel {

    private TableRowSorter<TableModel> rowSorter = null;
    Object[][] data = {};
    Object[] columnNames = {"ID","CustomerID", "PetID", "Check-In Time", "Check-Out Time"};
    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return Integer.class;
                }
                return String.class;
            }
        };
    /**
     * Creates new form VisitorManage
     */
    public VisitorManage() throws Exception {
        initComponents();
        initTable();
        hoTroTimKiem();
        spTable.setVerticalScrollBar(new ScrollBar());
        txtPetID.setColumns(10); 
        txtCustomerID.setColumns(10);
        addEnterKeyListener(txtCustomerID);
        addEnterKeyListener(txtPetID);
    }
    
    private void addEnterKeyListener(JTextField textField) {
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nhấn Enter, thực hiện kết thúc nhập
                //System.out.println("Finished input: " + textField.getText());
                textField.transferFocus();
            }
        });
    }
    
    private boolean isHetHan(Date date) {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // Check if the given date is before now

        return calendar.getTime().before(new Date());
    }
    
    private boolean isValidDateTime(String dateTimeString, String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    sdf.setLenient(false);
    try {
        Date dateTime = sdf.parse(dateTimeString);
        return true;
    } catch (ParseException e) {
        return false;
    }
}

    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
    long diffInMillies = abs(date2.getTime() - date1.getTime());
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
     // Phương thức tạo bảng
    public void initTable() {
        // Xóa dữ liệu cũ trong bảng
        tblChiTietRaVao.setModel(model);
        model.setRowCount(0);
              
        // Lấy dữ liệu từ cơ sở dữ liệu và thêm vào bảng
        try {
            ArrayList<ChiTietRaVaoDTO> list = ChiTietRaVaoDAO.getInstance().selectAll();
            for (int i = 0; i < list.size(); i++) {
                ChiTietRaVaoDTO chiTiet = list.get(i);
                String thoiGianVao = ExtendFunctions.DateFormat(chiTiet.getDateThoiGianVao());
                String thoiGianRa = ExtendFunctions.DateFormat(chiTiet.getDateThoiGianRa());
                model.addRow(new Object[]{
                    i + 1,
                    chiTiet.getIMaKH(),
                    chiTiet.getIMaThuCung(),
                    thoiGianVao,
                    thoiGianRa
                });
            }
            
            tblChiTietRaVao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblChiTietRaVao.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy dữ liệu từ hàng đã chọn
                    txtCustomerID.setText(tblChiTietRaVao.getValueAt(selectedRow, 1).toString());
                    txtPetID.setText(tblChiTietRaVao.getValueAt(selectedRow, 2).toString());
                }
            }
        });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateTable(){
        tblChiTietRaVao.setModel(model);
        model.setRowCount(0);
        
        try {
            ArrayList<ChiTietRaVaoDTO> list = VisitorManagementBUS.getInstance().searchByID(Integer.parseInt(txtCustomerID.getText()), Integer.parseInt(txtPetID.getText()));
            for (int i = 0; i < list.size(); i++) {
                ChiTietRaVaoDTO chiTiet = list.get(i);
                String thoiGianVao = ExtendFunctions.DateFormat(chiTiet.getDateThoiGianVao());
                String thoiGianRa = ExtendFunctions.DateFormat(chiTiet.getDateThoiGianRa());
                model.addRow(new Object[]{
                    i + 1,
                    chiTiet.getIMaKH(),
                    chiTiet.getIMaThuCung(),
                    thoiGianVao,
                    thoiGianRa
                });
            }
            
            tblChiTietRaVao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblChiTietRaVao.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy dữ liệu từ hàng đã chọn
                    txtCustomerID.setText(tblChiTietRaVao.getValueAt(selectedRow, 1).toString());
                    txtPetID.setText(tblChiTietRaVao.getValueAt(selectedRow, 2).toString());
                }
            }
        });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void hoTroTimKiem() {

        rowSorter = new TableRowSorter<>(tblChiTietRaVao.getModel());
        tblChiTietRaVao.setRowSorter(rowSorter);
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
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
        jLabel6 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPetID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSearchBy = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnCheck_out = new javax.swing.JButton();
        btnCheck_in = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnUpdateNew = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        spTable = new javax.swing.JScrollPane();
        tblChiTietRaVao = new PetGuardianManagement.GUI.Admin.HomepageAdmin.swing.Table();

        setBackground(new java.awt.Color(255, 153, 102));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setText("VISITOR MANAGEMENT");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("CustomerID");

        txtCustomerID.setText("Enter customer's ID");
        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });

        jLabel7.setText("PetID");

        txtPetID.setText("Enter Pet's ID");
        txtPetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPetIDActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/search.png"))); // NOI18N

        btnSearchBy.setText("Search by");
        btnSearchBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnCheck_out.setText("Check-out");
        btnCheck_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheck_outMouseClicked(evt);
            }
        });
        btnCheck_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck_outActionPerformed(evt);
            }
        });

        btnCheck_in.setText("Check-in");
        btnCheck_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheck_inMouseClicked(evt);
            }
        });
        btnCheck_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheck_inActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPetID)
                    .addComponent(txtCustomerID))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheck_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCheck_out, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSearchBy)
                                .addComponent(btnCheck_in))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCheck_out))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/visitor.png"))); // NOI18N

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/refresh.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/save.png"))); // NOI18N

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/delete.png"))); // NOI18N

        btnUpdateNew.setText("Update new");
        btnUpdateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNewActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PetGuardianManagement/GUI/Admin/HomepageAdmin/icon/upload.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(btnRefresh))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSave)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(btnUpdateNew, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDelete)
                                .addComponent(jLabel10)))))
                .addGap(14, 14, 14))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblChiTietRaVao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                " ID", "CustomerID", "PetID", "Check-In Time", "Check-Out Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(tblChiTietRaVao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
//        try{
//           
//            if (Integer.parseInt(txtCustomerID.getText()) < 0) {
//                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
//                return;
//            }
//            if (Integer.parseInt(txtPetID.getText()) < 0) {
//                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
//                return;
//            }
//            if (!isValidDateTime(txtCheck_in.getText(), "yyyy-MM-dd HH:mm:ss")) {
//            JOptionPane.showMessageDialog(this, "Thời gian vào không hợp lệ");
//            return;
//            }
//            if (!isValidDateTime(txtCheck_out.getText(), "yyyy-MM-dd HH:mm:ss")) {
//                JOptionPane.showMessageDialog(this, "Thời gian ra không hợp lệ");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Mã khách hàng hoặc mã thú cưng không hợp lệ");
//        }
//        int maKH =Integer.parseInt(txtCustomerID.getText());
//        int maThuCung =Integer.parseInt(txtPetID.getText());
//        String tgVao = txtCheck_in.getText();
//        String tgRa = txtCheck_out.getText(); 
//        try {
//            VisitorManagementBUS.getInstance().save(tgVao, tgRa, maKH, maThuCung);
//        } catch (SQLException ex) {
//            Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        JOptionPane.showMessageDialog(this, "Lưu thành công");      
    }//GEN-LAST:event_btnSaveActionPerformed

    
    private void btnSearchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByActionPerformed
        // TODO add your handling code here:       
        updateTable();
    }//GEN-LAST:event_btnSearchByActionPerformed

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void txtPetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPetIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPetIDActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtCustomerID.setText("");
        txtPetID.setText("");
        txtTimKiem.setText("");
        initTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try{
           
            if (Integer.parseInt(txtCustomerID.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
                return;
            }
            if (Integer.parseInt(txtPetID.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng hoặc mã thú cưng không hợp lệ");
        }
        int maKH =Integer.parseInt(txtCustomerID.getText());
        int maThuCung =Integer.parseInt(txtPetID.getText());     
        try {
            VisitorManagementBUS.getInstance().deleteData(maKH, maThuCung);
        } catch (SQLException ex) {
            Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Xóa thành công");    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNewActionPerformed
        // TODO add your handling code here:
//         try{
//           
//            if (Integer.parseInt(txtCustomerID.getText()) < 0) {
//                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
//                return;
//            }
//            if (Integer.parseInt(txtPetID.getText()) < 0) {
//                JOptionPane.showMessageDialog(this, "Mã khách hàng không được bé hơn 0");  
//                return;
//            }
//            if (!isValidDateTime(txtCheck_in.getText(), "yyyy-MM-dd HH:mm:ss")) {
//            JOptionPane.showMessageDialog(this, "Thời gian vào không hợp lệ");
//            return;
//            }
//            if (!isValidDateTime(txtCheck_out.getText(), "yyyy-MM-dd HH:mm:ss")) {
//                JOptionPane.showMessageDialog(this, "Thời gian ra không hợp lệ");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Mã khách hàng hoặc mã thú cưng không hợp lệ");
//        }
//        int maKH =Integer.parseInt(txtCustomerID.getText());
//        int maThuCung =Integer.parseInt(txtPetID.getText());
//        String tgVao = txtCheck_in.getText();
//        String tgRa = txtCheck_out.getText(); 
//        VisitorManagementBUS.getInstance().updateNew(tgVao, tgRa, maKH, maThuCung);
//        JOptionPane.showMessageDialog(this, "Cập nhập thành công"); 
    }//GEN-LAST:event_btnUpdateNewActionPerformed

    private void btnCheck_outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheck_outMouseClicked
        ArrayList<VeDTO> list_VeTV = VeDAO.getInstance().selectByMaKH(Integer.parseInt(txtCustomerID.getText()));
        for (VeDTO ve : list_VeTV) {
            if (ve.getIMaLoaiVe() == 1 && ve.getStrTrangThai().equals("Đang sử dụng")) 
                {
                    ve.setStrTrangThai("Đã hết hạn");
                try {
                    VeDAO.getInstance().update(ve);
                    break;
                } catch (Exception ex) {
                    Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        ArrayList<ChiTietRaVaoDTO> list_CTRV = ChiTietRaVaoDAO.getInstance().selectAll();
        for (ChiTietRaVaoDTO ctrv : list_CTRV) {
                if (ctrv.getIMaKH() == Integer.parseInt(txtCustomerID.getText()) && ctrv.getDateThoiGianRa() == null) {
                    if (getDateDiff(new java.util.Date(),ctrv.getDateThoiGianVao(),TimeUnit.SECONDS) < 30){
                        JOptionPane.showMessageDialog(this, "Thời gian ra phải lớn hơn thời gian vào ít nhất 30s");
                        return;
                    }
                    ctrv.setDateThoiGianRa(new java.util.Date());
                    try {
                        ChiTietRaVaoDAO.getInstance().update(ctrv);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Thời gian ra phải lớn hơn thời gian vào ít nhất 30s");
                        return;
                    }
                    updateTable();
                    JOptionPane.showMessageDialog(this, "Nhận thú cưng thành công");
                    return;
                }

        }
        JOptionPane.showMessageDialog(this, "Nhận thú cưng thất bại");
        updateTable();
    }//GEN-LAST:event_btnCheck_outMouseClicked

    private void btnCheck_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck_outActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheck_outActionPerformed

    private void btnCheck_inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheck_inMouseClicked

        //NguoiDungDTO nd = NguoiDungDAO.getInstance().selectUser(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY)
        //KhachHangDTO kh = KhachHangDAO.getInstance().selectById(Integer.parseInt(txtCustomerID.getText()));
        //ThuCungDTO tc = ThuCungDAO.getInstance().selectbyID(Integer.parseInt(txtPetID.getText()));
        ArrayList<VeDTO> list_VeTV = VeDAO.getInstance().selectByMaKH(Integer.parseInt(txtCustomerID.getText()));
        //Nếu khách hàng không có vé nào sẽ thông báo cho khách hàng
        if (list_VeTV.size() == 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng không có vé để gửi thú cưng, vui lòng mua vé!");
            updateTable();
            return;
        }
        for (VeDTO ve : list_VeTV) {
            if(ve.getStrTrangThai().equals("Đang sử dụng")&& isHetHan(ve.getDateNgayHetHan())){
                ve.setStrTrangThai("Đã hết hạn");
            try {
                    VeDAO.getInstance().update(ve);
                } catch (Exception ex) {
                    Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        int count = 0;
        for (VeDTO ve : list_VeTV) {
            if (ve.getStrTrangThai().equals("Đang sử dụng"))
            {
                ++count;
            }
        }
        if(count == 0){
                JOptionPane.showMessageDialog(this, "Gửi thú cưng không thành công, vui lòng kiểm tra lại xem có vé nào đang sử dụng!");
                updateTable();
                return;
        }  

       
        for (VeDTO ve : list_VeTV) {
            if (ve.getStrTrangThai().equals("Đang sử dụng")) {
                
                ChiTietRaVaoDTO ctrv = new ChiTietRaVaoDTO();
                try {
                    ctrv.setDateThoiGianVao(new Date());
                    ctrv.setDateThoiGianRa(null);
                    ctrv.setIMaKH(Integer.parseInt(txtCustomerID.getText()));
                    ctrv.setIMaThuCung(Integer.parseInt(txtPetID.getText()));
                    
                } catch (Exception ex) {
                    Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    ChiTietRaVaoDAO.getInstance().insert(ctrv.getDateThoiGianVao(), ctrv.getDateThoiGianRa(), ctrv.getIMaKH(), ctrv.getIMaThuCung());
                } catch (Exception ex) {
                    Logger.getLogger(VisitorManage.class.getName()).log(Level.SEVERE, null, ex);
                }
                updateTable();
                JOptionPane.showMessageDialog(this, "Gửi thú cưng thành công");
                return;
            }
        }
        
        updateTable();
        JOptionPane.showMessageDialog(this, "Gửi thú cưng không thành công, vui lòng kiểm tra lại thông tin vé của mình!");
    }//GEN-LAST:event_btnCheck_inMouseClicked

    private void btnCheck_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheck_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheck_inActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck_in;
    private javax.swing.JButton btnCheck_out;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchBy;
    private javax.swing.JButton btnUpdateNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane spTable;
    private PetGuardianManagement.GUI.Admin.HomepageAdmin.swing.Table tblChiTietRaVao;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtPetID;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
