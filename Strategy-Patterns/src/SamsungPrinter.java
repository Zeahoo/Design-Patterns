/**
 * Created by SunnyZheng on 3/21/16.
 */
public class SamsungPrinter extends Printer {

    public SamsungPrinter() {
        originalPrice = 2678;
        discountMethod = new DiscountByPercent();
        printerName = "三星打印机";
        discountWay = "八五折";
    }




    @Override
    public double getRealPrice() {
        return  discountMethod.discount(originalPrice,quantity);
    }
}
