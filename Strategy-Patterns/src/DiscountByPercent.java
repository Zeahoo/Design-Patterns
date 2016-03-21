/**
 * Created by SunnyZheng on 3/20/16.
 */
public class DiscountByPercent implements DiscountMethod {
    final double PERCENT = 0.15;

    @Override
    public double discount(double price, int quantity) {
        return price * (1 - PERCENT) * quantity;
    }
}
