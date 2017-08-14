class QuickSort {

    public static void quickSort(int[] array, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index-1) {
            quickSort(arr, left, index-1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    int partition(int[] array, int left, int right) {
        int pivot = array[(left+right)/2];

        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }
}