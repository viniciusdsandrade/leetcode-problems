/*
    217. Contains Duplicate
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

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
function containsDuplicate(nums) {
    var set = new Set();
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        if (set.has(num))
            return true;
        set.add(num);
    }
    return false;
}
function testContainsDuplicate(nums) {
    console.log("\nInput: " + JSON.stringify(nums));
    var start = performance.now();
    var result = containsDuplicate(nums);
    var end = performance.now();
    var runtimeMilliseconds = (end - start).toFixed(6);
    var runtimeNanoseconds = ((end - start) * 1e6).toFixed(6); // Convertendo para nanossegundos e formatando
    console.log("Resultado: ".concat(result));
    console.log("Tempo de execu\u00E7\u00E3o em milissegundos: ".concat(runtimeMilliseconds));
    console.log("Tempo de execu\u00E7\u00E3o em nanossegundos: ".concat(runtimeNanoseconds, "\n"));
}
// Exemplo de uso
var input_1 = [1, 2, 3, 1];
var input_2 = [1, 2, 3, 4];
var input_3 = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2];
testContainsDuplicate(input_1);
testContainsDuplicate(input_2);
testContainsDuplicate(input_3);
