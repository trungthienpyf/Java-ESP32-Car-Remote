//add necessary libraries.
#include <WiFi.h>

const char* SSID     = "ESP32-Access-Point";
const char* PASSWORD = "123456789";

WiFiServer SERVER(80);
WiFiClient  CLIENT;

int RELAY_1 = 13;
int RELAY_2 = 12;
int RELAY_3 = 14;
int RELAY_4 = 27;

void setup() {
  Serial.begin(9600);
  Serial.print("Setting AP (Access Point)…");
  WiFi.softAP(SSID, PASSWORD);
  IPAddress IP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(IP);
  SERVER.begin();

  pinMode(RELAY_1, OUTPUT);
  pinMode(RELAY_2, OUTPUT);
  pinMode(RELAY_3, OUTPUT);
  pinMode(RELAY_4, OUTPUT);

  digitalWrite(RELAY_1, HIGH);
  digitalWrite(RELAY_2, HIGH);
  digitalWrite(RELAY_3, HIGH);
  digitalWrite(RELAY_4, HIGH);
}

void loop() {
  if (SERVER.hasClient()) {
    if (!CLIENT || !CLIENT.connected()) {
      if (CLIENT) {
        CLIENT.stop();
      }
      CLIENT = SERVER.available();
    }
  }
  if (CLIENT && CLIENT.connected()) {
    if (CLIENT.available()) {
      while (CLIENT.available()) {
        char DATA = CLIENT.read();
        //Serial.println(DATA);
        if (DATA == 'A') {
          digitalWrite(RELAY_1, LOW);
        } else if (DATA == 'a') {
          digitalWrite(RELAY_1, HIGH);
        } else if (DATA == 'B') {
          digitalWrite(RELAY_2, LOW);
        } else if (DATA == 'b') {
          digitalWrite(RELAY_2, HIGH);
        } else if (DATA == 'C') {
          digitalWrite(RELAY_3, LOW);
        } else if (DATA == 'c') {
          digitalWrite(RELAY_3, HIGH);
        } else if (DATA == 'D') {
          digitalWrite(RELAY_4, LOW);
        } else if (DATA == 'd') {
          digitalWrite(RELAY_4, HIGH);
        }
      }
    }
  }
}
