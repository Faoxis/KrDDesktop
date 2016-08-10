package com.faoxis.krddesktop.view.right.controllers;

import com.faoxis.krddesktop.config.Configuration;
import jssc.SerialPortException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 23.06.2016.
 */
public class StopButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Configuration.instance().setStartGraphic(false);

        try {
            Configuration.instance().getPortConnection().writeByte((byte) 228);
            Configuration.instance().getPortConnection().closePortConnection();
            Configuration.instance().setPortConnection(Configuration.instance().getNumberOfCom());
        } catch (SerialPortException e1) {
            e1.printStackTrace();
        }

        if (Configuration.instance().getPortConnection() == null) {
            Configuration.instance().setState("График не строится. Соединение отсутствует.");
        } else {
            Configuration.instance().setState("График не строится. Соединение не разорвано.");
        }

    }
}
