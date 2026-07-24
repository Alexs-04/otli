package com.korebit.model;

/**
 * In this example, we will see how to use the sealed classes in Java. A sealed class is a class that can only be extended by a specific set of classes.
 * This is useful when we want to restrict the inheritance of a class to a specific set of classes.
 */
public abstract sealed class Animal permits Dog, Cat {
}
