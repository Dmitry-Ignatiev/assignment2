package T2;

import java.util.concurrent.*;

public class SemaphoreExample {
    static class SharedResource {
        private final Semaphore semaphore;
        private int permits_;

        public SharedResource(int permits) {
            permits_ = permits;
            semaphore = new Semaphore(permits, true); 
        }

        public synchronized void accessResource() throws InterruptedException {
            while (permits_ <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }

            try {
                semaphore.acquire();
                // Access the resource here...
                System.out.println(Thread.currentThread().getName() + " is accessing the resource.");
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                permits_++;
                notifyAll();
            }
        }
    }

    static class Worker extends Thread {
        private final SharedResource sharedResource;

        public Worker(String name, SharedResource sharedResource) {
            super(name);
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
        	synchronized (this) {
        		try {
        			if (sharedResource.permits_ < 1) {
        				wait();
        			}
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}finally {
        			try{sharedResource.accessResource(); // Access the shared resource
        			}catch(InterruptedException e) {
        				e.printStackTrace();}
        		}

        	}

        }
    }


    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(2); //  permits available

        // Create multiple threads trying to access the resource
        Thread thread1 = new Worker("Thread 1", sharedResource);
        Thread thread2 = new Worker("Thread 2", sharedResource);
        Thread thread3 = new Worker("Thread 3", sharedResource);

        thread1.start();
        thread2.start();
        thread3.start();
       
    }
}
