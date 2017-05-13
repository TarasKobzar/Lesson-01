package HomeWork.Threads.bank;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TransferThread implements Runnable{
    static BlockingQueue<String> mailerQueue = new LinkedBlockingQueue<>();

    Account acc1;
    Account acc2;
    int amount;

    public TransferThread (Account acc1, Account acc2, int amount){
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    public void transferMoney(Account acc1, Account acc2, int amount) {
        synchronized (acc1.id < acc2.id ? acc1 : acc2){
            try {
                if (acc1.balance >= amount) {
                    synchronized (acc1.id < acc2.id ? acc2 : acc1) {
                        acc1.balance -= amount;
                        acc2.balance += amount;

                        mailerQueue.put(Thread.currentThread().getName() + " Finish! $ " + amount + ": " + acc1.userName + " --> " + acc2.userName);
                    }
                }
                else mailerQueue.put(Thread.currentThread().getName() + " Cancel! $ " + amount + ": " + acc1.userName + " -X-> " + acc2.userName);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run(){
        transferMoney(acc1, acc2, amount);
    }
}
