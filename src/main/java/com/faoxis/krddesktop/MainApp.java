package com.faoxis.krddesktop;

import com.faoxis.krddesktop.view.center.ChartDrawing;
import com.faoxis.krddesktop.view.right.ButtonMenu;
import com.faoxis.krddesktop.view.top.SettingsMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sergei on 21.06.2016.
 */
public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KrDDesktop_v1.00");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChartDrawing chartDrawing = new ChartDrawing("График положения шторки", "Время", "Координата");
        JLabel label = new JLabel("Программа только что запустилась");

        UpdateChartThread updateChart = new UpdateChartThread(chartDrawing.getChartPanel());
        updateChart.run();
        UpdateLabelThread updateLabelThread = new UpdateLabelThread(label);
        updateLabelThread.run();

        frame.setSize(800, 500);
        frame.setMinimumSize(new Dimension(800, 500));
        frame.getContentPane().add(new SettingsMenu(), BorderLayout.NORTH);
        frame.getContentPane().add(chartDrawing.getChartPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(new ButtonMenu(), BorderLayout.EAST);
        frame.getContentPane().add(label, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
