package HomeWork.Threads.bank;

import java.util.ArrayList;

public class Bank {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Account> accList = new ArrayList<>();
        accList.add(new Account(0, "Petrov", 50));
        accList.add(new Account(1, "Ivanov", 50));
      /*  accList.add(new Account(2, "Sidorov", 150));
        accList.add(new Account(3, "Kozlov", 50));
        accList.add(new Account(4, "Pupkin", 250));*/

        for (Account acc : accList)
            System.out.println(acc.userName + ": " + acc.balance);

        System.out.print("\n");

        Thread mailerThread = new Thread(new MailerThread());
        mailerThread.start();

        for (int i = 0; i < 10; i++){
            new Thread(new TransferThread(accList.get(0), accList.get(1), 50)).start();
            new Thread(new TransferThread(accList.get(1), accList.get(0), 50)).start();
        }

        Thread.sleep(1000);

        mailerThread.interrupt();

        System.out.print("\n");

        for (Account acc : accList)
            System.out.println(acc.userName + ": " + acc.balance);
    }
}
