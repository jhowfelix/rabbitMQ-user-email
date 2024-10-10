# Cadastro de usuário com envio de email e rabbitMQ

Um simples projeto para aplicar o conceito (A nível básico) de mensageria  utilizando a plataforma rabbitMQ.




## USER (Producer)
Responsavel por: 
- Cadastrar um usuário
- Enviar usuário cadastrado para a queue correspondente no cloudAMQP 
- Salvar usuário no banco de dados

## Email (Consumer)
Responsável por: 
- Consumir a mensagem do rabbitMQ
- Criar um objeto que será utilizado no envio de email
- Enviar um email para o usuário cadastrado.
- Salvar o email enviado na base de dados.

