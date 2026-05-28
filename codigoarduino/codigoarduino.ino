const byte TRIG_PINS[4] = {2, 4, 6, 8};
const byte ECHO_PINS[4] = {3, 5, 7, 9};
const byte BUZZER_PIN = 10;

const int LIMIAR_CM = 15;

bool estadoAnterior[4] = {false, false, false, false};

long lerDistanciaCM(byte trigPin, byte echoPin) {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);

  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  long duracao = pulseIn(echoPin, HIGH, 30000);

  if (duracao == 0) return -1;

  return (long)(duracao * 0.0343 / 2.0);
}

void tocarBuzzer() {
  digitalWrite(BUZZER_PIN, HIGH);
  delay(120);
  digitalWrite(BUZZER_PIN, LOW);
}

void setup() {
  Serial.begin(9600);

  for (int i = 0; i < 4; i++) {
    pinMode(TRIG_PINS[i], OUTPUT);
    pinMode(ECHO_PINS[i], INPUT);
  }

  pinMode(BUZZER_PIN, OUTPUT);
  digitalWrite(BUZZER_PIN, LOW);
}

void loop() {
  bool ocupada[4];
  bool houveMudancaParaOcupada = false;

  for (int i = 0; i < 4; i++) {
    long distancia = lerDistanciaCM(TRIG_PINS[i], ECHO_PINS[i]);

    ocupada[i] = (distancia > 0 && distancia <= LIMIAR_CM);

    if (ocupada[i] && !estadoAnterior[i]) {
      houveMudancaParaOcupada = true;
    }

    estadoAnterior[i] = ocupada[i];
  }

  // Envia: 1,0,1,0
  for (int i = 0; i < 4; i++) {
    Serial.print(ocupada[i] ? 1 : 0);
    if (i < 3) Serial.print(',');
  }
  Serial.println();

  if (houveMudancaParaOcupada) {
    tocarBuzzer();
  }

  delay(250);
}