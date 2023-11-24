/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Task1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button Clicker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            JPanel panel = new JPanel();
            frame.add(panel);
            JButton button = new JButton("Click Here");
            JLabel label = new JLabel("Click count: 0");
            int[] clickCount = {0};
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickCount[0]++;
                    label.setText("Click count: " + clickCount[0]);
                }
            });
            panel.add(button);
            panel.add(label);
            frame.setVisible(true);
        });
    }
}