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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Task2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 400);
            JPanel panel = new JPanel();
            frame.add(panel);
            panel.setLayout(new GridLayout(5, 4));
            JTextField textField = new JTextField();
            panel.add(textField);
            String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
            };
            for (String label : buttonLabels) {
                JButton button = new JButton(label);
                panel.add(button);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        if (command.equals("C")) {
                            textField.setText("");
                        } else if (command.equals("=")) {
                            try {
                                String expression = textField.getText();
                                double result = operations(expression);
                                textField.setText(String.valueOf(result));
                            } catch (Exception ex) {
                                textField.setText("Error");
                            }
                        } else {
                            textField.setText(textField.getText() + command);
                        }
                    }
                });
            }
            frame.setVisible(true);
        });
    }
    public static double operations(String expression) throws Exception {
    String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
    double result = Double.parseDouble(tokens[0]);
    for (int i = 1; i < tokens.length; i += 2) {
        String operator = tokens[i];
        double operand = Double.parseDouble(tokens[i + 1]);
        switch (operator) {
            case "+":
                result += operand;
                break;
            case "-":
                result -= operand;
                break;
            case "*":
                result *= operand;
                break;
            case "/":
                result /= operand;
                break;
        }
    }
    return result;
}
}

