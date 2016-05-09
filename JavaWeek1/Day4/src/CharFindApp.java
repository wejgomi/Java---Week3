import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharFindApp extends JFrame {

    JLabel label3;

    public static void main(String[] args) {
        new CharFindApp();
    }

    public CharFindApp() {
        super("Search-a-string!");
        setSize(350, 350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Please enter the string: ");
        JLabel label2 = new JLabel("Enter the character to seek: ");
        label3 = new JLabel("Amount of times in the string: ");
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JButton button1 = new JButton("Search!");

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(label1, BorderLayout.WEST);
        panel.add(textField1, BorderLayout.CENTER);
        panel.add(label2, BorderLayout.WEST);
        panel.add(textField2, BorderLayout.CENTER);
        panel.add(button1, BorderLayout.CENTER);
        panel.add(label3, BorderLayout.WEST);
        label3.setVisible(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Seek(textField1.getText(),textField2.getText());
            }
        });

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);
        setVisible(true);
    }

    public int Seek(String str, String find) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(find)) {
                j++;
            }
        }
        label3.setText("Amount of times in the string: " + ((j>0) ? j : "0"));
        label3.setVisible(true);
        return j;
    }
}
