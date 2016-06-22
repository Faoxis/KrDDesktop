package com.faoxis.krddesktop.view.top;

import com.faoxis.krddesktop.port.PortConnection;
import com.faoxis.krddesktop.view.top.controllers.SelectPortsListener;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by Sergei on 21.06.2016.
 */
public class TopMenu extends JMenuBar {
    public TopMenu() {
        super();
            JMenu portMenu = new JMenu("Порт");
            //------------------------------- Вкладка с выбором порта ------------------------------------//
            String[] portsName = PortConnection.getPorts();
            HashMap<String, JMenuItem> ports = new HashMap<>();

            for (int i = 0; i < portsName.length; ++i) {
                ports.put(portsName[i], new JMenuItem(portsName[i]));
                portMenu.add(ports.get(portsName[i]));
                ports.get(portsName[i]).addActionListener(new SelectPortsListener(portsName[i]));
            }

            JMenuItem refreshPorts = new JMenuItem("Обновить список com-портов");
            portMenu.add(refreshPorts);
    //        refreshPorts.addActionListener(new RefreshPortsListener());
            //----------------------------------------------------------------------------------------------//

            //------------------------------- Вкладка соединение -------------------------------------------//
            JMenuItem checkConnection = new JMenuItem("Проверить соединение");
    //        checkConnection.addActionListener(new CheckConnectionListener());
            JMenuItem openConnection = new JMenuItem("Подключиться");
    //        openConnection.addActionListener(new OpenConnectionListener());
            JMenuItem closeConnection = new JMenuItem("Отключиться");
    //        closeConnection.addActionListener(new CloseConnectionListener());
            JMenu connectionMenu = new JMenu("Соединение");
            connectionMenu.add(checkConnection);
            connectionMenu.add(openConnection);
            connectionMenu.add(closeConnection);
            //--------------------------------------------------------------------------------------------//

            this.add(portMenu);
            this.add(connectionMenu);
            //********************************************************************************************//
    }

}
