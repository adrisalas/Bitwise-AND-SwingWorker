package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class WindowBuilderGUIPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public WindowBuilderGUIPanel() {
		setLayout(new MigLayout("", "[grow][][][grow][][][grow]", "[][grow][][][][][grow][][][][]"));
		
		JLabel lblWhatIsThe = new JLabel("What is the length");
		add(lblWhatIsThe, "cell 0 0 3 1,alignx right");
		
		textField = new JTextField();
		add(textField, "cell 3 0,growx");
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		add(textPane, "cell 0 1 3 4,grow");
		
		JTextPane textPane_1 = new JTextPane();
		add(textPane_1, "cell 3 1 4 4,grow");
		
		JLabel lblSequence = new JLabel("Sequence 1");
		add(lblSequence, "cell 0 5");
		
		JLabel lblSequence_1 = new JLabel("Sequence 2");
		add(lblSequence_1, "cell 3 5");
		
		JTextPane textPane_2 = new JTextPane();
		add(textPane_2, "cell 0 6 7 4,grow");
		
		JLabel lblSequence_2 = new JLabel("Sequence 1 & Sequence 2");
		add(lblSequence_2, "cell 0 10");
		
		JProgressBar progressBar = new JProgressBar();
		add(progressBar, "cell 3 10");

	}
}
