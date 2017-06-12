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

}