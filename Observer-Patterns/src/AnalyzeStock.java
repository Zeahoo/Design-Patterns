/**
 * Created by SunnyZheng on 3/27/16.
 */
public class AnalyzeStock implements Observer, DisplayElement {
    private Subject stockMarket;
    public AnalyzeStock(Subject stockMarket) {
        this.stockMarket = stockMarket;
        stockMarket.addObserver(this);
    }

    @Override
    public void display() {

    }

    @Override
    public void update() {

    }
}
