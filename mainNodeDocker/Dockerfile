FROM ubuntu:16.04
RUN  apt-get update


RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk  && \
    apt-get clean

RUN  apt-get update && apt-get install -y openssh-client
RUN  apt-get update && apt-get install -y sshpass

RUN apt-get update && \
    apt-get install -y openjdk-8-jdk openjfx


COPY /mainNode.jar /

RUN  mkdir /inputDir
ADD . /inputDir

COPY /controlfile.sh /
ENTRYPOINT ["/controlfile.sh"]
CMD []

