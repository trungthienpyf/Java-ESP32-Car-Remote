//add necessary libraries.
#include <WiFi.h>

const char* SSID     = "tientien";
const char* PASSWORD = "4567jqka";

WiFiServer SEVER(80);
WiFiClient  CLIENT;

int IN_1 = 12;
int IN_2 = 14;
int IN_3 = 27;
int IN_4 = 26;
 
void setup() {
Serial.begin(115200);
Serial.print("Connecting to wifi");
  Serial.println(SSID);
  WiFi.begin(SSID, PASSWORD);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected.");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  
  //khởi tạo webserver
  SEVER.begin();

  pinMode(IN_1, OUTPUT);
  pinMode(IN_2, OUTPUT);
  pinMode(IN_3, OUTPUT);
  pinMode(IN_4, OUTPUT);

  digitalWrite(IN_1, LOW);
  digitalWrite(IN_2, LOW);
  digitalWrite(IN_3, LOW);
  digitalWrite(IN_4, LOW);
}

void loop() {
  if (SEVER.hasClient()) {
    if (!CLIENT || !CLIENT.connected()) {
      Serial.println("test2");
      if (CLIENT) {
        CLIENT.stop();
      }
      CLIENT = SEVER.available();
    }
  }
  if (CLIENT && CLIENT.connected()) {
    Serial.println("test3");

    if (CLIENT.available()) {
      while (CLIENT.available()) {
        char DATA = CLIENT.read();
        //Serial.println(DATA);
        if(DATA=='b'){
  Serial.println("t1");
      digitalWrite(IN_1, HIGH);
      digitalWrite(IN_2, LOW);
      digitalWrite(IN_3, LOW);
      digitalWrite(IN_4, HIGH);}
      else if(DATA=='a'){
     Serial.println("test2");
        digitalWrite(IN_1, LOW);
      digitalWrite(IN_2, HIGH);
      digitalWrite(IN_3, HIGH);
      digitalWrite(IN_4, LOW);}
//PHAI
else if(DATA=='c'){
  Serial.println("t3");
      digitalWrite(IN_1, LOW);
      digitalWrite(IN_2, HIGH);
      digitalWrite(IN_3, LOW);
      digitalWrite(IN_4, HIGH);}
//TRTRAIAI
else if(DATA=='d'){
  Serial.println("t4");
      digitalWrite(IN_1, HIGH);
      digitalWrite(IN_2, LOW);   
      digitalWrite(IN_3, HIGH);
      digitalWrite(IN_4, LOW);}
      else if(DATA=='e'){
  Serial.println("t4");
      digitalWrite(IN_1, LOW);
      digitalWrite(IN_2, LOW);   
      digitalWrite(IN_3, LOW);
      digitalWrite(IN_4, LOW);}
}
    }
    
    
  }} 
