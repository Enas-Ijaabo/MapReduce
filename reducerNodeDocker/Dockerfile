FROM ubuntu:16.04
RUN  apt-get update


RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk  && \
    apt-get clean


COPY /reducerNode.jar /


COPY /controlfile.sh /
ENTRYPOINT ["/controlfile.sh"]
CMD []

