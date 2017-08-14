class Merge {

    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
    }

    public static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low+high)/ 2;
            mergeSort(array, helper, low, mid); // sort left half
            mergeSort(array, helper, mid+1, high); // sort right half
            merge(array, helper, low, mid, high); // merge both halves (single elements)
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        // copy both halves
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        // keep track of start of both halves
        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;
        // merge both halves
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] < helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        // copy the rest of the left side into the array
        int remaining = middle-helperLeft;
        for (int i = 0; i < remaining; i++) {
            array[current+i] = helper[helperLeft+i];
        }

    }
}
