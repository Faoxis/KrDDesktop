package com.faoxis.krddesktop.port;

import com.faoxis.krddesktop.control.DataCatcher;
import jssc.*;

/**
 * Created by Sergei on 25.04.2016.
 */
public class PortConnection {

    private SerialPort serialPort;
    private PortConnectionListener portConnectionListener;
    private DataCatcher dataCatcher;

    public void writeByte(byte data) throws SerialPortException {
        serialPort.writeByte((byte) data);
    }

    //------------------------------------- Конструктор с одним параметром ---------------------------------------//
    public PortConnection(String port) throws SerialPortException {
        this(port, SerialPort.BAUDRATE_115200);
    } // Конец конструктора с единственным параметром
    //------------------------------------------------------------------------------------------------------------//

    //------------------------------------- Конструктор с baudrate ----------------------------------------------//
    public PortConnection(String port, int baudrate) throws SerialPortException {
        this(port, baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
    } // Конец конструктора с baudrate
    //-----------------------------------------------------------------------------------------------------------//

    //-------------------------------------- Конструктор с параметрами ------------------------------------------//
    public PortConnection(String port, int baudrate, int databits, int stopbits, int parity) throws SerialPortException {
        serialPort = new SerialPort(port);
        //Открываем порт
        serialPort.openPort();
        serialPort.setParams(baudrate, databits, stopbits, parity);

        // Включаем аппаратное управление потоком
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                SerialPort.FLOWCONTROL_RTSCTS_OUT);

        // Устанавливаем ивент лисенер и маску
        this.portConnectionListener = new PortConnectionListener(serialPort, dataCatcher);
        serialPort.addEventListener(portConnectionListener, SerialPort.MASK_RXCHAR);
    } // Конец конструктора со всеми параметрами
    //------------------------------------------------------------------------------------------------------------//


    //---------------------------------------- Получение данных с COM-порта --------------------------------------//
    public int getData() {
        return portConnectionListener.getDataFromPort()[0];
    } // Конец метода getData()
    //------------------------------------------------------------------------------------------------------------//

    //---------------------------------------- Закрытие порта ----------------------------------------------------//
    public void closePortConnection() throws SerialPortException {
        serialPort.closePort();
    }
    //------------------------------------------------------------------------------------------------------------//

    public void openPortConnection() throws SerialPortException {
        serialPort.openPort();
    }

    //---------------------------------- Статический метод с информацией о портах --------------------------------//
    public static String[] getPorts() {
        return SerialPortList.getPortNames();
    } // Конец метода getPorts()
    //------------------------------------------------------------------------------------------------------------//

}