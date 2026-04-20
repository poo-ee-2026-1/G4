## G4

# Discentes

César Henrique da Silva Neves - 202503334;

Davi Jared de Souza Campos - 202503336;

João Francisco Ramos Araújo - 202503358.

# Gerenciador de Vagas Inteligente Utilizando Java e Arduíno
# Introdução

<p align="justify">
O monitoramento de espaços físicos em tempo real é uma das bases da automação moderna e das Smart Cities. Este projeto propõe o desenvolvimento de um sistema de gerenciamento de estacionamento que integra hardware (Arduino) e software (Java), utilizando os princípios da Programação Orientada a Objetos (POO) para modelar e controlar a ocupação de vagas de forma eficiente. O sistema utiliza sensores ultrassônicos para detectar a presença de veículos. Os dados capturados pelo hardware são processados por uma aplicação Java, que gerencia o estado de cada vaga e fornece uma interface visual (grid) para o usuário. O foco principal é a transição de sinais físicos para objetos lógicos, permitindo o controle de alertas sonoros e a persistência de dados. O sistema contará com uma interação de usuário com sistema de login para casos de funcionários precisarem corrigir erros falhas dos sensores.
</p>

## Descrição do Problema

<p align="justify">
A gestão manual de estacionamentos frequentemente resulta em ineficiência no fluxo de veículos e falta de dados precisos sobre ocupação. Sem um sistema automatizado, o motorista perde tempo procurando vagas, e o gestor não possui um histórico de uso. A integração entre sensores de baixo custo e um software robusto em Java resolve esse gap, transformando sinais analógicos em informações digitais estruturadas.
</p>

## Motivação

<p align="justify">
A escolha deste projeto se deve à oportunidade de aplicar conceitos de POO em um cenário de interação real entre software e o mundo físico. Implementar a comunicação serial entre C++ e Java exige uma abstração clara de classes (como Vaga, Sensor e Alerta), consolidando o aprendizado de encapsulamento e tratamento de eventos, além de fornecer uma solução prática e visualmente tangível.
</p>

# Objetivos
## Objetivo Geral:

<p align="justify">
Desenvolver um sistema integrado de hardware e software para o gerenciamento de vagas de estacionamento, que seja capaz de demonstrar tanto para possiveis clientes quanto para funcionários a disponibilidade de vagas utilizando Java para a lógica de negócios e interface, e Arduino para a automação sensorial.
</p>

## Objetivos Específicos:

Implementar a Automação: Utilizar sensores ultrassônicos para medição de distância e detecção de obstáculos.

Comunicação Serial: Estabelecer a troca de dados eficiente entre o firmware (C++) e o software (Java).

Modelagem POO: Criar uma estrutura de classes que represente o domínio do estacionamento (Vagas, Sensores, Logs).

Interface Visual: Desenvolver um grid dinâmico que atualize o status das vagas (Livre/Ocupada) em tempo real.

Feedback ao Usuário: Implementar alertas sonoros via Buzzer para auxílio em manobras de proximidade.

# Materiais e Tecnologias
## Software:
Java (JDK 21): Lógica do sistema e Interface Gráfica.

Arduino IDE (C++): Programação do microcontrolador.

Biblioteca Serial (jSerialComm/JSSC): Para integração Java-Arduino.

## Hardware:
1x Arduino Uno;

4x Sensor Ultrassônico HC-SR04;

1x Buzzer Ativo;

Protoboard e Jumpers.

# Orçamento do Projeto

<img width="524" height="191" alt="image" src="https://github.com/user-attachments/assets/1bcb9344-a032-4176-a63d-4b5aa46d778b" />

# Modelagem Inicial
<img width="599" height="716" alt="image" src="https://github.com/user-attachments/assets/618ab284-4b86-4b36-956e-2c60324647ef" />

# Diagrama de Classes UML

<img width="644" height="787" alt="image" src="https://github.com/user-attachments/assets/a8b35192-f66e-4c3a-8453-a1ef7439890c" />


# Cronograma
23/03 - Apresentação do cronograma e escopo do projeto; 

06/04 - Organização dos materiais futuramente utilizados; 

20/04 - Desenvolvimento e aprimoramento do código;

04/05 - Simulação prática da funcionalidade do projeto;

18/05 - Teste de campo;

01/06 - Entrega final.

<img width="991" height="683" alt="image" src="https://github.com/user-attachments/assets/960b2f0c-0c86-4944-a321-8d4b9b3935e8" />





