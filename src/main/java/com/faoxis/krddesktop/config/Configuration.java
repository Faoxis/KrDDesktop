package com.faoxis.krddesktop.config;

import com.faoxis.krddesktop.port.PortConnection;
import jssc.SerialPortException;

/**
 * Created by Sergei on 22.06.2016.
 */
public class Configuration {
    private static Configuration configuration;
    private String numberOfCom;
    private String state = "Программа только что запустилась";
    private PortConnection portConnection;

    private boolean startGraphic = false;
    private boolean clearGraphic = false;

    private int data = 0;
    private boolean isDateCame = false;

    public int getData() {
        this.isDateCame = false;
        return data;
    }

    public void setData(int data) {
        this.data = data;
        this.isDateCame = true;
    }

    public boolean isDataCame() {
        return isDateCame;
    }

    public boolean isClearGraphic() {
        return clearGraphic;
    }

    public void setClearGraphic(boolean clearGraphic) {
        this.clearGraphic = clearGraphic;
    }

    public boolean isStartGraphic() {
        return startGraphic;
    }

    public void setStartGraphic(boolean startGraphic) {
        this.startGraphic = startGraphic;
    }

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

    public static Configuration instance() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }



}
