/**
 * Created by SunnyZheng on 3/20/16.
 */
public class HPPrinter extends Printer {
    public HPPrinter() {
        originalPrice = 1788;
        discountMethod = new DiscountByPercent();
        printerName = "惠普打印机";
        discountWay = "八五折";
    }

    @Override
    public double getRealPrice() {
        return discountMethod.discount(originalPrice,quantity);
    }
}
