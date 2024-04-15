class ListNode {
    val: number
    next: ListNode | null

    constructor(val?: number, next?: ListNode | null) {
        this.val = val === undefined ? 0 : val
        this.next = next === undefined ? null : next
    }

    toString(): string {
        let result = "[";
        let current: ListNode | null = this;
        while (current != null) {
            result += current.val.toString();
            if (current.next != null) {
                result += " -> ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }
}

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if (!list1) return list2;
    if (!list2) return list1;

    let dummy = new ListNode();
    let current = dummy;

    while (list1 && list2) {
        if (list1.val < list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }

    if (list1) current.next = list1;
    if (list2) current.next = list2;

    return dummy.next;
}

function testMergeTwoLists(list1: ListNode | null, list2: ListNode | null): void {
    console.log(`list1: ${list1}`);
    console.log(`list2: ${list2}`);

    const start = new Date().getTime();
    const result = mergeTwoLists(list1, list2);
    const end = new Date().getTime();

    console.log(`result: ${result}`);
    console.log(`Execution time: ${end - start}`);
}

testMergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
testMergeTwoLists(null, null);
testMergeTwoLists(null, new ListNode(0));
