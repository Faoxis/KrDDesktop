package com.faoxis.krddesktop;

import com.faoxis.krddesktop.view.center.ChartDrawing;
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
        
        frame.setSize(800, 500);
        frame.setMinimumSize(new Dimension(800, 500));
        frame.getContentPane().add(new SettingsMenu(), BorderLayout.NORTH);
        frame.getContentPane().add(chartDrawing.getChartPanel());
        frame.setVisible(true);
    }
}
