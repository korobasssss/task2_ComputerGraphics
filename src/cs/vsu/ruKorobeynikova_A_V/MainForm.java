package cs.vsu.ruKorobeynikova_A_V;

import cs.vsu.ruKorobeynikova_A_V.figures.Rectangle;
import cs.vsu.ruKorobeynikova_A_V.transformations.Rotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame{
    private JPanel panelMain;
    private JTextField textFieldScale;
    private JTextField textFieldRotate;
    private JTextField textFieldCompression;
    private JButton buttonClean;
    private JButton buttonScale;
    private JButton buttonRotate;
    private JButton buttonCompression;
    private JButton buttonTransfer;
    private JPanel menuPanel;
    private JPanel fieldPanel;
    private JTextField textFieldTransferX;
    private JTextField textFieldTransferY;


    List<int[]> points = new ArrayList<>();

    public MainForm() {
        this.setTitle("Affine transformations");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(new Dimension(1300,740));
        fieldPanel.setSize(700, 700);

        points.add(new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
        points.add(new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2 - 100, 1});
        points.add(new int[]{fieldPanel.getWidth() / 2 + 150, fieldPanel.getHeight() / 2 - 100, 1});
        points.add(new int[]{fieldPanel.getWidth() / 2 + 150, fieldPanel.getHeight() / 2, 1});

        buttonRotate.addActionListener(e -> {
            Rotate rotate = new Rotate(Integer.parseInt(textFieldRotate.getText()));
            rotate.rotateFigure(points);

            fieldPanel.repaint();
        });

        buttonClean.addActionListener(e -> {
            points.set(0, new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
            points.set(0, new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
            points.set(0, new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
            points.set(0, new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
            fieldPanel.repaint();
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        fieldPanel = new DrawField();
    }


    class DrawField extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            drawOxAndOy(g2);
            g2.setStroke(new BasicStroke(4));


            g2.setColor(Color.black);
            drawRectangle(g2, points);
            repaint();
        }

        public void drawOxAndOy(Graphics2D g2) {
            //рисуем систему координат (оси оХ и оУ)
            int w = fieldPanel.getWidth();
            int h =fieldPanel.getHeight();
            g2.setColor(Color.blue);
            g2.drawLine(fieldPanel.getWidth() / 2, 0, fieldPanel.getWidth() / 2, fieldPanel.getHeight());
            g2.drawLine(0, fieldPanel.getHeight() / 2, fieldPanel.getWidth(), fieldPanel.getHeight() / 2);
        }

        public void drawRectangle(Graphics2D g2, List<int[]> points) {
            Rectangle rect = new Rectangle(points);
            for (int row = 0; row < points.size() - 1; row++){
                g2.drawLine(rect.getPoints().get(row)[0], rect.getPoints().get(row)[1], rect.getPoints().get(row + 1)[0], rect.getPoints().get(row + 1)[1]);
            }
            g2.drawLine(rect.getPoints().get(points.size() - 1)[0], rect.getPoints().get(points.size() - 1)[1], rect.getPoints().get(0)[0], rect.getPoints().get(0)[1]);
        }
    }
}
