

import javax.swing.JFrame;
public class RunCalc {

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(225, 265);
		calc.setVisible(true);
	}
}