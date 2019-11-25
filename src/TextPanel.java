import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TextPanel extends JPanel {
	
	private JLabel titleLabel;
	private JTextArea textArea;
	
	public TextPanel(String label) {
		
		titleLabel = new JLabel(label);
		textArea = new JTextArea();
		
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
		
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		add(titleLabel, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void setText(String text) {
		textArea.selectAll();
		textArea.replaceSelection(text);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
	
	public String getText() {
		textArea.selectAll();
		return textArea.getSelectedText();
	}

}
