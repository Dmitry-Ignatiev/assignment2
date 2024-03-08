public class Main {
	public static void main(String[] args) {
		// Create the threads
		T1 t1 = new T1();
		T2 t2 = new T2();
		T3 t3 = new T3();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY-1);
		t3.setPriority(Thread.MAX_PRIORITY-2);
		// Start all threads
		t1.start();
		t2.start();
		t3.start();

		try {
			// Wait for all threads to complete
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {

			// Once all threads have completed, print the message
			System.out.println("All threads completed. Main thread exiting.");
		}
	}
}
