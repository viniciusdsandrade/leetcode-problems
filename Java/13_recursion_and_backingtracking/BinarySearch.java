import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        List<Integer> list = List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        int target = 7;

        System.out.println(binarySearch(array, target));
        System.out.println(binarySearch(list, target));
    }

    public static int binarySearch(List<Object> list, Object target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (list.get(middle).equals(target))
                return middle;

            if ((int) list.get(middle) < (int) target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static int binarySearch(Object[] array, Object target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle].equals(target))
                return middle;

            if ((int) array[middle] < (int) target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (list.get(middle) == target)
                return middle;

            if (list.get(middle) < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }
}
