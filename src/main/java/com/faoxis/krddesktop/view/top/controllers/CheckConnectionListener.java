package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.config.Configuration;
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
        if (Configuration.instance().getPortConnection() != null) {
            JOptionPane.showMessageDialog(null, "Подключение уже установлено или порт не был выбран.");
            return;
        }

        try {
            Configuration.instance().setPortConnection(Configuration.instance().getNumberOfCom());
            Configuration.instance().getPortConnection().closePortConnection();
            Configuration.instance().resetPortConnection();

            Configuration.instance().setState("Соединение было успешно проверено");
        } catch (SerialPortException ex) {
            Configuration.instance().setState("Проверка соединения закончилось неудачей. " +
                    "Возможно вы уже подключены к устройству или не выбрали порт.");
        }
    } // Конец метода actionPerformed
} // Конец класса CheckConnectionListener