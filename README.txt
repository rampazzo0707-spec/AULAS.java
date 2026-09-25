Sistema de Cadastro de Usuários e Tarefas — Java

Projeto desenvolvido durante meus estudos de Java e Orientação a Objetos. Simula um sistema de gerenciamento de usuários e tarefas via terminal, com validação real de dados e tratamento de erros.

Funcionalidades
Cadastro de usuários com validação de CPF (cálculo de dígito verificador, não apenas contagem de caracteres)
Validação de formato de e-mail
Cadastro de tarefas associadas a um usuário responsável
Listagem de usuários e tarefas
Conclusão de tarefas
Remoção de usuários
Tratamento de duplicidade (nome, CPF e título de tarefa já cadastrados)
Tratamento de erros de entrada, com repetição de tentativa em caso de dado inválido
Tópicos Praticados
 Classes, atributos privados, construtores e encapsulamento
 Getters e Setters (com regra de negócio: CPF é imutável após o cadastro, sem setter)
 Associação entre classes (Tarefa referencia um Usuario responsável)
 Validação de dados no construtor, com IllegalArgumentException
 ArrayList (add, get, remove, busca com for-each)
 Estrutura de menu com switch e while
 Tratamento de exceções (try/catch)
 Algoritmo de validação de CPF (dígito verificador)
 Validação de e-mail com expressão regular
Em andamento
 Reorganização do projeto em pacotes (model, service, app)
 Testes unitários com JUnit para os métodos de validação
 Migração para API REST com Spring Boot + Maven
 Persistência em banco de dados (H2 → PostgreSQL) via Spring Data JPA
 Interface web simples consumindo a API
Tecnologias
Java (sem frameworks nesta fase — foco em fundamentos e lógica)
Como Rodar o Projeto
Clone o repositório
Compile e execute a classe Main.java
Certifique-se de que as classes Usuario.java e Tarefa.java estão no mesmo projeto/pasta
bash
javac Main.java Usuario.java Tarefa.java
java Main
Feedback

Ainda estou estudando e este projeto evolui aos poucos. Se você é dev e tiver sugestões, correções ou conselhos, fico grato — todo retorno ajuda no aprendizado.
