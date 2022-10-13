package cs.vsu.ruKorobeynikova_A_V;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{
    private JPanel panelMain;
    private JTextField textFieldScale;
    private JTextField textFieldRotate;
    private JTextField textFieldCompression;
    private JTextField textFieldTransfer;
    private JButton buttonClean;
    private JButton buttonScale;
    private JButton buttonRotate;
    private JButton buttonCompression;
    private JButton buttonTransfer;
    private JComboBox comboBox1;
    private JPanel menuPanel;
    private JPanel fieldPanel;

    public MainForm() {
        this.setTitle("Affine transformations");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(new Dimension(1300,700));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        fieldPanel = new DrawField();
    }

    class DrawField extends JPanel {
        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);

            Graphics2D g2 = (Graphics2D) g;
            draw(g2);

        }

        public void draw(Graphics2D g2) {
            //рисуем систему координат (оси оХ и оУ)

            g2.setColor(Color.blue);
            g2.setFont(g2.getFont().deriveFont(8f));
            g2.drawLine(350, 0, 350, 700);
            g2.drawLine(0, 350, 700, 350);
        }
    }


}
