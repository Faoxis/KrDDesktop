package com.faoxis.krddesktop.settings;

/**
 * Created by Sergei on 22.06.2016.
 */
public class DataContainer {
    private static DataContainer dataContainer;
    String numberOfCom;
    String state;

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

    public static DataContainer instance() {
        if (dataContainer == null) {
            dataContainer = new DataContainer();
        }
        return dataContainer;
    }



}
