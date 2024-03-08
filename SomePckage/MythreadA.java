package SomePckage;

public class MythreadA extends Thread{
	MyThreadB t_;
	public MythreadA(MyThreadB t) {
		t_=t;
	
	
	}
	public void run() {
		System.out.println("in my threadA run()");
	t_.start();
		
	}
	public void f() {
		System.out.println("f() is called");
	}
	
}
