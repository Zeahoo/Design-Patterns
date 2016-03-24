
/**
 * Created by SunnyZheng on 3/20/16.
 */
public class CanonPrinter extends Printer {

    public CanonPrinter(){
        originalPrice = 1998;
        discountMethod = new Nodiscount();
        printerName = "佳能打印机";
        discountWay = "无折扣";
    }

    @Override
    public double getRealPrice() {
        return discountMethod.discount(originalPrice,quantity);
    }

}
