# IntegraSUS Mental

Backend desenvolvido para o Hackathon da Pós-Tech FIAP em Arquitetura e Desenvolvimento Java.

O **IntegraSUS Mental** é uma solução voltada à ampliação do acesso a atendimento psicológico pelo SUS por meio da integração de clínicas-escola à rede de atendimento público.

A proposta permite que instituições parceiras disponibilizem vagas de atendimento psicológico, presenciais ou por telemedicina, além de oferecer suporte ao fluxo de agendamento, atendimento clínico, supervisão acadêmica e reaproveitamento de vagas canceladas.

---

## Problema

O acesso à saúde mental é um dos grandes desafios atuais da saúde pública brasileira.

A procura por acolhimento psicológico ocorre em um contexto marcado por ansiedade, depressão, vulnerabilidade social, dificuldades econômicas e outros fatores que podem comprometer a qualidade de vida da população. Além de todos esses fatores, nos últimos anos, um novo elemento passou a receber atenção crescente: a popularização das plataformas de apostas online, conhecidas como *bets*.

O uso problemático dessas plataformas pode gerar impactos financeiros, familiares, sociais e emocionais. O próprio Ministério da Saúde reconhece o transtorno do jogo como um problema de saúde e passou a desenvolver ações específicas de prevenção, acolhimento e tratamento dentro do SUS.

Esse problema ganha ainda mais relevância quando associado ao endividamento. Levantamentos apresentados no Senado apontaram impactos das apostas online sobre a inadimplência e sobre a renda das famílias brasileiras, especialmente entre populações economicamente mais vulneráveis.

Ao mesmo tempo, a Rede de Atenção Psicossocial do SUS, incluindo serviços como os Centros de Atenção Psicossocial (CAPS), precisa responder a uma ampla variedade de demandas de saúde mental.

Nesse cenário, ampliar a capacidade de atendimento psicológico e aproveitar estruturas já existentes fora da rede pública pode ser uma estratégia complementar para fortalecer o acesso da população ao cuidado.

---
## Contexto e evidências

A relação entre apostas online, endividamento e saúde mental passou a receber atenção crescente no Brasil.

Em 2026, o Ministério da Saúde lançou uma campanha nacional voltada à prevenção dos danos causados pelas apostas online e à divulgação dos serviços de saúde mental disponíveis no SUS para apostadores e familiares.

O Ministério também publicou recomendações específicas para profissionais e gestores da Rede de Atenção Psicossocial no cuidado de pessoas com problemas relacionados a jogos de aposta.

Dados apresentados ao Senado também apontaram efeitos econômicos relevantes. Em estudo apresentado pela Confederação Nacional do Comércio, estimou-se que a expansão das apostas online contribuiu para que aproximadamente 1,3 milhão de brasileiros se tornassem inadimplentes em 2024.

Esses dados reforçam a importância de ampliar estratégias de prevenção, acolhimento e acesso a serviços de saúde mental.

Durante o desenvolvimento deste projeto, o Governo Federal editou uma Medida Provisória que proíbe a exploração, oferta, intermediação e publicidade das chamadas *bets* no Brasil.

Embora a medida represente uma mudança importante no enfrentamento do problema, os impactos financeiros, sociais e psicológicos associados ao uso problemático das apostas não desaparecem imediatamente. Pessoas já afetadas podem continuar necessitando de acolhimento, tratamento e acompanhamento pela rede de saúde.

Nesse contexto, o IntegraSUS Mental busca atuar como capacidade complementar à Rede de Atenção Psicossocial, ampliando a oferta de atendimento psicológico sem substituir os serviços especializados existentes.


### Referências

- [Ministério da Saúde — Campanha de prevenção aos danos das apostas online](https://www.gov.br/saude/pt-br/assuntos/noticias-ms/2026/julho/campanha-do-ministerio-da-saude-orienta-sobre-riscos-das-apostas-online-e-atendimento-em-saude-mental-no-sus)
- [Ministério da Saúde — Teleatendimento em saúde mental relacionado a jogos e apostas](https://www.gov.br/saude/pt-br/assuntos/noticias-ms/2026/agosto/meu-sus-digital-oferecera-ate-100-mil-teleatendimentos-mensais-para-pessoas-com-necessidades-relacionadas-a-jogos-e-apostas)
- [Senado Federal — Estudo da CNC sobre impactos econômicos das apostas](https://www12.senado.leg.br/noticias/materias/2024/11/26/a-cpi-cnc-aponta-impactos-negativos-das-casas-de-apostas-na-economia)
- [Ministério da Saúde — Medida Provisória que proíbe as bets no Brasil](https://www.gov.br/saude/pt-br/assuntos/noticias-ms/2026/setembro/presidente-lula-assina-medida-provisoria-que-proibe-as-bets-no-brasil/)

---

## Solução proposta

O **IntegraSUS Mental** propõe utilizar clínicas-escola de instituições de ensino como parceiras da rede pública de saúde mental.

Clínicas-escola já possuem uma estrutura voltada ao atendimento da população, com estudantes em formação realizando atendimentos sob supervisão de profissionais habilitados. A proposta do projeto é permitir que parte dessa capacidade possa ser integrada ao fluxo de atendimento do SUS, adicionando novas vagas à rede existente.

A ideia não é substituir o CAPS ou os demais componentes da Rede de Atenção Psicossocial, mas **somar capacidade de atendimento**, permitindo que clínicas-escola atuem como uma rede complementar para casos compatíveis com esse modelo de cuidado.

Por meio do IntegraSUS Mental, instituições parceiras podem disponibilizar vagas de atendimento psicológico em duas modalidades:

- **presencial**, considerando a localização do paciente e da instituição;
- **telemedicina**, ampliando o alcance geográfico do atendimento.

As vagas também podem ser classificadas de acordo com a abordagem clínica oferecida, permitindo uma organização mais adequada dos atendimentos.

O sistema também contempla o fluxo acadêmico das clínicas-escola. Alunos realizam os atendimentos e registram anotações clínicas, que posteriormente passam pela avaliação de um supervisor.

Além da ampliação da oferta, o projeto busca reduzir o desperdício de capacidade causado pelo absenteísmo. Quando um atendimento é cancelado, a vaga é automaticamente reaberta e um evento é publicado para que outros processos, como notificações a pacientes interessados, possam ser executados.

Dessa forma, o IntegraSUS Mental atua em três frentes principais:

1. **ampliação da oferta de atendimento psicológico**, integrando clínicas-escola à rede;
2. **melhor aproveitamento das vagas disponíveis**, especialmente após cancelamentos;
3. **estruturação do atendimento supervisionado**, respeitando o modelo acadêmico das clínicas-escola.

O objetivo é criar uma arquitetura capaz de aproximar capacidade ociosa de instituições de ensino da demanda existente na saúde pública, fortalecendo a rede de atenção psicossocial e ampliando as possibilidades de acesso ao cuidado psicológico.

---

## Arquitetura

A aplicação utiliza uma arquitetura baseada em microsserviços, separação de responsabilidades e comunicação orientada a eventos.

```text
                         ┌────────────────────┐
                         │     API Gateway    │
                         │       :8085        │
                         └─────────┬──────────┘
                                   │
                ┌──────────────────┼──────────────────┐
                │                  │                  │
                ▼                  ▼                  ▼
       ┌──────────────┐   ┌────────────────┐   ┌──────────────┐
       │ Core Service │   │   Scheduling   │   │   Clinical   │
       │    :8080     │   │ Service :8081  │   │ Service:8082 │
       └──────┬───────┘   └───────┬────────┘   └──────┬───────┘
              │                   │                   │
              ▼                   ▼                   ▼
          PostgreSQL          PostgreSQL          PostgreSQL
            :5432               :5433               :5434
                                  │
                                  ▼
                            ┌───────────┐
                            │ RabbitMQ  │
                            │   :5672   │
                            └─────┬─────┘
                                  │
                                  ▼
                       ┌─────────────────────┐
                       │ Notification Worker │
                       └─────────────────────┘
```

---

# Microsserviços

## Core Service

Responsável pelos dados cadastrais principais da solução.

### Responsabilidades

- cadastro de instituições;
- cadastro de profissionais;
- diferenciação entre aluno e supervisor;
- vínculo de profissionais com instituições;
- vínculo de aluno com supervisor;
- cadastro de pacientes.

### Porta

```text
8080
```

### Banco de dados

```text
PostgreSQL - localhost:5432
```

### Endpoints

```http
POST /api/v1/instituicoes
GET  /api/v1/instituicoes
GET  /api/v1/instituicoes/{id}

POST /api/v1/profissionais

POST /api/v1/pacientes
```

---

## Scheduling Service

Responsável pela gestão de vagas e agendamentos.

### Responsabilidades

- criação de vagas;
- definição de modalidade;
- definição de abordagem clínica;
- agendamento;
- consulta de agendamento;
- cancelamento;
- reabertura automática da vaga;
- publicação de eventos no RabbitMQ.

### Porta

```text
8081
```

### Banco de dados

```text
PostgreSQL - localhost:5433
```

### Endpoints

```http
POST  /api/v1/vagas
GET   /api/v1/vagas

POST  /api/v1/agendamentos
GET   /api/v1/agendamentos/{id}

PATCH /api/v1/agendamentos/{id}/cancelar
```

### Regras de negócio implementadas

Uma vaga:

- não pode ser criada com data no passado;
- deve possuir CEP quando a modalidade for `PRESENCIAL`;
- é criada inicialmente com status `DISPONIVEL`;
- muda para `OCUPADA` após um agendamento;
- volta para `DISPONIVEL` quando o agendamento é cancelado.

### Modalidades suportadas

```text
TELEMEDICINA
PRESENCIAL
```

### Abordagens clínicas suportadas

```text
TCC
PSICANALISE
```

---

## Clinical Service

Responsável pelo fluxo clínico e de supervisão acadêmica.

### Responsabilidades

- criação de atendimento;
- registro de anotação clínica;
- alteração do status do atendimento;
- aprovação da anotação pelo supervisor;
- consulta ao histórico do paciente.

### Porta

```text
8082
```

### Banco de dados

```text
PostgreSQL - localhost:5434
```

### Endpoints

```http
POST  /api/v1/atendimentos

POST  /api/v1/atendimentos/{id}/anotacoes

PATCH /api/v1/atendimentos/{id}/aprovar

GET   /api/v1/atendimentos/paciente/{pacienteId}
```

### Fluxo clínico

```text
EM_ATENDIMENTO
       ↓
Aluno registra anotação clínica
       ↓
AGUARDANDO_SUPERVISAO
       ↓
Supervisor avalia
       ↓
CONCLUIDO
```

No MVP, cada atendimento possui uma única anotação clínica.

---

## Notification Worker

Responsável pelo consumo assíncrono de eventos.

O serviço não expõe endpoints REST públicos.

### Evento consumido

```text
VagaReabertaEvent
```

### Fila

```text
vaga.reaberta.queue
```

### Fluxo

```text
Agendamento cancelado
        ↓
Status = CANCELADO
        ↓
Vaga = DISPONIVEL
        ↓
VagaReabertaEvent
        ↓
RabbitMQ
        ↓
Notification Worker
        ↓
Notificação simulada em log
```

No MVP, o envio de notificação real é simulado.

---

# API Gateway

O API Gateway fornece um ponto único de entrada para os serviços REST.

### Porta

```text
8085
```

### Roteamento

```text
/api/v1/instituicoes/**
/api/v1/profissionais/**
/api/v1/pacientes/**
        ↓
Core Service
```

```text
/api/v1/vagas/**
/api/v1/agendamentos/**
        ↓
Scheduling Service
```

```text
/api/v1/atendimentos/**
        ↓
Clinical Service
```

### Exemplos

```http
GET http://localhost:8085/api/v1/instituicoes
```

```http
GET http://localhost:8085/api/v1/vagas
```

```http
GET http://localhost:8085/api/v1/atendimentos/paciente/1
```

---

# Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Cloud Gateway
- Spring AMQP
- RabbitMQ
- PostgreSQL
- Hibernate
- Maven
- Maven Wrapper
- Lombok
- Docker
- Docker Compose
- Swagger
- OpenAPI
- Postman

---

# Estrutura do projeto

```text
integraSUS/
│
├── docker-compose.yml
├── README.md
│
├── core-service/
│
├── scheduling-service/
│
├── clinical-service/
│
├── notification-worker/
│
└── api-gateway/
```

Cada microsserviço possui:

- seu próprio `pom.xml`;
- suas próprias dependências;
- seu próprio ciclo de execução;
- responsabilidades específicas.

---

# Infraestrutura local

A infraestrutura local utiliza Docker Compose.

Na raiz do projeto:

```bash
docker compose up -d
```

Para verificar os containers:

```bash
docker ps
```

### Serviços de infraestrutura

| Serviço | Porta |
|---|---:|
| PostgreSQL Core | 5432 |
| PostgreSQL Scheduling | 5433 |
| PostgreSQL Clinical | 5434 |
| RabbitMQ | 5672 |
| RabbitMQ Management | 15672 |

### RabbitMQ Management

```text
http://localhost:15672
```

Credenciais locais:

```text
guest
guest
```

---

# Executando os serviços

Cada serviço deve ser iniciado individualmente.

## Core Service

```bash
cd core-service
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## Scheduling Service

```bash
cd scheduling-service
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## Clinical Service

```bash
cd clinical-service
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## Notification Worker

```bash
cd notification-worker
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## API Gateway

```bash
cd api-gateway
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

# Documentação da API

Todas as APIs REST utilizam versionamento:

```text
/api/v1
```

Cada serviço REST disponibiliza sua própria documentação através de Swagger/OpenAPI.

---

## Core Service

### Swagger UI

```text
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON

```text
http://localhost:8080/v3/api-docs
```

Documenta:

- instituições;
- profissionais;
- pacientes.

---

## Scheduling Service

### Swagger UI

```text
http://localhost:8081/swagger-ui.html
```

### OpenAPI JSON

```text
http://localhost:8081/v3/api-docs
```

Documenta:

- vagas;
- agendamentos;
- cancelamentos.

---

## Clinical Service

### Swagger UI

```text
http://localhost:8082/swagger-ui.html
```

### OpenAPI JSON

```text
http://localhost:8082/v3/api-docs
```

Documenta:

- atendimentos;
- anotações clínicas;
- supervisão;
- histórico do paciente.

---

## Notification Worker

O Notification Worker não possui Swagger, pois não expõe endpoints REST.
Sua comunicação ocorre através do RabbitMQ.

---

# Fluxo principal do MVP

O fluxo principal demonstrado pela aplicação é:

```text
Cadastro da instituição
        ↓
Cadastro do supervisor
        ↓
Cadastro do aluno
        ↓
Cadastro do paciente
        ↓
Criação da vaga
        ↓
Agendamento
        ↓
Atendimento
        ↓
Anotação clínica
        ↓
Supervisão
        ↓
Histórico do paciente
```

---

# Fluxo orientado a eventos

O sistema também implementa um fluxo assíncrono para reaproveitamento de vagas.

```text
Paciente cancela
       ↓
Agendamento = CANCELADO
       ↓
Vaga = DISPONIVEL
       ↓
VagaReabertaEvent
       ↓
RabbitMQ
       ↓
Notification Worker
       ↓
Notificação simulada
```

Esse fluxo reduz o acoplamento entre o serviço responsável pelos agendamentos e o mecanismo responsável pelas notificações.

---

# Exemplo de fluxo de demonstração

A seguir, temos uma sequência possível e indicada para o teste/avaliação da solução MVP:

```text
1. Criar instituição
2. Criar supervisor
3. Criar aluno
4. Criar paciente
5. Criar vaga
6. Criar agendamento
7. Criar atendimento
8. Registrar anotação clínica
9. Aprovar anotação
10. Consultar histórico
11. Cancelar um agendamento
12. Visualizar evento no RabbitMQ
13. Visualizar consumo pelo Notification Worker
```

---

# Decisões de MVP

Por se tratar de um projeto desenvolvido em contexto de hackathon, algumas decisões foram tomadas para manter o escopo viável.

## Implementado

- arquitetura baseada em microsserviços;
- API Gateway;
- APIs REST;
- versionamento `/api/v1`;
- bancos PostgreSQL separados;
- cadastro de instituições;
- cadastro de profissionais;
- vínculo entre aluno e supervisor;
- cadastro de pacientes;
- criação de vagas;
- atendimento presencial e por telemedicina;
- abordagem clínica;
- agendamento;
- cancelamento;
- reabertura de vaga;
- mensageria;
- RabbitMQ;
- Notification Worker;
- registro clínico;
- supervisão acadêmica;
- histórico do paciente;
- Swagger/OpenAPI.

---

# Evoluções futuras

Possíveis evoluções da solução:

- autenticação e autorização via JWT;
- Keycloak ou Auth0;
- controle de acesso por perfil;
- integração com RNDS;
- integração com sistemas oficiais do SUS;
- envio real de e-mails;
- envio real de SMS;
- notificações push;
- integração com plataformas de teleconsulta;
- triagem clínica estruturada;
- classificação de prioridade;
- geolocalização;
- cálculo de distância para atendimentos presenciais;
- reagendamento;
- service discovery;
- circuit breaker;
- rate limiting;
- observabilidade centralizada;
- logs distribuídos;
- tracing;
- métricas;
- deploy em cloud;
- uso de SNS/SQS em ambiente produtivo;
- transactional outbox para maior consistência de eventos.

---

# Segurança e dados clínicos

O projeto atual é um MVP acadêmico.

Os dados utilizados para desenvolvimento e demonstração são fictícios.

Em um ambiente produtivo, o manejo de dados pessoais e clínicos exigiria medidas adicionais, incluindo:
- autenticação;
- autorização;
- controle de acesso baseado em perfil;
- auditoria;
- criptografia em trânsito;
- criptografia em repouso;
- proteção de informações sensíveis;
- rastreabilidade;
- políticas de retenção;
- adequação à LGPD;
- integração segura com sistemas oficiais de saúde.

---

# Persistência

Cada serviço possui seu próprio banco PostgreSQL.

Essa decisão evita o compartilhamento direto de banco entre os microsserviços e mantém a separação de responsabilidades.

Além disso, falhas de persistência tendem a ficar isoladas ao domínio responsável, reduzindo o impacto direto sobre os bancos dos demais serviços. Dependendo do fluxo, porém, a indisponibilidade de um microsserviço ainda pode afetar funcionalidades que dependam dele.

O Notification Worker não possui banco próprio neste MVP.


```text
Core Service
    ↓
integrasus_core

Scheduling Service
    ↓
integrasus_scheduling

Clinical Service
    ↓
integrasus_clinical
```


---

# Comunicação entre serviços

O projeto utiliza dois estilos principais de comunicação, sendo:

## Comunicação síncrona

As APIs REST são expostas através do API Gateway.

```text
Cliente
   ↓
API Gateway
   ↓
Microsserviço
```

## Comunicação assíncrona

Os eventos são publicados através do RabbitMQ.

```text
Scheduling Service
       ↓
RabbitMQ
       ↓
Notification Worker
```

---

# Status principais

## Vaga

```text
DISPONIVEL
OCUPADA
CANCELADA
```

## Agendamento

```text
AGENDADO
CANCELADO
REAGENDADO
```

## Atendimento

```text
EM_ATENDIMENTO
AGUARDANDO_SUPERVISAO
CONCLUIDO
```

## Perfil profissional

```text
ALUNO
SUPERVISOR
```

---

# Observações sobre o MVP

Alguns relacionamentos entre serviços são representados por identificadores externos.

Por exemplo, o Scheduling Service armazena identificadores de:

- instituição;
- aluno;
- supervisor;
- paciente.

Esses dados pertencem conceitualmente ao Core Service.

Essa simplificação foi adotada no MVP para evitar forte acoplamento entre os serviços e manter o desenvolvimento compatível com o prazo do hackathon.

Em uma evolução futura, validações entre serviços poderiam ser realizadas através de:

- chamadas internas;
- eventos;
- cache;
- replicação controlada de dados de referência.

---

# Autores

- Victoria Maziero
- Artur Gussi

---

# Licença

Projeto acadêmico desenvolvido como projeto final para a Pós-Tech em Arquitetura e Desenvolvimento Java, na FIAP, com fins educacionais.