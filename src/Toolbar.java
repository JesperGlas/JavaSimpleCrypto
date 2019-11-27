import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2544272439906654645L;
	private JButton encryptBtn;
	private JButton decryptBtn;
	
	private ButtonListener buttonListener;
	
	public Toolbar() {
		
		encryptBtn = new JButton("Encrypt");
		decryptBtn = new JButton("Decrypt");
		
		encryptBtn.addActionListener(this);
		decryptBtn.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(encryptBtn);
		add(decryptBtn);
	}
	
	/**
	 * Method to to add a StringListener to the toolbar
	 * @param actionListener StringListener
	 */
	public void setButtonListener(ButtonListener listener) {
		this.buttonListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (buttonListener != null) {
			if (clicked == encryptBtn) {
				System.out.println("Encrypt!");
				buttonListener.actionEmitted("encrypt");
			} else if (clicked == decryptBtn) {
				System.out.println("Decrypt!");
				buttonListener.actionEmitted("decrypt");
			}
		}
	}

}
