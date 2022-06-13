Esse é o backend do Rota do Mosquito.


Para a execucao do codigo fonte:
- Somente é necessario uma jdk >= 11 e uma IDE.
- Dentro do package principal existe uma classe RotamosquitoApplication e dentro dela um metodo main, basta apenas executa-lo.
- É necessario tambem um banco postgres rodando, e para configurar basta criar um arquivo .env na pasta rotamosquito,
com 3 parametros DATABASE_URL, DATABASE_USER, DATABASE_PASS, isso são variaveis de ambiente e podem ser configuradas
de outras maneiras tambem. Como o ddl-auto=update esta ativo, basta criar o banco de dados da informado na url, que aplicacao trata de 
criar as tabelas e sequences necessarias.
- Ao rodar o projeto, é possivel acessar a url http://localhost:8080/swagger-ui que possui a documentação do projeto

----------------------------------------------------------------

Esses comandos  abaixo devem ser rodados dentro da pasta rotamosquito do projeto backend, somente são necessarios para realizar o build da aplicacao e atualizar a imagem no dockerhub, essa imagem do docker hub é a usada no docker-compose.

- É necessario ter o maven e jdk configurada ou usar uma IDE de auxilio (gera um jar executavel dentro da pasta target).

  - mvn clean package -DskipTests 

- Gera uma imagem docker do projeto

  - docker build -t rotadomosquito/backend .

- Para realizar o push, é necesario antes realizar o login antes, esse passo normalmente é executado somente uma vez, e pode feito de varias maneiras o mais simples é gerar um token dentro do docker hub, executar esse comando e colar o token quando solicitado, porem isso somente é necessario uma vez

  - docker login -u rotadomosquito

- Realiza o push da imagem para o dockerhub

  - docker push rotadomosquito/backend

- Para reiniciar o docker compose atualizado, pode ser necessario deletar a imagem antiga para atualiza com a nova, para isso basta o comando

  - docker rmi rotadomosquito/backend:latest

- Para iniciar o docker compose

  - docker-compose -d up

- Para deletar os containers

  - docker-compose rm

----------------------------------------------------------------

Postman Collections:
https://gist.github.com/RotaDoMosquito/db9ad96a99c44a591627aad2b51eb79e

