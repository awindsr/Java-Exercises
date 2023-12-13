package guiexercises;


/*Java program that works as a simple calculator. Arrange Buttons for digits and
the + - * % operations properly. Add a text field to display the result. Handle any possible
exceptions like divide by zero. Use Java Swing.*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class GuiCalc extends JFrame implements ActionListener {
    JButton numberButtons[] = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    int operand1, operand2;
    char operator;
    JTextField resultField;

    GuiCalc() {
        JFrame frame = new JFrame("Calculator by Awin");
        frame.setTitle("Calculator by Awin");
        frame.setBackground(new Color(64, 64, 64));

        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        resultField = new JTextField(10);
        resultField.setPreferredSize(new Dimension(200, 30));
        resultField.setHorizontalAlignment(JTextField.RIGHT);

        mainPanel.add(resultField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 7; i <= 9; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            gbc.gridx = i - 7;
            gbc.gridy = 0;
            buttonPanel.add(numberButtons[i], gbc);
        }
        clearButton = createButton("C");
        gbc.gridx = 3;
        gbc.gridy = 0;
        buttonPanel.add(clearButton, gbc);

        for (int i = 4; i <= 6; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            gbc.gridx = i - 4;
            gbc.gridy = 1;
            buttonPanel.add(numberButtons[i], gbc);
        }
        addButton = createButton("+");
        gbc.gridx = 3;
        gbc.gridy = 1;
        buttonPanel.add(addButton, gbc);

        for (int i = 1; i <= 3; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            gbc.gridx = i - 1;
            gbc.gridy = 2;
            buttonPanel.add(numberButtons[i], gbc);
        }
        subtractButton = createButton("-");
        gbc.gridx = 3;
        gbc.gridy = 2;
        buttonPanel.add(subtractButton, gbc);

        // Add buttons 0, *, %, =
        numberButtons[0] = createButton("0");
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(numberButtons[0], gbc);

        multiplyButton = createButton("*");
        gbc.gridx = 1;
        gbc.gridy = 3;
        buttonPanel.add(multiplyButton, gbc);

        divideButton = createButton("/");
        gbc.gridx = 2;
        gbc.gridy = 3;
        buttonPanel.add(divideButton, gbc);

        equalsButton = createButton("=");
        gbc.gridx = 3;
        gbc.gridy = 3;
        buttonPanel.add(equalsButton, gbc);

        mainPanel.add(buttonPanel);

        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(this);
        return button;
    }


    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == clearButton) {
            operand1 = operand2 = 0;
            resultField.setText("");
        } else if (clickedButton == equalsButton) {
            operand2 = Integer.parseInt(resultField.getText());
            evaluate();
            resultField.setText(String.valueOf(operand1));
            operand1 = 0; 
        } else {
            boolean isOperator = false;
            if (clickedButton == addButton) {
                operator = '+';
                isOperator = true;
            }
            if (clickedButton == subtractButton) {
                operator = '-';
                isOperator = true;
            }
            if (clickedButton == multiplyButton) {
                operator = '*';
                isOperator = true;
            }
            if (clickedButton == divideButton) {
                operator = '/';
                isOperator = true;
            }

            if (!isOperator) {
                for (int i = 0; i < 10; i++) {
                    if (clickedButton == numberButtons[i]) {
                        String currentText = resultField.getText();
                        currentText += i;
                        resultField.setText(currentText);
                    }
                }
            } else {
                operand1 = Integer.parseInt(resultField.getText());
                resultField.setText("");
            }
        }
    }

    void evaluate() {
        switch (operator) {
            case '+':
                operand1 += operand2;
                break;
            case '-':
                operand1 -= operand2;
                break;
            case '*':
                operand1 *= operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    operand1 /= operand2;
                } else {
                    resultField.setText("Error: Divide by zero");
                }
                break;
        }
    }
    public static void main(String[] args) {
        new GuiCalc();
    }
}
