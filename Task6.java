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
public class Task6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Color Palette");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            JPanel panel = new JPanel();
            frame.add(panel);
            JPanel colorPanel = new JPanel();
            colorPanel.setPreferredSize(new Dimension(100, 100));
            panel.add(colorPanel);
            JPanel palettePanel = new JPanel(new GridLayout(3, 3));
            panel.add(palettePanel);
            Color[] colors = {
                Color.RED, Color.BLACK, Color.CYAN,
                Color.yellow, Color.ORANGE, Color.GREEN,
                Color.WHITE, Color.pink, Color.blue
            };
            for (Color color : colors) {
                JButton colorButton = new JButton();
                colorButton.setBackground(color);
                colorButton.setPreferredSize(new Dimension(50, 50));
                palettePanel.add(colorButton);
                colorButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        colorPanel.setBackground(color);
                    }
                });
            }
            frame.setVisible(true);
        });
    }
}