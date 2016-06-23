package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.port.PortConnection;
import com.faoxis.krddesktop.settings.SettingsContainer;
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
            if (SettingsContainer.instance().getPortConnection() == null) {
                SettingsContainer.instance().setPortConnection(SettingsContainer.instance().getNumberOfCom());
                SettingsContainer.instance().setState("Соединение установлено");
            } else {
                JOptionPane.showMessageDialog(null, "Соединение уже установлено.");
            }
        } catch (SerialPortException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка подключения к устройству.");
            SettingsContainer.instance().resetPortConnection();
        }
    } // Конец метода actionPerformed
} // Конец класса OpenConnectionListener
