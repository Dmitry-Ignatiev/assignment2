package bankPckage;

public class bankAccount {
    private int count = 0;

    public synchronized void addOne() {
        count++;
    }

    public int getCount() {
        return count;
    }
}