/**
 * Created by SunnyZheng on 4/14/16.
 */
public class TimeSequence implements Observer, DisplayElement {
    private Subject stockMarket;

    private double[] data;
    public TimeSequence(Subject stockMarket){
        this.stockMarket = stockMarket;
        stockMarket.addObserver(this);
    }
    @Override
    public void display() {
        new TimesequenceChart(data);
    }

    @Override
    public void update(double[] data) {
        this.data = data;
        display();
    }
}
