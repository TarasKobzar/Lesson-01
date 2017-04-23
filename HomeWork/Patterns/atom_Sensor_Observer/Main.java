package HomeWork.Patterns.atom_Sensor_Observer;

/**
 * Created by Тарас on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int temp = 100;

        Sensor sensor = new Sensor();

        sensor.subscribe(new Listener(){
           public void signal (int temp){
               if (temp >= 150 && temp < 200)
                   System.out.println("Зеленый уровень опасности!");
           }
        });

        sensor.subscribe(new Listener(){
            public void signal(int temp){
                if (temp >= 200 && temp < 250)
                    System.out.println("Желтый уровень опасности!");
            }
        });

        sensor.subscribe(new Listener(){
            public void signal(int temp){
                if (temp >= 250)
                    System.out.println("Красный уровень опасности!");
            }
        });

        while (temp <=300){
            sensor.reportTemp(temp);

            Thread.sleep(2000);

            temp += 10;
        }

        if (temp > 300)
            System.out.println("Booom!");
    }
}
