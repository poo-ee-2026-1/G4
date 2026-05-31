## G4

# Discentes

César Henrique da Silva Neves - 202503334;

Davi Jared de Souza Campos - 202503336;

João Francisco Ramos Araújo - 202503358.

# Gerenciador de Vagas Inteligente Utilizando Java e Arduíno
# Introdução
## Descrição do projeto

<p align="justify">
O monitoramento de espaços físicos em tempo real é uma das bases da automação moderna e das Smart Cities. Este projeto propõe o desenvolvimento de um sistema de gerenciamento de estacionamento que integra hardware (Arduino) e software (Java), utilizando os princípios da Programação Orientada a Objetos (POO) para modelar e controlar a ocupação de vagas de forma eficiente. O sistema utiliza sensores ultrassônicos para detectar a presença de veículos. Os dados capturados pelo hardware são processados por uma aplicação Java, que gerencia o estado de cada vaga e fornece uma interface visual (grid) para o usuário. O foco principal é a transição de sinais físicos para objetos lógicos, permitindo o controle de alertas sonoros e a persistência de dados. O sistema contará com uma interação de usuário com sistema de login para casos de funcionários precisarem corrigir erros falhas dos sensores.
</p>

## Descrição do Problema e Solução

<p align="justify">
A gestão eficiente de vagas em estacionamentos representa um desafio devido à necessidade de manter informações atualizadas sobre a ocupação dos espaços disponíveis. Em sistemas convencionais, o controle é frequentemente realizado manualmente, o que pode resultar em erros operacionais, atrasos na identificação de vagas livres e dificuldades no acompanhamento da utilização do estacionamento. Nesse contexto, existe a necessidade de uma solução computacional capaz de monitorar e gerenciar as vagas de forma centralizada, oferecendo informações em tempo real para usuários e administradores. Além disso, a integração com dispositivos de hardware, como sensores ultrassônicos e sistemas de alerta, pode aumentar a confiabilidade das informações e reduzir a dependência da intervenção humana. Assim, o projeto propõe o desenvolvimento de um sistema de estacionamento inteligente que permita o controle das vagas, o registro dos veículos estacionados e a visualização do estado do estacionamento por meio de uma interface gráfica, proporcionando maior eficiência operacional e melhor experiência aos usuários.
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

# Funcionalidades do Projeto
## Cliente
Inserir nome e placa do veículo.

Solicitar reserva de vaga.

Visualizar vagas disponíveis e ocupadas.

Consultar informações do veículo estacionado.
## Funcionário
Realizar login administrativo.

Visualizar o estado de todas as vagas.

Liberar vagas manualmente.

Atualizar o estado das vagas.

## Sistema
Gerenciamento automático das vagas.

Controle de ocupação.

Simulação de sensores.

Atualização visual em tempo real.

Integração preparada para Arduino.

# Materiais e Tecnologias
## Software:
Java (JDK 21): Lógica do sistema e Interface Gráfica.

Apache Maven (gestão de dependências e automação de compilação)

Arduino IDE (C++): Programação do microcontrolador.

Biblioteca Serial (jSerialComm/JSSC): Para integração Java-Arduino.

## Hardware:
1x Arduino Uno;

4x Sensor Ultrassônico HC-SR04;

1x Buzzer Ativo;

Protoboard e Jumpers.

# Fluxo de Funcionamento

1: O sistema é iniciado.

2: O usuário escolhe entre Cliente ou Funcionário.

3: O cliente informa nome e placa.

4: O sistema procura uma vaga livre.

5: A vaga é reservada.

6: A interface exibe o estado atualizado das vagas.

7: Sensores ou comandos administrativos podem alterar o estado das vagas.

8: A interface é atualizada automaticamente.

# Funcionamento 
Cada sensor monitora uma vaga.

Quando um veículo é detectado:

a vaga passa para ocupada;

o sistema atualiza automaticamente a interface;

um buzzer emite um alerta para situações de detecção.


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

# Entrega Parcial 3 (20/04/2026)

<img width="991" height="683" alt="image" src="https://github.com/user-attachments/assets/960b2f0c-0c86-4944-a321-8d4b9b3935e8" />

## Aplicação Inicial

A aplicação possui uma interface gráfica desenvolvida em JavaFX, onde o usuário pode visualizar, em tempo real, a situação de quatro vagas de estacionamento organizadas em formato de grade. Cada vaga apresenta um estado visual simples e intuitivo:

Verde: vaga livre
Vermelho: vaga ocupada

Além da visualização pública para clientes, o sistema também conta com um modo de funcionário, no qual colaboradores autorizados podem realizar login para corrigir manualmente o estado de vagas em casos de falha dos sensores ou inconsistências no sistema. Nesta versão inicial, os sensores são simulados por software, alterando aleatoriamente a ocupação das vagas para representar a chegada e saída de veículos. Essa estratégia permite testar toda a estrutura orientada a objetos do sistema, incluindo:

gerenciamento de vagas;
atualização automática de estados;
autenticação de funcionários;
alteração manual de vagas;
navegação entre telas do sistema.

A arquitetura foi organizada utilizando conceitos de Programação Orientada a Objetos, com classes responsáveis por entidades específicas, como:

Vaga
Gerenciador
Funcionário
SensorSimulado

Essa primeira aplicação do projeto serve de base para as próximas etapas que incluirão:

integração com sensores físicos reais;
comunicação serial entre microcontrolador e Java;
registro histórico de uso das vagas;
melhorias visuais na interface;
expansão para múltiplos setores de estacionamento.

# Hardware
Foto do Arduíno Uno(R3) utilizado
<img width="1220" height="835" alt="WhatsApp Image 2026-05-18 at 13 55 50" src="https://github.com/user-attachments/assets/d9b1f656-386a-43a1-8b5f-dd12f208c3bf" />


Foto do sensor ultrassônico (HC-SR04) utilizado
<img width="720" height="1280" alt="WhatsApp Image 2026-05-18 at 13 54 23" src="https://github.com/user-attachments/assets/288d449f-225c-4f48-b062-98e4a2210dfe" />


Foto do Buzzer passivo 5V utilizado
<img width="1220" height="935" alt="WhatsApp Image 2026-05-18 at 13 56 39" src="https://github.com/user-attachments/assets/e05897fd-a11c-4424-a3e4-f85b6bcd74f9" />


## Sistema Montado
Vista Superior

<img width="720" height="1280" alt="WhatsApp Image 2026-05-18 at 13 51 59" src="https://github.com/user-attachments/assets/62b84920-3e23-4a5d-bc95-0c3d76d461d6" />


Vista Lateral

<img width="720" height="1280" alt="WhatsApp Image 2026-05-18 at 13 53 32" src="https://github.com/user-attachments/assets/3430b68d-ca77-4fac-b146-d6056a5c2705" />


## Tabela de Ligações
<img width="205" height="233" alt="image" src="https://github.com/user-attachments/assets/fb1ebe9e-75cc-4ca7-9304-390c9c98ece5" />
Observações: todos os sensores conectados em 5V e GND comun, idealmente, os sensores são lidos um por vez
