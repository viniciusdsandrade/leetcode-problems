var ListNode = /** @class */ (function () {
    function ListNode(val, next) {
        this.val = val === undefined ? 0 : val;
        this.next = next === undefined ? null : next;
    }
    ListNode.prototype.toString = function () {
        var result = "[";
        var current = this;
        while (current != null) {
            result += current.val.toString();
            if (current.next != null) {
                result += " -> ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    };
    return ListNode;
}());
function mergeTwoLists(list1, list2) {
    if (!list1)
        return list2;
    if (!list2)
        return list1;
    var dummy = new ListNode();
    var current = dummy;
    while (list1 && list2) {
        if (list1.val < list2.val) {
            current.next = list1;
            list1 = list1.next;
        }
        else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    if (list1)
        current.next = list1;
    if (list2)
        current.next = list2;
    return dummy.next;
}
function testMergeTwoLists(list1, list2) {
    console.log("list1: ".concat(list1));
    console.log("list2: ".concat(list2));
    var start = new Date().getTime();
    var result = mergeTwoLists(list1, list2);
    var end = new Date().getTime();
    console.log("result: ".concat(result));
    console.log("Execution time: ".concat(end - start));
}
testMergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
testMergeTwoLists(null, null);
testMergeTwoLists(null, new ListNode(0));
