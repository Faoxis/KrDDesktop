package com.faoxis.krddesktop.control;

import java.util.ArrayList;

/**
 * Created by Sergei on 27.06.2016.
 */
public class DataCatcher {
    private int data;
    private int filterData;
    private ArrayList<Integer> dataList;
    private long dataCounter;
    private boolean dataIsReady;

    public int getFilterData() {
        return filterData;
    }

    public void setFilterData(int filterData) {
        this.filterData = filterData;
    }

    public int getData() {
        return data;
    }

    public long getDataCounter() {
        return dataCounter;
    }

    public void addToData(int data) {
        dataIsReady = false;
        this.dataList.add(data);
        this.data = data;
        this.dataCounter++;
        filter();
        dataIsReady = true;
    }


    private void filter() {
        setFilterData(data);
    }
}
