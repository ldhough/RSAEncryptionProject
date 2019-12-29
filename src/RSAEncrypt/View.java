package RSAEncrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * View class uses information from the model (RSAEncrypt) and the Controller to create a GUI that demonstrates
 * how RSA encryption works
 * 
 * Due Date: 04/24/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

public class View extends JFrame {
	private Controller myController;
	public RSAEncrypt myEncrypt;
	private JPanel myInputPanel;
	private JLabel myInputLabel;
	private JPanel myASCIIPanel;
	private JLabel myASCIILabel;
	private JPanel myEncryptedPanel;
	private JLabel myEncryptedLabel;
	private JPanel myEncrypted2Panel;
	private JLabel myEncrypted2Label;
	private JPanel myDecryptedPanel;
	private JLabel myDecryptedLabel;
	private JLabel myDecryptedASCIILabel;
	private JPanel myDecryptedASCIIPanel;
	private JTextField myInputField;
	//private JPanel myInputFieldPanel;
	private JButton myEncryptButton;
	private JButton myDecryptButton;
	byte[] myEncrypted;
	
	public View(Controller controller) {
		myController = controller;
		JFrame frame = new JFrame("RSA Encryption");
		frame.setSize(600, 400);
		frame.setLayout(null);
		frame.setBackground(Color.gray);
		
		myInputLabel = new JLabel("Input string to encrypt here:");
		myInputLabel.setLocation(20, 20);
		
		myInputPanel = new JPanel(new FlowLayout());
		myInputPanel.setSize(560, 20);
		myInputPanel.setLocation(20, 20);
		myInputPanel.add(myInputLabel);
		
		myInputField = new JTextField();
		myInputField.setSize(200, 30);
		myInputField.setLocation(200, 50);
		
		myASCIILabel = new JLabel("String in ASCII characters:");
		myASCIILabel.setLocation(20, 80);
		
		myASCIIPanel = new JPanel(new FlowLayout());
		myASCIIPanel.setSize(560, 20);
		myASCIIPanel.setLocation(20, 80);
		myASCIIPanel.add(myASCIILabel);
		
		myEncryptButton = new JButton();
		myEncryptButton.setLocation(200, 120);
		myEncryptButton.setText("Encrypt");
        myEncryptButton.setSize(200, 30);
        myEncryptButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = myInputField.getText();
						myEncrypt = new RSAEncrypt();
						myASCIILabel.setText("String in ASCII characters: " + myEncrypt.returnToString(s.getBytes()));
						myEncrypted = myEncrypt.Encrypt(s);
						myEncrypted2Label.setText(myEncrypt.returnToString(myEncrypted));
					}
				}
		);
        
        myEncryptedLabel = new JLabel("Encrypted text: ");
		myEncryptedLabel.setLocation(20, 160);
		
		myEncryptedPanel = new JPanel(new FlowLayout());
		myEncryptedPanel.setSize(560, 20);
		myEncryptedPanel.setLocation(20, 160);
		myEncryptedPanel.add(myEncryptedLabel);
		
		myEncrypted2Label = new JLabel("x");
		myEncrypted2Label.setLocation(20, 180);
		
		myEncrypted2Panel = new JPanel(new FlowLayout());
		myEncrypted2Panel.setSize(560, 20);
		myEncrypted2Panel.setLocation(20, 180);
		myEncrypted2Panel.add(myEncrypted2Label);
		
		myDecryptButton = new JButton();
		myDecryptButton.setLocation(200, 220);
		myDecryptButton.setText("Decrypt");
		myDecryptButton.setSize(200, 30);
		myDecryptButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//byte[] decrypted = myEncrypt.Decrypt(myEncrypted);
						//String decryptedText = new String(decrypted);
						String decryptedText = myEncrypt.Decrypt(myEncrypted);
						myDecryptedLabel.setText("Decrypted text: " + decryptedText);
						myDecryptedASCIILabel.setText("Decrypted text ASCII: " + myEncrypt.returnToString(decryptedText.getBytes()));
					}
				}
		);
		
		myDecryptedASCIILabel = new JLabel("Decrypted text ASCII: ");
		myDecryptedASCIILabel.setLocation(20, 260);
		
		myDecryptedASCIIPanel = new JPanel(new FlowLayout());
		myDecryptedASCIIPanel.setSize(560, 20);
		myDecryptedASCIIPanel.setLocation(20, 260);
		myDecryptedASCIIPanel.add(myDecryptedASCIILabel);
		
		myDecryptedLabel = new JLabel("Decrypted text: ");
		myDecryptedLabel.setLocation(20, 280);
		
		myDecryptedPanel = new JPanel(new FlowLayout());
		myDecryptedPanel.setSize(560, 20);
		myDecryptedPanel.setLocation(20, 280);
		myDecryptedPanel.add(myDecryptedLabel);
		
        frame.add(myInputField);
		frame.add(myInputPanel);
		frame.add(myASCIIPanel);
		frame.add(myEncryptButton);
		frame.add(myDecryptButton);
		frame.add(myEncryptedPanel);
		frame.add(myDecryptedPanel);
		frame.add(myDecryptedASCIIPanel);
		frame.add(myEncrypted2Panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
