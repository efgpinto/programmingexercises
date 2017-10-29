package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ThreadFactoryImpl implements ThreadFactory {
	
	int id = 0;
	
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r, "theboss"+id++);
	}
}

public class ThreadPools {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryImpl());
		
		for (int i = 0; i < 5; i++) {
			es.submit(new Runnable() {
	
				@Override
				public void run() {
					System.out.println("Starting thread...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Ending thread...");
				}
				
			});
		}
		
		es.shutdown();
		try {
			es.awaitTermination(1, TimeUnit.DAYS);

			System.out.println("All threads completed...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
