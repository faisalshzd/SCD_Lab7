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
import java.util.ArrayList;
import java.util.List;
public class Task10 {
     private static int selectedDay = 0;
    private static List<Event> events = new ArrayList<>();
    private static JButton[] dayButtons = new JButton[42];
    private static JTextArea eventTextArea;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Monthly Calendar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            JPanel panel = new JPanel(new BorderLayout());
            frame.add(panel);
            JPanel calendarPanel = new JPanel(new GridLayout(7, 7));
            panel.add(calendarPanel, BorderLayout.CENTER);
            for (int i = 1; i < 31; i++) {
                dayButtons[i] = new JButton(String.valueOf(i));
                calendarPanel.add(dayButtons[i]);
                final int day = i + 1;
                dayButtons[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        selectedDay = day;
                        updateEventTextArea();
                        if (day > 0 && day <= 31) {
                            selectedDay = day-1;
                            showEventDialog();
                        }
                    }
                });
            }
            JPanel navPanel = new JPanel(new FlowLayout());
            panel.add(navPanel, BorderLayout.NORTH);
            JButton prevButton = new JButton("Previous");
            JButton nextButton = new JButton("Next");
            navPanel.add(prevButton);
            navPanel.add(nextButton);
            prevButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            eventTextArea = new JTextArea(5, 20);
            JScrollPane scrollPane = new JScrollPane(eventTextArea);
            panel.add(scrollPane, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
    private static void updateEventTextArea() {
        eventTextArea.setText("Events for " + selectedDay + ":\n");
        for (Event event : events) {
            if (event.getDay() == selectedDay) {
                eventTextArea.append(event.getDescription() + "\n");
            }
        }
    }
   private static void showEventDialog() {
        JFrame eventFrame = new JFrame("Events for " + selectedDay);
        eventFrame.setSize(300, 200);
        JPanel eventPanel = new JPanel(new BorderLayout());
        eventFrame.add(eventPanel);
        JTextArea eventTextArea = new JTextArea();
        eventPanel.add(eventTextArea, BorderLayout.CENTER);
        JButton saveButton = new JButton("Save Event");
        eventPanel.add(saveButton, BorderLayout.SOUTH);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String event = eventTextArea.getText();
                if (!event.isEmpty()) {
                    events.add(new Event(selectedDay, event));
                    eventFrame.dispose();
                }
            }
        });
        eventFrame.setVisible(true);
    }
}
class Event {
    private int day;
    private String description;
    public Event(int day, String description) {
        this.day = day;
        this.description = description;
    }
    public int getDay() {
        return day;
    }
    public String getDescription() {
        return description;
    }
}