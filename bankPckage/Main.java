package bankPckage;

public class Main {
    public static void main(String[] args) {
        bankAccount account = new bankAccount();
        Depositor wife = new Depositor(account);
        Depositor husband = new Depositor(account);
        Thread wifeThread = new Thread(wife);
        Thread husbandThread = new Thread(husband);
        wifeThread.start();
        husbandThread.start();
//         try {
//         
//         
//         
//         }catch(InterruptedException e) {
//         e.printStackTrace();
//         }
        System.out.println(account.getCount());
    }
}