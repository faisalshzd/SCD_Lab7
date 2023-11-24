/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author fast
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Task8 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            JPanel panel = new JPanel();
            frame.add(panel);
            panel.setLayout(new GridLayout(3, 2));
            JLabel usernameLabel = new JLabel("Username:");
            JTextField usernameField = new JTextField();
            JLabel passwordLabel = new JLabel("Password:");
            JPasswordField passwordField = new JPasswordField();
            JButton loginButton = new JButton("Login");
            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            // Empty label for spacing
            panel.add(new JLabel()); 
            panel.add(loginButton);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    char[] password = passwordField.getPassword();
                    // Check for authentication
                    if (authenticate(username, new String(password))) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Login Failed. Please check your credentials.");
                    }
                    // Clear the fields after the login attempt
                    usernameField.setText("");
                    passwordField.setText("");
                }
            });
            frame.setVisible(true);
        });
    }
    private static boolean authenticate(String username, String password) {
       //can change any other for authentication
        return username.equals("faisal") && password.equals("cr7");
    }
}