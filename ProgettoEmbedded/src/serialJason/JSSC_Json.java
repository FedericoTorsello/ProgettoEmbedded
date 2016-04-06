package serialJason;



import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author federico
 */
public class JSSC_Json {

    public static void main(String[] args) throws SerialPortException, InterruptedException, IOException {

        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        System.out.println("Port opened: " + serialPort.openPort());
        System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
        
        while (true) {
            Thread.sleep(2000);// utile per riavviare la connessione con Arduino

            String input = serialPort.readString();

            try (JsonReader reader = new JsonReader(new StringReader(input))) {
                reader.beginObject();
                reader.setLenient(true);
                
                while (reader.hasNext()) {
                    String name = reader.nextName();
                    
                    if (name.equals("sensor")) {
                        System.out.println(reader.nextString());
                    } else if (name.equals("time")) {
                        System.out.println(reader.nextInt());
                    } else {
                        reader.skipValue(); //avoid some unhandle events
                    }
                }
                
                reader.endObject();
            }
        }
    }
}


