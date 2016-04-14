/**
 * Created by SunnyZheng on 4/14/16.
 */
public class Candlestick implements Observer, DisplayElement {
    private Subject stockMarket;
//    private double initValue;
    private double[] data;
    public Candlestick(Subject stockMarket){
        this.stockMarket = stockMarket;
        stockMarket.addObserver(this);
    }
    @Override
    public void display() {
        new CandlestickChart(data);
    }

    @Override
    public void update(double[] data) {
        this.data = data;
        display();
    }
}
