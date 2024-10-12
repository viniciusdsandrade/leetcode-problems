import java.util.Arrays;

/*
    2332. The Latest Time to Catch a Bus
    You are given a 0-indexed integer array buses of length n, where buses[i] represents the departure time
    of the ith bus. You are also given a 0-indexed integer array passengers of length m, where passengers[j]
    represents the arrival time of the jth passenger. All bus departure times are unique.
    All passenger arrival times are unique.

    You are given an integer capacity, which represents the maximum number of
    passengers that can get on each bus.

    When a passenger arrives, they will wait in line for the next available bus.
    You can get on a bus that departs at x minutes if you arrive at y minutes where y <= x,
    and the bus is not full. Passengers with the earliest arrival times get on the bus first.
    More formally when a bus arrives, either:

    If capacity or fewer passengers are waiting for a bus, they will all get on the bus, or
    The capacity passengers with the earliest arrival times will get on the bus.
    Return the latest time you may arrive at the bus station to catch a bus.
    You cannot arrive at the same time as another passenger.

    Note: The arrays buses and passengers are not necessarily sorted.

    Example 1:
    Input: buses = [10,20], passengers = [2,17,18,19], capacity = 2
    Output: 16
    Explanation: Suppose you arrive at time 16.
    At time 10, the first bus departs with the 0th passenger.
    At time 20, the second bus departs with you and the 1st passenger.
    Note that you may not arrive at the same time as another passenger, which is why you must arrive before the 1st passenger to catch the bus.
    Example 2:

    Input: buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
    Output: 20
    Explanation: Suppose you arrive at time 20.
    At time 10, the first bus departs with the 3rd passenger.
    At time 20, the second bus departs with the 5th and 1st passengers.
    At time 30, the third bus departs with the 0th passenger and you.
    Notice if you had arrived any later, then the 6th passenger would have taken your seat on the third bus.

    Constraints:
    n == buses.length
    m == passengers.length
    1 <= n, m, capacity <= 105
    2 <= buses[i], passengers[i] <= 109
    Each element in buses is unique.
    Each element in passengers is unique.
 */

public class _2332_The_Latest_Time_To_Catch_A_Bus {

    public static void main(String[] args) {

        int[] buses1 = {10, 20};
        int[] passengers1 = {2, 17, 18, 19};
        int capacity1 = 2;

        testLatestTimeCatchTheBus(buses1, passengers1, capacity1);

        int[] buses2 = {20, 30, 10};
        int[] passengers2 = {19, 13, 26, 4, 25, 11, 21};
        int capacity2 = 2;

        testLatestTimeCatchTheBus(buses2, passengers2, capacity2);

        int[] buses3 = {3};
        int[] passengers3 = {2, 3};
        int capacity3 = 2;

        testLatestTimeCatchTheBus(buses3, passengers3, capacity3);
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        int passenger = -1;
        int bus = 0;
        int currCap = 0;

        Arrays.sort(buses);
        Arrays.sort(passengers);

        while (bus < buses.length) {
            currCap = 0;
            while (currCap < capacity && passenger < (passengers.length - 1) && passengers[passenger + 1] <= buses[bus]) {
                currCap++;
                passenger++;
            }
            bus++;
        }
        if (currCap < capacity && (passenger < 0 || buses[buses.length - 1] != passengers[passenger]))
            return buses[buses.length - 1];

        while (passenger > 0 && (passengers[passenger] - 1) == passengers[passenger - 1])
            passenger--;

        return passengers[passenger] - 1;
    }

    public static void testLatestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        System.out.println("Input: " + Arrays.toString(buses) + ", " + Arrays.toString(passengers) + ", " + capacity);

        long start = System.nanoTime();
        int result = latestTimeCatchTheBus(buses, passengers, capacity);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
