package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerSequence2 extends SwingWorker<Void, Integer> {

	private int numberOfBits;
	private MainPanel panel;
	private List<Integer> myList;
	private Random randomGenerator;

	public WorkerSequence2(int numberOfBits, MainPanel panel) {
		this.numberOfBits = numberOfBits;
		this.panel = panel;
		myList = new ArrayList<Integer>();
		this.randomGenerator = new Random();
	}

	@Override
	protected Void doInBackground() throws Exception {		
		for(int i = 0; i < numberOfBits; i++) {			
			publish(randomGenerator.nextInt(2));		
			Thread.sleep(25);
		}
		System.out.println("Worker of Sequence 1 has finished.");
		return null;
	}

	synchronized protected void process(List<Integer> list) {		
		panel.writeList2(list);
		myList.addAll(list);
		notifyAll();
	}

	synchronized public Integer readItem(int index) throws InterruptedException {
		while(index>=myList.size())
			wait();
		return myList.get(index);
	}
}
