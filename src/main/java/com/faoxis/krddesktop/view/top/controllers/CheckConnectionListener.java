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
public class CheckConnectionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Делаем проверку на наличие уже готового подключения, чтобы не разорвать его при попытке проверить
        if (SettingsContainer.instance().getPortConnection() != null) {
            JOptionPane.showMessageDialog(null, "Подключение уже установлено или порт не был выбран.");
            return;
        }

        try {
            SettingsContainer.instance().setPortConnection(SettingsContainer.instance().getNumberOfCom());
            SettingsContainer.instance().getPortConnection().closePortConnection();
            SettingsContainer.instance().resetPortConnection();

            SettingsContainer.instance().setState("Соединение было успешно проверено");
        } catch (SerialPortException ex) {
            SettingsContainer.instance().setState("Проверка соединения закончилось неудачей. " +
                    "Возможно вы уже подключены к устройству или не выбрали порт.");
        }
    } // Конец метода actionPerformed
} // Конец класса CheckConnectionListener