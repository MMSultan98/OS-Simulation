import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class Dispatcher extends TimerTask {
	
	private Vector<Process> readyQueue;
	private Process currentlyRunning;
	private Timer timer;
	
	
	public Dispatcher(Vector<Process> readyQueue) {
		this.readyQueue = readyQueue;
		timer = new Timer();
		timer.schedule(this, 100, 50);
	}
	
	
	
	//FCFS algorithm
	@SuppressWarnings("deprecation")
	public void run() {
		
		if (currentlyRunning==null && readyQueue.isEmpty())
			timer.cancel();
		
		
		if (currentlyRunning != null) {
			if (currentlyRunning.getCurrentState()==ProcessState.BLOCKED || currentlyRunning.getCurrentState()==ProcessState.FINISHED)
				currentlyRunning = null;
		}
		
		
		if (currentlyRunning == null && !readyQueue.isEmpty()) {
			currentlyRunning = readyQueue.remove(0);
			currentlyRunning.setCurrentState(ProcessState.RUNNING);
			if (currentlyRunning.isAlive())
				currentlyRunning.resume();
			else
				currentlyRunning.start();
		}
		
	}
	
	
}
