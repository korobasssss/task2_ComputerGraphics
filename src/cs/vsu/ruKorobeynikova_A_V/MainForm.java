package cs.vsu.ruKorobeynikova_A_V;

import cs.vsu.ruKorobeynikova_A_V.figures.Rectangle;
import cs.vsu.ruKorobeynikova_A_V.transformations.Move;
import cs.vsu.ruKorobeynikova_A_V.transformations.Rotate;
import cs.vsu.ruKorobeynikova_A_V.transformations.Scaling;
import cs.vsu.ruKorobeynikova_A_V.transformations.Stretch;

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
    private JButton buttonClean;
    private JButton buttonScale;
    private JButton buttonRotate;
    private JButton buttonStretch;
    private JButton buttonTransfer;
    private JPanel menuPanel;
    private JPanel fieldPanel;
    private JTextField textFieldTransferX;
    private JTextField textFieldTransferY;
    private JTextField textFieldStretchX;
    private JTextField textFieldStretchY;
    private JButton buttonDoingAllWhatThereIs;


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
            points.clear();
            points.add(new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2, 1});
            points.add(new int[]{fieldPanel.getWidth() / 2, fieldPanel.getHeight() / 2 - 100, 1});
            points.add(new int[]{fieldPanel.getWidth() / 2 + 150, fieldPanel.getHeight() / 2 - 100, 1});
            points.add(new int[]{fieldPanel.getWidth() / 2 + 150, fieldPanel.getHeight() / 2, 1});
            fieldPanel.repaint();
        });

        buttonScale.addActionListener(e -> {
            Scaling scale = new Scaling(Double.parseDouble(textFieldScale.getText()), Double.parseDouble(textFieldScale.getText()));
            scale.scalingFigure(points);

            fieldPanel.repaint();
        });

        buttonStretch.addActionListener(e -> {
            Stretch stretch = new Stretch(Double.parseDouble(textFieldStretchX.getText()), Double.parseDouble(textFieldStretchY.getText()));
            stretch.stretchFigure(points);

            fieldPanel.repaint();
        });

        buttonTransfer.addActionListener(e -> {
            Move move = new Move(Double.parseDouble(textFieldTransferX.getText()), Double.parseDouble(textFieldTransferY.getText()));
            move.moveFigure(points);

            fieldPanel.repaint();
        });

        buttonDoingAllWhatThereIs.addActionListener(e -> {
            if (!textFieldScale.getText().equals("")) {
                Scaling scale = new Scaling(Double.parseDouble(textFieldScale.getText()), Double.parseDouble(textFieldScale.getText()));
                scale.scalingFigure(points);
            }
            if (!textFieldTransferY.getText().equals("") || !textFieldTransferX.getText().equals("")) {
                Move move = new Move(Double.parseDouble(textFieldTransferX.getText()), Double.parseDouble(textFieldTransferY.getText()));
                move.moveFigure(points);
            }
            if (!textFieldStretchY.getText().equals("") || !textFieldStretchX.getText().equals("")) {
                Stretch stretch = new Stretch(Double.parseDouble(textFieldStretchX.getText()), Double.parseDouble(textFieldStretchY.getText()));
                stretch.stretchFigure(points);
            }
            if (!textFieldRotate.getText().equals("")) {
                Rotate rotate = new Rotate(Double.parseDouble(textFieldRotate.getText()));
                rotate.rotateFigure(points);
            }
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
