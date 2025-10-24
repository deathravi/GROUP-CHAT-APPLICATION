import java.sql.*;
public class ViewMessages {
    public static void main(String[] args) {
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:sqlite:chat.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages ORDER BY id");
            System.out.println("=== DATABASE CONTENTS ===");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") + 
                    " | Time: " + rs.getString("time") + 
                    " | From: " + rs.getString("sender") + 
                    " | Message: " + rs.getString("message")
                );
            }
            if(!rs.isBeforeFirst()) {
                System.out.println("No messages found.");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
