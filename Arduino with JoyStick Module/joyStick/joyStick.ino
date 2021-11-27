int JoyStick_X = A0;
int JoyStick_Y = A1;
int JoyStick_SW = 3;

void setup() {
  pinMode(JoyStick_SW, INPUT_PULLUP);
  Serial.begin(9600);
}

void loop() {
  int x, y, sw;

  x = analogRead(JoyStick_X);
  y = analogRead(JoyStick_Y);
  sw = digitalRead(JoyStick_SW);

  if(x>=1000){
    Serial.println("Jump");
  }
  if(y>=1000){
    Serial.println("Rating");
  }
  else if(y<=24) {
    Serial.println("Back");
  }
  if(sw == false){
    Serial.println("Start");
  }
  delay(300);
}
