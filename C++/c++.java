public class Knowledge {

    public static void printLastKLines(char* fileName) {
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

    }

}