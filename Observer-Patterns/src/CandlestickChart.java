import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CandlestickChart extends JFrame {
    private String stockSymbol = "中国联通股票";
    private double open, high,low,close,volume,adjClose;
    public CandlestickChart(double[] data) {
        super("中国联通 4月份 k 线图");
        this.open = data[0];
        this.high = getMax(data);
        this.low = getMin(data);
        this.close = data[data.length - 1];
        this.volume = 5000000;
        this.adjClose = getAverage(data);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DateAxis    domainAxis       = new DateAxis("日期");
        NumberAxis  rangeAxis        = new NumberAxis("价格");
        CandlestickRenderer renderer = new CandlestickRenderer();
        XYDataset   dataset          = getDataSet();

        XYPlot mainPlot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);

        //Do some setting up, see the API Doc
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setDrawVolume(false);
        rangeAxis.setAutoRangeIncludesZero(false);
        domainAxis.setTimeline( SegmentedTimeline.newMondayThroughFridayTimeline() );

        //Now create the chart and chart panel
        JFreeChart chart = new JFreeChart(stockSymbol, null, mainPlot, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));

        this.add(chartPanel);
        this.pack();
        this.setVisible(true);
    }

    private double getMax(double[] data) {
        double temp = data[0];
        for(int i = 1; i < data.length; i++){
            if(temp < data[i])
                temp = data[i];
        }
        return temp;

    }
    private double getMin(double[] data) {
        double temp = data[0];
        for(int i = 1; i < data.length; i++){
            if(temp > data[i])
                temp = data[i];
        }
        return temp;
    }
    private double getAverage(double[] data){
        double sum = 0;
        for(double i : data){
            sum += i;
        }
        return sum / data.length;
    }
    protected AbstractXYDataset getDataSet() {
        //This is the dataset we are going to create
        DefaultOHLCDataset result = null;
        //This is the data needed for the dataset
        OHLCDataItem[] ddata;

        //This is where we go get the data, replace with your own data source
        ddata = getData();

        //Create a dataset, an Open, High, Low, Close dataset
        result = new DefaultOHLCDataset(stockSymbol, ddata);

        return result;
    }
    //This method uses yahoo finance to get the OHLC data
    protected OHLCDataItem[] getData() {

        //New
        List<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();

        for(int i = 1; i < 30; i++){
            Date d = new Date(2016, 3, i);
            if(i != 16){
                OHLCDataItem item = new OHLCDataItem(d, 0, 0, 0, 0, 0);
                dataItems.add(item);
            }else{
                OHLCDataItem item = new OHLCDataItem(d, open, high, low, close, volume);
                dataItems.add(item);
            }

        }
        OHLCDataItem[] ddata = dataItems.toArray(new OHLCDataItem[dataItems.size()]);
        return ddata;
    }

//    public static void main(String[] args) {
//        new CandlestickChart("MSFT").setVisible(true);
//    }
}