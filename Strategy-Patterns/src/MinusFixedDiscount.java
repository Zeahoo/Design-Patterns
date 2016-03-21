/**
 * Created by SunnyZheng on 3/20/16.
 */
public class MinusFixedDiscount implements DiscountMethod {
    final double DISCOUNT_NUMBER = 200;

    @Override
    public double discount(double price, int quantity) {
        return (price - DISCOUNT_NUMBER) * quantity;
    }
}
