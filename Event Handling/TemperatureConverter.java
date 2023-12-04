package GUI_exercises;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//to convert celsius to farenhiet
public class TemperatureConverter extends JFrame implements ActionListener {
	
	private JTextField celsiusTextField;
	private JTextField fahrenheitTextField;

	TemperatureConverter(){
		setTitle("Temperature converter");
		setSize(300, 159);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		
		
		//Create and add components
		JLabel celsiusLabel = new JLabel("Celsius:");
		celsiusTextField = new JTextField();
		
		JLabel fahrenheitLabel = new JLabel("Farenhiet:");
		fahrenheitTextField = new JTextField();
		fahrenheitTextField.setEditable(false);
		
		JButton convertBtn = new JButton("Convert");
		
		//register the listener
		convertBtn.addActionListener(this);
		
		// Add components to the panel
        panel.add(celsiusLabel);
        panel.add(celsiusTextField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitTextField);
        panel.add(new JLabel());
        panel.add(convertBtn);
        
        // Set layout for the frame and add panel
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
//        add(panel);
		
	}
	
	

	public static void main(String [] args){
		TemperatureConverter converter = new TemperatureConverter();
		converter.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Double celsius = Double.parseDouble(celsiusTextField.getText());
			
			double fahrenheit = (celsius * 9 / 5) + 32;
			
			fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
		}
		catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Celsius.", "Error", JOptionPane.ERROR_MESSAGE);
        }
		
	}
	
}
