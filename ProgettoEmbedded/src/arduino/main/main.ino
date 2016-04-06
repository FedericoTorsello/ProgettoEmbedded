#include <ArduinoJson.h>

void setup() {

  Serial.begin(9600);
  while (!Serial) {
    // wait serial port initialization
  }

}

void loop() {

  StaticJsonBuffer<200> jsonBuffer;

  JsonObject& root = jsonBuffer.createObject();

  root["sensor"] = "gps";
  root["time"] = 1351824120;
  root.printTo(Serial);
  //delay importante
  delay(2000);

  JsonObject& root2 = jsonBuffer.createObject();
  root2["sensor"] = "gps2";
  root2["time"] = 0;
  root2.printTo(Serial);
  //  root.prettyPrintTo(Serial);
  //delay importante
  delay(2000);

}