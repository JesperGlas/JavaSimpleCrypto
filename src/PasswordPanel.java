import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3284759601422914964L;
	private JLabel keyLabel;
	private JPasswordField keyField;
	
	public PasswordPanel(String label) {
		
		keyLabel = new JLabel(label);
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
