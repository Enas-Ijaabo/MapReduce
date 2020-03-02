# Table of Contents
1. [General Introduction of MapReduce Framework](#general-introduction-of-mapreduce-framework)
2. [Porject Description](#porject-description)
3. [Technologies](#technologies)

 

# General Introduction of MapReduce Framework
MapReduce is a software framework that is used for processing large data sets in a distributed fashion over sevel machines (i.e., nodes).The core idea behind MapReduce is mapping your data set into a collection of <key, value> pairs, and then reducing over all pairs -with the same key. Typically, available implementations of MapRedcue frameworks automate the entire workflow. Users only need to specify the input text file, the mapper function and the output function.

# Porject Description:

In this project, The framework has three programs that are distributed on different nodes (machines):

-The first program is the mainNode; it is the main program which starts the framework, read the inputs, and controls the rest of the nodes. The mainNode program should have one global container, and should be created on a manger/master machine in the swarm. 
The main node has a GUI that is built using JavaFX. 

MainNode Input: input text file, mapper function, reducer function, the number of mapper nodes and the number of reducer nodes.

MainNode Output: output text file.

**To see the source code of MainNode click [here](https://github.com/Enas-Ij/MapReduce/tree/master/mainNode). To see the dockerFile and shellScript to create the docker image click [here](https://github.com/Enas-Ij/MapReduce/tree/master/mainNodeDocker).**

-The second program is the mapperNode program. Which is the program that that handles running a mapping function on a split of the text file. The number of mapper nodes is defined by the users as mentioned previously. The processes of creating the mapperNode replicas, sending information to them, receiving information from them, and destroying them are fully automated and controlled by the MainNode. And the orchestration of the replicas is handled by docker swarm.

MapperNode Input: text file split, mapper function.

MapperNode Output: map of the keys and values.

**To see the source code of MapperNode click [here](https://github.com/Enas-Ij/MapReduce/tree/master/Mapper). To see the dockerFile and shellScript to create the docker image click [here](https://github.com/Enas-Ij/MapReduce/tree/master/mapperNodeDocker).**

-The Third program is the reducerNode program. Which is the program that that handles running the reducing function on mappers outputs. The number of reducer nodes is defined by the users as mentioned previously. The processes of creating the reducerNode replicas, sending information to them, receiving information from them, and destroying them are fully automated and controlled by the MainNode. And the orchestration of the replicas is handled by docker swarm.

reducerNode Input: map of the keys and values, reducer function.

reducerNode Output: reduced map of the keys and values.

**To see the source code of ReducerNode click [here](https://github.com/Enas-Ij/MapReduce/tree/master/reducerNode). To see the dockerFile and shellScript to create the docker image click [here](https://github.com/Enas-Ij/MapReduce/tree/master/reducerNodeDocker).**

The running container of the mainNode, and all of the mapperNode and reducerNode replicas are connected to an overlay network. The containers and replicas communicate using Java sockets.

# Technologies:
- Java 8
- JavaFX
- Docker 18.09.0
- Docker swarm
- Maven
- ubuntu 

# How To Run The FrameWork

1- install Docker 18.09.0
* *Note: You Do Not need to install anything else, because everything you need (java 8, javafx 8, ubuntu, etc ...) will be automatically installed when you pull the images from DockerHub* *

2- To view GUI on the windows host, we will need Xlunch. To install it, make sure you have [Chocolatey](https://chocolatey.org/) first, then write on the powerShell:
```
choco install vcxsrv
```
Then run Xlaunch from the start menu and follow the initial configuration steps:

- on Display sitting window choose "Multipule windows", and click next.

- on client startup window choose "Start no client", and click next. 

- on Extra setting window make sure that all the boxes are checked, and click next

- save the to one of the following locations:

 %appdata%\Xming
 
 %userprofile%\Desktop
 
 %userprofile%

3- Start a swarm with at least two machines, (if you already have swarm skip this step)

4- on the manager node create the overlay network net1
```
docker network create -d overlay --attachable net1
```
5-As the docker images of the three programs are already uploaded on Dockerhub use the following command to start the framwork:

```
docker docker run --network=net1 -v /manager_host_path:/container_path -p 10000:10000 -e DISPLAY=WINDOWS_HOST_IP:0.0 enij/main_node 
```
- The option v represents the shared volume between the container and the manager node, you can change the it to any desired , location in the manager, and in the container.

- The option e represents the environment variables, the variable DISPLAY should be set to the windows host ip. So that, Xlunch can display the GUI.

6- 
