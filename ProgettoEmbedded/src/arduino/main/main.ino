#include <ArduinoJson.h>

char data;

void setup() {

  pinMode(13, OUTPUT);

  Serial.begin(9600);
  while (!Serial) {
    // wait serial port initialization
  }

}

void loop() {

  //  StaticJsonBuffer<200> jsonBuffer;
  //
  //  JsonObject& root = jsonBuffer.createObject();
  //
  //  root["sensor"] = "gps";
  //  root["time"] = 1351824120;
  //  root.printTo(Serial);
  //delay importante
  //delay(2000);

  if (Serial.available()) {
    data = Serial.read();
    if (data == '1') {
      digitalWrite(13, HIGH);
    } else if (data == '2') {
      digitalWrite(13, LOW);
    }
  }

}
