## G4

# Discentes
César Henrique da Silva Neves - 202503334;

Davi Jared de Souza Campos - 202503336;

João Francisco Ramos Araújo - 202503358.

# Gerenciamento de Vagas de Estacionamento Utilizando Java e Arduíno
## Introdução
<p align="justify">
O projeto se trata de um gerenciador de vagas de estacionamento com interface visual demonstrando quais vagas estariam ocupadas e quais estariam livres, para detectar quais vagas estariam livres, seriam usados sensores de proximidade, caso o sensor detectasse um objeto a vaga estaria ocupada e isso seria demonstrado na interface (em formato de "grid"), os sensores de proximidade seriam feitos utilizando principalmente de um sensor ultrassônico para a detecção de veículos, além de dois microprocessadores, um Arduíno Uno que lerá as informações dadas pelo sensor ultrassônico e as enviará para um hardware programado em Java que utilizará dos dados para operar o sistema, gerenciar o banco de dados e formatar a interface visual.
A ideia central do projeto é criar um sistema capaz de medir a distância entre o carro e quaisquer obstáculo atrás dele. Assim que o objeto estiver muito próximo, o sistema emitirá um alerta sonoro (temporizado) para avisar o motorista e enviará o dado sobre a ocupação da vaga na qual ocorrera a detecção para o banco de dados que gerenciará as informações e aplicará ao grid, assim que a detecção for interrompida o sistema contabilizará a vaga como "livre", alterando a informação visual dentro do grid
</p>

## Objetivos do Projeto
O principal objetivo deste projeto é desenvolver um sistema eletrônico capaz de:

 * Medir a distância entre dois pontos (um carro e o obstáculo em sua traseira);
 * Realizar um alerta sonoro em caso de muita proximidade;
 * Fazer a intercomunicação entre linguagens (C++ e Java);
 * Utilizar componentes de baixo custo;
 * Demonstrar e usar de conceitos básicos da programação orientada a objetos.

## Materiais Utilizados
Para a montagem do sistema serão utilizados os seguintes componentes (desconsiderando os fios e possiveis "plataformas"):

 * 1 Arduíno Uno;
 * 1 hardware de programação em Java (computador/notebook);
 * 1 Sensor Ultrassônico;
 * 1 Buzzer.

## Cronograma
23/03 - Apresentação do cronograma e escopo do projeto; 

06/04 - Organização dos materiais futuramente utilizados; 

20/04 - Desenvolvimento e aprimoramento do código;

04/05 - Simulação prática da funcionalidade do projeto;

18/05 - Teste de campo;

01/06 - Entrega final.


