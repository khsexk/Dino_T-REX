#include<StopWatch.h>

int sensorPin = A0;
int value = 0;
StopWatch MySW;

void setup() {
  Serial.begin(9600); // 시리얼 통신을 위해서
}

void loop() {
  int sensor = analogRead(sensorPin);

  MySW.start(); // 스탑워치 시작
  if(MySW.elapsed()>=10000 && sensor>=1000 && value==0){ // 10초 이상 인식하고 있는데 사람이 있는 경우
      Serial.println("outKhsexk");
      value = 1;
  }else if(MySW.elapsed()>=10000 && sensor<=100){ // 10초 이상 있는데 사람이 없는 경우
      Serial.println("inKhsexk");
      value = 0;
      delay(5000); // 
      MySW.reset(); // 타이머 초기화
  }
}
