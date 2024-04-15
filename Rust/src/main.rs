mod _21_merge_two_lists;

use crate::_21_merge_two_lists::{ListNode, test_merge_two_lists};

fn main() {
    println!("Hello, world!");

    let list1 = Some(Box::new(ListNode {
        val: 1,
        next: Some(Box::new(ListNode {
            val: 2,
            next: Some(Box::new(ListNode::new(4))),
        })),
    }));

    let list2 = Some(Box::new(ListNode {
        val: 1,
        next: Some(Box::new(ListNode {
            val: 3,
            next: Some(Box::new(ListNode::new(4))),
        })),
    }));

    test_merge_two_lists(list1, list2);

    let list3 = Some(Box::new(ListNode::new(0)));
    let list4 = Some(Box::new(ListNode::new(0)));

    test_merge_two_lists(list3, list4);
}
