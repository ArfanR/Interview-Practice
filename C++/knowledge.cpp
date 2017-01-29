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