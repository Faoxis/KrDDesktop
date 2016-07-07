package com.faoxis.krddesktop.view.right.controllers;

import com.faoxis.krddesktop.config.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 23.06.2016.
 */
public class StartButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Configuration.instance().getPortConnection() != null) {
            Configuration.instance().setStartGraphic(true);

            Configuration.instance().setState("Программа находится в режиме построения графика.");
        } else {
            JOptionPane.showMessageDialog(null, "Вначале необходимо произвести подключение.");
        }
    } // Конец метода actionPerformed
}
