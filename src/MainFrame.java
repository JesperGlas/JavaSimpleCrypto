import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5063276219420379402L;
	// Default dimensions of the window
	private int frameWidth = 600;
	private int frameHeight = 500;

	private Toolbar toolbar;
	private TextPanel inputPanel;
	private TextPanel outputPanel;
	private PasswordPanel key1Panel;

	public MainFrame() {
		super("JavaEncrypt");
		
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}

		// Set the main windows layout to BorderLayout
		setLayout(new GridBagLayout());

		toolbar = new Toolbar();
		inputPanel = new TextPanel("Input");
		outputPanel = new TextPanel("Output");
		key1Panel = new PasswordPanel("Key");

		toolbar.setButtonListener(new ButtonListener() {

			@Override
			public void actionEmitted(String action) {
				String inputText = inputPanel.getText();
				String password = key1Panel.getKey() != null ? key1Panel.getKey(): "";
				String outputText = "";

				inputText = inputText != null ? inputText : "";

				if (action == "encrypt") {
					String encrypted;
					try {
						encrypted = Crypto.encryptString(inputText, password);
					} catch (Exception e) {
						encrypted = "";
						e.printStackTrace();
					}
					outputText = encrypted;
				} else if (action == "decrypt") {
					String decrypted;
					try {	
						decrypted = Crypto.decryptString(inputText, password);
					} catch (Exception e) {
						decrypted = "Error";
						e.printStackTrace();
					}
					outputText = decrypted;
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
		add(key1Panel, gc);

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
