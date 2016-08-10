package com.faoxis.krddesktop.view.right;

import com.faoxis.krddesktop.view.right.controllers.ClearButtonListener;
import com.faoxis.krddesktop.view.right.controllers.StartButtonListener;
import com.faoxis.krddesktop.view.right.controllers.StopButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Sergei on 23.06.2016.
 */
public class ButtonMenu extends JPanel {

    public ButtonMenu() {
        GridBagConstraints layConstraints;

        this.setBorder(new EmptyBorder(4, 4, 4, 4)); // отступ внутри панели на 4 пикселя со всех сторон
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 0}; // высоты кнопок
        layout.columnWeights = new double[]{1.0};
        layout.rowWeights = new double[14];
        layout.rowWeights[layout.rowWeights.length - 1] = Double.MIN_VALUE;
        this.setLayout(layout);


        JButton startButton = new JButton("Старт");
        startButton.addActionListener(new StartButtonListener());
        layConstraints = getGridBagConstraints(0, 0, 1);
        this.add(startButton, layConstraints); // добавление кнопки на панель с учётом разметки

        JButton stopButton = new JButton("Стоп");
        stopButton.addActionListener(new StopButtonListener());
        layConstraints = getGridBagConstraints(0, 1, 1);
        this.add(stopButton, layConstraints);


        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener(new ClearButtonListener());
        layConstraints = getGridBagConstraints(1, 0, 2);
        this.add(clearButton, layConstraints);

    }

    private GridBagConstraints getGridBagConstraints(int col, int row, int size) {
        GridBagConstraints layConstraints = new GridBagConstraints();
        layConstraints.fill = GridBagConstraints.BOTH; // заполняет ячейку целиком
        layConstraints.gridwidth = size;
        layConstraints.gridx = row; // координаты ячейки, в которую помещается кнопка
        layConstraints.gridy = col;
        return layConstraints;
    }
}
