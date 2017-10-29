package multithreading;

public class ReverseHello implements Runnable {
	
	int id;
	
	public ReverseHello(int id) {
		this.id = id;
	}
	
	public void run() {
		
		if (id < 50) {
			Thread t = new Thread(new ReverseHello(id+1));
			try {
				t.start();
				t.join();
				System.out.println("Hello from " + id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		else
			System.out.println("Hello from " + id);
		
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new ReverseHello(0));
		t.start();
	}

}
