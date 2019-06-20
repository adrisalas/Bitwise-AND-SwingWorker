package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class Main {
   
    public static void main(String args[]) {
    	System.out.println("main() - isEventDispatchThread? "+ SwingUtilities.isEventDispatchThread());
    	
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	System.out.println("run() - isEventDispatchThread? "+ SwingUtilities.isEventDispatchThread());
            	JFrame frame = new JFrame();
            	MainPanel panel = new MainPanel();
            	Controller controller = new Controller(panel);
            	panel.setController(controller);
            	
            	frame.setTitle("App Sequence of Bits - ©Adrian Salas Troya, 2019");
            	frame.setContentPane(panel);
                frame.pack();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}