
// merge two sorted arrays
public static void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    int indexMerged = lastB + lastA - 1;
    // start at end of buffer to avoid shifting elements down
    while (indexB >= 0) {
        if (indexA >= 0 && a[indexA] > b[indexB]) {
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
    // create hash list like bucket sort
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
    // pivot point is at the right of mid
    if (a[left] < a[mid]) {
        // target is in the left range of sorted vals
        if (x >= a[left] && x < a[mid]) {
            return search(a, left, mid-1, x);
        }
        // else target is in the right range
        else {
            return search(a, mid+1, right, x);
        }
    }
    // pivot point is at the left of mid
    else if (a[mid] < a[left]) {
        // search on the right
        if (x > a[mid] && x <= a[right]) {
            return search(a, mid+1, right, x);
        }
        // search on the left
        else {
            return search(a, left, mid-1, x);
        }
    }
    // handle duplicate values
    else if (a[left] == a[mid]) {
        if (a[mid] != alright]) {
            return search(a, mid + 1, right, x);
        }
        // duplicate values on both sides
        else {
            // search left and right: O(n)
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

// sorted search with no size function available
public static search(Listy list, int value) {
    int size = 1;
    // exponential backoff for O(logN) runtime
    while (list.elementAt(size) != -1 && list.elementAt(size) < value) {
        size *= 2;
    }
    return binarySearch(list, value, size/2, size);
}
// modified binary search on listy data structure
public static int binarySearch(Listy list, int value, int low, int high) {
    int mid;
    while (low <= high) {
        mid = (low+high)/2;
        int middle = list.elementAt(mid);
        // if middle is too high, search in left half
        if (value < middle || middle == -1) {
            high = mid-1;
        }
        // search right half
        else if (middle < value) {
            low = mid+1;
        }
        // target is found
        else {
            return mid;
        }
    }
    return -1;
}

// search in a array of strings interspersed with empty string
public static int search(String[] strings, String str) {
    if (strings == null || str == null || str = "") {
        return -1;
    }
    return search(strings, str, 0 , strings.length-1);
}
// helper function for above
public static int search(Strings[] strings, String str, int first, int last) {
    if (first > last) return -1;
    int mid;

    while (first <= last) {
        mid = (first+last)/2;
        if (strings[mid].equals(str)) {
            return mid;
        }
        else if (strings[mid].isEmpty()) {
            int left = mid-1;
            int right = mid+1;
            while (true) {
                if (left >= high) {
                    return -1;
                }
                else if (!strings[left].isEmpty() && left >= first) {
                    mid = left;
                    break;
                }
                else if(!strings[right] != " " && right < last) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }
        else if (strings[mid].compareTo(str) > 0) {
            mid = high-1;
        }
        else {
            low = mid+1;
        }
    }

    return -1;
}

