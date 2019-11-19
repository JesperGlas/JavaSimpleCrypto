import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class MainFrame extends JFrame {
	
	// Default dimensions of the window
	private int frameWidth = 600;
	private int frameHeight = 500;
	
	private Toolbar toolbar;
	private TextPanel inputPanel;
	private TextPanel outputPanel;
	private PasswordPanel keyPanel;
	
	public MainFrame() {
		super("JavaEncrypt");
		
		// Set the main windows layout to BorderLayout
		setLayout(new GridBagLayout());
		
		toolbar = new Toolbar();
		inputPanel = new TextPanel("Input");
		outputPanel = new TextPanel("Output");
		keyPanel = new PasswordPanel();
		
		toolbar.setButtonListener(new ButtonListener() {
			
			@Override
			public void actionEmitted(String action) {
				String inputText = inputPanel.getText();
				byte[] cryptoKey = keyPanel.getKey() != null ? (byte[]) keyPanel.getKey().getBytes() : null;
				String outputText = "";
				
				inputText = inputText != null ? inputText : "";
				
				if (action == "encrypt") {
					byte[] encrypted = Crypto.encrypt(inputText.getBytes(), cryptoKey);
					outputText = new String(encrypted);
				} else if (action == "decrypt") {
					byte[] decrypted = Crypto.decrypt(inputText.getBytes(), cryptoKey);
					outputText = new String(decrypted);
				}
				
				outputPanel.setText(outputText);
			}
		});
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// ### Row 2 ###
		gc.fill = GridBagConstraints.BOTH;
		gc.gridwidth = 1;
		gc.weighty = 1;
		gc.weightx = 1;
		
		gc.gridy = 0;
		
		gc.gridx = 0;
		add(inputPanel, gc);
		
		gc.gridx = 1;
		add(outputPanel, gc);
		
		// ### Row 2 ###
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridwidth = 2;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		
		gc.gridx = 0;
		add(keyPanel, gc);
		
		// ### Row 3 ###
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridwidth = 2;
		gc.weighty = 0.1;
		
		gc.gridy = 2;
		
		gc.gridx = 0;
		add(toolbar, gc);
		
		// Various settings for the window
		setSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	};

}
