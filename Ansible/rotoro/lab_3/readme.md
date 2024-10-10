# Lab 3: Playbooks
## Task 1
Установи название (параметр name) в play в значение Execute a date command on localhost
## Task 2
Измени task так, чтобы в нем выполнялась команда cat /etc/hosts и измени его название (name) на Execute a command to display hosts file
## Task 3
Добавь в playbook еще один task. Этот новый task должен выполнять команду cat /etc/hosts и его название должно быть Execute a command to display hosts file
## Task 4
Мы запустили и проверили все эти tasks на localhost. Теперь мы хотим запустить их в боевой среде на хосте web_node1. Обнови этот play, чтобы запуск был на узле web_node1.
## Task 5
Изучи прикрепленный inventory-файл. Нам требуется запустить tasks определенные в play на серверах, которые территориально находятся в boston. Отрази эти сервера в playbook.


Вкладка на inventory-файл находится вверху справа
## Task 6
Создай новый play с названием Execute a command to display hosts file contents on web_node2, который выполнит команду cat /etc/hosts на ноде web_node2, a название task должно быть Execute a command to display hosts file.
## Task 7
Мы получили задание на перезапуск нескольких серверов в определенной последовательности. Последовательность и команды для исполнения приведены ниже. Обрати внимание, что эти команды нужно запустить только на подходящих для этого серверах. Изучи inventory-файл и обнови playbook, чтобы последовательность была правильной.

ИНФО: Используй приведенное ниже описание для plays и tasks.

1. Останови web-службы на веб-серверах - service httpd stop
2. Останови db-службы на серверах баз данных - service mysql stop
3. Перегрузи все сервера (web и db) за один раз - /sbin/shutdown -r
4. Запусти db-службы на узлах баз данных - service mysql start
5. Запусти web-службы на узлах веб-серверов - service httpd start

Внимание: Не используй этот playbook в реальной установке. Есть лучшие варианты реализации этих действий. Мы делаем это для закрепления основных навыков понимания playbooks.