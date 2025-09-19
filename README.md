# 🚀 TP3 - Desenvolvimento Back-end com Java

## 📋 Sobre o Projeto

Este projeto implementa um cliente HTTP completo em Java puro, demonstrando operações CRUD (Create, Read, Update, Delete) através do consumo de APIs REST. Desenvolvido como parte do curso **Fundamentos de Desenvolvimento com Java: Desenvolvimento Back-end** do Instituto Infnet.

### 🎯 Objetivos

- ✅ Implementar todos os verbos HTTP (GET, POST, PUT, DELETE, OPTIONS)
- ✅ Consumir APIs REST utilizando `HttpURLConnection`
- ✅ Manipular dados JSON de forma manual
- ✅ Aplicar tratamento de exceções e códigos HTTP
- ✅ Demonstrar boas práticas de organização de código

## 🏗️ Arquitetura do Projeto

```
src/
├── 📁 Exercícios Individuais/
│   ├── Exercicio1.java          # GET todas as entidades
│   ├── Exercicio2.java          # GET entidades específicas (1-8)
│   ├── Exercicio3.java          # GET entidade inexistente (404)
│   ├── Exercicio4.java          # GET com query parameters
│   ├── Exercicio5.java          # POST criar nova entidade
│   ├── Exercicio6.java          # GET verificar criação
│   ├── Exercicio7.java          # POST atualizar entidade
│   ├── Exercicio8.java          # PUT atualizar entidade
│   ├── Exercicio9.java          # DELETE entidade válida
│   ├── Exercicio10.java         # DELETE tentativa inválida
│   └── Exercicio11.java         # OPTIONS descobrir métodos
│
├── 🛠️ Classes Utilitárias/
│   ├── HttpUtils.java           # Métodos HTTP reutilizáveis
│   └── TestSimpleAPI.java       # Testes Simple API
│
└── 🎯 Execução Principal/
    └── TP3Main.java             # Demonstração completa
```

## 🔧 Tecnologias Utilizadas

### Core
- **Java SE** - Linguagem principal
- **HttpURLConnection** - Cliente HTTP nativo
- **BufferedReader/DataOutputStream** - Manipulação I/O

### APIs Consumidas
- **API Entities**: `https://apichallenges.eviltester.com/sim/entities`
- **Simple API**: `https://apichallenges.eviltester.com/simpleapi/items`

### Ferramentas de Desenvolvimento
- **VS Code** - IDE com extensão Java
- **Git** - Controle de versão

## 🚦 Como Executar

### Pré-requisitos
- ☕ Java 11+ instalado
- 🔧 JDK configurado no PATH
- 🌐 Conexão com internet (para acessar APIs)

### Execução Individual
```bash
# Compilar classe específica
javac src/Exercicio1.java

# Executar
java -cp src Exercicio1
```

### Execução Completa
```bash
# Compilar classe principal
javac src/TP3Main.java src/HttpUtils.java

# Executar demonstração completa
java -cp src TP3Main
```

### Execução via VS Code
1. Abrir projeto no VS Code
2. Instalar extensão "Extension Pack for Java"
3. Executar qualquer classe usando `Ctrl+F5`

## 📊 Funcionalidades Implementadas

### 🔍 Operações de Leitura (GET)
- **GET All**: Buscar todas as entidades
- **GET by ID**: Buscar entidades específicas (IDs 1-8)
- **GET 404**: Testar comportamento com ID inexistente
- **GET with Params**: Requisições com query parameters

### ✍️ Operações de Escrita (POST/PUT)
- **POST Create**: Criar novas entidades
- **POST Update**: Atualizar entidades existentes
- **PUT Update**: Atualização completa via PUT

### 🗑️ Operações de Exclusão (DELETE)
- **DELETE Valid**: Remover entidades permitidas
- **DELETE Invalid**: Testar remoção de entidades protegidas

### 🔍 Descoberta de API (OPTIONS)
- **OPTIONS**: Descobrir métodos HTTP suportados

### 📚 Simple API Integration
- **ISBN Generation**: Gerar ISBNs aleatórios
- **Book Management**: CRUD completo de livros
- **Inventory Control**: Controle de estoque

## 🧩 Componentes Principais

### HttpUtils.java - Classe Utilitária
```java
// Métodos estáticos para reutilização
HttpUtils.get(url)           // GET genérico
HttpUtils.post(url, json)    // POST com payload
HttpUtils.put(url, json)     // PUT com payload
HttpUtils.delete(url)        // DELETE simples
HttpUtils.options(url)       // OPTIONS para descoberta
```

### TP3Main.java - Orquestrador
Executa todos os exercícios de forma sequencial, demonstrando:
- 🔄 Fluxo completo de operações
- 📋 Validação de resultados
- 🎨 Formatação de saída organizada

## 📈 Códigos HTTP Tratados

| Código | Status | Significado |
|--------|--------|-------------|
| 200 | ✅ OK | Operação bem-sucedida |
| 201 | ✅ Created | Recurso criado com sucesso |
| 204 | ✅ No Content | Exclusão bem-sucedida |
| 404 | ⚠️ Not Found | Recurso não encontrado |
| 405 | ❌ Method Not Allowed | Método não permitido |

## 🎓 Conceitos Aplicados

### Programação Orientada a Objetos
- **Encapsulamento**: Métodos estáticos organizados
- **Reutilização**: Classe HttpUtils evita duplicação
- **Responsabilidade Única**: Cada classe tem propósito específico

### Padrões de Design
- **Factory Method**: Métodos de criação de requisições
- **DRY Principle**: Don't Repeat Yourself
- **Error Handling**: Tratamento robusto de exceções

### Protocolo HTTP
- **Verbos HTTP**: Implementação completa
- **Headers**: Content-Type, Accept configurados
- **Status Codes**: Interpretação e tratamento adequados

## 🧪 Testes e Validação

### Cenários de Teste
- ✅ Operações CRUD completas
- ✅ Tratamento de erros (404, 405)
- ✅ Validação de payloads JSON
- ✅ Verificação de persistência
- ✅ Descoberta de métodos API

### Resultados Esperados
Cada exercício produz saídas específicas demonstrando:
- Códigos HTTP corretos
- Payloads JSON válidos  
- Tratamento adequado de erros
- Fluxos de negócio completos

## 📚 Aprendizados Obtidos

### Técnicos
- 🔧 Manipulação de HttpURLConnection
- 📄 Processamento manual de JSON
- 🔄 Gerenciamento de streams I/O
- ⚠️ Tratamento robusto de exceções

### Conceituais
- 🌐 Funcionamento do protocolo HTTP
- 🏗️ Arquitetura de APIs REST
- 🔒 Códigos de status e semântica HTTP
- 📊 Padrões de integração entre sistemas

## 🚀 Próximos Passos

### Melhorias Possíveis
- 📦 **Jackson/Gson**: Serialização automática JSON
- 🌐 **Apache HttpClient**: Cliente HTTP mais robusto
- 🧪 **JUnit**: Testes automatizados
- 🔒 **Autenticação**: OAuth/JWT para APIs seguras
- ⚡ **Spring Boot**: Framework para desenvolvimento web

### Aplicações Práticas
- 🔗 **Microsserviços**: Comunicação entre serviços
- 🤖 **SDKs**: Desenvolvimento de bibliotecas cliente
- 🧪 **Automação**: Testes de APIs automatizados
- 📊 **ETL**: Extração/transformação de dados via APIs

## 👨‍💻 Autor

**Lucas Amorim Porciuncula**
- 🎓 Estudante de Engenharia de Dados e IA
- 💼 Auxiliar Administrativo
- 📍 Catu, Bahia, Brasil

*"Sempre em busca de evolução através da tecnologia"*

## 📄 Licença

Este projeto é desenvolvido para fins educacionais como parte do curso do Instituto Infnet.

---

*Desenvolvido com ☕ e muito aprendizado em Java*
