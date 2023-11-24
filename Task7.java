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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
public class Task7 {
      private static enum ShapeType { LINE, RECTANGLE, ELLIPSE }
    private static ShapeType currentShape = ShapeType.LINE;
    private static Point startPoint = null;
    private static Point endPoint = null;
    private static JPanel canvas;
    private static List<Shape> shapes = new ArrayList<>();
    private static List<Color> shapeColors = new ArrayList<>();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Drawing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            canvas = new JPanel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    for (int i = 0; i < shapes.size(); i++) {
                        g2d.setColor(shapeColors.get(i));
                        g2d.draw(shapes.get(i));
                    }
                }
            };
            canvas.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startPoint = e.getPoint();
                    endPoint = startPoint;
                    canvas.repaint();
                }
                public void mouseReleased(MouseEvent e) {
                    if (startPoint != null) {
                        endPoint = e.getPoint();
                        drawShape();
                        canvas.repaint();
                    }
                }
            });
            canvas.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    if (startPoint != null) {
                        endPoint = e.getPoint();
                        canvas.repaint();
                    }
                }
            });
            frame.add(canvas, BorderLayout.CENTER);
            JPanel tools = new JPanel();
            frame.add(tools, BorderLayout.NORTH);
            ButtonGroup shapeGroup = new ButtonGroup();
            JRadioButton lineButton = new JRadioButton("Line");
            JRadioButton rectangleButton = new JRadioButton("Rectangle");
            JRadioButton ellipseButton = new JRadioButton("Ellipse");
            shapeGroup.add(lineButton);
            shapeGroup.add(rectangleButton);
            shapeGroup.add(ellipseButton);
            tools.add(lineButton);
            tools.add(rectangleButton);
            tools.add(ellipseButton);
            lineButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentShape = ShapeType.LINE;
                }
            });
            rectangleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentShape = ShapeType.RECTANGLE;
                }
            });
            ellipseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentShape = ShapeType.ELLIPSE;
                }
            });
            frame.setVisible(true);
        });
    }
    private static void drawShape() {
        if (startPoint != null && endPoint != null) {
            Shape shape = null;
            switch (currentShape) {
                case LINE:
                    shape = new Line2D.Double(startPoint, endPoint);
                    break;
                case RECTANGLE:
                    shape = new Rectangle2D.Double(
                            Math.min(startPoint.getX(), endPoint.getX()),
                            Math.min(startPoint.getY(), endPoint.getY()),
                            Math.abs(startPoint.getX() - endPoint.getX()),
                            Math.abs(startPoint.getY() - endPoint.getY())
                    );
                    break;
                case ELLIPSE:
                    shape = new Ellipse2D.Double(
                            Math.min(startPoint.getX(), endPoint.getX()),
                            Math.min(startPoint.getY(), endPoint.getY()),
                            Math.abs(startPoint.getX() - endPoint.getX()),
                            Math.abs(startPoint.getY() - endPoint.getY())
                    );
                    break;
            }
            if (shape != null) {
                shapes.add(shape);
                shapeColors.add(Color.BLACK); // You can change the color as desired.
                startPoint = null;
                endPoint = null;
            }
        }
    }
}