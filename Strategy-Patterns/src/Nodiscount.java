/**
 * Created by SunnyZheng on 3/20/16.
 */
public class Nodiscount implements DiscountMethod {


    @Override
    public double discount(double price, int quantity) {
        return price * quantity;
    }
}
