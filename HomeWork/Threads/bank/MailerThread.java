package HomeWork.Threads.bank;

import java.util.Iterator;

/**
 * Created by Тарас on 10.05.2017.
 */
public class MailerThread implements Runnable{
    public void run(){

        while(!Thread.currentThread().isInterrupted()){
            Iterator iter = TransferThread.mailerQueue.iterator();

            if(iter.hasNext()){
                System.out.println(iter.next());

                iter.remove();
            }
        }
    }
}
