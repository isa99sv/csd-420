package FanDatabase;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;


/* Colton Stone, May 17, 2026, Module 10.2 Assignment

In this program I will write a program which updates a database's information and uses two buttons to display or update the records*/


public class Main extends JFrame {

    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JButton displayButton;
    private JButton updateButton;
    private JTextField fNameField;
    private JTextField lNameField;
    private JTextField fTeamField;
    private static final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASS = "pass";


    public Main() {
        setTitle("JDBC Team Window");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("First Name:"));
        fNameField = new JTextField();
        inputPanel.add(fNameField);

        inputPanel.add(new JLabel("Last Name:"));
        lNameField = new JTextField();
        inputPanel.add(lNameField);

        inputPanel.add(new JLabel("Favorite Team:"));
        fTeamField = new JTextField();
        inputPanel.add(fTeamField);

        add(inputPanel, BorderLayout.NORTH);

        String[] columnNames = {"ID", "firstname", "lastname", "favoriteteam"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        displayButton = new JButton("Display Data");
        updateButton = new JButton("Update Data");

        buttonPanel.add(displayButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayData();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });
    }

    private void insertData() {
        String firstName = fNameField.getText().trim();
        String lastName = lNameField.getText().trim();
        String favoriteteam  = fTeamField.getText().trim();


        String query = "INSERT INTO teams (firstname, lastname, favoriteteam) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, favoriteteam);


            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted successfully!");

                fNameField.setText("");
                lNameField.setText("");
                fTeamField.setText("");

                DisplayData();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void DisplayData() {
        tableModel.setRowCount(0);
        String query = "SELECT ID, firstname, lastname, favoriteteam FROM teams";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String fName = rs.getString("firstname");
                String lName = rs.getString("lastname");
                String fTeam = rs.getString("favoriteteam ");


                Object[] rowData = {id, fName, lName, fTeam};
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Grabbing Data Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}



