package launcher;
import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
		Student alumnoyo= new Student(124903, "Dueñas Pacioni", "Nahuel", "ndp912@gmail.com.ar", "https://github.com/NahuelDP8/-tdp-proyecto-1", "/images/miFoto.png");
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen screen = new SimplePresentationScreen(alumnoyo);
            	screen.setVisible(true);
            }
        });
    }
}