package HomeWork.Threads.bank;

import java.util.ArrayList;

/**
 * Created by Тарас on 10.05.2017.
 */
public class Bank {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Account> accList = new ArrayList<>();
        accList.add(new Account(0, "Petrov", 100));
        accList.add(new Account(1, "Ivanov", 200));
        accList.add(new Account(2, "Sidorov", 150));
        accList.add(new Account(3, "Kozlov", 50));
        accList.add(new Account(4, "Pupkin", 250));

        for (Account acc : accList) {
            System.out.println(acc.userName + ": " + acc.balance);
        }

        transferMoney(accList.get(0), accList.get(1), 50);
        transferMoney(accList.get(1), accList.get(0), 100);
        transferMoney(accList.get(0), accList.get(1), 50);
        transferMoney(accList.get(1), accList.get(0), 100);
        transferMoney(accList.get(0), accList.get(1), 50);
        transferMoney(accList.get(1), accList.get(0), 100);


        Thread.sleep(1000);

        for (Account acc : accList) {
            System.out.println(acc.userName + ": " + acc.balance);
        }
    }

    public static void transferMoney(Account acc1, Account acc2, int amount) throws InterruptedException {
        Thread thread = new Thread(new TransferThread(acc1, acc2, amount));

        thread.start();
    }
}
