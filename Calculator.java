import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    int boardWidth = 360;
    int boardHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray  = new Color(80, 80, 80);
    Color customBlack     = new Color(28, 28, 28);
    Color customOrange    = new Color(255, 149, 0);

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel("0");
    JPanel displayPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel  = new JPanel(new GridLayout(5, 4, 1, 1));

    String[] buttonLabels = {
        "AC", "+/-", "%", "÷",
        "7",  "8",  "9", "×",
        "4",  "5",  "6", "-",
        "1",  "2",  "3", "+",
        "0",        ".", "="
    };

    double firstOperand  = 0;
    String operator      = "";
    boolean newInput     = true;
    boolean justComputed = false;

    Calculator() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(1, 1));
        frame.getContentPane().setBackground(Color.BLACK);

        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 70));
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayLabel.setOpaque(true);

        displayPanel.setBackground(customBlack);
        displayPanel.add(displayLabel, BorderLayout.SOUTH);
        displayPanel.setPreferredSize(new Dimension(boardWidth, 140));
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonPanel.setBackground(Color.BLACK);

        for (int i = 0; i < buttonLabels.length; i++) {
            String label = buttonLabels[i];
            if (label == null) continue;

            JButton btn;

            if (label.equals("0")) {
                // "0" spans two columns
                btn = makeButton(label, customDarkGray, Color.WHITE);
                buttonPanel.add(btn);
                buttonPanel.add(new JLabel()); // spacer occupies the "." slot visually
                i++; // skip one slot — "." comes next after spacer
                buttonPanel.add(makeButton(buttonLabels[i], customDarkGray, Color.WHITE));
                buttonPanel.add(makeButton(buttonLabels[++i], customOrange, Color.WHITE));
                continue;
            }

            Color bg   = getButtonBackground(label);
            Color fg   = label.equals("AC") || label.equals("+/-") || label.equals("%")
                         ? customBlack : Color.WHITE;
            btn = makeButton(label, bg, fg);
            buttonPanel.add(btn);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    JButton makeButton(String label, Color bg, Color fg) {
        JButton btn = new JButton(label);
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(new Font("Arial", Font.PLAIN, 28));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.addActionListener(this);
        return btn;
    }

    Color getButtonBackground(String label) {
        switch (label) {
            case "AC": case "+/-": case "%": return customLightGray;
            case "÷": case "×": case "-": case "+": case "=": return customOrange;
            default: return customDarkGray;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String current = displayLabel.getText();

        switch (cmd) {
            case "AC":
                displayLabel.setText("0");
                firstOperand  = 0;
                operator      = "";
                newInput      = true;
                justComputed  = false;
                break;

            case "+/-":
                if (!current.equals("0")) {
                    if (current.startsWith("-"))
                        displayLabel.setText(current.substring(1));
                    else
                        displayLabel.setText("-" + current);
                }
                break;

            case "%":
                double pct = Double.parseDouble(current) / 100;
                displayLabel.setText(format(pct));
                newInput = true;
                break;

            case "÷": case "×": case "-": case "+":
                firstOperand = Double.parseDouble(current);
                operator     = cmd;
                newInput     = true;
                justComputed = false;
                break;

            case "=":
                if (!operator.isEmpty()) {
                    double second = Double.parseDouble(current);
                    double result = compute(firstOperand, second, operator);
                    displayLabel.setText(format(result));
                    firstOperand  = result;
                    operator      = "";
                    newInput      = true;
                    justComputed  = true;
                }
                break;

            case ".":
                if (newInput) {
                    displayLabel.setText("0.");
                    newInput = false;
                } else if (!current.contains(".")) { 
                    displayLabel.setText(current + ".");
                }
                break; 

            default: // digit
                if (newInput || justComputed) {
                    displayLabel.setText(cmd);
                    newInput     = false;
                    justComputed = false;
                } else {
                    displayLabel.setText(current.equals("0") ? cmd : current + cmd);
                }
                break;
        }

        shrinkFontToFit(displayLabel);
    }

    double compute(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "×": return a * b;
            case "÷": return b == 0 ? Double.NaN : a / b;
            default:  return b;
        }
    }

    String format(double v) {
        if (Double.isNaN(v))      return "Error";
        if (Double.isInfinite(v)) return "Error";
        if (v == Math.floor(v) && !Double.isInfinite(v) && Math.abs(v) < 1e15)
            return String.valueOf((long) v);
        return String.valueOf(v);
    }

    void shrinkFontToFit(JLabel label) {
        int size = 70;
        int len  = label.getText().length();
        if (len > 9)  size = 40;
        else if (len > 6) size = 55;
        label.setFont(new Font("Arial", Font.PLAIN, size));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
