package com.faoxis.krddesktop;

import com.faoxis.krddesktop.config.Configuration;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;

/**
 * Created by Sergei on 23.06.2016.
 */
public class UpdateChartThread extends Thread {
    private ChartPanel chartPanel;
    private XYSeries channel1;
    private long counter = 0;

    public UpdateChartThread(ChartPanel chartPanel, XYSeries channel1) {
        this.chartPanel = chartPanel;
        this.channel1 = channel1;
    }

    @Override
    public void run() {
        while(true) {
            if (Configuration.instance().isStartGraphic()) {
                try {
                    Thread.currentThread().sleep(1);
                    if (Configuration.instance().isDataCame()) {
                        channel1.add(this.counter++, Configuration.instance().getData());
                        chartPanel.repaint();
                    }

                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Что-то пошло не так в отдельной ните");
                }
            } else {
                try { Thread.currentThread().sleep(100); }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        }
    }
}
