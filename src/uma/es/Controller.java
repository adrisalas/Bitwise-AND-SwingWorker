package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class Controller implements ActionListener{
	private MainPanel panel;
	public Controller(MainPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(panel.START_COMMAND)){
			System.out.println("actionPerformed - isEventDispatchThread? "+ SwingUtilities.isEventDispatchThread());			
			panel.area1.setText("");
			panel.area2.setText("");
			panel.area3.setText("");
			
			WorkerSequence1 w1 = new WorkerSequence1(Integer.parseInt(panel.numberOfBits.getText()), panel);
			WorkerSequence2 w2 = new WorkerSequence2(Integer.parseInt(panel.numberOfBits.getText()), panel);
			WorkerSequence3 w3 = new WorkerSequence3(Integer.parseInt(panel.numberOfBits.getText()), panel,w1,w2);
			w3.setController(new ControllerProgress(panel));
			
			w1.execute();
			w2.execute();
			w3.execute();
		}
	}

}
