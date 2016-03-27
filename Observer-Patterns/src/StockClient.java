/**
 * Created by SunnyZheng on 3/27/16.
 */
public class StockClient {
    public static void main(String[] args){
        StockMarket stockMarket = new StockMarket();

        CurrentPrice currentPrice = new CurrentPrice(stockMarket);
        AnalyzeStock analyzeStock = new AnalyzeStock(stockMarket);
        ForcastPrice forcastPrice = new ForcastPrice(stockMarket);
    }

}
