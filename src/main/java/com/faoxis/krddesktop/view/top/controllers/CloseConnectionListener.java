package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.config.Configuration;
import jssc.SerialPortException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 23.06.2016.
 */
public class CloseConnectionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (Configuration.instance().getPortConnection() == null) {
                JOptionPane.showMessageDialog(null, "Невозможно закрыть соединение, которого нет.");
                return;
            }

            Configuration.instance().getPortConnection().closePortConnection();
            Configuration.instance().setState("Соединение отключено.");
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка отключения устройства. " +
                    "Рекомендую выдернуть и всунуть проводок.");
        } finally {
            Configuration.instance().resetPortConnection();
        }
    } // Конец метода actionPerformed
} // Конец класса CloseConnectionListener