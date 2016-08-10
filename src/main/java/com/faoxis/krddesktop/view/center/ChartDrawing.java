package com.faoxis.krddesktop.view.center;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by Sergei on 23.06.2016.
 */
public class ChartDrawing {
    private String name;
    private String xLabel;
    private String yLabel;
    private ChartPanel chartPanel;
    private XYSeries channel1;
    private XYSeries channel2;

    public XYSeries getChannel1() {
        return channel1;
    }

    public void setChannel1(XYSeries channel1) {
        this.channel1 = channel1;
    }

    public ChartDrawing(String name, String xLabel, String yLabel) {
        this.name = name;
        this.xLabel = xLabel;
        this.yLabel = yLabel;

        initChartPanel();
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    private void initChartPanel() {
        channel1 = new XYSeries("Канал 1");
        channel2 = new XYSeries("Канал 2");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(channel1);
        //dataset.addSeries(channel2);

        // XYDataset is
        XYDataset xyDataset = dataset;

        JFreeChart chart = ChartFactory.createXYLineChart(
                name, xLabel, yLabel, xyDataset, PlotOrientation.VERTICAL, true, true, true);

        chartPanel = new ChartPanel(chart);
    }
}
