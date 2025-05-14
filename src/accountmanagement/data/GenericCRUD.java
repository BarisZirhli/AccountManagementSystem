package accountmanagement.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Generic class for database CRUD operations
public class GenericCRUD<T> {
    private static final Logger LOGGER = Logger.getLogger(GenericCRUD.class.getName());
    
    private String url;
    private String DBusername;
    private String DBpassword;
    
    public GenericCRUD() {
        loadProperties();
    }
    // loads connection informations from properties file
    private void loadProperties() {
        Properties properties = new Properties();
        String currentDirectory = System.getProperty("user.dir");
        
        try (FileInputStream input = new FileInputStream(currentDirectory + "\\src\\accountmanagement\\config.properties")) {
            // Load the properties from the input stream
            properties.load(input);
            
            // Extract database connection details from properties
            url = properties.getProperty("db.url");
            DBusername = properties.getProperty("db.username");
            DBpassword = properties.getProperty("db.password");
            
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load database properties", e);
        }
    }
    // it makes connection to database (postgresql)
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, DBusername, DBpassword);
    }
    // it is generic insertion method for any table
    public void insert(String table, Map<String, Object> data) throws SQLException {
        String columns = String.join(", ", data.keySet());
        String values = String.join(", ", Collections.nCopies(data.size(), "?"));
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
        
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int index = 1;
            for (Object value : data.values()) {
                stmt.setObject(index++, value);
            }
            stmt.executeUpdate();
        }
    }
    // it is generic selection method for any table
    public List<Map<String, Object>> readAll(String table) throws SQLException {
        String sql = "SELECT * FROM " + table;
        
        try (Connection conn = connect(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            
            List<Map<String, Object>> resultList = new ArrayList<>();
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(meta.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }
            
            return resultList;
        }
    }
    // it is generic updating method for any table
    public void update(String table, Map<String, Object> data, String conditionColumn, Object conditionValue) throws SQLException {
        StringBuilder setClause = new StringBuilder();
        data.forEach((key, value) -> setClause.append(key).append("=?, "));
        String sql = "UPDATE " + table + " SET "
                + setClause.substring(0, setClause.length() - 2)
                + " WHERE " + conditionColumn + "=?";
        
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            int index = 1;
            for (Object value : data.values()) {
                stmt.setObject(index++, value);
            }
            stmt.setObject(index, conditionValue);
            stmt.executeUpdate();
        }
    }
    // it is generic deleting method for any table
    public void delete(String table, String conditionColumn, Object conditionValue) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE " + conditionColumn + "=?";
        
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, conditionValue);
            stmt.executeUpdate();
        }
    }
}