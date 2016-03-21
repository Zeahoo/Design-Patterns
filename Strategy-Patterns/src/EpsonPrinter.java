/**
 * Created by SunnyZheng on 3/20/16.
 */
public class EpsonPrinter extends Printer {

    public EpsonPrinter(){
        originalPrice = 1899;
        discountMethod = new MinusFixedDiscount();
        printerName = "爱普生打印机";
        discountWay = "每台减扣 200 元";
    }

    @Override
    public double getRealPrice() {
        return discountMethod.discount(originalPrice,quantity);
    }
}
