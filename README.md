# Estudos sobre performance

Esta solução é um playground para demonstrar operações computacionais simples como cálculos, escrita em arquivo, escrita em banco, acesso a APIs REST (chamadas interprocessos). O objetivo é demonstrar os tempos de processamento destas operações simples que diferem bastante entre si e que são perceptiveis quando processamos centenas de milhares de registros.

## Configuração
A solução é composta por três partes:

   - Perf-demo : aplicação que executa as operações de teste e coleta as métricas
   - Perf-web-rest-api : aplicação Web que expõe um serviço de cálculo de sequência de Fibonacci. Utilizada para testar a chamada a API externa.
   - DB MySQL: banco de dados MySQL rodando em Docker, utilizado para testar a escrita em banco de dados.

### Configuração de banco de dados
  O banco de dados é um MySQL rodando em Docker. Uma imagem já foi preparada com o banco e schema adequado para os testes. Para criar a imagem execute os seguintes comandos:

   1. <performance-studies>/cmd/01_docker_createdb_image.sh
   2. <performance-studies>/cmd/02_docker_createdb.sh

   O primeiro comando cria a imagem Docker com o banco e o segundo comando cria o container com o banco.

## Execução

### Verifique o DB está no ar
  Execute

   ```bash
    docker ps
   ```
  e verifique o container local-mysql está sendo execudado. Exemplo de resultado


   ```bash
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                               NAMES
ef804a8c527c        mysql-perfdb        "docker-entrypoint.s…"   3 days ago          Up 10 seconds       33060/tcp, 0.0.0.0:9501->3306/tcp   local-mysql
   ```
Caso não esteja funcionando execute `docker start local-mysql` para iniciar o container do DB criado anteriormente. Caso o DB ainda não esteja no ar verifique que executou o passo "Configuração de banco de dados" acima. 

### Inicie o serviço Web
O serviço é uma aplicação Web Spring Boot que pode ser iniciado com o comando
  
  `<performance-studies>/cmd/10_start_webapi.sh`

ou chamando o java diretamente : `java -jar <performance-studies>/perf-web-rest-api/target/perf-web-rest-api-<versao>.jar

### Execute os testes

Os testes são executados pela aplicação perf-demo. O número de execuções pode ser informado além do tipo de teste a ser executado. Mais de um teste pode ser executado por vez.

Formato de chamada:

```bash
  java -jar perf-demo-<versao>.jar  --n=<número de execuções> --test=<nome do primeiro teste> --test=<nome do segundo teste> ... --test=<nome do ultimo teste> 

```
Onde 
  --n : deve ser um número inteiro que indica o número de execuções do teste
  --test: contém um nome válido de operação de teste
  --webapiurl: OPCIONAL informa a url do serviço perf-web-rest-api; caso não informado utiliza o endereço padrão http://localhos:9510/fibonacci/

Operações de teste válidas:

  - OnlyCPU : executa o cálculo de digito verificador de raiz de CNPJ. Esta é uma operação que somente utiliza CPU sem nenhum uso de I/O
  - FileWrite : escreve um registro delimitado no tamanho de 192 bytes cada
  - DBWrite : escreve o mesmo registro acima mas numa tabela de banco de dados MySQL que contém somente a PK
  - DBWrite10Indx : escreve o mesmo registro acima numa tabela de banco de dados identica à acima mas que além da PK possui 10 indices
  - WebApiCall : faz uma chamada a API Web (perf-web-rest-api) passando um inteiro e recebendo a sequência Fibonacci como resposta
  - FindInList : faz uma busca sequencial numa lista com 100k registros
  - FindInHash : faz uma busca num HashMap com 100k registros


Exemplo de uso:

```bash
  java -jar perf-demo-<versao>.jar  --n=50000 --test=OnlyCPU --test=FileWrite --test=DBWrite --test=WebApiCall 

# chamada passando um outro endereço para o serviço Web API

java -jar perf-demo-<versao>.jar  --n=50000 --test=OnlyCPU --test=FileWrite --test=DBWrite --test=WebApiCall  --webapiurl=http://172.10.4.55:8080/fibonacci/
```