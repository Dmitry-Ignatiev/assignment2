class T1 extends Thread{
    private final Object lock;
    private boolean hasLock;
    public T1() {
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
                		 System.out.println(Thread.currentThread().getName() +1+ " is waiting for T3 to finish...");
                		 }
                	 }
                }               
                System.out.println(Thread.currentThread().getName()+1+" is Running...");
        
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Notify other threads that T1 is finished
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName()+1+" finished");
            }
        }
    }
}