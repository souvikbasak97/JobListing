FROM openjdk:17
ADD ./docker-joblisting-spring-boot.jar docker-joblisting-spring-boot.jar
ENTRYPOINT ["java","-jar","docker-joblisting-spring-boot.jar"]