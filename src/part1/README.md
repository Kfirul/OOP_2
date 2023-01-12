### OOP Assignment 2 
## Part 1
Ex2 in OOP Course. The project were writen by:

* Kfir Zilbernagel
* Roy Ofer
* Tomer Gozlan

# Summary of the project
In this project we will be focusing on comparing the efficiency of creating files and writing into them using three different methods: using threads, using a thread pool, and not using threads at all.
The project will measure the performance of each method and compare the results to determine which method is the most efficient for file creation.

# Thread
A thread is a lightweight, independent unit of execution that can run simultaneously with other threads within a process. 
Threads are used to divide a large, complex task into smaller, more manageable chunks that can be executed in parallel.
This can greatly improve the performance of a program, especially on systems with multiple processors or cores.

# Threadpool
A thread pool is a collection of worker threads that are pre-instantiated and kept in a pool, ready to be used. When a task is submitted to the pool, a worker thread is taken from the pool and assigned to the task. Once the task is complete, the worker thread is returned to the pool.
Using a thread pool can be more efficient than creating and destroying threads for each task, as it eliminates the overhead of creating and destroying threads.


In summary, Threads are individual unit of execution that can run in parallel. Thread pool is a set of pre-instantiated threads that can be reused for multiple tasks.

# UML of the classes
![image](https://user-images.githubusercontent.com/99495429/212017464-0f6a205b-a5fb-40ce-b4db-9e0ce6e6d4a4.png)

# Results of creating 1000 files
![image](https://user-images.githubusercontent.com/99495429/212017659-7acc55f6-231e-4651-b851-087635691f75.png)

# Conclusion
Using a thread pool to create files can be faster than using threads for several reasons:

Thread creation overhead: Creating a new thread for each file to be created can be time-consuming, as the operating system must allocate resources for the new thread. With a thread pool, the threads have already been created, so there is no overhead associated with creating new threads.

Thread synchronization: When using threads, it's often necessary to synchronize access to shared resources to prevent race conditions. This can add additional overhead to the process. With a thread pool, the threads are already synchronized, so there is no additional overhead.

Thread management: Managing multiple threads can be difficult, as the programmer must ensure that all threads are properly started, stopped, and joined. With a thread pool, the management of threads is handled automatically.

Thread pool can better utilize system resources: Thread pool can distribute the tasks to the threads efficiently so that all the cores of the processor can be used to the fullest. This way, it can maximize the usage of the system resources.

In summary, using a thread pool can be faster than using threads because it eliminates the overhead of creating and destroying threads, reduces the need for thread synchronization, and simplifies thread management. Additionally, thread pool can better utilize the system resources.

# How to use it
In order to run the project just clone the repository:
git clone https://github.com/Kfirul/OOP_2.git

Have fun :)
