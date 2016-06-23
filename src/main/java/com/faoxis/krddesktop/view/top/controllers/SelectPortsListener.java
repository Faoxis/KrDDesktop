package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.settings.SettingsContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 22.06.2016.
 */
public class SelectPortsListener implements ActionListener {
    private String portsName;

    public SelectPortsListener(String portsName) {
        this.portsName = portsName;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        SettingsContainer.instance().setNumberOfCom(portsName);
        SettingsContainer.instance().setState("");
    }
}

