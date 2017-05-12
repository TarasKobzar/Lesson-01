package HomeWork.Threads.bank;

import java.util.Iterator;

/**
 * Created by Тарас on 10.05.2017.
 */
public class MailerThread implements Runnable{
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                System.out.println(TransferThread.mailerQueue.take());
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
