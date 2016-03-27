/**
 * Created by SunnyZheng on 3/27/16.
 */
public class CurrentPrice implements Observer, DisplayElement {
    private Subject stockMarket;
    public CurrentPrice(Subject stockMarket) {
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
