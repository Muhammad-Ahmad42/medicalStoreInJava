package medical;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class medicine extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtProductId;
    private JTextField txtProductName;
    private JTextField txtCompanyName;
    private JTextField txtCategory;
    private JTextField txtQuantity;
    private JTextField txtPricePerUnit;
    private JTextField txtSellDate;
    private JTextField txtSearch;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String DATA_FILE = "medicines.txt";

    public medicine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1180, 731);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Medicine Info");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(375, 11, 152, 61);
        contentPane.add(lblNewLabel_1);

        // Insert Medicine Button
        JButton btnInsertMedicine = new JButton("Insert Medicine");
        btnInsertMedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnInsertMedicine.setBounds(33, 246, 152, 37);
        contentPane.add(btnInsertMedicine);

        // Update Medicine Button
        JButton btnUpdateMedicine = new JButton("Update Medicine");
        btnUpdateMedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdateMedicine.setBounds(33, 332, 152, 37);
        contentPane.add(btnUpdateMedicine);

        // Delete Medicine Button
        JButton btnDeleteMedicine = new JButton("Delete Medicine");
        btnDeleteMedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDeleteMedicine.setBounds(33, 412, 152, 37);
        contentPane.add(btnDeleteMedicine);

        // Back Button
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new home().setVisible(true);
                dispose();
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBack.setBounds(33, 488, 152, 37);
        contentPane.add(btnBack);

        // Search Medicine TextField
        txtSearch = new JTextField();
        txtSearch.setBounds(203, 170, 391, 25);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        // Search Medicine Button
        JButton btnSearchMedicine = new JButton("Search");
        btnSearchMedicine.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSearchMedicine.setBounds(615, 169, 152, 24);
        contentPane.add(btnSearchMedicine);

        // Table setup
        String[] columnNames = { "Product ID", "Product Name", "Company Name", "Category", "Quantity", "Price per Unit", "Sell Date" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(203, 246, 640, 279);
        contentPane.add(scrollPane);

        // Product ID TextField
        JLabel lblProductId = new JLabel("Product ID:");
        lblProductId.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProductId.setBounds(33, 80, 100, 25);
        contentPane.add(lblProductId);
        txtProductId = new JTextField();
        txtProductId.setBounds(120, 80, 150, 25);
        contentPane.add(txtProductId);

        // Product Name TextField
        JLabel lblProductName = new JLabel("Product Name:");
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProductName.setBounds(280, 80, 100, 25);
        contentPane.add(lblProductName);
        txtProductName = new JTextField();
        txtProductName.setBounds(380, 80, 150, 25);
        contentPane.add(txtProductName);

        // Company Name TextField
        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCompanyName.setBounds(540, 80, 110, 25);
        contentPane.add(lblCompanyName);
        txtCompanyName = new JTextField();
        txtCompanyName.setBounds(650, 80, 150, 25);
        contentPane.add(txtCompanyName);

        // Category TextField
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCategory.setBounds(810, 80, 100, 25);
        contentPane.add(lblCategory);
        txtCategory = new JTextField();
        txtCategory.setBounds(880, 80, 150, 25);
        contentPane.add(txtCategory);

        // Quantity TextField
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblQuantity.setBounds(33, 110, 100, 25);
        contentPane.add(lblQuantity);
        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 110, 150, 25);
        contentPane.add(txtQuantity);

        // Price per Unit TextField
        JLabel lblPricePerUnit = new JLabel("Price per Unit:");
        lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPricePerUnit.setBounds(280, 110, 100, 25);
        contentPane.add(lblPricePerUnit);
        txtPricePerUnit = new JTextField();
        txtPricePerUnit.setBounds(380, 110, 150, 25);
        contentPane.add(txtPricePerUnit);

        // Sell Date TextField
        JLabel lblSellDate = new JLabel("Sell Date (YYYY-MM-DD):");
        lblSellDate.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSellDate.setBounds(540, 110, 150, 25);
        contentPane.add(lblSellDate);
        txtSellDate = new JTextField();
        txtSellDate.setBounds(690, 110, 110, 25);
        contentPane.add(txtSellDate);

        // ActionListener for Insert Medicine Button
        btnInsertMedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productID = txtProductId.getText();
                String productName = txtProductName.getText();
                String companyName = txtCompanyName.getText();
                String category = txtCategory.getText();
                String quantity = txtQuantity.getText();
                String pricePerUnit = txtPricePerUnit.getText();
                String sellDate = txtSellDate.getText();

                // Validate sell date format
                if (!isValidDateFormat(sellDate)) {
                    JOptionPane.showMessageDialog(null, "Invalid Sell Date format! Use YYYY-MM-DD.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if Product ID already exists
                if (isProductIDExists(productID)) {
                    JOptionPane.showMessageDialog(null, "Product ID already exists!", "Duplicate Product ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Add the record to the table
                tableModel.addRow(new Object[]{productID, productName, companyName, category, quantity, pricePerUnit, sellDate});

                // Write the record to the file
                writeToFile(productID, productName, companyName, category, quantity, pricePerUnit, sellDate);

                // Clear the input fields
                clearInputFields();
            }
        });

        btnUpdateMedicine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String productID = txtProductId.getText();
            String productName = txtProductName.getText();
            String companyName = txtCompanyName.getText();
            String category = txtCategory.getText();
            String quantity = txtQuantity.getText();
            String pricePerUnit = txtPricePerUnit.getText();
            String sellDate = txtSellDate.getText();

            // Validate sell date format
            if (!isValidDateFormat(sellDate)) {
                JOptionPane.showMessageDialog(null, "Invalid Sell Date format! Use YYYY-MM-DD.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the record in the table
            tableModel.setValueAt(productID, selectedRow, 0);
            tableModel.setValueAt(productName, selectedRow, 1);
            tableModel.setValueAt(companyName, selectedRow, 2);
            tableModel.setValueAt(category, selectedRow, 3);
            tableModel.setValueAt(quantity, selectedRow, 4);
            tableModel.setValueAt(pricePerUnit, selectedRow, 5);
            tableModel.setValueAt(sellDate, selectedRow, 6);

            // Update the record in the file
            updateFile();
        }
    }
});

// ActionListener for Delete Medicine Button
btnDeleteMedicine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            updateFile();
        }
    }
});

// ActionListener for Search Medicine Button
btnSearchMedicine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String searchText = txtSearch.getText().trim().toLowerCase();
        tableModel.setRowCount(0); // Clear the table before search

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Check if any field contains the search text
                boolean found = false;
                for (String field : data) {
                    if (field.toLowerCase().contains(searchText)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    tableModel.addRow(data);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});

// Load data from file on startup
loadDataFromFile();
}

// Method to check if Product ID already exists
private boolean isProductIDExists(String productID) {
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (productID.equals(tableModel.getValueAt(i, 0))) {
            return true;
        }
    }
    return false;
}

// Method to write data to file
private void writeToFile(String productID, String productName, String companyName, String category, String quantity, String pricePerUnit, String sellDate) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
        writer.write(productID + "," + productName + "," + companyName + "," + category + "," + quantity + "," + pricePerUnit + "," + sellDate);
        writer.newLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// Method to update data in the file
private void updateFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                writer.write(tableModel.getValueAt(i, j).toString());
                if (j < tableModel.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// Method to clear input fields
private void clearInputFields() {
    txtProductId.setText("");
    txtProductName.setText("");
    txtCompanyName.setText("");
    txtCategory.setText("");
    txtQuantity.setText("");
    txtPricePerUnit.setText("");
    txtSellDate.setText("");
}

// Method to load data from file on startup
private void loadDataFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            tableModel.addRow(data);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// Method to validate sell date format (YYYY-MM-DD)
private boolean isValidDateFormat(String date) {
    String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
    return date.matches(dateFormat);
}

}
