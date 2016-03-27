/**
 * Created by SunnyZheng on 3/27/16.
 */
public class ForcastPrice implements Observer, DisplayElement {
    private Subject stockMarket;
    public ForcastPrice(Subject stockMarket) {
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
