package com.faoxis.krddesktop.view.right.controllers;

import com.faoxis.krddesktop.config.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sergei on 23.06.2016.
 */
public class ClearButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Configuration.instance().setClearGraphic(true);
    }
}
