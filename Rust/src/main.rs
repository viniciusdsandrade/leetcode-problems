mod _21_merge_two_lists;
mod _1_two_sum;
mod _226_invert_binary_tree;

use std::rc::Rc;
use std::cell::RefCell;
use crate::_1_two_sum::test_two_sum;
use crate::_21_merge_two_lists::{ListNode, test_merge_two_lists};
use crate::_226_invert_binary_tree::{test_invert_tree, TreeNode};


fn main() {
    println!("Hello, world!");

    // Test 1
    let root = Some(Rc::new(RefCell::new(TreeNode::with_children(
        4,
        Some(Rc::new(RefCell::new(TreeNode::with_children(
            2,
            Some(Rc::new(RefCell::new(TreeNode::new(1)))),
            Some(Rc::new(RefCell::new(TreeNode::new(3))))
        )))),
        Some(Rc::new(RefCell::new(TreeNode::with_children(
            7,
            Some(Rc::new(RefCell::new(TreeNode::new(6)))),
            Some(Rc::new(RefCell::new(TreeNode::new(9))))
        ))))
    ))));
    test_invert_tree(root);

    // Test 2
    let root = Some(Rc::new(RefCell::new(TreeNode::with_children(
        2,
        Some(Rc::new(RefCell::new(TreeNode::new(1)))),
        Some(Rc::new(RefCell::new(TreeNode::new(3))))
    ))));
    test_invert_tree(root);

    // Test 3
    let root = None;
    test_invert_tree(root);

    let nums1: Vec<i32> = vec![2, 7, 11, 15];
    let target2: i32 = 9;
    test_two_sum(nums1, target2);

    let nums2: Vec<i32> = vec![3, 2, 4];
    let target2: i32 = 6;
    test_two_sum(nums2, target2);

    let nums3: Vec<i32> = vec![3, 3];
    let target3: i32 = 6;
    test_two_sum(nums3, target3);

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
