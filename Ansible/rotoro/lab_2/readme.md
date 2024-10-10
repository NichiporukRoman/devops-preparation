# Lab 2: Inventory
## Location
- default: /etc/ansible/hosts
- by yourself: -i <path> option or in configuration using inventory

## Task 1
У нас есть одинаковые записи в inventory файле для 3 серверов в списке. Добавь четвертый сервер с именем server4.domain.com

## Task 2
Мы добавили алиас web1, web2 и web3 для первых трех серверов. Обнови server4, чтобы у него был алиас db1

## Task 3
Наши вебсерверы на Linux, но сервер базы данных на Windows. Добавь дополнительные параметры в каждую строку, чтобы были ansible_connection, ansible_user и password. Используй приведенную ниже таблицу учетных данных с информацией о доступе.


| Alias	| Host	| Connection	| User	| Password |
| ---|--- | ---|--- | ---|  
| web1	| server1.domain.com	| SSH| 	root	| Password123!| 
web2| 	server2.domain.com| 	SSH	| root	| Password123!| 
web3| 	server3.domain.com| 	SSH| 	root| 	Password123!| 
db1| 	server4.domain.com| 	| Windows	administrator| 	Password123!| 

ИНФО: Для Linux используй ansible_ssh_pass, а для Windows используй ansible_password. Коннектор для Windows winrm

## Task 4
Мы создали группу вебсерверов. Таким же образом создай группу для серверов баз данных с названием db_servers и добавь туда сервер db1.

## Task 5
Давай создадим группу, содержащую группы. Создай группу с названием all_servers и добавь в нее ранее созданные группы web_servers и db_servers.

```
ИНФО: Syntax:
[parent_group:children]
child_group1
child_group2
```
## Task 6
Попробуй представить приведенные ниже в таблице данные в формате Ansible Inventory
|Server Alias|Server Name|OS|User|Password|
|---|---|---|---|---| 
|sql_db1|sql01.xyz.com|Linux|root|Lin$Pass|
|sql_db2|sql02.xyz.com|Linux|root|Lin$Pass|
|web_node1|web01.xyz.com|Win|administrator|Win$Pass|
|web_node2|web02.xyz.com|Win|administrator|Win$Pass|
|web_node3|web03.xyz.com|Win|administrator|Win$Pass|

Сгруппируй серверы на основе этой таблицы:
|Group|Members|
|---|---|
|db_nodes|sql_db1, sql_db2|
|web_nodes|web_node1, web_node2, web_node3|
|boston_nodes|sql_db1, web_node1|
|dallas_nodes|sql_db2, web_node2, web_node3|
|us_nodes|boston_nodes, dallas_nodes|