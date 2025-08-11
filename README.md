# Sistema de Gerenciamento de Excursões - EmbarqueJá

## 📋 Descrição do Projeto

Sistema desenvolvido para automatizar o gerenciamento de excursões, substituindo o controle manual em pranchetas por uma solução digital completa. O sistema permite o cadastro de clientes, controle de assentos, gerenciamento de ônibus e roteiros, proporcionando maior eficiência e organização para agências de turismo.

## 🎯 Problema e Solução

**Problema:** Agências de excursão que ainda utilizam controle manual em pranchetas enfrentam dificuldades na organização, reserva de assentos e podem ter erros operacionais.

**Solução:** Sistema web intuitivo que digitaliza todo o processo de gestão de excursões, desde o cadastro de clientes até o controle de assentos em tempo real.

## 🚀 Tecnologias Utilizadas

- **Backend:** Java 21, Spring Boot 3.5.3
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA
- **Ferramentas:** 
  - Lombok (redução de boilerplate)
  - MapStruct (mapeamento de objetos)
  - Maven (gerenciamento de dependências)

## 👥 Personas

### Marcinho - Dono da Agência
- **Idade:** 35 anos
- **Objetivo:** Sistema para cadastro de clientes e controle de assentos vendidos
- **Frustrações:** Problemas com reserva de assentos usando modelo físico em pranchetas
- **Necessidades:** 
  - Gerenciamento digital de excursões
  - Cadastro e controle de clientes
  - Reserva de assentos digital
  - Gerenciamento de ônibus e roteiros

## 📝 Histórias de Usuário

| Como | Quero | Para |
|------|-------|------|
| Dono da agência | Gerenciar clientes (cadastro e histórico) | Evitar repetição de coleta de dados e manter informações no banco |
| Dono da agência | Gerenciar ônibus (cadastro e disponibilidade) | Ter maior controle sobre a frota disponível |
| Dono da agência | Gerenciar roteiros (destinos e paradas) | Manter informações organizadas sobre embarques e itinerários |
| Dono da agência | Marcar e liberar assentos digitalmente | Manter controle preciso da disponibilidade em viagens |

## ⚙️ Requisitos Funcionais

| ID | Título | Descrição | Prioridade |
|----|--------|-----------|------------|
| RF-01 | Gerenciamento de Cliente | CRUD completo de clientes | ALTA |
| RF-02 | Gerenciamento de Ônibus | CRUD completo de ônibus | ALTA |
| RF-03 | Gerenciamento de Roteiro | CRUD completo de roteiros | ALTA |
| RF-04 | Gerenciamento de Excursão | CRUD completo de excursões | ALTA |
| RF-05 | Gerenciamento de Assentos | Reserva e liberação de assentos | ALTA |
| RF-06 | Busca de Cliente | Busca por diversos critérios | BAIXA |
| RF-07 | Busca de Excursão | Busca por código, destino e hotel | BAIXA |
| RF-08 | Filtro por Data | Filtragem por data de saída/retorno | BAIXA |

## 🔧 Requisitos Não Funcionais

| ID | Título | Descrição | Prioridade |
|----|--------|-----------|------------|
| RNF-01 | Desempenho | Suporte a 10 acessos simultâneos | ALTA |
| RNF-02 | Escalabilidade | Crescimento sem perda de performance | ALTA |
| RNF-03 | Usabilidade | Interface intuitiva e fácil navegação | MÉDIA |
| RNF-04 | Disponibilidade | 99% de uptime (24/7) | ALTA |
| RNF-05 | Compatibilidade | Principais navegadores web | ALTA |
| RNF-06 | Backup e Recuperação | Backups regulares e recuperação rápida | ALTA |

## 🛠️ Instalação e Configuração

### Pré-requisitos
- Java 21
- PostgreSQL
- Maven 3.6+

### Configuração do Banco de Dados
```sql
CREATE DATABASE excursao_db;
CREATE USER excursao_user WITH ENCRYPTED PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE excursao_db TO excursao_user;
```

### Configuração da Aplicação
1. Clone o repositório
```bash
git clone [https://github.com/RyanGTorres/marcinho-excursoes-backend/tree/main]
cd marcinho
```

2. Configure o banco no `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/excursao_db
spring.datasource.username=excursao_user
spring.datasource.password=sua_senha
```

3. Execute a aplicação
```bash
mvn spring-boot:run
```

## 📊 Diagramas

### Diagrama de Caso de Uso
O sistema apresenta os seguintes casos de uso principais:
- Gerenciar Clientes
- Gerenciar Ônibus
- Gerenciar Embarques
- Gerenciar Excursões
- Controlar Assentos
- Realizar Buscas e Filtros

### Diagrama de Entidades
Principais entidades do sistema:
- **Cliente:** Informações pessoais e histórico
- **Ônibus:** Dados da frota e capacidade
- **Embarque:** Destinos e paradas
- **Excursão:** Viagens programadas
- **Assento:** Controle de ocupação

## 🚦 Status do Projeto

🔧 **Em Desenvolvimento**

### Funcionalidades Implementadas
- [ ] Estrutura base do projeto
- [ ] Configuração do banco de dados
- [ ] Modelos de entidade
- [ ] Implementação dos CRUDs básicos
- [ ] Sistema de reserva de assentos

### Próximos Passos
- [ ] Interface web responsiva (react)
- [ ] Funcionalidades de busca e filtro

## 📝 Licença

Este projeto está sob a licença [LICENSE]. Veja o arquivo `LICENSE` para mais detalhes.


## 📚 Documentação Adicional

- [Documentação da API](https://github.com/RyanGTorres/marcinho-excursoes-backend/blob/main/docs/Documenta%C3%A7%C3%A3o.md)

---

⭐ **Gostou do projeto? Deixe uma estrela!**


