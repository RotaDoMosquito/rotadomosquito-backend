FROM adoptopenjdk/openjdk14

EXPOSE 8080

ADD target/rotamosquito-0.0.1-SNAPSHOT.jar rotamosquito.jar

ENTRYPOINT ["java", "-Duser.language=pt", "-Duser.country=BR", "-Duser.timezone=America/Sao_Paulo", "-jar", "rotamosquito.jar"]
