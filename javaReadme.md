# readme do java #
Parte do java do trabalho de banco de dados de POO 2
O projeto consiste em um programa em java que serve para registrar clientes e atribuir eventos destes clientes em uma agenda, tudo conectado ao banco de dados Mysql

# Organização do projeto
![Organização](https://github.com/user-attachments/assets/8233b356-736b-4fc9-8956-784b8f2a020b)
## br.com.DAO:
Contém as classes de acesso a dados (Data Access Object). Essas classes são responsáveis por interagir com o banco de dados MySQL, realizando operações de inserção, leitura, atualização e deleção (CRUD) de dados.
## AgendaDAO.java:
Provavelmente lida com a tabela de agendamentos no banco de dados.
## ClienteDAO.java:
Interage com a tabela de clientes.
## ConexaoDAO.java: 
Esta classe centraliza a conexão com o banco de dados, estabelecendo a comunicação com o MySQL.
## UsuarioDAO.java: 
Realiza operações relacionadas à tabela de usuários.
## br.com.DTO:
Contém as classes de transferência de dados (Data Transfer Object). Essas classes representam os objetos que serão transferidos entre as camadas da aplicação, geralmente transportando dados entre a camada de apresentação e a camada de negócios.
## AgendaDTO.java:
Representa um agendamento.
## ClienteDTO.java:
Representa um cliente.
## UsuarioDTO.java: 
Representa um usuário.
## br.com.bios: 
Contém as classes que compõem a interface gráfica do usuário (GUI).
## CadCli.java, CadUsu.java, CriaUsu.java:
são responsáveis por cadastrar clientes e usuários.
## TelaAgenda.java, TelaInicial.java, TelaPrincipal.java: 
São as telas principais da aplicação, exibindo informações sobre agendamentos, a tela inicial e a tela principal, respectivamente.
## login.java: Contém a lógica de autenticação de usuários.

# Interfaces graficas
## Tela inicial
![Captura de tela 2024-10-21 201816](https://github.com/user-attachments/assets/b63f5852-6407-4637-8b66-f150caec10d9)

 A primeira tela do projeto, onde é possivel escolher Logar em uma conta existente, ou criar uma nova.

 ## Tela principal

 ![Captura de tela 2024-10-21 202407](https://github.com/user-attachments/assets/a6f0552c-d6c7-4e84-aebc-43d1da6df314)

 Tela principal do projeto, podendo escolher ir até o cadastro de usuarios ou clientes, e acessar a agenda.
 É acessada após o login ser feito ou uma conta ser criada.

 ## Tela login

 ![Captura de tela 2024-10-21 202924](https://github.com/user-attachments/assets/249749fa-853c-4e3e-be64-36f82278aa54)

 Tela acessada ao selecionar "fazer login" na tela inicial.


 ## Tela criar usuario
 
![Captura de tela 2024-10-21 203344](https://github.com/user-attachments/assets/ec5e4d76-b0fe-47c2-a3e4-bc318b2e6ea6)

Tela acessada ao selecionar "criar conta" na tela inicial.

## Tela de cadastro de usuarios

![Captura de tela 2024-10-21 203608](https://github.com/user-attachments/assets/a2924e3d-09d1-4192-8e4e-77ecbcce3238)

Permite manipular os usuarios cadastrados no banco de dados com um CRUD(criar, ler, atualizar e deletar).

## Tela de cadastro de clientes 

![Captura de tela 2024-10-21 203843](https://github.com/user-attachments/assets/989c1b23-fe34-428c-b9ae-e5805c6d6896)

Tambem permite manipular dados porem de clientes com o mesmo CRUD.

## Tela da agenda

![Captura de tela 2024-10-21 204041](https://github.com/user-attachments/assets/ae66f50f-8777-434c-9bed-06a7b3d6518a)

Permite manipular a agenda. criar, modificar, deletar e pesquisar eventos entre certas datas, horarios e clientes  especificos.







 

 


 
