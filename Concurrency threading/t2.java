class T2 extends Thread{
    private final Object lock;
    private boolean hasLock=false;
    public T2() {
        this.lock = this;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
            	if (!Thread.currentThread().equals(lock)) {
                	 synchronized(this) {
                		 while(!hasLock) {
                		 lock.wait();
                		 System.out.println(Thread.currentThread().getName() + 1+" is waiting for T1 to finish...");
                         }
                	 }
                }               
                System.out.println("Thread 2 is running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Notify other threads that T2 is finished
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName()+1+"  finished");
            }
        }
    }
}