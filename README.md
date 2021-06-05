# DS bootcamp - challenge CRUD



## Introduction

<p> This repository is the resolution of a challenge suggested by 'Dev Superior' .</p>

<p>The project consists of several steps utilizing CRUD with validations, exceptions, status, etc...</p>


<p> The Bootcamp promoted by <a href="https://devsuperior.com.br/"> DevSuperior <a/> which aims to
help students and programming professionals to enter or re-enter their careers.</p>

<p> Challenge steps: </p>

<ul>
  <li>* [x] Entity</li>
  <li>* [x] Repository</li>
  <li>* [x] Service</li>
  <li>* [x] Resource </li>
  <li>* [x] H2 Database </li>
  <li>* [x] Database File </li>
  <li>* [x] DTO</li>
  <li>* [ ] Resource Exception</li>
  <li>* [ ] Service Exception</li>
  <li>* [ ] Pagination</li>
  <li>* [ ] CRUD</li>
</ul>



## Technical knowledge

<ul>
	<li><a href="https://youtu.be/xC_yKw3MYX4">OO and SQL</a></li>
	<li><a href="https://youtu.be/os6hdZbCnpM">Jpa Repository</a></li>
	<li><a href="https://youtu.be/OX5MmJrFTdw">Domain Model</a></li>
</ul>

## Tools list

<ul>
	<li>Backend - Optional IDEs to Java 
		<ul>
			<li>Spring Tool Suite (STS)</li>
			<li>Eclipse</li>
			<li>intellij</li>
		</ul>	
	</li>
</ul>




# Layers Pattern

<a href="https://imgbox.com/PAUEeYER" target="_blank"><img src="https://images2.imgbox.com/45/77/PAUEeYER_o.png" alt="image host"/></a>



<p>
Front end: application that the client uses on his device, that is,
is accessible on the client side.
</p>
<p>
Back end: is the part of the system that is running on the server.


<p>
The user using the Front end is exchanging interactions and / or
data with Back end. This data exchange can be done in several ways
forms, but in this case, in the context of the web, requests are being used
<a href="https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol"> HTTP <a/> (Hypertext Transfer Protocol)
</p>

<p>
Analyzing the internal part of the Back end we have logical layers, each partition
has a purpose and is divided into 3 main layers:
</p>



<ul>
	<li> Rest Controllers
		<ul>
			<li> You will receive requests from the Front end to the Back end </li>
			<li> Forwards the customer's actions to the Service Layer </li>
		</ul>
	</li>
	<li> Service Layer
		<ul>
			<li> Has the system / business logic </li>
			<li> Responsible for checks, calculations, orchestration of various operations </li>
		</ul>
	</li>
	<li> Data Access Layer
		<ul>
			<li> Basic data access operations in the database (CRUD) </li>
		</ul>
	</li>
		</ul>

<p>
This system organization is important to make the system flexible and easy to maintain.
</p>


<p>
Analogy to show the difference between the Service Layer and Data Access Layer layers:

</p>

<p>
Imagine that you will need to save an order on an e-commerce system. To save the
order it is necessary to trigger / call a function from the database. However, before saving this
order it is necessary to do a lot of checks, in which the Service Layer layer will be
responsible:
</p>

<ul>
  <li> Check if the stock is up to date </li>
  <li> Write off inventory </li>
<li> If the inventory policy allows you to sell without having the product </li>
<li> Write off inventory </li>
<li> Send e-mail to the customer, notifying the customer about the order </li>
</ul>

<p>
The operations that go directly into the database and do something, is that
will be in the Data Access Layer (CRUD) layer. But the whole orchestration, the order
when things have to happen, it will be on Service Layer.
</p>

<p>
Data Transfer Objects (DTO): are simple objects to load / traffic data between Rest Controllers
and Service Layer. But when you enter the Service Layer and need to make transactions with the data
then Entities will be instated. The concept of Entities in this scenario, is that Entities will play the role
of objects that will be monitored, controlled ... to maintain the integrity of the database.
So the moment you access the Service Layer and the orchestrations / operations start to occur ...
Entities will be instantiated, saved, deleted, updated, etc ... Using the
Data Access Layer ... but all of these operations are being monitored to maintain integrity
of the data.

</p>

## Database code

```
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('José de Souza','555.555.458-21',400,NOW()-20*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Felipe Lima','458.555.458-65',400,NOW()-35*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Luana Pereira','287.333.458-12',400,NOW()-18*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Carol Castro','728.555.845-39',400,NOW()-25*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Joaquim dos Santo','228.555.152-70',400,NOW()-30*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Fernanda Aguiar','448.335.583-11',400,NOW()-27*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Carlos Drummond','628.555.127-44',400,NOW()-22*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Tereza Flores','828.255.558-91',400,NOW()-44*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Cassandra Ferreira','228.559.154-33',400,NOW()-26*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Bruno Lira','528.255.958-29',400,NOW()-35*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('André de Souza','428.505.452-28',400,NOW()-20*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Emerson Lima','842.515.454-35',400,NOW()-34*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Clara Pereira','481.334.351-42',400,NOW()-48*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Aline Castro','225.255.645-19',400,NOW()-23*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Bernardo dos Santo','728.255.151-60',400,NOW()-50*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Felipa Aguiar','548.235.183-41',400,NOW()-47*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Caio Drummond','928.725.227-34',400,NOW()-26*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Vanessa Flores','328.255.158-31',400,NOW()-45*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Suelen Ferreira','428.259.254-33',400,NOW()-23*365, 1, NOW());
INSERT INTO tb_client (name, cpf, income, birth_date, children, created_At) VALUES('Leon Lira','328.455.458-89',400,NOW()-32*365, 1, NOW());
```

## Source

<ul>
  <li><a href="https://devsuperior.com.br/">DevSuperior</a></li>
</ul>

