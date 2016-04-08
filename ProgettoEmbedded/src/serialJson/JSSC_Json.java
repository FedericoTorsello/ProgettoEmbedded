package serialJson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;
import sun.nio.cs.StreamDecoder;

/**
 *
 * @author federico
 */
public class JSSC_Json {

    private static Reader in;

    public static void main(String[] args) throws SerialPortException, InterruptedException, IOException {

        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        System.out.println("Port opened: " + serialPort.openPort());
        System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));

        System.out.println(serialPort.writeInt(1));
        System.out.println("1");

//        Thread.sleep(10000);
//        serialPort.writeInt(2);
//        System.out.println("2");

//        int i = 0;
        while (true) {
//            Thread.sleep(1000);// utile per riavviare la connessione con Arduino
//            String input = serialPort.readString();
//            Thread.sleep(5000);
//            serialPort.writeInt(1);
//            System.out.println("1");
//            
//            Thread.sleep(2000);
////            serialPort.writeInt(2);
////            System.out.println("2");

//            if (input != null) {
//                System.out.println("[" + i++ + "]"+ input);
//                JsonReader jr = new JsonReader(new StringReader(input));
//                System.out.println(jr.nextBoolean());
//                String json = "{\"brand\" : \"Toyota\", \"doors\" : 5}";
//                JsonReader jsonReader = new JsonReader(new StringReader(input));
//
//                jsonReader.setLenient(true);
//                try {
//                    while (jsonReader.hasNext()) {
//                        JsonToken nextToken = jsonReader.peek();
//                        System.out.println(nextToken);
//
//                        if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {
//                            jsonReader.beginObject();
//                        } else if (JsonToken.NAME.equals(nextToken)) {
//                            String name = jsonReader.nextName();
//                            System.out.println(name);
//                        } else if (JsonToken.STRING.equals(nextToken)) {
//                            String value = jsonReader.nextString();
//                            System.out.println(value);
//                        } else if (JsonToken.NUMBER.equals(nextToken)) {
//                            long value = jsonReader.nextLong();
//                            System.out.println(value);
//                        } else if (JsonToken.BOOLEAN.equals(nextToken)) {
//                            boolean bool = jsonReader.nextBoolean();
//                            System.out.println(bool);
////                        } else if (JsonToken.NULL.equals(nextToken)) {
////                            jsonReader.nextNull();
////                            jsonReader.skipValue();
//                        }
//                    }
//                } catch (IOException e) {
////                    e.printStackTrace();
//                }
//            try (JsonReader reader = new JsonReader(new StringReader(input))) {
//                reader.beginObject();
//                reader.setLenient(true);
//                
//                while (reader.hasNext()) {
//                    String name = reader.nextName();
//                    
//                    if (name.equals("sensor")) {
//                        System.out.println(reader.nextString());
//                    } else if (name.equals("time")) {
//                        System.out.println(reader.nextInt());
//                    } else {
//                        reader.skipValue(); //avoid some unhandle events
////                        Thread.sleep(200);// utile per riavviare la connessione con Arduino
//                    }
//                }
//                
//                reader.endObject();
//            }
//            }
        }
    }
}
