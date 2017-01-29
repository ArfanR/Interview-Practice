    void printLastKLines(char* fileName) {
        const int K = 10;
        ifstream file(fileName);
        string L[K];
        int size = 0;

        /* read file line by line into circular array */
        /* peek() so EOF following a line ending is not considered a separate line */
        while (file.peek() != EOF) {
            getline(file, L[size % K]);
            size++;
        }

        /* compute start of circular array and the size of it */
        int start = size > K ? (size % K): 0;
        int count = min(K, size);

        /* print elements in order */
        for (int i = 0; i < count; i++) {
            cout << L[(start+i) % K] << endl;
        }
    }

    void reverse(char* str) {
        int end = 0;

        while (*(str)) {
            end++;
        }

        for (int i = 0; i < end; i++) {
            char tmp = str[end-i-1];
            str[end-i-1] = str[i];
            str[i] = tmp;
        }
    }

/*
Hash Table vs STL Map
In a hash table a value is stored by calling a hash function on a key. Values are not stored in sorted order. Additionally,
since hash tables use the key to find the index that will store the value, an insert or lookup can be done in amortized
0(1) time (assuming few collisions in the hash table). In a hash table, one must also handle potential collisions. This is
often done by chaining, which means to create a linked list of all the values whose keys map to a particular
index. On the other hand, an STL map inserts the key/value pairs into a binary search tree based on the keys. There is no
need to handle collisions, and, since the tree is balanced,the insert and lookup time is guaranteed to be 0(log N).
If the number of inputs is small, then the STL map is best to use.

Virtual Function
A virtual function depends on a "vtable" or "Virtual Table:' If any function of a class is declared to be virtual, a
vtable is constructed which stores addresses of the virtual functions of this class. The compiler also adds a hidden vptr
variableinallsuchclasseswhichpointstothevtableofthatclass.Ifavirtualfunctionisnot overridden in the derived class, the
vtable of the derived class stores the address of the function in its parent class. The vtable is used to resolve the
address of the function when the virtual function is called. Dynamic binding in C++ is performed through the vtable
mechanism. Thus, when we assign the derived class object to the base class pointer, the vptr variable points to the
vtable of the derived class. This assignment ensures that the most derived virtual function gets called.

*/











