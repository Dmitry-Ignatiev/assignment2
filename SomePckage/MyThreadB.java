package SomePckage;

public class MyThreadB extends Thread{
private MythreadA t_;
public MyThreadB() {
	
	t_=new MythreadA(this);
	
	
}
public void run() {
	System.out.println("in myThreadB run()");
	t_.f();
	t_.start();
}
}
