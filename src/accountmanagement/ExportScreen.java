package accountmanagement;

import accountmanagement.data.Session;
import java.io.FileInputStream;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author pc
 */
public class ExportScreen extends javax.swing.JFrame {

    public static double income = 0.0;
    public static double expense = 0.0;

    public ExportScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Start Date");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("End Date");

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jDateChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jDateChooser4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Monthly Report Generate ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Export File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(278, 278, 278))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // export file button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // I created JFileChooer object to save file to folders
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Report File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(filter);
        // I prefered .txt file for report extention
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = chooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    filePath += ".txt";
                }

                Properties properties = new Properties();
                String currentDirectory = System.getProperty("user.dir");
                FileInputStream input = new FileInputStream(currentDirectory + "\\src\\accountmanagement\\config.properties");
                properties.load(input);

                String url = properties.getProperty("db.url");
                String DBusername = properties.getProperty("db.username");
                String DBpassword = properties.getProperty("db.password");

                Date startDate = jDateChooser1.getDate();
                Date endDate = jDateChooser4.getDate();
                // I calculated  between the 2 different date interval for report 
                String email = Session.CurrentUser.getEmail();
                int userID = Dashboard.getUserIdFromEmail(email);
                String query = "SELECT type, amount, currency FROM transactions WHERE date BETWEEN ? AND ? AND user_id = ? ";
                 
                try (Connection conn = DriverManager.getConnection(url, DBusername, DBpassword); PreparedStatement pstmt = conn.prepareStatement(query)) {

                    pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
                    pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
                    pstmt.setInt(3, userID);
                    ResultSet rs = pstmt.executeQuery();
                    // report header
                    StringBuilder reportContent = new StringBuilder();
                    reportContent.append("Monthly Report\n")
                            .append("Start Date: ").append(startDate).append("\n")
                            .append("End Date: ").append(endDate).append("\n\n");

                    String type = "";
                    int amount = 0;
                    String currency = "";

                    while (rs.next()) {
                        amount = rs.getInt("amount");
                        type = rs.getString("type");
                        currency = rs.getString("currency");
                        // my radio buttons and api provider represent different curreny names I write a converter.
                        // like euro to eur  
                        String currencyCode = normalizeCurrencyCode(currency);

                        try {
                            double convertedAmount = amount;

                            if (!currencyCode.equals("tl")) {
                                double exchange = getExchangeRate(currencyCode);
                                convertedAmount = exchange * amount;
                            }
                            // if transaction type income accumulated under income 
                            if (type.equalsIgnoreCase("income")) {
                                income += convertedAmount;
                                // if transaction type income accumulated under expense 
                            } else if (type.equalsIgnoreCase("expense")) {
                                expense += convertedAmount;
                            }

                        } catch (Exception e) {
                            System.out.println("While fetching caused a problem: " + currency + " -> " + e.getMessage());

                            if (type.equalsIgnoreCase("income")) {
                                income += amount;
                            } else if (type.equalsIgnoreCase("expense")) {
                                expense += amount;
                            }
                        }
                        // I saved to file as text format these information.
                        reportContent.append("Type: ").append(type)
                                .append(" | Amount: ").append(amount)
                                .append(" ").append(currency)
                                .append(" (≈ ").append(String.format("%.2f", income - expense)).append(" TL)")
                                .append("\n");
                    }
                    reportContent.append("---------------------------------------------------\n");
                    reportContent
                            .append("Total Amount: ").append(String.format("%.2f", income - expense))
                            .append(" (≈ ").append(" TL)")
                            .append("\n");

                    java.nio.file.Files.write(java.nio.file.Paths.get(filePath), reportContent.toString().getBytes());
                    JOptionPane.showMessageDialog(this, "Report exported successfully.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error exporting file: " + ex.getMessage());
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExportScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExportScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ChartScreen cs = new ChartScreen();
        this.dispose();
        cs.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportScreen().setVisible(true);
            }
        });
    }
    // I fetched exchange values from  "https://doviz.dev" interactively via a WebAPI
    // to fetch also intalled called json.jar into project. I have done  GET request from service provide
    // per currency then I reflected them to calculations.

    public double getExchangeRate(String currencyCode) throws Exception {
        String url = "https://doviz.dev/v1/" + currencyCode.toLowerCase() + ".json";
        HttpURLConnection con = null;
        BufferedReader reader = null;

        try {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JSONObject jsonObj = new JSONObject(response.toString());

            String key = currencyCode.toUpperCase() + "TRY";
            if (jsonObj.has(key)) {
                return jsonObj.getDouble(key);
            } else {
                throw new Exception("Not found exchaned pair: " + key);
            }

        } catch (Exception e) {
            throw new Exception("Can not received currency value: " + currencyCode);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static String normalizeCurrencyCode(String dbCurrency) {
        return switch (dbCurrency.toUpperCase()) {
            case "EURO" ->
                "eur";
            case "EUR" ->
                "eur";
            case "USD" ->
                "usd";
            default ->
                "tl";
        };
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
