//Presents a GUI to verify Credit Card Number
//Final version with event handling
import java.awt.*;//for Dimension
import java.awt.event.*;//for ActionListener

import javax.swing.*;//for GUI components

public class CreditCardGUI2 implements ActionListener{

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		CreditCardGUI2 gui = new CreditCardGUI2();
	}
	//Fields
	private JFrame frame;
	private JTextField numberField;
	private JLabel validLabel;
	private JButton verifyButton;

	//Creates components, does Layout, shows window onscreen
	public CreditCardGUI2(){
		numberField = new JTextField(16);
		validLabel = new JLabel("Not yet verified");
		verifyButton = new JButton("Verify CC Number");
		
		//event Listener
		verifyButton.addActionListener(this);
	
		frame = new JFrame("Credit Card Nmuber Verifier");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(350, 100));
		frame.setLayout(new FlowLayout());
		frame.add(numberField);
		frame.add(verifyButton);
		frame.add(validLabel);
		frame.setVisible(true);
	}
	
	//Returns whether the given string is valid Visa Card 
	//Number according to the Luhn checksum algorithm.
	public boolean isValidCC(String text){
		int sum = 0;
		for(int i = text.length() - 1; i >= 0; i--){
			int digit = Integer.parseInt(text.substring(i, i + 1));
			if(i % 2 == 0){
				digit *= 2;
			}
			sum += (digit / 10) + (digit % 10);
		}
		//Valid numbers add up to a multiple of 10
		return sum % 10 == 0 && text.startsWith("4");
	}
	//Sets label's text to show whether CC number is valid.
	public void actionPerformed(ActionEvent event){
		String text = numberField.getText();
		if(isValidCC(text)){
			validLabel.setText("Valid Number!");
		}else{
			validLabel.setText("Invalid Number");
		}
	}

}



