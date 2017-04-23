package HomeWork.Patterns.atom_Sensor_Observer;

/**
 * Created by Тарас on 23.04.2017.
 */
import java.util.*;

public class Sensor {
    private List<Listener> listeners = new ArrayList<>();

    public void subscribe (Listener listener){
        listeners.add(listener);
    }

    public void unsupscribe (Listener listener){
        listeners.remove(listener);
    }

    public void reportTemp (int temp){
        System.out.println("Текущая температура: " + temp);

        notifyListeners(temp);
    }

    public void notifyListeners (int temp){
        for (Listener listener : listeners)
            listener.signal(temp);
    }


}
