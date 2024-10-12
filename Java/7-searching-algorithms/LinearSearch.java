import java.util.List;

public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        List<Integer> list = List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        List<Object> list2 = List.of(1.0, 3, 5.34, 7.1, 9, 11, 13.98, 15, 17, 19);
        Object[] array2 = {1.0, 3, 5.34, 7.1, 9, 11, 13.98, 15, 17, 19};
        int target = 7;
        Object targets = 13.98;

        System.out.println(linearSearch(array, target));
        System.out.println(linearSearch(list, target));
        System.out.println(linearSearch(list2, targets));
        System.out.println(linearSearch(array2, targets));
    }

    public static int linearSearch(List<Object> list, Object target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target))
                return i;
        }
        return -1;
    }

    public static int linearSearch(List<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target)
                return i;
        }
        return -1;
    }

    public static int linearSearch(Object[] array, Object target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target))
                return i;
        }
        return -1;
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }
}