/**
 * Created by SunnyZheng on 3/27/16.
 */
public interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
