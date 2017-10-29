package multithreading;

import java.util.Random;

public class MaxValue implements Runnable {
	
	public static int[] values;
	public static volatile int max = 0;
	
	int i, j;
	
	public MaxValue(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public void run() {
		
		for (int k = i; k <= j; k++) {
			if (values[k] > max)
				max = values[k];
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		
		values = new int[20];
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextInt(300);
			System.out.print(values[i]+", ");
		}
		
		MaxValue m = new MaxValue(0, 9);
		MaxValue m1 = new MaxValue(10, 19);
		Thread t = new Thread(m);
		Thread t2 = new Thread(m1);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println("\nMAX: " + max);
	}


}
