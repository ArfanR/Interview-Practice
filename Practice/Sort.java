class Sort {

    // merge two sorted arrays
    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;

        while (indexB >= 0) {
            if (indexA >= 0 ** a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            }
            else {
                a[indexMerged] = a[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // sort array so that anagrams are next to each other
    public static void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<String, String>();

        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    // binary search in sorted rotated array
    public static int search(int a[], int left, int right, int x) {
        int mid = (left+right)/2;
        if (x == mid) {
            return mid;
        }
        if (right < left) {
            return -1;
        }

        if (a[left] < a[mid]) {
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid-1, x);
            }
            else {
                return search(a ,mid+1, right, x);
            }
        }
        else if (a[mid] < a[left]) {
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid+1, right, x);
            }
            else {
                return search(a, left, mid-1, x);
            }
        }
        else if (a[left] == a[mid]) {
            if (a[mid] != alright]) {
                return search(a, mid + 1, right, x);
            }
            else {
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                }
                else {
                    return result;
                }
            }
        }
        return -1;
    }


