/*
Private Constructor
Declaring a constructor private on class A means that you can only access the (private) constructor if you could also
access A's private methods. Who, other than A, can access A's private methods and constructor? A's inner classes can.
Additionally, if A is an inner class of Q, then Q's other inner classes can. This has direct implications for inheritance,
since a subclass calls its parent's constructor. The class A can be inherited, but only by its own or its parent's inner
classes.

Finally
Yes, it will get executed. The finally block gets executed when the try block exits. Even when we attempt to exit within
the try block (via a return statement,a continue statement, a break statement or any exception), the finaly block will
still be executed. Note that there are some cases in which the fin a lly block will not get executed, such as the
following:
    • If the virtual machine exits during try/catch block execution.
    • If the thread which is executing during the try/catch block gets killed.

Final vs Finally vs Finalize
To speak in very general terms, final is used to control whether a variable, method, or class is "changeable.
The finally keyword is used in a try/catch block to ensure that a segment of code is always executed.
The finalize() method is called by the garbage collector once it determines that no more references exist.

Generics vs Templates
The implementation of Java generics is rooted in an idea of "type erasure:' This technique eliminates the parameterized
types when source code is translated to the Java Virtual Machine (JVM) byte code. For this reason, Java generics are sometimes
called "syntactic sugar". This is quite different from C++. In C++, templates are essentially a glorified macro set, with
the compiler creating a new copy of the template code for each type. Proof of this is in the fact that an instance of
MyClass<Foo> will not share a static variable with MyClass<Bar>. Two instances ofMyClass<Foo>, however, will share a
static variable.

More Differences:
    - C++ templates can use primitive types, like int, but Java must use Interger.
    - In Java, you can restrict the template's type parameters to be of a certain type. For instance, you might use generics
      to implement a CardDeck and specify that the type parameter must extend from CardGame.
    - In C++, the type parameter can be instantiated, whereas Java does not support this.
    - In Java, the type parameter (Le., the Foo in MyClass<Foo» cannot be used for static methods and variables, since
      these would be shared between MyClass<Foo> and MyClass<Bar>.ln C++, these classes are different, so the type parameter
      can be used for static methods and variables.
    - In Java, all instances of MyClass, regardless of their type parameters, are the same type. The type parameters are
      erased at runtime. In C++, instances with different type parameters are different types.


*/