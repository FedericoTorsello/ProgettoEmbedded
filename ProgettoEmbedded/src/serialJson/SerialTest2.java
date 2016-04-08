package serialJson;

import jssc.SerialPort;
import jssc.SerialPortException;

public class SerialTest2 {

    public static void main(String[] args) throws InterruptedException, SerialPortException {

        String portName = "/dev/ttyACM0";
        System.out.println("Opening serial port " + portName);
        //CommPortIdentifier portid = CommPortIdentifier.getPortIdentifier(portName);
        //SerialPort serialPort = (SerialPort)portid.open("Serialport DTR/RTS test", 1000);
        SerialPort serialPort = new SerialPort(portName);

        serialPort.openPort();
        serialPort.setParams(SerialPort.BAUDRATE_9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        //serialPort.closePort();//Close serial port
        //int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;//Prepare mask
        //serialPort.setEventsMask(mask);

        //serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        //serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
        //serialPort.disableReceiveTimeout();
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        //serialPort.notifyOnCTS(true);

        //serialPort.notifyOnDSR(true);
        /*
            RTS - Request To Send
            CTS - Clear To Send
            DTR - Data Terminal Ready
         */
        while (true) {
//            Thread.sleep(500);
            if (serialPort.isCTS()) {
                System.out.println("CTS is: True");
            } else {
                System.out.println("CTS is: False");
            }

            if (serialPort.isDSR()) {
                System.out.println("DSR is: True");
            } else {
                System.out.println("DSR is: False");
            }

            if (serialPort.isRING()) {
                System.out.println("RI is: True");
            } else {
                System.out.println("RI is: False");
            }

            System.out.println('\n');
        }

    }
}
