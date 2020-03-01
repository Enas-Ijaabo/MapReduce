# Table of Contents
1. [Introduction of MapReduce Framework](#general-introduction-of-mapreduce-framework)
 

# General Introduction of MapReduce Framework
MapReduce is a software framework that is used for processing large data sets in a distributed fashion over sevel machines (i.e., nodes).
The core idea behind MapReduce is mapping your data set into a collection of <key, value> pairs, and then reducing over all pairs with 
the same key.  
-Input: in this project, we will always assume the input is a text file.

-Splitting phase: the text in the input file is splitted equally into segments and each segment is passed to a dffierent node.

-Mapping phase: each node runs the mapping function (which is given by the user) to convert text segments into <key,value> pairs.

-Shuffling phase: node exchange <key,value> pairs such that the pairs with the same keys are grouped in the same node.

-Reducing phase: each node runs the reduce function (which is also given by the user), which takes a collection of <key,value> pairs and "reduce" them into a smaller set of <key,value> pairs.

-Output: nodes write their final results to one output file (which we will also assume to be a text file). 

Typically, available implementations of MapRedcue frameworks automate the entire workflow. Users only need to specify the input text file, the mapper function and the output function.


# Porject Description:
In this project, The framework has three programs that are distributed on different nodes (machines):

-The first program is the mainNode; it is the main program which starts the framework, read the inputs, and controls the rest of the nodes. The mainNode program should have one global replica, and should be created on a manger/master machine in the swarm. 
The main node has a GUI built using JavaFX. 

MainNode Input: input text file, mapper function, reducer function, the number of mapper nodes and the number of reducer nodes.

MainNode Output: output text file.

-The second program is the mapperNode program. Which is the program that that handles running a mapping function on a split of the text file. The number of mapper nodes is defined by the users as mentioned previously. The processes of creating the mapperNode replicas, sending information to them, receiving information from them, and destroying them are fully automated and controlled by the MainNode. And the orchestration of the replicas is handled by docker swarm.

MapperNode Input: text file split, mapper function.

MapperNode Output: Map of the keys and values.
	
-The Third program is the reducerNode program. Which is the program that that handles running the reducing function on mappers outputs. The number of reducer nodes is defined by the users as mentioned previously. The processes of creating the reducerNode replicas, sending information to them, receiving information from them, and destroying them are fully automated and controlled by the MainNode. And the orchestration of the replicas is handled by docker swarm.

reducerNode Input: Map of the keys and values, reducer function.

reducerNode Output:  reduced Map of the keys and values.

