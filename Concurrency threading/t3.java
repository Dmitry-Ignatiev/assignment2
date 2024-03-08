class T3 extends Thread{
	private final Object lock;
	private boolean hasLock=false;
	public T3() {this.lock=this;}

	@Override
	public void run() {
		synchronized (lock) {
				synchronized(this) {
						if (!Thread.currentThread().equals(lock)) {
							
								try {
									while(!hasLock) {
								lock.wait();
								System.out.println(Thread.currentThread().getName() + 1+" is waiting for T2 to finish...");
									}
							}catch(InterruptedException e) {}
						}      
				}
						System.out.println(Thread.currentThread().getName()+1+" is running");
				
				// Notify other threads that T3 is finished
				lock.notifyAll();
				System.out.println(Thread.currentThread().getName()+1+" finished");
			}
		}
}
	
		
