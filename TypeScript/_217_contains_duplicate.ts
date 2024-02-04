/*
    217. Contains Duplicate
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
 */

function containsDuplicate(nums: number[]): boolean {
    const set = new Set<number>();
    for (const num of nums) {
        if (set.has(num)) return true;
        set.add(num);
    }
    return false;
}

function testContainsDuplicate(nums: number[]) {
    console.log("\nInput: " + JSON.stringify(nums));
    const start = performance.now();
    const result = containsDuplicate(nums);
    const end = performance.now();

    const runtimeMilliseconds = (end - start).toFixed(6);
    const runtimeNanoseconds = ((end - start) * 1e6).toFixed(6); // Convertendo para nanossegundos e formatando

    console.log(`Resultado: ${result}`);
    console.log(`Tempo de execução em milissegundos: ${runtimeMilliseconds}`);
    console.log(`Tempo de execução em nanossegundos: ${runtimeNanoseconds}\n`);
}

const input_1 = [1, 2, 3, 1];
const input_2 = [1, 2, 3, 4];
const input_3 = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2];

testContainsDuplicate(input_1);
testContainsDuplicate(input_2);
testContainsDuplicate(input_3);
