package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

public class WorkerSequence3 extends SwingWorker<Void, Integer> {

	private int numberOfBits;
	private MainPanel panel;
	private List<Integer> myList;
	private WorkerSequence1 w1;
	private WorkerSequence2 w2;

	public WorkerSequence3(int numberOfBits, MainPanel panel, WorkerSequence1 w1, WorkerSequence2 w2) {
		this.numberOfBits = numberOfBits;
		this.panel = panel;
		this.myList = new ArrayList<Integer>();
		this.w1 = w1;
		this.w2 = w2;
	}

	@Override
	protected Void doInBackground() throws Exception {	

		this.setProgress(10);
		double progressWithDecimal = 0.0; // For numberOfBits >100
		int progress = 0;
		
		for(int i=0; i < numberOfBits; i++) {
			publish(w1.readItem(i) & w2.readItem(i));
			progressWithDecimal += 100d/numberOfBits;
			progress = (int) progressWithDecimal;
			
			this.setProgress(Math.min(100, (int) progress));
			Thread.sleep(25);
		}
		return null;
	}

	
	@Override
	protected void done() {
		System.out.println("Worker of Sequence 3 has finished.");
		this.setProgress(100);
	}

	synchronized protected void process(List<Integer> list) {		
		panel.writeList3(list);
		myList.addAll(list);
		notifyAll();
	}
	
	public void setController(PropertyChangeListener ctr){
		this.addPropertyChangeListener(ctr);
	}

}
