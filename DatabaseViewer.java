import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DatabaseViewer extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    
    public DatabaseViewer() {
        setTitle("Chat Database Viewer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        // Create table model with columns
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Time");
        model.addColumn("Sender");
        model.addColumn("Message");
        
        table = new JTable(model);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setRowHeight(25);
        
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Add refresh button
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> loadData());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Load data initially
        loadData();
    }
    
    private void loadData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:chat.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages ORDER BY id");
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("time"),
                    rs.getString("sender"),
                    rs.getString("message")
                });
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
            // Show message if no data
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No messages found in database.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default (CORRECTED)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new DatabaseViewer().setVisible(true);
        });
    }
}