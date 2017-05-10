package HomeWork.Threads.bank;

/**
 * Created by Тарас on 10.05.2017.
 */
public class TransferThread implements Runnable{
    public static boolean ready;
    public static boolean happy;

    Account acc1;
    Account acc2;
    int amount;

    public TransferThread (Account acc1, Account acc2, int amount){
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    public void run(){
        synchronized (acc1){
            if (acc1.balance >= amount) {
                synchronized (acc2) {
                    acc1.balance -= amount;
                    acc2.balance += amount;
                }
                ready = true;
                happy = true;

                synchronized (MailerThread.class){
                    MailerThread.class.notify();
                }
            }
            else{
                ready = true;
                happy = false;

                synchronized (MailerThread.class){
                    MailerThread.class.notify();
                }

                //System.out.println("Cansel " + amount + "! from " + acc1.userName + " to " + acc2.userName);
                //return;
            }
        }

        //System.out.println("Update " + amount + "! - " + acc1.userName + ": " + acc1.balance + ", " + acc2.userName + ": " + acc2.balance);
    }
}
