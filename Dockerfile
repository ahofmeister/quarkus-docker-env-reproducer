FROM openjdk:8u212-b04-jdk
ENV DEPLOY_DIR /opt
ENV INSTALL_DIR ${DEPLOY_DIR}/lib
COPY target/lib ${INSTALL_DIR}
COPY target/quarkus-runner.jar ${DEPLOY_DIR}
ENTRYPOINT java -jar ${DEPLOY_DIR}/quarkus-runner.jar
EXPOSE 8080