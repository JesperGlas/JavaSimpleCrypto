import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordPanel extends JPanel {
	
	private JLabel keyLabel;
	private JPasswordField keyField;
	
	public PasswordPanel() {
		
		keyLabel = new JLabel("Encryption Key");
		keyField = new JPasswordField(30);
		
		setLayout(new FlowLayout());
		
		add(keyLabel);
		add(keyField);
	}
	
	public String getKey() {
		keyField.selectAll();
		return keyField.getSelectedText();
	}

}
