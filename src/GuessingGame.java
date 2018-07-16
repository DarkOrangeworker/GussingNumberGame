import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + " is correct. You win!";
				newGame();
			}
		} catch (Exception e) {
			message = "Unvalidated data.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Enginecat's Hi-Lo Gussing Game");
		getContentPane().setLayout(null);
		
		JLabel lblEnginecatsHiloGussing = new JLabel("Enginecat's Hi-Lo Gussing Game");
		lblEnginecatsHiloGussing.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnginecatsHiloGussing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnginecatsHiloGussing.setBounds(10, 52, 414, 24);
		getContentPane().add(lblEnginecatsHiloGussing);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGuessANumber.setBounds(10, 128, 251, 14);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(279, 124, 66, 21);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(170, 161, 93, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above,and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOutput.setBounds(106, 194, 213, 15);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
