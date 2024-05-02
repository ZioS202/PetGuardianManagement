/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.GUI.Admin.HomepageAdmin.swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DucTran
 */
public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                if (isSelected) {
                    com.setForeground(new Color(15, 89, 140));
                } else {
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
            }
        });
    }

    public void selectRow(String maSach) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(maSach)) {
                clearSelection();
                setRowSelectionInterval(i, i);
            }
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

//    public int removeRow(String maSachToDelete) {
//        DefaultTableModel model = (DefaultTableModel) getModel();
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (model.getValueAt(i, 0).equals(maSachToDelete)) {
//                model.removeRow(i);
//                return 1;
//            }
//        }
//        return 0;
//    }
//    public int updateRow(SachDTO data) {
//        DefaultTableModel model = (DefaultTableModel) getModel();
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (model.getValueAt(i, 0).equals(data.getMaSach())) {
//                model.setValueAt(data.getTenSach(), i, 1);
//                model.setValueAt(data.getTacGia(), i, 2);
//                model.setValueAt(data.getNxb(), i, 3);
//                model.setValueAt(QuanLySach.CurrencyFormat(data.getGia()), i, 4);
//                return 1;
//            }
//        }
//        return 0;
//    }
//    public void clearAllRows() {
//        DefaultTableModel model = (DefaultTableModel) getModel();
//        model.setRowCount(0);
//    }
}
