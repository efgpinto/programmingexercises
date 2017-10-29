package multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	int limit = 10;
	LinkedList<Integer> queue = new LinkedList<Integer>();
	Object lock = new Object();
	
	//BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	

	
	void producer() throws InterruptedException {
		int i = 0;
		while (true) {
			synchronized (lock) {
			
				while (queue.size() == limit)
					lock.wait();
				
				queue.add(i++);
				System.out.println("Added " + (i-1) + " total " + queue.size());
				lock.notify();			
			}
		}
	}
	
	void consumer() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while (queue.isEmpty())
					lock.wait();
				
				Integer i = queue.poll();
				System.out.println("Removed " + i + " remain " + queue.size());
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer e = new ProducerConsumer();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					e.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					e.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
	

}
