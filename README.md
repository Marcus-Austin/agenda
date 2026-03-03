📒 Agenda – Sistema de Gerenciamento de Contatos

Sistema de agenda desenvolvido com Java 21, estruturado em arquitetura em camadas, com planejamento de evolução para Arquitetura Limpa (Clean Architecture).

📌 Objetivo do Projeto

Desenvolver uma aplicação backend robusta para gerenciamento de contatos, aplicando boas práticas de engenharia de software, separação de responsabilidades e princípios de código limpo.

Este projeto tem como foco:

Organização arquitetural

Clareza na separação de camadas

Facilidade de manutenção

Evolução futura para Arquitetura Limpa

🚀 Tecnologias Utilizadas

Java 21

API REST (caso utilize framework como Spring Boot, você pode incluir aqui)

Padrão arquitetural em camadas

Banco de dados relacional (ex: PostgreSQL, se aplicável)

Maven ou Gradle (caso utilize)

🏗️ Arquitetura Atual – Padrão em Camadas

A aplicação segue o modelo clássico de arquitetura em camadas:

📂 Estrutura Base
src/main/java
│
├── controller     → Camada de apresentação (API REST)
├── service        → Regras de negócio
├── repository     → Acesso a dados
├── model          → Entidades de domínio
└── dto            → Objetos de transferência de dados
🔎 Responsabilidade das Camadas

Controller

Recebe requisições HTTP

Valida entrada

Delegação para a camada de serviço

Service

Implementação das regras de negócio

Orquestração de operações

Validações de domínio

Repository

Comunicação com o banco de dados

Operações CRUD

Model

Representação das entidades do sistema

DTO

Objetos para transporte de dados entre camadas
🔄 Evolução Planejada – Arquitetura Limpa

O projeto será refatorado para seguir os princípios da Clean Architecture, proposta por Robert C. Martin.

🎯 Objetivos da Migração

Independência de frameworks

Domínio desacoplado de infraestrutura

Inversão de dependências

Alta testabilidade

Aplicação sólida dos princípios SOLID

📂 Estrutura Futura (Planejada)
domain
  ├── entities
  ├── usecases
  └── interfaces

application
  └── services

infrastructure
  ├── persistence
  └── configuration

presentation
  └── controllers

