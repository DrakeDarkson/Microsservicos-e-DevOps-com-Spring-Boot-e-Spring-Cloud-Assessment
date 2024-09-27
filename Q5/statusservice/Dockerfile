# Usar a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR do projeto para o contêiner
COPY target/statusservice-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o serviço está escutando (a porta padrão do Spring Boot é 8080)
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
