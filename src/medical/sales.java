package medical;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class sales extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtname;
    private JTextField txtQuantity;
    private JTextField txttotalbill;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtsaleDate;
    private JTextField txtPricePerUnit;
    private double totalBill = 0.0;

    public sales() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 694);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("New Sales");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(262, 11, 160, 34);
        contentPane.add(lblNewLabel);

        JLabel txtproductName = new JLabel("Product Name");
        txtproductName.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtproductName.setBounds(117, 72, 131, 14);
        contentPane.add(txtproductName);

        JLabel txtquantity = new JLabel("Enter Quantity");
        txtquantity.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtquantity.setBounds(117, 107, 131, 14);
        contentPane.add(txtquantity);

        JLabel txtxDate = new JLabel("Date");
        txtxDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtxDate.setBounds(117, 144, 49, 14);
        contentPane.add(txtxDate);

        JLabel lblPricePerUnit = new JLabel("Price per Unit");
        lblPricePerUnit.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPricePerUnit.setBounds(117, 181, 100, 14);
        contentPane.add(lblPricePerUnit);

        txtname = new JTextField();
        txtname.setBounds(366, 71, 211, 20);
        contentPane.add(txtname);
        txtname.setColumns(10);

        txtQuantity = new JTextField();
        txtQuantity.setColumns(10);
        txtQuantity.setBounds(366, 106, 211, 20);
        contentPane.add(txtQuantity);

        txtsaleDate = new JTextField();
        txtsaleDate.setColumns(10);
        txtsaleDate.setBounds(366, 143, 211, 20);
        contentPane.add(txtsaleDate);

        txtPricePerUnit = new JTextField();
        txtPricePerUnit.setColumns(10);
        txtPricePerUnit.setBounds(366, 180, 211, 20);
        contentPane.add(txtPricePerUnit);

        JButton btnAddtocart = new JButton("Add to Cart");
        btnAddtocart.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAddtocart.setBounds(423, 215, 154, 23);
        contentPane.add(btnAddtocart);

        JButton btnDone = new JButton("Done");
        btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDone.setBounds(423, 249, 154, 23);
        contentPane.add(btnDone);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(423, 283, 154, 23);
        contentPane.add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBounds(423, 317, 154, 23);
        contentPane.add(btnBack);

        JLabel lblTotalBill = new JLabel("Total Bill:");
        lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTotalBill.setBounds(225, 521, 131, 14);
        contentPane.add(lblTotalBill);

        txttotalbill = new JTextField();
        txttotalbill.setEditable(false); // Total bill field should be read-only
        txttotalbill.setColumns(10);
        txttotalbill.setBounds(366, 520, 211, 20);
        contentPane.add(txttotalbill);

        String[] columnNames = { "Product Name", "Date of Sale", "Quantity", "Price per Unit", "Total" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(69, 348, 508, 150);
        contentPane.add(scrollPane);

        // Add to Cart button action listener
        btnAddtocart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = txtname.getText();
                String quantityStr = txtQuantity.getText();
                String date = txtsaleDate.getText();
                String pricePerUnitStr = txtPricePerUnit.getText();

                // Validate input
                if (productName.isEmpty() || quantityStr.isEmpty() || date.isEmpty() || pricePerUnitStr.isEmpty()) {
                    // Show an error message if any field is empty
                    // This should ideally be handled with more user-friendly feedback (dialogs, etc.)
                    System.out.println("Please fill all fields");
                    return;
                }

                // Parse quantity and price per unit
                int quantity = Integer.parseInt(quantityStr);
                double pricePerUnit = Double.parseDouble(pricePerUnitStr);
                double totalPrice = quantity * pricePerUnit;

                // Add row to the table model
                tableModel.addRow(new Object[] { productName, date, quantity, pricePerUnit, totalPrice });

                // Update total bill
                totalBill += totalPrice;
                txttotalbill.setText(String.valueOf(totalBill));

                // Clear input fields
                txtname.setText("");
                txtQuantity.setText("");
                txtsaleDate.setText("");
                txtPricePerUnit.setText("");
            }
        });

        // Delete button action listener
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    double deletedTotal = (double) tableModel.getValueAt(selectedRow, 4);
                    tableModel.removeRow(selectedRow);
                    totalBill -= deletedTotal;
                    txttotalbill.setText(String.valueOf(totalBill));
                }
            }
        });

        // Done button action listener
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Write data to file
                writeSalesToFile();

                // Clear all fields and reset total bill
                tableModel.setRowCount(0); // Clear all rows
                totalBill = 0.0;
                txttotalbill.setText("");
            }
        });

        // Back button action listener
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new home().setVisible(true);
                dispose();
            }
        });
    }

    // Method to write sales data to a file
    private void writeSalesToFile() {
        BufferedWriter writer = null;
        try {
            File file = new File("sales_data.txt");
            writer = new BufferedWriter(new FileWriter(file, true)); // Append mode

            // Iterate through the table rows
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    sb.append(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("\n");
                writer.write(sb.toString());
            }

            System.out.println("Sales data written to file successfully.");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
