import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDB {
    private static final String DB_URL = "jdbc:sqlite:chat.db";
    
    public static void setupDatabase() {
        System.out.println("Setting up simple database...");
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            
            // Create messages table
            String sql = "CREATE TABLE IF NOT EXISTS messages (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "sender TEXT, " +
                         "message TEXT, " +
                         "time TEXT)";
            
            stmt.execute(sql);
            stmt.close();
            conn.close();
            System.out.println("✓ Database ready!");
        } catch (Exception e) {
            System.out.println("Database setup error: " + e.getMessage());
        }
    }
    
    public static void saveMessage(String sender, String message) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String sql = "INSERT INTO messages(sender, message, time) VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Get current time
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sdf.format(new Date());
            
            pstmt.setString(1, sender);
            pstmt.setString(2, message);
            pstmt.setString(3, currentTime);
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            System.out.println("✓ Saved to DB: " + sender + " - " + message);
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }
    
    public static void showMessages() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");
            
            System.out.println("=== Chat History ===");
            while (rs.next()) {
                System.out.println(rs.getString("time") + " - " + 
                                 rs.getString("sender") + ": " + 
                                 rs.getString("message"));
            }
            System.out.println("====================");
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}