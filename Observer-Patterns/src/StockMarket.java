import java.util.ArrayList;

/**
 * Created by SunnyZheng on 3/27/16.
 */
public class StockMarket implements Subject {
    private ArrayList observers;
    public StockMarket(){
        observers = new ArrayList();
    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update();
        }
    }
}
