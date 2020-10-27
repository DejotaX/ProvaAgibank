# provaAgibank

	Este projeto é um processador de dados, que realiza leituras periódicas de arquivos com a extensão .dat presentes
	em um determinado diretório, filtrando as informações e produzindo um relatório com os resultados.
	Ele está codificado na linguagem Java, utilizando o Spring Boot framework.

# Getting Started

	Para executar o projeto, você precisará dos seguintes programas e configurações:

	   - Apache Maven 3.6.3: Utilzado para fazer o build do projeto Java.
	   
	   - Java jdk 11.0.8: Necessário para executar o projeto e o Jar que é gerado.
          
	   - IntelliJ IDEA 2020.2.1: Necessário para o desenvolvimento do projeto e para executar os testes unitários. 

	   - Definir a variável de ambiente HOMEPATH dentro de C:\Users\ - Recomendado por questões de permissões.
	   
	   - O(s) arquivo(s) .dat devem estar presentes dentro da pasta de leitura.

# Developing

	- git clone git@github.com:DejotaX/provaAgibank.git
	- cd provaAgibank/

# Build

	- Não é necessário fazer o build do projeto, ele pode ser executado diretamente pelo Jar dentro da pasta.

# Deploying 
 
 	O projeto pode ser executado de diversas maneiras, porém irei citar apenas 3:
 
 		- Entrar na pasta do projeto e executar o "app.bat" que irá automaticamente executar o Jar do projeto.
 
 		- Entrar na pasta do projeto e abrir um prompt de comando. Dentro dele basta digitar o comando: 
 		  "java -cp application.jar com.prova.agibank.ProvaAgibankDeorgenes.Application"
 
		- É possível executar o projeto a partir da IDE do IntelliJ, onde também podem ser rodados os testes unitários do código.
 
# Features

	Este projeto executa, em uma taxa de 10 segundos, a leitura de todos os arquivos com a extensão ".bat" que estejam presentes 
	dentro do diretório "HOMPATH\data\in", gerando um relatório no diretório "HOMEPATH\data\out" com os dados da quantidade de 
	clientes, vendedores, o id da venda mais cara e o nome do pior vendedor.
	
	Os dados de entrada estão no seguinte formato:
	
	- Vendedor -> 001çCPFçNameçSalary
	- Cliente  -> 002çCNPJçNameçBusiness Area
	- Venda    -> 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
	
	Devido ao formato dos dados de entrada, foi implementado um filtro para extrair a informação linha a linha, para que ela pudesse ser 
	analisada e posteriormente gerar o relatório.


# Configuration

	- Neste projeto é possível configurar a taxa de leitura dos arquivos. Basta alterar o valor do parâmetro 
	  "TAXA_LEITURA_mSEGUNDO" em Util\ConstantsUtil.java.
	
	- Atualmente o valor está configurado para 10 segundos. 
	
	- Como o @Scheduling do spring é configurado em milissegundos, o valor deverá ser de 10.000 para rodar a cada 10 segundos.
 
# Links

	- Obrigado por ter lido até aqui. Em caso de bugs, entrar em contato pelo e-mail: deorgenes.junior@gmail.com xD

