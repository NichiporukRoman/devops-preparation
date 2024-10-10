# Docker

## Dockerfile comands
FROM - образ на базе которого создается новый образ контейнера

RUN - запустить команду на указанном образе

COPY file /dir/file - скопировать файл file в образ в каталог /dir/file

ENTRYPOINT - процесс запускаемый в контейнере

## Docker comands
Скачать image из docker repository:
```
docker pull
```
Увидеть все image:
```
docker images
```
Увидеть все контейнеры:
```
docker ps
```
Запустить контейнер:
```
docker run 
```
Сделать переброс портов с порта docker hosts в порт localhost:
```
docker -p <порт в localhost>:<порт в docker hosts> run 
```
Изучить контейнер:
```
docker inspect 
```
Изучить контейнер:
```
docker inspect 
```
Получить логи контейнера:
```
docker logs 
```
Присвоить переменные среды:
```
docker -e <название>=<значение> run
```
Указать максимальный процент использования CPU:
```
docker --cpus=.5 <название>=<значение> run
```
Указать максимальный процент использования памяти:
```
docker --memory=100m run
```
Увеличь количество реплик rocketcounter до 2:
``` 
docker-compose up -d --scale rocketcounter=2
```