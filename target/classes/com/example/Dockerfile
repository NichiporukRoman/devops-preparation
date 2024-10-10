FROM ubuntu

RUN apt-get update && apt-get install -y openjdk-17-jdk git
RUN apt-get install -y docker-ce docker-ce-cli containerd.io

WORKDIR /src/main/java/com/example

RUN javac Calculator.java

