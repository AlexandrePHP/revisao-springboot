# revisao-springboot

Este é um projeto de revisão do framework Java SpringBoot.
Contém o básico de SpringBoot necessário para não morrer de fome com este framework, rs.
É um webservice REST com um CRUD básico que se comunica com um banco de dados local Postgres e gera um arquivo de log.

Considerações:
- Modificar dados de conexão no arquivo aplication.properties com os dados do seu banco. Note que o nome do banco é passado na url do datasource.
- Descomentar a linha #spring.jpa.hibernate.ddl-auto=create-drop e rodar inicialmente para o Spring criar a tabela e a sequence, depois comentar de novo se não quiser que fique dropando a tabela e os dados cada vez que iniciar a aplicação.

