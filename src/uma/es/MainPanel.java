package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	public final String START_COMMAND = "START";

	private JLabel labelBitLength;
	protected JTextField numberOfBits;

	protected JTextArea area1;
	protected JScrollPane scroll1;
	private JLabel labelSequence1;

	protected JTextArea area2;
	protected JScrollPane scroll2;
	private JLabel labelSequence2;

	protected JTextArea area3;
	protected JScrollPane scroll3;
	private JLabel labelSequence3;

	protected JProgressBar progressBar;

	public MainPanel() {
		labelBitLength = new JLabel();
		numberOfBits = new JTextField(5);

		area1 = new JTextArea(10,20);
		area1.setLineWrap(true);
		area1.setWrapStyleWord(true);
		scroll1 = new JScrollPane(area1);
		labelSequence1 = new JLabel();

		area2 = new JTextArea(10,20);
		area2.setLineWrap(true);
		area2.setWrapStyleWord(true);
		scroll2 = new JScrollPane(area2);
		labelSequence2 = new JLabel();

		area3 = new JTextArea(10,20);
		area3.setLineWrap(true);
		area3.setWrapStyleWord(true);
		scroll3 = new JScrollPane(area3);
		labelSequence3 = new JLabel();

		progressBar = new JProgressBar(0,100);
		progressBar.setStringPainted(true);

		labelBitLength.setText("What is the length of the bits sequence?");
		labelSequence1.setText("Sequence 1");
		labelSequence2.setText("Sequence 2");
		labelSequence3.setText("Sequence 1 & Sequence 2");


		this.setLayout(new MigLayout("", "[grow][][][grow][][][grow]", "[][grow][][][][][grow][][][][]"));

		this.add(labelBitLength, "cell 0 0 3 1, alignx right");
		this.add(numberOfBits,"cell 3 0");

		this.add(scroll1, "cell 0 1 3 4,grow");
		this.add(labelSequence1, "cell 0 5");

		this.add(scroll2,"cell 3 1 4 4,grow");
		this.add(labelSequence2, "cell 3 5");

		this.add(scroll3, "cell 0 6 7 4,grow");
		this.add(labelSequence3, "cell 0 10");

		this.add(progressBar, "cell 3 10");
	}

	public void setController(ActionListener ctr) {
		numberOfBits.setActionCommand(START_COMMAND);
		numberOfBits.addActionListener(ctr);
	}

	public void writeList1(List<Integer> list) {
		for(Integer i: list) {
			area1.append(i+" ");
		}
	}

	public void writeList2(List<Integer> list) {
		for(Integer i: list) {
			area2.append(i+" ");
		}
	}
	public void writeList3(List<Integer> list) {
		list.stream().forEach(i -> area3.append(i+" "));
	}

	public void setMyProgress(int n){
		progressBar.setValue(n);
	}
}
