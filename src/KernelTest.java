
public class KernelTest {
	
	public static void main(String[] args) {
		
		//Create a new kernel instance
		Kernel k = new Kernel();
		
		
		//create the processes
		k.createProcess("Process 1");
		k.createProcess("Process 2");
		k.createProcess("Process 3");
		k.createProcess("Process 4");
		k.createProcess("Process 5");
		
		
		//adding other processes
//		Thread.sleep(10000);
//		k.createProcess("Process 1");
		
	}
	
}
