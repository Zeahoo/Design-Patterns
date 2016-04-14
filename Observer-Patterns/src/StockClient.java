import java.util.Random;

/**
 * Created by SunnyZheng on 3/27/16.
 */
public class StockClient {
    public static void main(String[] args){

        double initValue = 100;
        double data[] = new double[24];

        StockMarket stockMarket = new StockMarket();
        TimeSequence timeSequence = new TimeSequence(stockMarket);
        Candlestick candlestick = new Candlestick(stockMarket);
        generateData(data);
        stockMarket.changed(data);
    }
    public static void generateData(double[] data){
        for(int i = 0; i < data.length; i++){
            data[i] = 100 * (0.9 + 0.2 * Math.random());
        }
    }
}
