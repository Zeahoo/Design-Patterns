import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SunnyZheng on 4/14/16.
 */
public class CandlestickChart{
    double first, last, low, high;
    public CandlestickChart(double[] data) {
        this.first = data[0];
        this.last = data[data.length - 1];
        this.low = getLowPrice(data);
        this.high = getHighPrice(data);
        System.out.printf("该日的开盘价为 %.2f元, 收盘价为 %.2f元\n" +
                "最高价为 %.2f元, 最低价为 %.2f元\n", first, last, high, low);
    }
    public double getLowPrice(double[] data){
        double temp = data[0];
        for(int i = 1; i < 24; i++){
            if(temp > data[i])
                temp = data[i];
        }
        return temp;
    }
    public double getHighPrice(double[] data){
        double temp = data[0];
        for(int i = 1; i < 24; i++){
            if(temp < data[i])
                temp = data[i];
        }
        return temp;
    }

}
