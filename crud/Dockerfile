# Corretto is a no-cost, production-ready distribution of
# the Open Java Development Kit (OpenJDK).
# En muchos tutoriales usan openjdk, pero la documentación
# oficial dice que está deprecado. Esta es la primera sugerencia.
FROM amazoncorretto

ADD target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]