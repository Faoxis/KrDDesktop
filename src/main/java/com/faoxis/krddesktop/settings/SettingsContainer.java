package com.faoxis.krddesktop.settings;

import com.faoxis.krddesktop.port.PortConnection;
import jssc.SerialPortException;

/**
 * Created by Sergei on 22.06.2016.
 */
public class SettingsContainer {
    private static SettingsContainer settingsContainer;
    private static String numberOfCom;
    private static String state = "Программа только что запустилась";
    private static PortConnection portConnection;


    public String getNumberOfCom() {
        return numberOfCom;
    }

    public void setNumberOfCom(String numberOfCom) {
        this.numberOfCom = numberOfCom;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPortConnection(String com) throws SerialPortException {
        portConnection = new PortConnection(com);
    }

    public PortConnection getPortConnection() {
        return portConnection;
    }

    public void resetPortConnection() {
        portConnection = null;
    }

    public static SettingsContainer instance() {
        if (settingsContainer == null) {
            settingsContainer = new SettingsContainer();
        }
        return settingsContainer;
    }



}
