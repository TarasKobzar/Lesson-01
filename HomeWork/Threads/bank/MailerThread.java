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
                            System.out.println("Транзакция прошла успешно!");
                        else System.out.println("Отмена транзакции!");
                    }
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
