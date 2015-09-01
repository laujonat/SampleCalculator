
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Calculator extends JFrame {

	private JLabel resultLabel; 
	
	// set i
	private JButton zeroButton, oneButton, twoButton, threeButton, fourButton,
		fiveButton, sixButton, sevenButton, eightButton, nineButton, 
		clearButton, multiplyButton, divideButton, additionButton, 
		subtractionButton, equalsButton, decimalButton, plusMinusButton;

	boolean nextNumber;
	double operand1, operand2, result;
	final int MULTIPLY = 1;
	final int DIVIDE = 2;
	final int ADD = 3;
	final int SUBTRACT = 4;
	int operation, intResult;


	public Calculator() {

		super("Calculator");
		setLayout(null);
		setLocation(250,250);
		setFocusable(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("Arial", 4, 12);
		Font font2 = new Font("Arial", 4, 18);
		nextNumber = true;

		resultLabel = new JLabel();
		resultLabel.setSize(199,37);
		resultLabel.setLocation(12,9);
		resultLabel.setBorder(border);
		resultLabel.setFont(font2);
		resultLabel.setHorizontalAlignment(JLabel.RIGHT);
		resultLabel.setText("0");
		add(resultLabel);

		equalsButton = new JButton();
		clearButton = new JButton();

		zeroButton = new JButton();
		oneButton = new JButton();
		twoButton = new JButton();
		threeButton = new JButton();
		fourButton = new JButton();
		fiveButton = new JButton();
		sixButton = new JButton();
		sevenButton = new JButton();
		eightButton = new JButton();
		nineButton = new JButton();
		multiplyButton = new JButton();
		divideButton = new JButton();
		additionButton = new JButton();
		subtractionButton = new JButton();
		decimalButton = new JButton();
		plusMinusButton = new JButton();	

		JButton[] buttons = {zeroButton, oneButton, twoButton, threeButton, fourButton,
				fiveButton, sixButton, sevenButton, eightButton, nineButton, multiplyButton, 
				divideButton, additionButton, subtractionButton, decimalButton, plusMinusButton};

		for (int i = 0; i < 10; i++){
			buttons[i].setText(Integer.toString(i));
		}

		multiplyButton.setText("*");
		divideButton.setText("/");
		additionButton.setText("+");
		subtractionButton.setText("-");
		decimalButton.setText(".");
		plusMinusButton.setText("+/-");
		clearButton.setText("Clear");
		equalsButton.setText("=");


		clearButton.setSize(76,35);
		equalsButton.setSize(76,35);

		zeroButton.setLocation(53,182);
		oneButton.setLocation(12, 141);
		twoButton.setLocation(53,141);
		threeButton.setLocation(94,141);
		fourButton.setLocation(12,100);
		fiveButton.setLocation(53,100);
		sixButton.setLocation(94,100);
		sevenButton.setLocation(12,59);
		eightButton.setLocation(53,59);
		nineButton.setLocation(94, 59);
		multiplyButton.setLocation(135,100);
		divideButton.setLocation(176, 100);
		additionButton.setLocation(135,141);
		subtractionButton.setLocation(176,141);
		plusMinusButton.setLocation(12,182);
		decimalButton.setLocation(94,182);

		for (int i = 0; i < buttons.length; i++){
			buttons[i].setSize(35,35);
			buttons[i].setFont(font);
			buttons[i].setMargin(new Insets(0,0,0,0));
			add(buttons[i]);
		}

		clearButton.setLocation(135,59);
		equalsButton.setLocation(135,182);
		add(clearButton);
		add(equalsButton);

		ButtonHandler handler = new ButtonHandler();
		KeyPressHandler keyHandler = new KeyPressHandler();

		for (int i = 0; i < buttons.length; i++){
			buttons[i].addActionListener(handler);
		}

		clearButton.addActionListener(handler);
		equalsButton.addActionListener(handler);

		addKeyListener(keyHandler);
	}

	private void pressZero(){

		if (nextNumber){
			resultLabel.setText("0");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "0");
		}
	}

	private void pressOne(){

		if (nextNumber){
			resultLabel.setText("1");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "1");
		}
	}

	private void pressTwo(){

		if (nextNumber){
			resultLabel.setText("2");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "2");
		}
	}

	private void pressThree(){

		if (nextNumber){
			resultLabel.setText("3");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "3");
		}
	}

	private void pressFour(){

		if (nextNumber){
			resultLabel.setText("4");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "4");
		}
	}

	private void pressFive(){

		if (nextNumber){
			resultLabel.setText("5");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "5");
		}
	}

	private void pressSix(){

		if (nextNumber){
			resultLabel.setText("6");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "6");
		}
	}

	private void pressSeven(){

		if (nextNumber){
			resultLabel.setText("7");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "7");
		}
	}

	private void pressEight(){

		if (nextNumber){
			resultLabel.setText("8");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "8");
		}
	}

	private void pressNine(){

		if (nextNumber){
			resultLabel.setText("9");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + "9");
		}
	}

	private void pressPlusMinus(){

		try{

			if (Double.parseDouble(resultLabel.getText()) - Math.floor(Double.parseDouble(resultLabel.getText())) == 0){
				intResult = (int) Double.parseDouble(resultLabel.getText()) * -1;
				resultLabel.setText(intResult + "");
			}
			else{
				resultLabel.setText(Double.parseDouble(resultLabel.getText()) * -1 + "");
			}
		}
		catch(NumberFormatException e){
			resultLabel.setText("Syntax Error");
			nextNumber = true;
		}
	}

	private void pressDecimal(){

		if (nextNumber){
			resultLabel.setText(".");
			nextNumber = false;
		}
		else{
			resultLabel.setText(resultLabel.getText() + ".");
		}
	}

	private void pressAdd(){

		try{
			operand1 = Double.parseDouble(resultLabel.getText());
			operation = ADD;
			nextNumber = true;
		}
		catch(NumberFormatException e){
			resultLabel.setText("Syntax Error");
			nextNumber = true;
		}
	}

	private void pressSubtract(){

		try{
			operand1 = Double.parseDouble(resultLabel.getText());
			operation = SUBTRACT;
			nextNumber = true;
		}
		catch(NumberFormatException e){
			resultLabel.setText("Syntax Error");
			nextNumber = true;
		}
	}

	private void pressMultiply(){

		try{
			operand1 = Double.parseDouble(resultLabel.getText());
			operation = MULTIPLY;
			nextNumber = true;
		}
		catch(NumberFormatException e){
			resultLabel.setText("Syntax Error");
			nextNumber = true;
		}
	}

	private void pressDivide(){

		try{
			operand1 = Double.parseDouble(resultLabel.getText());
			operation = DIVIDE;
			nextNumber = true;
		}
		catch(NumberFormatException e){
			resultLabel.setText("Syntax Error");
			nextNumber = true;
		}
	}

	private void pressClear(){

		resultLabel.setText("0");
		nextNumber = true;
		operation = 0;
	}

	private void pressEquals(){

		nextNumber = true;

		if (operation == ADD){

			try{
				operand2 = Double.parseDouble(resultLabel.getText());
				result = operand1 + operand2;

				if (result - Math.floor(result) == 0){
					intResult = (int) result;
					resultLabel.setText(intResult + "");
				}
				else{
					resultLabel.setText(result + "");
				}
			}
			catch(NumberFormatException e){
				resultLabel.setText("Syntax Error");
				nextNumber = true;
			}

		}
		else if (operation == SUBTRACT){

			try{
				operand2 = Double.parseDouble(resultLabel.getText());
				result = operand1 - operand2;

				if (result - Math.floor(result) == 0){
					intResult = (int) result;
					resultLabel.setText(intResult + "");
				}
				else{
					resultLabel.setText(result + "");
				}
			}
			catch(NumberFormatException e){
				resultLabel.setText("Syntax Error");
				nextNumber = true;
			}
		}
		else if (operation == MULTIPLY){

			try{
				operand2 = Double.parseDouble(resultLabel.getText());
				result = operand1 * operand2;

				if (result - Math.floor(result) == 0){
					intResult = (int) result;
					resultLabel.setText(intResult + "");
				}
				else{
					resultLabel.setText(result + "");
				}
			}
			catch(NumberFormatException e){
				resultLabel.setText("Syntax Error");
				nextNumber = true;
			}
		}
		else if (operation == DIVIDE){

			try{
				operand2 = Double.parseDouble(resultLabel.getText());
				result = operand1 / operand2;

				if (result - Math.floor(result) == 0){
					intResult = (int) result;
					resultLabel.setText(intResult + "");
				}
				else{
					resultLabel.setText(result + "");
				}
			}
			catch(NumberFormatException e){
				resultLabel.setText("Syntax Error");
				nextNumber = true;
			}
		}
	}

	private class KeyPressHandler extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent event){

			if (event.getKeyCode() == KeyEvent.VK_0 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD0){
				pressZero();
			}
			else if (event.getKeyCode() == KeyEvent.VK_1 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD1){
				pressOne();
			}
			else if (event.getKeyCode() == KeyEvent.VK_2 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD2){
				pressTwo();
			}
			else if (event.getKeyCode() == KeyEvent.VK_3 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD3){
				pressThree();
			}
			else if (event.getKeyCode() == KeyEvent.VK_4 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD4){
				pressFour();
			}
			else if (event.getKeyCode() == KeyEvent.VK_5 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD5){
				pressFive();
			}
			else if (event.getKeyCode() == KeyEvent.VK_6 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD6){
				pressSix();
			}
			else if (event.getKeyCode() == KeyEvent.VK_7 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD7){
				pressSeven();
			}
			else if (event.getKeyCode() == KeyEvent.VK_8 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD8){
				pressEight();
			}
			else if (event.getKeyCode() == KeyEvent.VK_9 ||
					event.getKeyCode() == KeyEvent.VK_NUMPAD9){
				pressNine();
			}
			else if (event.getKeyCode() == KeyEvent.VK_DECIMAL){
				pressDecimal();
			}
			else if (event.getKeyCode() == KeyEvent.VK_ENTER){
				pressEquals();
			}
			else if (event.getKeyCode() == KeyEvent.VK_MULTIPLY){
				pressMultiply();
			}
			else if (event.getKeyCode() == KeyEvent.VK_DIVIDE){
				pressDivide();
			}
			else if (event.getKeyCode() == KeyEvent.VK_ADD){
				pressAdd();
			}
			else if (event.getKeyCode() == KeyEvent.VK_SUBTRACT){
				pressSubtract();
			}
			else if (event.getKeyCode() == KeyEvent.VK_DELETE){
				pressClear();
			}
		}
	}

	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){

			if (event.getSource() == zeroButton){
				pressZero();
			}
			else if (event.getSource() == oneButton){
				pressOne();
			}
			else if (event.getSource() == twoButton){
				pressTwo();
			}
			else if (event.getSource() == threeButton){
				pressThree();
			}
			else if (event.getSource() == fourButton){
				pressFour();
			}
			else if (event.getSource() == fiveButton){
				pressFive();
			}
			else if (event.getSource() == sixButton){
				pressSix();
			}
			else if (event.getSource() == sevenButton){
				pressSeven();
			}
			else if (event.getSource() == eightButton){
				pressEight();
			}
			else if (event.getSource() == nineButton){
				pressNine();
			}
			else if (event.getSource() == decimalButton){
				pressDecimal();
			}
			else if (event.getSource() == plusMinusButton){
				pressPlusMinus();
			}
			else if (event.getSource() == multiplyButton){
				pressMultiply();
			}
			else if (event.getSource() == divideButton){
				pressDivide();
			}
			else if (event.getSource() == additionButton){
				pressAdd();
			}
			else if (event.getSource() == subtractionButton){
				pressSubtract();
			}
			else if (event.getSource() == equalsButton){
				pressEquals();
			}
			else if (event.getSource() == clearButton){
				pressClear();
			}

			requestFocus();
		}
	}
}
