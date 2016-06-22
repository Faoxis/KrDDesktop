package com.faoxis.krddesktop.port;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

//----------------------------------- Класс - слушатель входящих бит -----------------------------------------//
public class PortConnectionListener implements SerialPortEventListener {

    private SerialPort serialPort;
    private int[] dataFromPort = {0};

    public PortConnectionListener(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public int[] getDataFromPort() {
        return dataFromPort;
    }


    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public void setDataFromPort(int[] dataFromPort) {
        this.dataFromPort = dataFromPort;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.isRXCHAR() && serialPortEvent.getEventValue() > 0) {
            try {
                //Получаем ответ от устройства, обрабатываем данные и т.д.
                this.dataFromPort = this.serialPort.readIntArray(1);
            } catch (SerialPortException ex) {
                System.out.println(ex);
            }
        }
    } // Конец функции serialEvent
} // Конец класса PortReader
//------------------------------------------------------------------------------------------------------------//