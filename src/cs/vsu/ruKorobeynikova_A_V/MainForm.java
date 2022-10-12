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

    public MainForm() {
        this.setTitle("Affine transformations");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(new Dimension(1300,800));


    }
}
