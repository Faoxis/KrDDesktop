package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.config.Configuration;
import jssc.SerialPortException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 23.06.2016.
 */
public class OpenConnectionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (Configuration.instance().getPortConnection() == null) {
                Configuration.instance().setPortConnection(Configuration.instance().getNumberOfCom());
                Configuration.instance().setState("Соединение установлено");
            } else {
                JOptionPane.showMessageDialog(null, "Соединение уже установлено.");
            }
        } catch (SerialPortException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка подключения к устройству.");
            Configuration.instance().resetPortConnection();
        }
    } // Конец метода actionPerformed
} // Конец класса OpenConnectionListener
