### OOP Assignment 2 
## Part 2
Ex2 in OOP Course. The project were writen by:

* Kfir Zilbernagel
* Roy Ofer
* Tomer Gozlan

# Summary of the project
The goal of the task is to create a new type that represents an asynchronous task with priorities and a new type of ThreadPool that supports prioritized tasks. First, the task will generally describe the two classes and then list the requirements in a detailed manner:

The Task class represents an action that can be run asynchronously and can return a value (i.e. a return type is defined). There is no requirement that the action must succeed, and in case of failure, an exception will be thrown.

The CustomExecutor class represents a new type of ThreadPool that supports prioritized tasks (each task is of type Task). CustomExecutor creates tasks before they are placed in the queue by passing a Callable<V> and an enum of type TaskType. CustomExecutor will execute tasks according to their priorities.

We used two diffrent design patterns: Adapter and Factory.
 
 # Factory
The Factory Design Pattern is a creational design pattern that provides a way to create objects without specifying the exact class of object that will be created.
The Factory pattern allows a class to delegate the responsibility of instantiating an object to its subclasses. 
This allows a class to create objects without knowing their class, and allows subclasses to alter the class of objects that will be created.
 
The Factory pattern consists of a factory class and one or more product classes. The factory class defines a method for creating objects, which is typically called "create" or "factory method". The product classes are the classes that will be instantiated by the factory method.
  
# Adapter
  The Adapter Design Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. The Adapter pattern converts the interface of a class into another interface that the client expects. This allows classes that could not otherwise work together due to incompatible interfaces to work together.

The Adapter pattern consists of a target interface (the interface that the client expects), an adapter class (the class that adapts the adaptee class to the target interface), and an adaptee class (the class that needs to be adapted to the target interface).

The Adapter class implements the target interface and holds an instance of the adaptee class. The client calls methods on the Adapter, which in turn calls the corresponding methods on the adaptee.
  
 # UML of the classes
  ![image](https://user-images.githubusercontent.com/99495429/212020267-e813737e-4868-4d18-b5a7-95ee5bc3dd45.png)
  
  # How to use it
In order to run the project just clone the repository:
git clone https://github.com/Kfirul/OOP_2.git

Have fun :)
