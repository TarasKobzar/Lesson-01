package HomeWork.Threads.bank;

/**
 * Created by Тарас on 10.05.2017.
 */
public class MailerThread implements Runnable{

    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            synchronized (this){
                try{
                    this.wait();

                    if (TransferThread.ready){
                        if (TransferThread.happy = true)
                            System.out.println("Update " + TransferThread.amount + "! - " + acc1.userName + ": " + acc1.balance + ", " + acc2.userName + ": " + acc2.balance);


                    }
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
