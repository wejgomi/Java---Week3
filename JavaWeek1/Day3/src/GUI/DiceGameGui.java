import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class DiceGameGui extends JFrame {

    public static int bank;
    public int money;
    public int bet;
    public int betamount;
    public int answer;
    public JLabel label;
    public JButton button2;
    JFrame frame;

    public static void main() {
        Random random = new Random();
        bank = random.nextInt(300) + 1;
        new DiceGameGui();
    }

    public DiceGameGui() {
        frame = new JFrame();
        frame.setSize(350,350);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        label = new JLabel("Amount in the bank: " + bank);
        JLabel label1 = new JLabel("Amount to bet: ");
        JLabel label2 = new JLabel("Place the bet: ");
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JButton button1 = new JButton("Place the bet!");
        button2 = new JButton("Restart?");
        button2.setVisible(false);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(label,BorderLayout.CENTER);
        panel.add(label1,BorderLayout.WEST);
        panel.add(textField1,BorderLayout.CENTER);
        panel.add(label2,BorderLayout.WEST);
        panel.add(textField2,BorderLayout.CENTER);
        panel.add(button1,BorderLayout.CENTER);
        panel.add(button2,BorderLayout.CENTER);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                betamount = Integer.parseInt(textField1.getText());
            }
        });

        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet = Integer.parseInt(textField2.getText());
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoTheMath(Integer.parseInt(textField1.getText()),Integer.parseInt(textField2.getText()));
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                main();
            }
        });
        setVisible(true);

    }
    public int DoTheMath(int betamount, int bet) {
        Random random = new Random();
        if(bank != 0) {
            if(bet == (random.nextInt(9) + 1)+(random.nextInt(9) + 1)) {
                bank += (betamount*3);
                JOptionPane.showMessageDialog(DiceGameGui.this, "We have a winner!");
                new DiceGameGui();
            }
            else {
                bank -= betamount;
                JOptionPane.showMessageDialog(DiceGameGui.this, (bank > 0) ? "Tough luck, try again!" : "You've gone bankrupt!");
                if (bank <= 0) { button2.setVisible(true); };
            }
        }
        label.setText("Amount in the bank: " + ((bank>0) ? bank : "0"));
        return bank;
    }
}
