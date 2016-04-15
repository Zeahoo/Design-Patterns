/**
 * Created by SunnyZheng on 4/14/16.
 */
/**
 * Created by SunnyZheng on 4/14/16.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;

public class TimesequenceChart extends JFrame implements ActionListener {
    private TimeSeries series;
    private double initValue;
    private double[] data;
    /**
     * 构造
     */
    public TimesequenceChart(double[] data) {
        this.data = data;
//        generateData(data);
        getContentPane().setBackground(Color.green);
        this.setTitle("中国联通 4月16日 股票 分时图");
        this.createUI();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 400);
        this.setVisible(true);
        this.dynamicRun();
    }
    /**
     * 动态运行
     */
    public void dynamicRun() {
        for (int i = 0; i < 24; i++) {
            Day d = new Day(16, 4, 2016);
            this.series.add(new Hour(i, d), data[i]);
            try {
                Thread.currentThread().sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建应用程序界面
     */
    public void createUI() {
        this.series = new TimeSeries("每小时股票价格");
        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        ChartPanel chartPanel = new ChartPanel(createChart(dataset));
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        add(chartPanel);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * 根据结果集构造JFreechart报表对象
     */
    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart result = ChartFactory.createTimeSeriesChart("中国联通股票", "4月16日",
                "数值变化", dataset, true, true, false);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
    }

}