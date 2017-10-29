package multithreading;

class Fork {
	boolean available = true;
	
	public boolean isAvailable() {
		return available;
	}
	
	public void pickup() {
		available = false;
	}
	
	public void putdown() {
		available = true;
	}
}

class Philosopher implements Runnable {
	
	int id;
	int thinking = 0;
	int eating = 0;
	int left, right;
	
	static Object mutex = new Object();
	
	public Philosopher(int id) {
		this.id = id;
		left = id == 0 ? DiningPhilosophers.nPhilosophers -1 : id-1;
		right = id == DiningPhilosophers.nPhilosophers ? 0 : id;
	}
	
	public String toString() {
		return "I'm " + id + ", have eaten for " + eating + " mins and thought for " + thinking + " mins.";
	}

	public boolean tryPickup() {
		synchronized (mutex) {
			if (DiningPhilosophers.forks[left].isAvailable() &&
					DiningPhilosophers.forks[right].isAvailable()) {
				DiningPhilosophers.forks[left].pickup();
				DiningPhilosophers.forks[right].pickup();
				return true;
			}
			return false;
		}
	}
	
	public void putDown() {
		synchronized (mutex) {
			DiningPhilosophers.forks[left].putdown();
			DiningPhilosophers.forks[right].putdown();
		}
	}
	
	
	public void run() {
		while (thinking < 1000) {
			if (tryPickup()) {
				
				eating++;
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				putDown();
			}
		
			
			try {
				Thread.sleep(1);
				thinking++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DiningPhilosophers {
	
	public static final int nPhilosophers = 5;
	public static Fork[] forks = new Fork[nPhilosophers];
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread[] ts = new Thread[nPhilosophers];
		Philosopher[] phils = new Philosopher[nPhilosophers];
		
		for (int i = 0; i < nPhilosophers; i++) {
			forks[i] = new Fork();
			phils[i] = new Philosopher(i);
			Thread temp = new Thread(phils[i]);
			ts[i] = temp;
		}
		
		for (int i = 0; i < nPhilosophers; i++) {
			ts[i].start();
		}
		
		for (int i = 0; i < nPhilosophers; i++) {
			ts[i].join();
		}
		
		for (int i = 0; i < nPhilosophers; i++) {
			System.out.println(phils[i]);
		}
		
		
	}
}
