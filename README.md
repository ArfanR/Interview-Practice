# Interview_Practice
Practice interviewing problems with data structures and algorithms.

Strings

1. Is Unique: Implement an algorithm to determine if a string has all unique characters.
2. Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
3. URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
4. Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
5. One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
6. String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed"string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

Linked Lists

1. Remove Dups: Write code to remove duplicates from an unsorted linked list.
2. Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
3. Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
4. Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need to be after the elements less than x (see below).The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
5. Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
6. Palindrome: Implement a function to check if a linked list is a palindrome.

C++

1. Last K Lines: Write a method to print the last K lines of an input file using C++.
2. Reverse String: Implement a function void reverse ( char* str) in C or C++ which reverses a null-terminated string.
3. Hash Table vs. STL Map: Compare and contrast a hash table and an STL map. How is a hash table implemented? If the number of inputs is small, which data structure options can be used instead of a hash table?
4. Virtual Functions: How do virtual functions work in C++?
5. Shallow vs. Deep Copy: What is the difference between deep copy and shallow copy? Explain how you would use each.
6. Volatile: What is the significance of the keyword "volatile" in C?
7. Virtual Base Class: Why does a destructor in base class need to be declared virtual?
8. Copy Node: Write a method that takes a pointer to a Node structure as a parameter and returns a complete copy of the passed in data structure. The Node data structure contains two pointers to other Nodes.
9. Smart Pointer: Write a smart pointer class. A smart pointer is a data type, usually implemented with templates, that simulates a pointer while also providing automatic garbage collection. It automatically counts the number of references to a SmartPointer<T* >object and frees the object of type T when the reference count hits zero.
10. Malloc: Write an aligned malloc and free function that supports allocating memory such that the memory address returned is divisible by a specific power of two.
11. Alloc: Write a function in C called my2DAlloc which allocates a two-dimensional array. Minimize the number of calls to malloc and make sure that the memory is accessible by the notation arr[i][j].
