package com.faoxis.krddesktop.view.top.controllers;

import com.faoxis.krddesktop.port.PortConnection;
import com.faoxis.krddesktop.settings.SettingsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by Sergei on 23.06.2016.
 */
public class RefreshPortsListener implements ActionListener {
    private JMenu portMenu;

    public RefreshPortsListener(JMenu portMenu) {
        this.portMenu = portMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Удаляем все строки из менюшки "Порт"
        portMenu.removeAll();

        // Получаем список com-портов и вешаем его на кнопки
        String[] portsName = PortConnection.getPorts();
        HashMap<String, JMenuItem> ports = new HashMap<>();

        for (int i = 0; i < portsName.length; ++i) {
            ports.put(portsName[i], new JMenuItem(portsName[i]));
            portMenu.add(ports.get(portsName[i]));
            ports.get(portsName[i]).addActionListener(new SelectPortsListener(portsName[i]));
        }

        // Создаем заного кнопку "Обновить список com-портов"
        JMenuItem refreshPorts = new JMenuItem("Обновить список com-портов.");
        portMenu.add(refreshPorts);

        // И вешаем на нее нового слушателя (такого же как этот, но для нового списка портов)
        refreshPorts.addActionListener(new RefreshPortsListener(portMenu));
        portMenu.repaint();

        // Меняем статус
        SettingsContainer.instance().setState("Список com-портов был успешно обновлен.");
    }
}

