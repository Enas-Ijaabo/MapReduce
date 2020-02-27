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
In this project, The task is to build a MapReduce framework using plain Java.

# Porject Description:
In this project, MapReduce framework is built using plain Java.  docker swarm as
orchestration tool.Input: input text file, mapper function, reducer function, the number of mapper nodes and the number of reducer nodes.

Output: output text file, performance statistics file.
