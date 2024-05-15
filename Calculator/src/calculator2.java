import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Double.*;

class calculator2 {
    private JFrame frame = new JFrame("Simple Calculator");
    private JPanel panel = new JPanel();
    private JTextField inputOne = new JTextField(5);
    private JTextField inputTwo = new JTextField(5);
    private JTextField output = new JTextField(20);
    private String[] symbols = {"\u002b", "\u2212", "\u00f7", "\u00d7"};
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox list = new JComboBox(symbols);
    private JButton calculateButton = new JButton("Calculate");

    public static void main(String[] args) {
        calculator2 Calculator = new calculator2();
        Calculator.run();
    }

    public void run() {
        buttonListener buttonListener = new buttonListener();

        calculateButton.addActionListener(buttonListener);
        calculateButton.setFocusPainted(false);
        calculateButton.setBackground(Color.WHITE);
        calculateButton.setForeground(Color.BLACK);

        inputOne.addActionListener(buttonListener);
        inputTwo.addActionListener(buttonListener);
        output.setEditable(false);

        list.setBackground(Color.GRAY);
        list.setForeground(Color.WHITE);
        list.setEditable(false);
        list.setFocusable(false);

        panel.setBackground(Color.DARK_GRAY);
        panel.add(inputOne);
        panel.add(list);
        panel.add(inputTwo);
        panel.add(output);

        frame.getContentPane().add(BorderLayout.SOUTH, calculateButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static double calculate(double a, double b, String c) {
        double result = 0;

        if (c.equals("\u002b")) {
            result = a + b;
        } else if (c.equals("\u2212")) {
            result = a - b;
        } else if (c.equals("\u00f7")) {
            result = a / b;
        } else if (c.equals("\u00d7")) {
            result = a * b;
        }

        return result;
    }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!inputOne.getText().equals("") & !inputTwo.getText().equals("")) {
                double numberOne = (parseDouble(inputOne.getText()));
                double numberTwo = (parseDouble(inputTwo.getText()));

                String function = (String) list.getSelectedItem();

                output.setText("" + calculator2.calculate(numberOne, numberTwo, function));
            }

        }
    }
}