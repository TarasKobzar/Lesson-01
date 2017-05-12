package HomeWork.Threads.bank;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TransferThread implements Runnable{
    static boolean ready;

    static BlockingQueue<String> mailerQueue = new LinkedBlockingQueue<>();

    Account acc1;
    Account acc2;
    int amount;

    public TransferThread (Account acc1, Account acc2, int amount){
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    public void run(){
        if(acc1.id < acc2.id){
            synchronized (acc1){
                if (acc1.balance >= amount) {
                    synchronized (acc2) {
                        acc1.balance -= amount;
                        acc2.balance += amount;

                        try {
                            mailerQueue.put(Thread.currentThread().getName() + " Finish! $ " + amount + ": " + acc1.userName + " --> " + acc2.userName);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    try {
                        mailerQueue.put(Thread.currentThread().getName() + " Cancel! $ " + amount + ": " + acc1.userName + " -X-> " + acc2.userName);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return;
                }
            }
        }
        else{
            synchronized (acc2){
                synchronized (acc1) {
                    if (acc1.balance >= amount) {
                        acc1.balance -= amount;
                        acc2.balance += amount;

                        try {
                            mailerQueue.put(Thread.currentThread().getName() + " Finish! $ " + amount + ": " + acc1.userName + " --> " + acc2.userName);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            mailerQueue.put(Thread.currentThread().getName() + " Cancel! $ " + amount + ": " + acc1.userName + " -X-> " + acc2.userName);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return;
                    }
                }
            }
        }
    }
}
