# Documentção do Projeto

Definição do problema e ideia de solução a partir da perspectiva do usuário. É composta pela definição do  diagrama de personas, histórias de usuários, requisitos funcionais e não funcionais além das restrições do projeto.

Apresente uma visão geral do que será abordado nesta parte do documento, enumerando as técnicas e/ou ferramentas utilizadas para realizar a especificações do projeto


## Personas

| **Pessoa**| **1** |
|--------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Nome**     | Marcinho |
| **Idade**    | 35 anos |
| **Ocupação** | Dono da agência |
| **Objetivo** | Marcinho precisa de um sistema para o cadastro de clientes e um controle de assentos vendidos em suas viagens. |
| **Frustrações** | Em algumas viagens, ele enfrenta problemas com a reserva de assentos, já que ainda utiliza um modelo físico em pranchetas, o que dificulta a organização e pode causar erros. |
| **Tecnologia** | O funcionário precisa de um sistema ágil e intuitivo que facilite a experiência do usuário final, permitindo o gerenciamento de excursões. Além disso, é essencial que a equipe tenha acesso à plataforma para um controle eficiente das viagens.|
| **Necessidades** | Sistema para gerenciamento de excursões.<br> Cadastro e controle de clientes. <br> Reserva de assentos de forma digital. <br> Gerenciamento de ônibus e roteiros.|


## Histórias de Usuários

Com base na análise das personas foram identificadas as seguintes histórias de usuários:

|EU COMO... `PERSONA`| QUERO/PRECISO ... `FUNCIONALIDADE` |PARA ... `MOTIVO/VALOR`                 |
|----------------|----------------------------------------|--------------------------------|
| **Dono da agência**  | Gerenciar clientes (cadastro e histórico) | Evitar repetição de coleta de dados e manter informações armazenadas no banco de dados |
| **Dono da agência**  | Gerenciar ônibus (cadastro e disponibilidade) | Ter maior controle sobre a frota disponível para cada excursão |
| **Dono da agência**  | Gerenciar roteiros (destinos e paradas)  | Manter informações organizadas sobre cada embarque e pontos do itinerário |
| **Dono da agência**  | Marcar e liberar assentos digitalmente| Manter controle preciso da disponibilidade em cada viagem/excursão |

## Requisitos Funcionais

| ID      |Título| Descrição                                                                 | Prioridade |
|---------|------|---------------------------------------------------------------------|------------|
| RF-01   | Gerenciamento de Cliente| O sistema deve permitir a possibilidade de criação, visualização, edição e deleção do cliente.  | ALTA       | 
| RF-02   | Gerenciamento de Ônibus | O sistema deve permitir a possibilidade de criação, visualização, edição e deleção do ônibus. | ALTA |
| RF-03   | Gerenciamento de Roteiro | O sistema deve permitir a possibilidade de criação, visualização, edição e deleção do roteiro. | ALTA |
| RF-04   | Gerenciamento de Excursão | O sistema deve permitir a possibilidade de criação, visualização, edição e deleção da excursão. | ALTA |
| RF-05   | Gerenciamento de Assentos | O sistema deve permitir a possibilidade de reserva e liberação de assentos. | ALTA |
| RF-06   | Busca de Conteúdo de Cliente | O sistema deve oferecer uma ferramenta de busca que permita aos usuários encontrar excursão por código, destino e hotel.| BAIXA |
| RF-07   | Busca de Conteúdo de Excursão  | O sistema deve oferecer uma ferramenta de busca que permita aos usuários encontrar excursão por código, destino e hotel. | BAIXA |
| RF-08   | Filtro por Data | O sistema deve oferecer uma ferramenta de filtragem que permita encontrar excursão por data de saída ou retorno. | BAIXA |

**Prioridade: Alta / Média / Baixa.**

## Requisitos Não Funcionais

| ID     |Título | Descrição                                                                 | Prioridade |
|---------|------|---------------------------------------------------------------------|------------|
| RNF-01  |Desempenho | O sistema deve suportar até 10 acessos simultâneos sem degradação de desempenho. | ALTA       |
| RNF-02  |Escalabilidade |O sistema precisa ser escalável para acomodar o aumento de excursões e clientes, mantendo o desempenho | ALTA |
| RNF-03  |Usabilidade |A interface do sistema deve ser intuitiva e fácil de navegar, proporcionando uma experiência agradável ao usuário. | MÉDIA      |
| RNF-04  |Disponibilidade |O sistema deve estar operacional 24 horas por dia, 7 dias por semana, com tempo de inatividade máximo de 1% ao mês. | ALTA |
| RNF-05  |Compatibilidade |O sistema deve ser compatível com os principais navegadores, como Google Chrome, Mozilla Firefox, Safari e Edge. | ALTA |
| RNF-06  |Backup e Recuperação de Dados|O sistema deve realizar backups de dados regularmente e permitir uma recuperação rápida em caso de falha.| ALTA |

**Prioridade: Alta / Média / Baixa.**

## Diagrama de Caso de Uso
<img width="3643" height="2003" alt="Diagrama de caso de uso" src="https://github.com/user-attachments/assets/1f9a299b-21e2-40ab-8fb7-aa3dd3b01875" />

## Diagrama de Fluxo
<img width="6592" height="3174" alt="Diagrama em branco (3)" src="https://github.com/user-attachments/assets/123953a2-86f3-4afd-90d3-cb413261d067" />

## Diagrama de Entidades
<img width="4084" height="2259" alt="Diagrama em branco (2)" src="https://github.com/user-attachments/assets/328bcd56-33d5-4ddb-a905-4f90aca3d550" />


