#include <climits>
#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution {
public:
    static int reverse(int x) {
        int num = x;
        long int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = 10 * rev + digit;
            if (rev > INT_MAX) return 0;
            if (rev < INT_MIN) return 0;
            num /= 10;
        }
        return (int) rev;
    }
};

void testReverse(int x) {
    try {
        auto startTime = high_resolution_clock::now();
        int answer = Solution::reverse(x);
        auto endTime = high_resolution_clock::now();

        cout << "\nInput:  " << x << endl;
        cout << "Output: " << answer << endl;

        auto duration = duration_cast<nanoseconds>(endTime - startTime);
        cout << "Execution time: " << duration.count() << " ns" << endl;

    } catch (const exception &e) {
        cerr << "Error in test: " << e.what() << endl;
    }
}

int main() {
    testReverse(123);
    testReverse(-123);
    testReverse(120);

    return 0;
}