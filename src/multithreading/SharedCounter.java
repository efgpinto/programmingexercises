package multithreading;

public class SharedCounter {

	public int counter = 0;
	
	public synchronized void inc() {
		counter++;
	}
	
	public void doWork() throws InterruptedException {
	
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++)
					inc();
			}
			
		});

		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++)
					inc();
			}
			
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	
		System.out.println("Count:" + counter);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SharedCounter s = new SharedCounter();
		s.doWork();
		
	}

}
