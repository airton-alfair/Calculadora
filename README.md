# 🧮 Calculadora (Java)

Implementação de uma **Calculadora em Java**, estruturada com separação clara entre **modelo e visão**, aplicando conceitos de **Programação Orientada a Objetos** e padrão de observador.

O projeto simula uma calculadora funcional com interface própria e arquitetura organizada em camadas.

---

## 🎯 Objetivo

Projeto desenvolvido com foco em:

* Prática de Programação Orientada a Objetos
* Separação de responsabilidades
* Organização modular de código
* Aplicação do padrão Observer
* Estrutura profissional de projeto Java

---

## 🛠️ Tecnologias Utilizadas

* Java (JDK 8+)
* Programação Orientada a Objetos
* Padrão Observer
* Interface gráfica em Java

---

## 📂 Estrutura do Projeto

```
src/
└── br/
    └── com/
        └── alfair/
            └── calc/
                ├── modelo/
                │   ├── Memoria.java
                │   └── MemoriaObservador.java
                │
                └── visao/
                    ├── Botao.java
                    ├── Calculadora.java
                    ├── Display.java
                    └── Teclado.java
```

---

## 🧠 Arquitetura do Projeto

O projeto está dividido em duas camadas principais:

```
Visão  →  Modelo
```

| Camada | Responsabilidade                          |
| ------ | ----------------------------------------- |
| modelo | Regras de negócio e cálculos              |
| visao  | Interface gráfica e interação com usuário |

---

## 📦 Camada Modelo

### 📌 Memoria.java

Classe responsável por:

* Armazenar valores digitados
* Controlar operações matemáticas
* Executar cálculos
* Gerenciar estado atual da calculadora

Centraliza toda a lógica de negócio da aplicação.

---

### 📌 MemoriaObservador.java

Interface que define o contrato para atualização da interface.

Implementa o padrão **Observer**, permitindo que a camada de visão seja notificada quando o valor do display muda.

---

## 🖥️ Camada Visão

### 📌 Calculadora.java

Classe principal (`main`) da aplicação.

Responsável por:

* Inicializar a interface
* Criar componentes
* Organizar layout
* Integrar visão com modelo

---

### 📌 Display.java

Responsável por:

* Exibir valores e resultados
* Atualizar informações quando a memória é alterada

---

### 📌 Teclado.java

Gerencia:

* Organização dos botões
* Layout da calculadora
* Disposição das operações

---

### 📌 Botao.java

Representa cada botão da calculadora.

Controla:

* Eventos de clique
* Envio de comandos para o modelo

---

## ➕ Operações Suportadas

* Soma (+)
* Subtração (-)
* Multiplicação (×)
* Divisão (÷)
* Limpar (C)
* Alteração de sinal (+/-)
* Operações encadeadas

---

## ▶️ Como Executar

### 1️⃣ Compilar

No diretório `src`:

```bash
javac br/com/alfair/calc/**/*.java
```

### 2️⃣ Executar

```bash
java br.com.alfair.calc.visao.Calculadora
```

---

## 🧩 Conceitos Aplicados

* Encapsulamento
* Separação de responsabilidades
* Padrão Observer
* Eventos de interface gráfica
* Organização modular
* Clean Code

---

## 🚀 Possíveis Melhorias Futuras

* Suporte a operações científicas
* Histórico de cálculos
* Testes unitários (JUnit)
* Melhorias visuais
* Tema escuro

---

## 👨‍💻 Autor

Projeto desenvolvido para prática e evolução em Java.

---

## 📄 Licença

Uso livre para fins educacionais.
