# 🔗 URshort - URL shortner

>Este projeto é uma aplicação de encurtamento de URLs, pensada para evoluir de uma API simples para um sistema completo, com frontend, autenticação, escala e observabilidade.
>
>A proposta é permitir que usuários criem e gerenciem seus próprios links encurtados, com foco em organização, segurança e possibilidade de crescimento do sistema.

<br>

## 🎯 Funcionalidades 

- Encurtar URLs longas em links curtos

- Criar links com códigos personalizado

- Associar URLs a usuários autenticados

<br>

## 🧱 Visão Geral da Arquitetura

- Backend responsável por autenticação, criação e redirecionamento de URLs

- Frontend (futuro) para interação do usuário

- Banco SQL para usuários

- Banco NoSQL (MongoDB) para URLs

<br>
<br>

# 🧩 Etapas do Projeto



## ✅ Etapa 1 — API Base

- API REST com Spring Boot

- Registro e login de usuários

- Autenticação via JWT

- Criação de URLs encurtadas

- Associação da URL ao usuário autenticado

<br>

## 🚧 Etapa 2 — Redirecionamento

- Acesso via /codigo

- Redirecionamento para a URL original

- Validação de links ativos

<br>

## 🔜 Etapa 3 — Frontend

- Interface web com React

- Comunicação com API REST

- Design responsivo (desktop e mobile)

- Autenticação com JWT

<br>

## 🔜 Etapa 4 — Infraestrutura e Escala

- Dockerização da aplicação

- Configuração de containers para bancos

- Separação de ambientes (dev | prod)

<br>

## 🔜 Etapa 5 — Performance e Observabilidade

- Redis para cache de redirecionamentos

- Kafka para eventos (ex: contagem de acessos)

- Grafana para métricas e monitoramento

<br>

## 🛠️ Tecnologias Utilizadas
#### Backend

- Spring Boot

- Spring Security

- JWT

#### Frontend

- React

- Axios

- Tailwind

#### Bancos de Dados

- SQL (usuários)

- MongoDB (URLs)

#### Infraestrutura (planejada)

- Docker

- Kafka

- Redis

- Grafana

<br>

## 📌 Considerações

- Projeto desenvolvido de forma incremental

- Foco em aprendizado prático de backend e arquitetura

- Estrutura pensada para crescer sem complicar a base inicial

<br>

## 📌 Status

### 🚧 Em desenvolvimento
- [x] Estrutura inicial do backend
- [x] Autenticação com JWT
- [x] Criação de URLs encurtadas
- [ ] Frontend
- [ ] Dockerização
- [ ] Observabilidade e métricas
