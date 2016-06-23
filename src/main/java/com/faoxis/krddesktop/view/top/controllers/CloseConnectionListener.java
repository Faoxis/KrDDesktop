package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.settings.SettingsContainer;
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

            if (SettingsContainer.instance().getPortConnection() == null) {
                JOptionPane.showMessageDialog(null, "Невозможно закрыть соединение, которого нет.");
                return;
            }

            SettingsContainer.instance().getPortConnection().closePortConnection();
            SettingsContainer.instance().setState("Соединение отключено.");
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка отключения устройства. " +
                    "Рекомендую выдернуть и всунуть проводок.");
        } finally {
            SettingsContainer.instance().resetPortConnection();
        }
    } // Конец метода actionPerformed
} // Конец класса CloseConnectionListener