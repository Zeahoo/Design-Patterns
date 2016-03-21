/**
 * Created by SunnyZheng on 3/20/16.
 */
public abstract class Printer {
    DiscountMethod discountMethod;
    protected double originalPrice;
    protected int quantity;
    protected String printerName;
    protected String discountWay;
    public Printer(){

    }
    public  String getMessage(String printerName, String discountWay){
        return String.format("你购买的是: %s\n" +
                        "原价: %.2f, 购买数量: %d\n" +
                        "折扣方式为: %s\n" +
                        "最终总价为: %.2f\n",
                printerName, originalPrice, quantity,
                discountWay, discountMethod.discount(originalPrice,quantity));
    }
    public abstract double getRealPrice();
}
