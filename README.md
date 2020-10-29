# Java plugin architecture

A non-reflection java plugin architecture where performance is important and no libraries used. 
This is a prototype project to prove a concept to be used in other projects.

## Motivation

Usually I would implement a plugin architecture using reflection.
Reflection is very slow to find classes. 
It is not so noticeable on large projects with heavy startup times.
It is noticeable in smaller projects where JVM bootstrapping is slower than the program execution.

Direct lookups will always be faster.

## Goals

- Fast
- No dependencies
- Simple to understand, not bloated with features
- Runtime jar loading (as to not require cli input)

The overall goal is to have the ability to drop plugin jars into a directory. 
The plugins will be loaded at runtime and provide additional functionality without direct references.
The addition and removal of jars will determine the features the main program has.
