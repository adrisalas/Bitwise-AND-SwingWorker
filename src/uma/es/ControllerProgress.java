package uma.es;
/**
 * @author Adrian Salas Troya
 * UMA - Systems Programming and Concurrency Events
 * 
 * IMPORTANT: For the UI I use miglayout-swing as a library, the program will not compile without it
 * I add the .jar version of the program and the library in the project folder
 */
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class ControllerProgress implements PropertyChangeListener{
       private MainPanel panel;

       public ControllerProgress(MainPanel panel){
            this.panel=panel;
       }
      
       @Override
       public void propertyChange(PropertyChangeEvent e) {

          if (e.getPropertyName().equals("progress")){
             int progress = (Integer)e.getNewValue();
             panel.setMyProgress(progress);
          }
       }
}
