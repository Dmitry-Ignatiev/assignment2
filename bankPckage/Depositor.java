package bankPckage;

public class Depositor implements Runnable{
bankAccount counter;
public Depositor(bankAccount counter) {
	this.counter=counter;
}
public void run() {
	for (int i=0;i<1000;i++)
	{
		counter.addOne();
		
	}
	
	
	
}

}
